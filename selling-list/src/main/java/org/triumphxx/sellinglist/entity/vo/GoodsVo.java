package org.triumphxx.sellinglist.entity.vo;

import org.triumphxx.sellinglist.entity.Goods;
import lombok.Data;

/**
 * @author:triumphxx
 * @Date:2020/5/16
 * @Time:9:08 上午
 * @微信公众号：北漂码农有话说
 * @desc:前端显示实体
 **/
@Data
public class GoodsVo extends Goods {

    private Integer sellNum;
}
