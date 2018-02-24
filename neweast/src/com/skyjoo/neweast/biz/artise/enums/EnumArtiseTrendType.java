package com.skyjoo.neweast.biz.artise.enums;

public enum EnumArtiseTrendType {
	//0:入驻 1:发布 2：购买 默认入驻
	JOIN(0,"入驻"),
	PUBLISH(1,"发布"),
	BUY(2,"购买"),
	;
	 private int value;
	 private String desp;
	 
	 private EnumArtiseTrendType(int value,String desp){
		 this.value=value;
		 this.desp=desp;
	 }
	 public Integer getValue() {
	        return value;
	    }

	    public String getDesp() {
	        return desp;
	    }
}
