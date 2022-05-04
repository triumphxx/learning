package org.triumphxx.xenum;

/**
 * @author:triumphxx
 * @Date: 2021/12/27
 * @Time: 17:21
 * @微信公众号：北漂码农有话说
 * @网站：https://blog.triumphxx.com.cn
 * @GitHub https://github.com/triumphxx
 * @Desc: 对应表的枚举类
 **/
public enum EnumCode {
    DATATYPE_CORE(EnumType.DATATYPE.getTypeCode(), "CORE_NB", "提取核心数据-新单");
    // 枚举分类
    private String typeCode;
    //枚举值
    private String code;
    //枚举值描述
    private String decs;

    EnumCode(String typeCode, String code, String decs) {
        this.typeCode = typeCode;
        this.code = code;
        this.decs = decs;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getCode() {
        return code;
    }

    public String getDecs() {
        return decs;
    }
}
