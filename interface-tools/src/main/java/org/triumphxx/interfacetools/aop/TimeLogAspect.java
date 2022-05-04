package org.triumphxx.interfacetools.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

/**
 * @author:triumphxx
 * @Date:2020/9/6
 * @Time:10:24 上午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 使用AOP环绕实现统计接口方法执行时间统计
 **/
@Aspect
@Component
@Slf4j
public class TimeLogAspect {

    @Around(value = "@annotation(org.triumphxx.interfacetools.annotation.TimeLog)")
    public Object runTimeLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        //获取方法的签名 就是整个方法：包括方法类型 返回值 方法名
        String methodLocation = proceedingJoinPoint.getSignature().toLongString();
        //获取到方法名【获取到的方法签名用空格分隔为两部分，所以我们只需要获取第二部分就行了】
        String method = methodLocation.split(" ")[2];
        long startTime =System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long endTime = System.currentTimeMillis();
        log.info("方法 {} ,执行时间 {} ms",method,endTime-startTime);
        return result;
    }
}
