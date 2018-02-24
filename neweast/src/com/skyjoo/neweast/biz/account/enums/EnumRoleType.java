package com.skyjoo.neweast.biz.account.enums;

public enum EnumRoleType {
	
    NORMAL(1, "��ͨ���"),
    
    AGENT(2, "�������"),
 
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
