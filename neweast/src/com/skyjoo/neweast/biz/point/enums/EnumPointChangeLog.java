package com.skyjoo.neweast.biz.point.enums;

public enum EnumPointChangeLog {
	LOGIN("login", "登录"), TRADE("trade", "交易"), COMMENT("comment", "评论"), CONCERN(
			"concern", "关注"), TRADEaPPRAISSE("trade_appraise", "交易评价"), CERTIFICATION(
			"certification", "实名认证"), BANKBIND("bank_bind", "绑定银行"), ADDITION(
			"addition", "加成"), PRESENT("present", "活动赠送"), STORCONSUME(
			"store_consume", "商城消费"), STOREBACK("store_back", "商城退回"), STORPRESENT(
			"store_present", "商城赠送");
	private String value;
	private String desc;

	private EnumPointChangeLog(String value, String desc) {
		this.desc = desc;
		this.value = value;
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
}
