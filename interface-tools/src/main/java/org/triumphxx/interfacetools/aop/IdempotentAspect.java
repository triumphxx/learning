package org.triumphxx.interfacetools.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.triumphxx.interfacetools.exception.IdempotentException;
import org.triumphxx.interfacetools.token.TokenService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:triumphxx
 * @Date:2020/8/30
 * @Time:9:28 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 使用Aop的方式实现拦截，校验接口幂等性
 **/
@Component
@Aspect
@Slf4j
public class IdempotentAspect {

    @Autowired
    TokenService tokenService;

    @Pointcut(value = "@annotation(org.triumphxx.interfacetools.annotation.Idempotent)")
    public void pointcut(){

    }
    @Before("pointcut()")
    public void before(JoinPoint joinPoint) throws IdempotentException {
        //通过RequestContextHolder工具类来获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.
                getRequestAttributes()).getRequest();
        try{
            tokenService.checkToken(request);
        }catch (IdempotentException e){
            throw e;
        }
    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) throws Throwable {
        //获取方法的签名 就是整个方法：包括方法类型 返回值 方法名
        String method = joinPoint.getSignature().toLongString().split(" ")[2];
        //获取到方法名【获取到的方法签名用空格分隔为两部分，所以我们只需要获取第二部分就行了】
        log.info("接口方法 {} ,执行时间结束",method);
    }
}
