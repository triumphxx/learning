package org.triumphxx.sellinglist.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.triumphxx.sellinglist.entity.Goods;
import org.triumphxx.sellinglist.entity.vo.GoodsVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-15
 */
@Component
public interface GoodsMapper extends BaseMapper<Goods> {

    GoodsVo selectSellTop(@Param(Constants.WRAPPER) QueryWrapper<Goods> wrapper);
}
