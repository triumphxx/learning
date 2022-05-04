package org.triumphxx.interfacetools.exception;

import lombok.Getter;

/**
 * @author:triumphxx
 * @Date:2020/8/29
 * @Time:11:10 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 自定义异常
 **/
@Getter
public class IdempotentException extends Exception {
    private int code;
    private String message;
    public IdempotentException(String message,int code){
        this.code = code;
        this.message = message;
    }
}
