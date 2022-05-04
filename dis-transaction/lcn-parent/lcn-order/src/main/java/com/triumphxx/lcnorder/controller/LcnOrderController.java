package com.triumphxx.lcnorder.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.triumphxx.lcnorder.bean.TOrder;
import com.triumphxx.lcnorder.dao.TOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

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
public class LcnOrderController {

    @Autowired
    TOrderDao tOrderDao;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add-order")
    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public String add() {
        TOrder bean = new TOrder();
        bean.setTId(1);
        bean.setTName("order");

        restTemplate.postForEntity("http://lcn-pay/add-pay", "", String.class);
//        int i = 1/0;
        tOrderDao.insert(bean);
        return "新增订单成功";
    }
}
