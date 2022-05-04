package org.triumphxx.interfacetools.common;

import lombok.Data;

/**
 * @author:triumphxx
 * @Date:2020/8/29
 * @Time:10:01 下午
 * @微信公众号：北漂码农有话说
 * @网站：http://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 返回结果封装类
 **/
@Data
public class Result {

    private int code;
    private String msg;
    private Object data;

    public static Result succ() {
        return succ(200, "操作成功", null);
    }

    public static Result succ(Object data) {
        return succ(200, "操作成功", data);
    }

    public static Result succ(Integer code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }

    public static Result fail(String msg) {
        return fail(400, msg, null);
    }

    public static Result fail(String msg, Object data) {
        return fail(400, msg, data);
    }

    public static Result fail(int code, String msg, Object data) {
        Result result = new Result();
        result.setCode(code);
        result.setMsg(msg);
        result.setData(data);
        return result;
    }
}
