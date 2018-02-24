package com.skyjoo.neweast.biz.portal.domain.enums;

import java.util.HashMap;
import java.util.Map;


/**
 * ��������ö����
 *
 * @author liupc
 * @version $Id: EnumPublicNoteType.java,v 0.1 2014-10-31 09:30:09 liupc Exp $
 */
public enum EnumPublicNoteType {

    INFO(1, "��Ϣ����"),
    ACTIVITY(2, "������ҵ�"),
    REPORTS(3, "ý�屨��");

    private Integer value;
    private String description;

    private EnumPublicNoteType(Integer value, String description) {
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
        Map<Integer, String> enumTypeMap = new HashMap<Integer, String>();
        for (EnumPublicNoteType type : EnumPublicNoteType.values()) {
        	enumTypeMap.put(type.getValue(), type.getDescription());
        }
        return enumTypeMap;
    }
}
