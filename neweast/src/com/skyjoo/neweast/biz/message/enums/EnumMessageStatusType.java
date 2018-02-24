package com.skyjoo.neweast.biz.message.enums;

import java.util.HashMap;
import java.util.Map;


/**
 * 消息阅读状态类型
 * @author paul
 * @version 2016-1-27 下午6:03:31
 */
public enum EnumMessageStatusType {
	/**1：未读*/
	UNREAD(1, "未读"),
	/**2：已读 */
	READ(2, "已读"),
	;
	private static Map<Integer, EnumMessageStatusType> map = new HashMap<Integer, EnumMessageStatusType>();
	static {
		for (EnumMessageStatusType type : EnumMessageStatusType.values()) {
			map.put(type.getValue(), type);
		}
	}
	
	private Integer value;
	private String desp;
	
	private EnumMessageStatusType(Integer value, String desp) {
		this.value = value;
		this.desp = desp;
	}

	public Integer getValue() {
		return value;
	}

	public String getDesp() {
		return desp;
	}
	
	public static EnumMessageStatusType getByValue(Integer value) {
		return map.get(value);
	}
}
