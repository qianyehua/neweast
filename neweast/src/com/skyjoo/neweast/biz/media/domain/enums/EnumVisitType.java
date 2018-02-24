/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017��4��24��
 */
package com.skyjoo.neweast.biz.media.domain.enums;

/**
 * @author ywb
 * @version $Id: EnumVisitType.java,v 0.1 2017��4��24�� ����2:35:58 Administrator Exp $
 */
public enum EnumVisitType {
    DIRECT(1,"ֱ�ӷ���"),
    LOCAL_TRANS(2,"����ת��"),
    MIDDLE_TRANS(3,"�м����");
    
    
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
