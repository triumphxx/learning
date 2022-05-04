package org.triumphxx.globaloperation.data;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;

/**
 * @author:triumphxx
 * @Date:2020/5/7
 * @Time:9:07 下午
 * @desc:全局数据绑定处理
 **/
@RestControllerAdvice
public class GlobalDataBindingHandler {

    @ModelAttribute(name = "triumphxx")
    @ResponseBody
    public HashMap<String,Object>  proceed() {
        HashMap<String,Object> hashMap = new HashMap<>();
        hashMap.put("name","wang");
        hashMap.put("age",27);
        return hashMap;
    }

}
