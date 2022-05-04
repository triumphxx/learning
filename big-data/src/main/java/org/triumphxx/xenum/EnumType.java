package org.triumphxx.xenum;

public enum EnumType {
    DATATYPE("DATATYPE", "数据提取的数据类型");
    // 枚举分类
    private String typeCode;
    // 枚举分类描述
    private String typeDesc;

    EnumType(String typeCode, String typeDesc) {
        this.typeCode = typeCode;
        this.typeDesc = typeDesc;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public String getTypeDesc() {
        return typeDesc;
    }
}
