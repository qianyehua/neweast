package com.skyjoo.neweast.biz.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * ����/����ö��
 * @author lxh
 * @version 2015��8��20�� ����10:15:49
 */
public enum EnumCountry {
	CN("CN", "�й���½"),
	SG("SG", "�¼���"),
	TW("TW", "̨��"),
	MY("MY", "��������");
	
	private static Map<String, EnumCountry> map = new HashMap<String, EnumCountry>();
	static {
		for (EnumCountry country : values()) {
			map.put(country.getValue(), country);
		}
	}
	
	private String value;
	private String desp;
	
	private EnumCountry(String value, String desp) {
		this.value = value;
		this.desp = desp;
	}

	public String getValue() {
		return value;
	}

	public String getDesp() {
		return desp;
	}
	
	public static EnumCountry getByValue(String value) {
		return map.get(value);
	}
}
