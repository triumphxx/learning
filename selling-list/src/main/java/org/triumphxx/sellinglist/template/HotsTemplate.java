package org.triumphxx.sellinglist.template;

import org.triumphxx.sellinglist.common.constant.Constants;
import org.triumphxx.sellinglist.common.templates.DirectiveHandler;
import org.triumphxx.sellinglist.common.templates.TemplateDirective;
import org.triumphxx.sellinglist.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * @author:triumphxx
 * @Date:2020/5/16
 * @Time:4:12 下午
 * @微信公众号：北漂码农有话说
 * @desc:今日热卖模板
 **/
@Component
public class HotsTemplate extends TemplateDirective {

    @Autowired
    RedisUtil redisUtil;

    @Override
    public String getName() {
        return "hots";
    }

    @Override
    public void execute(DirectiveHandler handler) throws Exception {

        Set<ZSetOperations.TypedTuple> zSetRank = redisUtil.getZSetRank(Constants.REDIS_KEY.GOODS_ONE_DAY_RANK, 0, 6);

        List<Map> hotsGoods = new ArrayList<>();

        for (ZSetOperations.TypedTuple typedTuple : zSetRank) {
            Map<String, Object> map = new HashMap<>();
            Object value = typedTuple.getValue();
            //货物id
            map.put("id", value);
            map.put("name", redisUtil.hget(Constants.REDIS_KEY.GOODS_KEY + value, Constants.REDIS_KEY.GOODS_KEY_NAME));
            map.put("num", redisUtil.hget(Constants.REDIS_KEY.GOODS_KEY + value, Constants.REDIS_KEY.GOODS_KEY_SELL_NUM));
            hotsGoods.add(map);
        }
        handler.put(RESULTS, hotsGoods).render();
    }
}
