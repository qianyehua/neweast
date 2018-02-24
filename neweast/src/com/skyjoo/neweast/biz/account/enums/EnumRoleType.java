package com.skyjoo.neweast.biz.account.enums;

public enum EnumRoleType {
	
    NORMAL(1, "普通买家"),
    
    AGENT(2, "机构买家"),
 
    ;
    private int value;
    private String desp;
    
    private EnumRoleType(int value, String desp) {
        this.value = value;
        this.desp = desp;
    }

    public Integer getValue() {
        return value;
    }

    public String getDesp() {
        return desp;
    }
}
