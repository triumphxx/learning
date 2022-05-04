package org.triumphxx.interfacetools.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.triumphxx.interfacetools.annotation.AccessLimit;
import org.triumphxx.interfacetools.annotation.Idempotent;
import org.triumphxx.interfacetools.annotation.TimeLog;
import org.triumphxx.interfacetools.common.Result;
import org.triumphxx.interfacetools.exception.IdempotentException;
import org.triumphxx.interfacetools.token.TokenService;

/**
 * @author:triumphxx
 * @Date:2020/8/29
 * @Time:11:37 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@RestController
public class IdempotentController {

    @Autowired
    TokenService tokenService;

    /**
     * 标注注解，需要进行拦截
     * @return
     */
    @RequestMapping("/test")
    @Idempotent
    public Result test(){
        System.out.println("你好");
        return Result.succ("你好");
    }
    /**
     * 没标注注解，不需要进行拦截
     * @return
     */
    @RequestMapping("/test1")
    @TimeLog
    public Result test1(){
        System.out.println("你好");
        return Result.succ("你好");
    }
    /**
     * 测试接口防刷
     * @return
     */
    @RequestMapping("/test2")
    @AccessLimit(seconds = 5,maxCount = 10,needLogin = false)
    public Result test2(){
        System.out.println("你好");
        return Result.succ("你好");
    }
    /**
     * 测试接口防刷
     * @return
     */
    @RequestMapping("/test3")
    @AccessLimit(seconds = 5,maxCount = 10,needLogin = false)
    public Result test3(){
        System.out.println("你好");
        return Result.succ("你好");
    }
    @GetMapping("/getToken")
    @TimeLog
    public String getToken() throws IdempotentException {
        return tokenService.createToken();
    }
}

