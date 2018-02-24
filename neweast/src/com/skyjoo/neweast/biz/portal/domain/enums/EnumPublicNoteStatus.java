package com.skyjoo.neweast.biz.portal.domain.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * ����״̬ö����
 * 
 * @author liupc
 * @version $Id: EnumAuditStatus.java,v 0.1 2014-10-31 09:36:01 liupc Exp $
 */
public enum EnumPublicNoteStatus {
    
    NEW(0, "�����"),     // �����
    REJECT(2, "�˻�"), // ���δͨ��
    PASS(1, "ͨ��"),    // ���ͨ��
    DELETE(3,"��ɾ��");  // ��ɾ��
    
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
