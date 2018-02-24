/*
 * Skyjoo Inc.
 * Copyright (c) 2011 All Rights Reserved.
 *
 * Author     :Administrator
 * Version    :1.0
 * Create Date:2017年4月25日
 */
package com.skyjoo.neweast.biz.media.domain.enums;

/**
 * @author ywb
 * @version $Id: EnumResult.java,v 0.1 2017年4月25日 上午9:34:07 Administrator Exp $
 */
public enum EnumResult {
    SUCCESS("SUCCESS"), FAILE("FAILE");

    private String val;

    /**
     * 
     */
    private EnumResult(String res) {
        this.val = res;
    }

    public String getVal() {
        return val;
    }
}
