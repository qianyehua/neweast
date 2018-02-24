/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017��4��26��
 */
package com.skyjoo.neweast.biz.homepage.domain;

/**
 * ��ҳͼƬ����ö����
 * @author ywb
 * @version $Id: EnumHomePageType.java,v 0.1 2017��4��26�� ����1:48:31 Administrator Exp $
 */
public enum EnumHomePageType {
    PC(1, "PC"), APP(2, "App"),APP����(3, "App����ҳ");

    private int    val;
    private String desc;

    /**
     * 
     */
    private EnumHomePageType(int val, String desc) {
        this.val = val;
        this.desc = desc;
    }

    public int getVal() {
        return val;
    }

    public String getDesc() {
        return desc;
    }
}
