package org.triumphxx.sellinglist.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 *
 * </p>
 *
 * @author 公众号：北漂码农有话说
 * @since 2020-05-15
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class Sell extends BaseEntity {

    private static final long serialVersionUID = 1L;

    private String sellId;

    private String goodsId;

    private Integer sellNum;

    private String sellDate;


}
