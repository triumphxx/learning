package org.triumphxx.dynamicallyswitchingdatasources.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author:triumphxx
 * @Date: 2022/5/10
 * @Time: 16:32 
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@Controller("/ce")
public class Test {
    @RequestMapping(value = "/V1")
    @ResponseBody
    public String test(){
        System.out.println("服务正常");
        return "200";
    }
}
