//package org.triumphxx.interfacetools.interceptor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import org.triumphxx.interfacetools.annotation.Idempotent;
//import org.triumphxx.interfacetools.exception.IdempotentException;
//import org.triumphxx.interfacetools.token.TokenService;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.lang.reflect.Method;
//
///**
// * @author:triumphxx
// * @Date:2020/8/29
// * @Time:9:29 下午
// * @微信公众号：北漂码农有话说
// * @网站：http://blog.triumphxx.com.cn
// * @GitHub https://github.com/triumphxx
// * @Desc： 方法拦截器
// **/
//@Component
//public class IdempotentInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    private TokenService tokenService;
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//        //进行方法的拦截，如若不是直接通过
//        if (!(handler instanceof HandlerMethod)) {
//            return true;
//        }
//        HandlerMethod handlerMethod = (HandlerMethod) handler;
//        //获取方法
//        Method method = handlerMethod.getMethod();
//        //获取方法上是否标注注解
//        Idempotent idempotent = method.getAnnotation(Idempotent.class);
//        if (idempotent != null) {
//            //检查Token
//           try{
//               return tokenService.checkToken(request);
//           }catch (IdempotentException e){
//               throw e;
//           }
//
//        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//}
