package com.triumphxx.lcnpay.controller;

import com.codingapi.txlcn.tc.annotation.LcnTransaction;
import com.triumphxx.lcnpay.bean.TPay;
import com.triumphxx.lcnpay.dao.TPayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:triumphxx
 * @Date:2021/10/15
 * @Time:10:06 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@RestController
public class Test {
    @Autowired
    TPayDao tPayDao;

    @GetMapping("/")
    public String test() {
        System.out.println("lcn-pay");
        return "lcn-pay";
    }

    @GetMapping("/insert")
    public String insert() {
        TPay tPay = new TPay();
        tPay.setTId(1);
        tPay.setTName("t_pay");
        int i = tPayDao.insertSelective(tPay);
        System.out.println("-------  " + i);
        if (i == 1) {
            return "lcn-pay 插入成功";
        }
        return "lcn-pay 插入失败";
    }


}
