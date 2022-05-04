package org.triumphxx.globaloperation.response;



/**
 * @author:triumphxx
 * @Date:2020/5/4
 * @Time:5:00 下午
 * @desc:统一数据返回格式
 **/
public class Result {
    /**状态码*/
   private Integer code;
   /**描述信息*/
   private String msg;

    public static Result ok(String msg) {
        return new Result(200, msg);
    }

    public static Result error(String msg) {
        return new Result(500, msg);
    }


    public static Result error(Integer code,String msg){
        return new Result(code, msg);
    }

    public Result(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public Result setCode(Integer code) {
        this.code = code;
        return this;
    }

    public String getMsg() {
        return msg;
    }

    public Result setMsg(String msg) {
        this.msg = msg;
        return this;
    }

}
