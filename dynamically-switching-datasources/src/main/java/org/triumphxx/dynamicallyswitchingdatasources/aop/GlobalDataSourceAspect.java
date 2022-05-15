package org.triumphxx.dynamicallyswitchingdatasources.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.triumphxx.dynamicallyswitchingdatasources.dynamic.DynamicDataSourceContextHolder;
import org.triumphxx.dynamicallyswitchingdatasources.prop.DataSourceType;

import javax.servlet.http.HttpSession;

/**
 * @author:triumphxx
 * @Date:2022/5/15
 * @Time:17:16
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 支持网页上切换数据源的切面
 **/
@Aspect
@Component
@Order(1)
public class GlobalDataSourceAspect {

    @Autowired
    HttpSession httpSession;

    @Pointcut("execution(* org.triumphxx.dynamicallyswitchingdatasources.service.*.*(..))")
    public void pc(){

    }

    @Around("pc()")
    public Object around(ProceedingJoinPoint pjp){
        DynamicDataSourceContextHolder.setDataSourceType((String) httpSession.getAttribute(DataSourceType.DS_SESSION_KEY));
        try {
            return pjp.proceed();
        }catch (Throwable throwable){
            throwable.printStackTrace();
        }finally {
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
        return null;
    }
}
