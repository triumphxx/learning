package org.triumphxx.interfacetools.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.triumphxx.interfacetools.common.Result;

/**
 * @author:triumphxx
 * @Date:2020/8/29
 * @Time:10:09 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 全局异常处理
 **/
@Slf4j
@RestControllerAdvice
public class GlobalException {

    @ExceptionHandler(IdempotentException.class)
    public Result handler(IdempotentException e){
        return Result.fail("你的请求异常了！！",e.getMessage());
    }

}
