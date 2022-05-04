package org.triumphxx.globaloperation.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.triumphxx.globaloperation.response.Result;

import java.util.HashMap;

/**
 * @author:triumphxx
 * @Date:2020/5/7
 * @Time:9:15 下午
 * @desc:全局数据处理测试
 **/
@RestController
@Slf4j
public class DataController {

    @GetMapping("/data")
    public Result data(Model model){
        HashMap<String,Object> hashMap = (HashMap<String, Object>) model.asMap();
        System.out.println(hashMap);
        return Result.ok(hashMap.toString());
    }
}
