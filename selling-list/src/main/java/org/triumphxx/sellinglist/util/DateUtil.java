package org.triumphxx.sellinglist.util;

import org.springframework.stereotype.Component;

import java.util.TimeZone;

/**
 * @author:triumphxx
 * @Date:2020/5/16
 * @Time:2:24 下午
 * @微信公众号：北漂码农有话说
 * @desc:时间获取转换类
 **/
@Component
public class DateUtil {

    //获取当天的0点时间的毫秒数
    public Long initDateByDay() {
        long current = System.currentTimeMillis();//当前时间毫秒数
        long zero = current / (1000 * 3600 * 24) * (1000 * 3600 * 24) - TimeZone.getDefault().getRawOffset();//今天零点零分零秒的毫秒数
        long twelve = zero + 24 * 60 * 60 * 1000 - 1;//今天23点59分59秒的毫秒数
        return twelve;
    }

}
