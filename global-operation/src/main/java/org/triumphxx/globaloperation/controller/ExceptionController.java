package org.triumphxx.globaloperation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author:triumphxx
 * @Date:2020/5/4
 * @Time:4:42 下午
 * @desc:测试全局异常处理
 **/
@RestController
@Slf4j
public class ExceptionController {
    @RequestMapping("/test")
    public void testException(){
        log.info("进入测试方法");
        int i =1/0;
    }

}
