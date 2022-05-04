package org.triumphxx.maildelivery.constant;

/**
 * @author:wangyupeng
 * @Date:2019-12-10
 * @Time:21:54
 * @desc:
 **/
public enum ConstantEnum {
    OK(200, "成功"),
    FAIL(404, "失败");

    ConstantEnum(int number, String description) {
        this.code = number;
        this.description = description;
    }

    private int code;
    private String description;

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

}
