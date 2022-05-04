package org.triumphxx.transaction.programingtransaction.test;

import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.triumphxx.transaction.programingtransaction.UserService;

/**
 * @author:triumphxx
 * @Date:2021/10/31
 * @Time:11:06 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
public class UserServiceTest {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean(UserService.class);
        userService.transfer2();
    }
}
