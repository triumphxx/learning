package org.triumphxx.interfacetools.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.triumphxx.interfacetools.common.Result;
import org.triumphxx.interfacetools.entity.UserVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author:triumphxx
 * @Date:2022/6/8
 * @Time:12:01
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@RestController
public class UserController {

    @GetMapping("/users")
    public Result findUserList(){
        List<UserVo> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            UserVo userVo = new UserVo();
            userVo.setId(i);
            userVo.setDescription("第几个名字"+i);
            userVo.setName("王玉鹏"+i);
            userVo.setPhone("1761161326"+i);
            list.add(userVo);
        }
        return Result.succ(list);
    }
}
