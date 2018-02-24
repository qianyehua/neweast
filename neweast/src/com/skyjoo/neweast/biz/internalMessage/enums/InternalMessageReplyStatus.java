package com.skyjoo.neweast.biz.internalMessage.enums;

import java.util.HashMap;
import java.util.Map;

public enum InternalMessageReplyStatus {
	noRepled("0","Î´»Ø¸´"),
	hasReplied("1","ÒÑ»Ø¸´");
	private String type;
	private String description;
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	InternalMessageReplyStatus() {
	}
	InternalMessageReplyStatus(String type,String description){
		this.type=type;
		this.description=description;
	}
	
	public static Map<String, String> toMap() {
        Map<String, String> enumDataMap = new HashMap<String, String>();
        for (InternalMessageReplyStatus institution : values()) {
            enumDataMap.put(institution.getType(), institution.getDescription());
        }
        return enumDataMap;
    }

}
