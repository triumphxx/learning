package org.triumphxx.sellinglist.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import org.triumphxx.sellinglist.entity.Goods;
import org.triumphxx.sellinglist.entity.vo.GoodsVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-15
 */
public interface GoodsService extends IService<Goods> {

    GoodsVo selectSellTop(QueryWrapper<Goods> wrapper);
}
