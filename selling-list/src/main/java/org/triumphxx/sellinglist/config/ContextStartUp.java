package org.triumphxx.sellinglist.config;

import org.triumphxx.sellinglist.service.SellService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


/**
 * @author:triumphxx
 * @Date:2020/5/16
 * @Time:7:40 上午
 * @微信公众号：北漂码农有话说
 * @desc:系统启动加载类
 **/
@Component
public class ContextStartUp implements ApplicationRunner {

    @Autowired
    SellService sellService;

    /**
     * 服务启动是加载执行的的方法
     * 将每天热卖的商品进行展示
     *
     * @param args
     * @throws Exception
     */
    @Override
    public void run(ApplicationArguments args) throws Exception {
        sellService.initGoodsSellTop();
    }

}
