package com.skyjoo.neweast.biz.art.enums;

public enum EnumArtCategoryPropertyType {

    Global(1,"全局属性"),
    Private(2,"私有属性");
   
    private int value;
    private String desc;
    private EnumArtCategoryPropertyType(int val, String desc){
        this.value =val;
        this.desc = desc;
    }
    public int getValue() {
        return value;
    }
    public String getDesc() {
        return desc;
    }
    
}
