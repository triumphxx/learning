package org.triumphxx.sellinglist.service.impl;

import cn.hutool.core.date.DateUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.triumphxx.sellinglist.common.constant.Constants;
import org.triumphxx.sellinglist.entity.Goods;
import org.triumphxx.sellinglist.entity.Sell;
import org.triumphxx.sellinglist.entity.vo.GoodsVo;
import org.triumphxx.sellinglist.mapper.SellMapper;
import org.triumphxx.sellinglist.service.GoodsService;
import org.triumphxx.sellinglist.service.SellService;
import org.triumphxx.sellinglist.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-15
 */
@Service
public class SellServiceImpl extends ServiceImpl<SellMapper, Sell> implements SellService {

    @Autowired
    GoodsService goodsService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    org.triumphxx.sellinglist.util.DateUtil dateUtil;

    @Override
    public void initGoodsSellTop() {
        //获取当天内销售量大于80的商品id和销售记录id
        List<Sell> sells = this.list(new QueryWrapper<Sell>()
                .ge("sell_num", 80)
                .ge("sell_date", DateUtil.format(new Date(), "yyyy-MM-dd"))
                .select("goods_id", "sell_num")
        );
        List<GoodsVo> goodsVos = new ArrayList<>();
        for (Sell sell : sells) {
            //1、根据销售量大于80的销售记录查询出货物的信息
            GoodsVo goods = goodsService.selectSellTop(new QueryWrapper<Goods>().eq("g.goods_id", sell.getGoodsId())
                    .eq("s.sell_date", DateUtil.format(new Date(), "yyyy-MM-dd")));
            //2、将销售货物一天的销售的数量进行数据缓存
            redisUtil.zSet(Constants.REDIS_KEY.GOODS_TOP_KEY + goods.getGoodsId(), goods.getGoodsId(), goods.getSellNum());
            //设置过期时间 当天有效
            //0点的时间减去现在的时间换算成毫秒数
            Long expireTime = dateUtil.initDateByDay() - System.currentTimeMillis();
            redisUtil.expire(Constants.REDIS_KEY.GOODS_TOP_KEY + goods.getGoodsId(), expireTime);
            //同时缓存一下货物的基本信息 货物id 货物名称 销售货物数量
            this.hasCacheGoods(goods, expireTime);
            goodsVos.add(goods);
        }
        //做并集
        this.zuionOneDayTop(goodsVos);
    }

    /**
     * 合并当天热卖榜
     */
    private void zuionOneDayTop(List<GoodsVo> goodsVos) {
        List<String> otherKeys = new ArrayList<>();
        for (GoodsVo goodsVo : goodsVos) {
            String temp = Constants.REDIS_KEY.GOODS_TOP_KEY + goodsVo.getGoodsId();
            otherKeys.add(temp);
        }
        redisUtil.zUnionAndStore(Constants.REDIS_KEY.GOODS_TOP_KEY,
                otherKeys, Constants.REDIS_KEY.GOODS_ONE_DAY_RANK);
    }

    /**
     * 缓存货物的基本信息
     *
     * @param goods
     * @param expireTime
     */
    private void hasCacheGoods(GoodsVo goods, Long expireTime) {
        //构造货物基本信息key
        String goodsKey = Constants.REDIS_KEY.GOODS_KEY + goods.getGoodsId();
        boolean isKey = redisUtil.hasKey(goodsKey);
        if (!isKey) {
            redisUtil.hset(goodsKey, Constants.REDIS_KEY.GOODS_KEY_ID, goods.getGoodsId(), expireTime);
            redisUtil.hset(goodsKey, Constants.REDIS_KEY.GOODS_KEY_NAME, goods.getGoodsName(), expireTime);
            redisUtil.hset(goodsKey, Constants.REDIS_KEY.GOODS_KEY_SELL_NUM, goods.getSellNum(), expireTime);

        }
    }


}
