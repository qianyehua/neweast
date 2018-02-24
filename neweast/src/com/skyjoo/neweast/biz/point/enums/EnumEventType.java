package com.skyjoo.neweast.biz.point.enums;

public enum EnumEventType {
	LOGIN("login", "登录",1),
	TRADE("trade", "交易",2), 
	COMMENT("comment", "评论",3), 
	TRADEAPPRAISE("trade_appraise", "交易评价",4), 
	CERTIFICATION("certification", "实名认证",5), 
	BANKBIND("bank_bind", "绑定银行",6),
	CONCERN("concern","关注",7),   
	;

	private String value;
	private String desc;
	private int index;

	public static EnumEventType getDesc(String value) {
		for (EnumEventType it : EnumEventType.values()) {
			if (it.value.equals(value)) {
				return it;
			}
		}
		return null;
	}

	
	private EnumEventType(String value, String desc,int index) {
		this.index = index;
		this.value = value;
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
}
