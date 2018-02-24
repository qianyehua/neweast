package com.skyjoo.neweast.biz.point.enums;

public enum EnumBadReasons {
    BAD_DATA("数据不全"), BAD_AMOUNT("赠送数目应为正整数且不超过10位"),REASON_TOLONG("赠送理由不能超过50字"), BAD_ACCOUNT("该账户状态不存在或已销户"),

    ;
    private EnumBadReasons(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    private String value;
}
