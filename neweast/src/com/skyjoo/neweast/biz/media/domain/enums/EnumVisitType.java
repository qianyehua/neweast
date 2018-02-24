/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月24日
 */
package com.skyjoo.neweast.biz.media.domain.enums;

/**
 * @author ywb
 * @version $Id: EnumVisitType.java,v 0.1 2017年4月24日 下午2:35:58 Administrator Exp $
 */
public enum EnumVisitType {
    DIRECT(1,"直接访问"),
    LOCAL_TRANS(2,"本地转换"),
    MIDDLE_TRANS(3,"中间过渡");
    
    
    private int value;

    private String desc;
    
    private EnumVisitType(int val,String desc) {
        this.value = val;
        this.desc = desc;
    }

    
    public int getValue() {
        return value;
    }

    public String getDesc() {
        return desc;
    }

}
