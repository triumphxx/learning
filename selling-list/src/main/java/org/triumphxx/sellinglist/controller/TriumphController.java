package org.triumphxx.sellinglist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author:triumphxx
 * @Date:2020/5/15
 * @Time:9:54 下午
 * @微信公众号：北漂码农有话说
 * @desc:测试服务可用性
 */
@Controller
public class TriumphController {
    @RequestMapping({"", "/", "index"})
    public String triumph() {
        System.out.println("服务正常启动");
        return "index";
    }
}
