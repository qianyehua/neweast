package com.skyjoo.neweast.biz.trade.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumRefundReason {
	
	unDeliverGoods("1000","seller","长时间未发货"),
	unReceived("1001","seller","长时间未收到货"),
	qualityProblems("1002","buyer","货物与描述不符或有质量问题"),
	consultationsReturn("1003","buyer","与卖家协商退换货"),
	others("9999","buyer","其他");


	private String code;
	
	private String holder;
	
	private String description;

	private EnumRefundReason(String code,String holder,String description) {
		this.code = code;
		this.holder = holder;
		this.description = description;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getHolder() {
		return holder;
	}

	public void setHolder(String holder) {
		this.holder = holder;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public static Map<String, String> toMap() {
        Map<String, String> enumDataMap = new HashMap<String, String>();
        for (EnumRefundReason institution : values()) {
            enumDataMap.put(institution.getCode(), institution.getDescription());
        }
        return enumDataMap;
    }
	
	public static EnumRefundReason getByCode(String code) {
		if (code == null) {
			return null;
		}
		for (EnumRefundReason institution : values()) {
			if (code.equalsIgnoreCase(institution.getCode()))
				return institution;
		}
		return null;
	}
}
