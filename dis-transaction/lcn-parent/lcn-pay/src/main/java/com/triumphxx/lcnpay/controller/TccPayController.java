package com.triumphxx.lcnpay.controller;

import com.codingapi.txlcn.tc.annotation.TccTransaction;
import com.triumphxx.lcnpay.bean.TPay;
import com.triumphxx.lcnpay.dao.TPayDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

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
public class TccPayController {
    @Autowired
    TPayDao tPayDao;
    //保存主键信息
    private static Map<String, Integer> maps = new HashMap<>();

    @PostMapping("/add-pay-tcc")
    @Transactional(rollbackFor = Exception.class)
    @TccTransaction
    public String addPay(@RequestBody Map map) {
        TPay tPay = new TPay();
        tPay.setTId((Integer) map.get("tId"));
        tPay.setTName((String) map.get("tName"));
        tPayDao.insert(tPay);
        maps.put("a", (Integer) map.get("tId"));
//        int i = 1/0;
        System.out.println("本次新增支付号为" + (Integer) map.get("tId"));
        return "新增支付成功";
    }

    public String confirmAddPay(Map map) {
        System.out.println("pay confirm");
        System.out.println("本次新增支付号为" + maps.get("a"));
        maps.clear();
        return "新增支付成功";

    }


    /**
     * 逆sql
     *
     * @param map
     * @return
     */
    public String cancelAddPay(Map map) {
        Integer a = maps.get("a");
        System.out.println("pay cancel");
        System.out.println("本次删除支付号为" + maps.get("a"));
        tPayDao.deleteByPrimaryKey(a);
        maps.clear();
        return "取消支付成功";

    }
}
