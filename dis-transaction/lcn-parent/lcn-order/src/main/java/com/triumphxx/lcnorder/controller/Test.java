package com.triumphxx.lcnorder.controller;

import com.alibaba.fastjson.JSONObject;
import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.triumphxx.lcnorder.bean.TOrder;
import com.triumphxx.lcnorder.dao.TOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author:triumphxx
 * @Date:2021/10/15
 * @Time:10:04 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@RestController
public class Test {

    @Autowired
    TOrderDao tOrderDao;

    @GetMapping("/")
    public String test() {
        System.out.println("lcn-order");
        return "lcn-order";
    }

    @GetMapping("/insert")
    public String insert() {
        TOrder tOrder = new TOrder();
        tOrder.setTId(1);
        tOrder.setTName("order");
        int i = tOrderDao.insertSelective(tOrder);
        if (i == 1) {
            return "lcn-order 插入成功";
        }
        return "lcn-order 插入失败";
    }

}
