package com.skyjoo.neweast.biz.portal.domain.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * 公告状态枚举类
 * 
 * @author liupc
 * @version $Id: EnumAuditStatus.java,v 0.1 2014-10-31 09:36:01 liupc Exp $
 */
public enum EnumPublicNoteStatus {
    
    NEW(0, "待审核"),     // 待审核
    REJECT(2, "退回"), // 审核未通过
    PASS(1, "通过"),    // 审核通过
    DELETE(3,"已删除");  // 已删除
    
    private Integer value;
    private String description;
    
    private EnumPublicNoteStatus(Integer value, String description) {
        this.value = value;
        this.description = description;
    }
    
    public Integer getValue() {
        return value;
    }
    
    public String getDescription() {
        return description;
    }
    public static Map<Integer, String> toMap() {
        Map<Integer, String> enumStatusMap = new HashMap<Integer, String>();
        for (EnumPublicNoteStatus status : EnumPublicNoteStatus.values()) {
        	enumStatusMap.put(status.getValue(),status.getDescription());
        }
        return enumStatusMap;
    }
}
