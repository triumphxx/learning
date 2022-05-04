package org.triumphxx.lifecycle;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author:triumphxx
 * @Date:2021/5/31
 * @Time:11:00 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/

public class TestBeanLifeCycle {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(TestBeanLifeCycle.class);
        applicationContext.register(BeanLifeCycle.class);
        BeanLifeCycle beanLifeCycle = applicationContext.getBean(BeanLifeCycle.class);
        beanLifeCycle.run();
        applicationContext.close();
    }
}
