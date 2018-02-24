/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月26日
 */
package com.skyjoo.neweast.biz.homepage.domain;

/**
 * 首页图片类型枚举类
 * @author ywb
 * @version $Id: EnumHomePageType.java,v 0.1 2017年4月26日 下午1:48:31 Administrator Exp $
 */
public enum EnumHomePageType {
    PC(1, "PC"), APP(2, "App"),APP开屏(3, "App开屏页");

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
