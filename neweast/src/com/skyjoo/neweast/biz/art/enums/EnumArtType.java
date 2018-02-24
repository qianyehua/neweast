package com.skyjoo.neweast.biz.art.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumArtType {
	  /**0 ��Ʒ*/
    ARTUNSELL(0, "��Ʒ"),
    /**1 ����Ʒ*/
    ARTSELL(1, "����Ʒ"),
    ;
    private static Map<Integer, EnumArtType> map = new HashMap<Integer, EnumArtType>();
    static {
        for (EnumArtType artType : values()) {
            map.put(artType.getValue(), artType);
        }
    }
    private int value;
    private String desp;
    
    private EnumArtType(int value, String desp) {
        this.value = value;
        this.desp = desp;
    }

    public Integer getValue() {
        return value;
    }

    public String getDesp() {
        return desp;
    }
    
    public static  EnumArtType getDespByValue(int value){
        return map.get(value);     
    }
}
