package com.skyjoo.neweast.biz.system.domain.enums;
/**
 * 系统操作类型枚举定义
 *
 */
public enum EnumSystemLogType {

	SYSTEM(0, "后台系统设置"),
	STOCK(1, "艺术品相关"),
	MEMBER(2, "交易商相关"),
	END_DAY_MANAGE(3, "日终管理"),
	TRADE_SYSTEM(4, "交易系统设置");
	
    private int value;
    private String description;
    
    private EnumSystemLogType(int value, String description) {
        this.value = value;
    }
    
    public int getValue() {
        return value;
    }
    
    public String getDescription() {
        return description;
    }

    public boolean equals(int status) {
        return this.value == status;
    }
    
    public boolean equals(Integer status) {
        if (status != null && this.value == status) {
            return true;
        }
        return false;
    }
}
