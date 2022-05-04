//package org.triumphxx.scheduledboot.service.impl;
//
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.Lifecycle;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.stereotype.Service;
//import org.triumphxx.scheduledboot.service.TestTwoService;
//
//import java.util.concurrent.ThreadPoolExecutor;
//
///**
// * @author:triumphxx
// * @Date: 2022/1/17
// * @Time: 13:51
// * @微信公众号：北漂码农有话说
// * @网站：https://blog.triumphxx.com.cn
// * @GitHub https://github.com/triumphxx
// * @Desc:
// **/
//@Service
//@PropertySource(value = "classpath:/ftptwo.properties")
//public class TestTwoServiceImpl implements TestTwoService{
//    @Value("${ftp2.IP}")
//    private String testFlag;
//    @Override
//    public void upload(ThreadPoolExecutor threadPool) {
//        threadPool.execute(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("线程名称"+Thread.currentThread().getName()+"，~~~~~~TestTwoService 在执行~~~~~~~~~~~~~~~"+testFlag);
//            }
//        });
//    }
//}
