package org.triumphxx.interfacetools.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:triumphxx
 * @Date:2021/2/18
 * @Time:1:55 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 标记防刷接口注解
 **/

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface AccessLimit {
    /**
     * 次数
     * @return
     */
    int seconds();

    /**
     * 最大次数
     * @return
     */
    int maxCount();

    /**
     * 是否需要登录 默认为需要
     * @return
     */
    boolean needLogin()default true;

}
