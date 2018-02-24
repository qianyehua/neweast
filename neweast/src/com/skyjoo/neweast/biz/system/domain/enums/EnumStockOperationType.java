package com.skyjoo.neweast.biz.system.domain.enums;

public enum EnumStockOperationType {
    
    LIST("list"),
    SUSPEND("suspend"),
    PAUSE("pause"),
    RESUM("resum"),
    DELIST("delist"),
    BAD_WEATHER_PAUSE("badWeatherPause");
    
    private String value;
    
    EnumStockOperationType(String value) {
    	this.value = value;
    }

	public String getValue() {
		return value;
	}
    
    public boolean equals(String type) {
        if (this.value.equalsIgnoreCase(type)) {
            return true;
        }
        return false;
    }
    
    public boolean equals(EnumStockOperationType type) {
        if (type != null && this.value.equalsIgnoreCase(type.getValue())) {
            return true;
        }
        return false;
    }

}
