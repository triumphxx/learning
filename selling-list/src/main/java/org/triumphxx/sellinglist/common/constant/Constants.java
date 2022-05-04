package org.triumphxx.sellinglist.common.constant;


/**
 * @author:triumphxx
 * @Date:2020/5/16
 * @Time:9:43 上午
 * @微信公众号：北漂码农有话说
 * @desc:常量类
 **/
public class Constants {

    public static class REDIS_KEY {
        /**
         * 货物销量key 每天某一个货物的销售量
         */
        public static final String GOODS_TOP_KEY = "goods:rank:";
        /**
         * 货物的基本信息key
         */
        public static final String GOODS_KEY = "goods:";
        /**
         * 货物id
         */
        public static final String GOODS_KEY_ID = "goods:id:";
        /**
         * 货物名称
         */
        public static final String GOODS_KEY_NAME = "goods:name:";
        /**
         * 货物销售数量
         */
        public static final String GOODS_KEY_SELL_NUM = "goods:sellnum:";
        /**
         * 每日销售并集后的key
         */
        public static final String GOODS_ONE_DAY_RANK = "oneday:rank";
    }
}
