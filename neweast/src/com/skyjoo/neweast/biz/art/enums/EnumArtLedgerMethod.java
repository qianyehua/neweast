package com.skyjoo.neweast.biz.art.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumArtLedgerMethod {
	  /**0 ���ս��*/
    MONEY(0, "���ս��"),
    /**1 ������*/
    RATE(1, "������"),
    ;
     
    private static Map<Integer, EnumArtLedgerMethod> map = new HashMap<Integer, EnumArtLedgerMethod>();
    static {
        for (EnumArtLedgerMethod artLedgerType : values()) {
            map.put(artLedgerType.getValue(), artLedgerType);
        }
    }
    private int value;
    private String desp;
    
    private EnumArtLedgerMethod(int value, String desp) {
        this.value = value;
        this.desp = desp;
    }

    public Integer getValue() {
        return value;
    }

    public String getDesp() {
        return desp;
    }
    
    public static  EnumArtLedgerMethod getDespByValue(int value){
        return map.get(value);     
    }
}
