package com.skyjoo.neweast.biz.message.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumMessageType {
	  /**0 ��Ʒ  (0:ϵͳ��Ϣ 1:������Ϣ 2:��ѯ��Ϣ 3��˽����Ϣ 4:������Ϣ 5:������Ϣ 6:֧����Ϣ 7:�ղ���Ϣ 8:��Ʒ��Ϣ)*/
    SYSTEM(0, "ϵͳ��Ϣ","����һ��ϵͳ��Ϣ"),
    /**1 ����Ʒ*/
    COMMENT(1, "������Ϣ","����һ��������Ϣ"),
    
    QUESTION(2, "��ѯ��Ϣ","����һ����ѯ��Ϣ"),
    
    PERSONAL(3,"˽����Ϣ","����һ��˽����Ϣ"),
    
    TRADE_ORDER(4,"������Ϣ","����һ��������Ϣ"),
    
    LOGISTIC(5,"������Ϣ","����һ��������Ϣ"),
    
    PAY(6,"֧����Ϣ","����һ��֧����Ϣ"),
    
    COLLECT(7,"�ղ���Ϣ","����һ���ղ���Ϣ"),
    
    ART(8,"��Ʒ��Ϣ","����һ����Ʒ��Ϣ"),
    
    BECOMEARTIST(9,"��פ��Ϣ","����һ����פ��Ϣ")
    ;
    private int value;
    private String desp;
    private String title;
    private static Map<Integer, EnumMessageType> map = new HashMap<Integer, EnumMessageType>();
    static {
        for (EnumMessageType type : EnumMessageType.values()) {
            map.put(type.getValue(), type);
        }
    }
    
    private EnumMessageType(int value, String desp,String title) {
        this.value = value;
        this.desp = desp;
        this.title = title;
    }

    public Integer getValue() {
        return value;
    }

    public String getDesp() {
        return desp;
    }
    
    public String getTitle(){
        return title;
    }
    
    public static EnumMessageType getByValue(Integer value) {
        return map.get(value);
    }
}
