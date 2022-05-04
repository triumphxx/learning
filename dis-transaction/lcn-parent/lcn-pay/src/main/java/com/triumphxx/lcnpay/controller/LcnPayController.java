package com.triumphxx.lcnpay.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.triumphxx.lcnpay.bean.TPay;
import com.triumphxx.lcnpay.dao.TPayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:triumphxx
 * @Date:2021/10/24
 * @Time:2:26 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@RestController
public class LcnPayController {
    @Autowired
    TPayDao tPayDao;

    @PostMapping("/add-pay")
    @Transactional(rollbackFor = Exception.class)
    @LcnTransaction
    public String addPay() {
        TPay tPay = new TPay();
        tPay.setTId(1);
        tPay.setTName("t_pay");
        int i = tPayDao.insertSelective(tPay);
        return "新增支付成功";

    }
}
