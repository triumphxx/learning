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
import org.triumphxx.interfacetools.annotation.AccessLimit;
import org.triumphxx.interfacetools.constant.Constant;
import org.triumphxx.interfacetools.exception.IdempotentException;
import org.triumphxx.interfacetools.redis.RedisService;
import org.triumphxx.interfacetools.token.TokenService;

import javax.servlet.http.HttpServletRequest;

/**
 * @author:triumphxx
 * @Date:2022/5/3
 * @Time:10:04
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 使用AOP实现接口防刷
 **/
@Component
@Aspect
@Slf4j
public class NotBrushAspect {

    @Autowired
    RedisService redisService;
    @Autowired
    TokenService tokenService;

    @Pointcut(value = "@annotation(org.triumphxx.interfacetools.annotation.AccessLimit)")
    public void pointcut() {

    }

    /**
     * && @annotation(accessLimit) 这样写的目的是
     * 为了获取 注解的属性值
     * @param accessLimit
     * @throws IdempotentException
     */
    @Before("pointcut() && @annotation(accessLimit)")
    public void before(AccessLimit accessLimit) throws IdempotentException {
        //通过RequestContextHolder工具类来获取request
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.
                getRequestAttributes()).getRequest();
        //获取方法上注解的属性值
        // 最大允许访问次数
        int maxCount = accessLimit.maxCount();
        // 是否需要登记登录标记
        boolean login = accessLimit.needLogin();
        try{
            tokenService.checkToken(request);
        }catch (IdempotentException e){
            throw e;
        }
        //获取访问的接口资源路径
        String key = request.getRequestURI();
        //获取参数列表中携带的Token的数值
        String token = request.getHeader(Constant.TOKEN_NAME);
        //用来限制 资源和用户绑定防刷接口
        String source = key + token;
        //若需要登录
        if (login) {
            //超出访问次数
            throw new IdempotentException(Constant.ExceptionMessage.EXCEPTION_LOGIN_MESSAGE, Constant.ExceptionCode.EXCEPTION_CODE);
        }
        //从redis中获取用户访问的次数
        Integer count = (Integer) redisService.get(source);
        if (count == null) {
            //第一次访问
            redisService.set(source, 1);
        } else if (count < maxCount) {
            //加1 由于有序列化的问题 实现方法先将key删除，然后值放进去
            count ++;
            redisService.remove(source);
            redisService.set(source, count);
        } else {
            //达到访问的次数后，需要重新申请Token,同一个人同一个接口使用一个Token
            boolean remove = redisService.remove(token);
            if (!remove) {
                throw new IdempotentException(Constant.ExceptionMessage.EXCEPTION_REDIS_TOKEN_EXPIRE_MESSAGE,
                        Constant.ExceptionCode.EXCEPTION_CODE);
            }
            //超出访问次数
            throw new IdempotentException(Constant.ExceptionMessage.EXCEPTION_BRUSH, Constant.ExceptionCode.EXCEPTION_CODE);
        }


    }

    @After("pointcut()")
    public void after(JoinPoint joinPoint) throws Throwable {
        //获取方法的签名 就是整个方法：包括方法类型 返回值 方法名
        String method = joinPoint.getSignature().toLongString().split(" ")[2];
        //获取到方法名【获取到的方法签名用空格分隔为两部分，所以我们只需要获取第二部分就行了】
        log.info("接口方法 {} ,执行接口防刷校验结束", method);
    }
}
