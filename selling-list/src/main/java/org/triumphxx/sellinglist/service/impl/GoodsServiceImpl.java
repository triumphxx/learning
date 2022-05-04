package org.triumphxx.sellinglist.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.triumphxx.sellinglist.entity.Goods;
import org.triumphxx.sellinglist.entity.vo.GoodsVo;
import org.triumphxx.sellinglist.mapper.GoodsMapper;
import org.triumphxx.sellinglist.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-15
 */
@Service
public class GoodsServiceImpl extends ServiceImpl<GoodsMapper, Goods> implements GoodsService {

    @Autowired
    GoodsMapper goodsMapper;


    @Override
    public GoodsVo selectSellTop(QueryWrapper<Goods> wrapper) {
        return goodsMapper.selectSellTop(wrapper);
    }
}
