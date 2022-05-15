package org.triumphxx.dynamicallyswitchingdatasources.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.triumphxx.dynamicallyswitchingdatasources.annotation.DataSource;
import org.triumphxx.dynamicallyswitchingdatasources.dynamic.DynamicDataSourceContextHolder;

import java.util.Objects;

/**
 * @author:triumphxx
 * @Date: 2022/5/10
 * @Time: 15:49 
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 解析注解 @DataSource 切面
 **/
@Aspect
@Order(2)
@Component
public class DataSourceAspect {
    @Pointcut("@annotation(org.triumphxx.dynamicallyswitchingdatasources.annotation.DataSource)"
             + "|| @within(org.triumphxx.dynamicallyswitchingdatasources.annotation.DataSource)")
    public void dsPc() {

    }

    @Around("dsPc()")
    public Object around(ProceedingJoinPoint point) throws Throwable {
        DataSource dataSource = getDataSource(point);

        if (Objects.nonNull(dataSource)) {
            //获取注解中数据源的名称
            String value = dataSource.value();
            DynamicDataSourceContextHolder.setDataSourceType(value);
        }

        try {
            return point.proceed();
        } finally {
            // 销毁数据源 在执行方法之后
            DynamicDataSourceContextHolder.clearDataSourceType();
        }
    }

    /**
     * 获取需要切换的数据源
     */
    public DataSource getDataSource(ProceedingJoinPoint point) {
        MethodSignature signature = (MethodSignature) point.getSignature();
        DataSource dataSource = AnnotationUtils.findAnnotation(signature.getMethod(), DataSource.class);
        if (Objects.nonNull(dataSource)) {
            return dataSource;
        }
        return AnnotationUtils.findAnnotation(signature.getDeclaringType(), DataSource.class);
    }
}
