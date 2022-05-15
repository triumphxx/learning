package org.triumphxx.dynamicallyswitchingdatasources.annotation;

import org.springframework.core.annotation.AliasFor;
import org.triumphxx.dynamicallyswitchingdatasources.prop.DataSourceType;
import org.triumphxx.dynamicallyswitchingdatasources.provider.DynamicDataSourceProvider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:triumphxx
 * @Date: 2022/5/10
 * @Time: 15:25
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 数据源配置注解
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.TYPE})
public @interface DataSource {

    String value() default DataSourceType.DEFAULT_DS_NAME;
}
