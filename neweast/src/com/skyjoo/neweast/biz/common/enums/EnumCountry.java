package com.skyjoo.neweast.biz.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 国家/地区枚举
 * @author lxh
 * @version 2015年8月20日 上午10:15:49
 */
public enum EnumCountry {
	CN("CN", "中国大陆"),
	SG("SG", "新加坡"),
	TW("TW", "台湾"),
	MY("MY", "马来西亚");
	
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
