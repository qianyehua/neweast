package com.skyjoo.neweast.biz.message.enums;

import java.util.HashMap;
import java.util.Map;


/**
 * ��Ϣ�Ķ�״̬����
 * @author paul
 * @version 2016-1-27 ����6:03:31
 */
public enum EnumMessageStatusType {
	/**1��δ��*/
	UNREAD(1, "δ��"),
	/**2���Ѷ� */
	READ(2, "�Ѷ�"),
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
