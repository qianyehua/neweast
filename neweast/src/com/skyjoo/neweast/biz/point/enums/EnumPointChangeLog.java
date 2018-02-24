package com.skyjoo.neweast.biz.point.enums;

public enum EnumPointChangeLog {
	LOGIN("login", "��¼"), TRADE("trade", "����"), COMMENT("comment", "����"), CONCERN(
			"concern", "��ע"), TRADEaPPRAISSE("trade_appraise", "��������"), CERTIFICATION(
			"certification", "ʵ����֤"), BANKBIND("bank_bind", "������"), ADDITION(
			"addition", "�ӳ�"), PRESENT("present", "�����"), STORCONSUME(
			"store_consume", "�̳�����"), STOREBACK("store_back", "�̳��˻�"), STORPRESENT(
			"store_present", "�̳�����");
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
