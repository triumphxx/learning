//package org.triumphxx.interfacetools.interceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
//import org.triumphxx.interfacetools.annotation.AccessLimit;
//import org.triumphxx.interfacetools.constant.Constant;
//import org.triumphxx.interfacetools.exception.IdempotentException;
//import org.triumphxx.interfacetools.redis.RedisService;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * @author:triumphxx
// * @Date:2021/2/18
// * @Time:1:59 下午
// * @微信公众号：北漂码农有话说
// * @网站：http://blog.triumphxx.com.cn
// * @GitHub https://github.com/triumphxx
// * @Desc: 拦截器，拦截被标记了接口防刷注解的类
// **/
//@Component
//public class NotBrushInterceptor extends HandlerInterceptorAdapter {
//
//    @Autowired
//    RedisService redisService;
//
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //判断请求是否属于方法的请求
//        if(handler instanceof HandlerMethod){
//            HandlerMethod hm = (HandlerMethod) handler;
//            //获取方法中的注解,看是否有该注解
//            AccessLimit accessLimit = hm.getMethodAnnotation(AccessLimit.class);
//            if(accessLimit == null){
//                return true;
//            }
//            int seconds = accessLimit.seconds();
//            int maxCount = accessLimit.maxCount();
//            boolean login = accessLimit.needLogin();
//            String key = request.getRequestURI();
//            //如果需要登录
//            if (login){
//                //获取登录的session进行判断
//                //.....
//                key+=""+"1";  //这里假设用户是1,项目中是动态获取的userId
//            }
//            //从redis中获取用户访问的次数
//            Integer count = (Integer)redisService.get(key);
//            if (count == null){
//                //第一次访问
//                redisService.set(key,1);
//            } else if (count < maxCount){
//                //加1
//                redisService.incr(key);
//            } else {
//                //超出访问次数
//                throw new IdempotentException(Constant.ExceptionMessage.EXCEPTION_BRUSH,Constant.ExceptionCode.EXCEPTION_CODE);
//            }
//        }
//        return true;
//    }
//}
