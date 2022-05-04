package com.triumphxx.lcnorder.controller;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.triumphxx.lcnorder.bean.TOrder;
import com.triumphxx.lcnorder.dao.TOrderDao;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @author:triumphxx
 * @Date:2021/10/24
 * @Time:2:13 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@RestController
public class TccOrderController {

    @Autowired
    TOrderDao tOrderDao;

    @Autowired
    private RestTemplate restTemplate;

    //保存主键信息
    private static Map<String, Integer> maps = new HashMap<>();


    @PostMapping("/add-order-tcc")
    @Transactional(rollbackFor = Exception.class)
    @TccTransaction
    public String add() {
        TOrder bean = new TOrder();
        Long no = Math.round((Math.random() + 1) * 1000);
        bean.setTId(no.intValue());
        bean.setTName("order" + no.intValue());
        JSONObject date = new JSONObject();
        date.put("tId", bean.getTId());
        date.put("tName", bean.getTName() + "pay");
        restTemplate.postForEntity("http://lcn-pay/add-pay-tcc", date, String.class);
//        int i = 1/0;
        tOrderDao.insert(bean);
        maps.put("a", no.intValue());
        System.out.println("本次新增订单号为" + no.intValue());
        return "新增订单成功";
    }

    public String confirmAdd() {
        System.out.println("order confirm ");
        System.out.println("订单新增成功 id为:" + maps.get("a"));
        maps.clear();
        return "新增订单成功";
    }

    public String cancelAdd() {
        Integer a = maps.get("a");
        System.out.println("order cancel ");
        System.out.println("删除的订单号为 :" + a);
        tOrderDao.deleteByPrimaryKey(a);
        maps.clear();
        return "新增订单成功";
    }
}
