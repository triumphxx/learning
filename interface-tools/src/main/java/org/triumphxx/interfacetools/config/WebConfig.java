//package org.triumphxx.interfacetools.config;//package org.triumphxx.config;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.triumphxx.interfacetools.interceptor.IdempotentInterceptor;
//import org.triumphxx.interfacetools.interceptor.NotBrushInterceptor;
//
///**
// * @author:triumphxx
// * @Date:2020/8/29
// * @Time:10:26 下午
// * @微信公众号：北漂码农有话说
// * @网站：http://blog.triumphxx.com.cn
// * @GitHub https://github.com/triumphxx
// * @Desc: Mvc配置,注册拦截器
// **/
//@Configuration
//public class WebConfig implements WebMvcConfigurer {
//
//    @Autowired
//    IdempotentInterceptor idempotentInterceptor;
//    @Autowired
//    NotBrushInterceptor notBrushInterceptor;
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //对所有的方法进行拦截
//        registry.addInterceptor(idempotentInterceptor).addPathPatterns("/**");
//        registry.addInterceptor(notBrushInterceptor).addPathPatterns("/**");
//    }
//}
