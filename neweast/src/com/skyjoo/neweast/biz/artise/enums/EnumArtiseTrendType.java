package com.skyjoo.neweast.biz.artise.enums;

public enum EnumArtiseTrendType {
	//0:��פ 1:���� 2������ Ĭ����פ
	JOIN(0,"��פ"),
	PUBLISH(1,"����"),
	BUY(2,"����"),
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
