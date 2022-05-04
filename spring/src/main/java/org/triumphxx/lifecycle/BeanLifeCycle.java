package org.triumphxx.lifecycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author:triumphxx
 * @Date:2021/5/31
 * @Time:10:55 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc:
 **/
@Component
@Scope("prototype")
public class BeanLifeCycle implements BeanFactoryAware, BeanNameAware,
        ApplicationContextAware, BeanPostProcessor, InitializingBean, DisposableBean {

    static String nanme;

    @Override
    public void setBeanName(String s) {
        nanme = s;
        System.out.println("Bean的名称 " + s);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        final boolean singleton = beanFactory.isSingleton(nanme);
        System.out.println("Bean 是否是单例 " + singleton);
        final boolean prototype = beanFactory.isPrototype(nanme);
        System.out.println("Bean 的作用域 " + prototype);
        System.out.println("setBeanFactory");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("setApplicationContext");
    }

    @PostConstruct
    public void init() {
        System.out.println("bean 开始初始化了");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }


    @Override
    public void destroy() throws Exception {
        System.out.println("Bean被销毁了");
    }

    public void run() {
        System.out.println("hello word");
    }
}
