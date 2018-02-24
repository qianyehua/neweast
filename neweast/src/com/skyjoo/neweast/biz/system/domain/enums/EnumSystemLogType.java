package com.skyjoo.neweast.biz.system.domain.enums;
/**
 * ϵͳ��������ö�ٶ���
 *
 */
public enum EnumSystemLogType {

	SYSTEM(0, "��̨ϵͳ����"),
	STOCK(1, "����Ʒ���"),
	MEMBER(2, "���������"),
	END_DAY_MANAGE(3, "���չ���"),
	TRADE_SYSTEM(4, "����ϵͳ����");
	
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
