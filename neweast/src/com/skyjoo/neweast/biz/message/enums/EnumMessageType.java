package com.skyjoo.neweast.biz.message.enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumMessageType {
	  /**0 作品  (0:系统消息 1:评论消息 2:咨询消息 3：私信消息 4:订单消息 5:物流消息 6:支付消息 7:收藏消息 8:作品消息)*/
    SYSTEM(0, "系统消息","您有一个系统消息"),
    /**1 艺术品*/
    COMMENT(1, "评论消息","您有一个评论消息"),
    
    QUESTION(2, "咨询消息","您有一个咨询消息"),
    
    PERSONAL(3,"私信消息","您有一个私信消息"),
    
    TRADE_ORDER(4,"订单消息","您有一个订单消息"),
    
    LOGISTIC(5,"物流消息","您有一个物流消息"),
    
    PAY(6,"支付消息","您有一个支付消息"),
    
    COLLECT(7,"收藏消息","您有一个收藏消息"),
    
    ART(8,"作品消息","您有一个作品消息"),
    
    BECOMEARTIST(9,"入驻消息","您有一条入驻消息")
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
