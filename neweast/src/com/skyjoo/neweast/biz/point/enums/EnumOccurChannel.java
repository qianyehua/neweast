package com.skyjoo.neweast.biz.point.enums;

public enum EnumOccurChannel {
	
	ONLINE_PC("online_pc", "现货pc",1),
	ONLINE_APP("online_app", "现货app",2),
	UNIT("unit", "unit份额交易",3);

	private String value;
	private String desc;
	private int index;

	private EnumOccurChannel(String value, String desc,int index) {
		this.value = value;
		this.desc = desc;
		this.index = index;
	}


	public static EnumOccurChannel getDesc(String value) {
		for (EnumOccurChannel it : EnumOccurChannel.values()) {
			if (it.value.equals(value)) {
				return it;
			}
		}
		return null;
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
