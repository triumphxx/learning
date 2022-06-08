package org.triumphxx.interfacetools.annotation;

import com.fasterxml.jackson.annotation.JacksonAnnotationsInside;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.triumphxx.interfacetools.enums.DesensitizedTypeEnum;
import org.triumphxx.interfacetools.utils.DesensitizedSerialize;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author:triumphxx
 * @Date:2022/6/8
 * @Time:11:23
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 脱敏注解，使用返回数据时，序列化的过程中进行处理脱敏数据
 **/
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
@JacksonAnnotationsInside
@JsonSerialize(using = DesensitizedSerialize.class)
public @interface Desensitized {
    /**
     * 脱敏数据类型, 非Customer时, 将忽略 refixNoMaskLen 和 suffixNoMaskLen 和 maskStr
     */
    DesensitizedTypeEnum type() default DesensitizedTypeEnum.CUSTOMER;

    /**
     * 前置不需要打码的长度
     */
    int prefixNoMaskLen() default 0;

    /**
     * 后置不需要打码的长度
     */
    int suffixNoMaskLen() default 0;

    /**
     * 用什么打码
     */
    String maskStr() default "*";

}
