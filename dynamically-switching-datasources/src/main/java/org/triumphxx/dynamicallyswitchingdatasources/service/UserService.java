package org.triumphxx.dynamicallyswitchingdatasources.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.triumphxx.dynamicallyswitchingdatasources.annotation.DataSource;
import org.triumphxx.dynamicallyswitchingdatasources.mapper.UserMapper;

/**
 * @author:triumphxx
 * @Date: 2022/5/10
 * @Time: 16:17 
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    @DataSource("master")
    public Integer master() {
        return userMapper.count();
    }

    @DataSource("slave")
    public Integer slave() {
        return userMapper.count();
    }
}
