package com.skyjoo.neweast.biz.art.enums;

public enum EnumArtCategoryPropertyType {

    Global(1,"ȫ������"),
    Private(2,"˽������");
   
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
