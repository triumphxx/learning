package org.triumphxx.dynamicallyswitchingdatasources.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.triumphxx.dynamicallyswitchingdatasources.model.User;
import org.triumphxx.dynamicallyswitchingdatasources.prop.DataSourceType;
import org.triumphxx.dynamicallyswitchingdatasources.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * @author:triumphxx
 * @Date:2022/5/15
 * @Time:16:59
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 前端暴露接口
 **/
@RestController
public class DataSourceController {

    private static final Logger logger = LoggerFactory.getLogger(DataSourceController.class);

    @Autowired
    UserService userService;

    @GetMapping("/test")
    public String test(){
        Integer master = userService.master();
        Integer slave = userService.slave();
        logger.info("master的数据量：{},slave的数据量为：{}",master,slave);
        return "200";
    }

    /**
     * 修改数据源
     * @param dsType
     */
    @PostMapping("/dstype")
    public void setDsType(String dsType, HttpSession session) {
        session.setAttribute(DataSourceType.DS_SESSION_KEY, dsType);
        logger.info("数据源切换为 {}", dsType);
    }

    /**
     * 获取数据
     * @return
     */
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
