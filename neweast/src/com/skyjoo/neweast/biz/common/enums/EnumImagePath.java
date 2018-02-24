package com.skyjoo.neweast.biz.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JIANGFENGXU
 * @version 2016-7-14 ����4:46:33
 */
public enum EnumImagePath {
    /**�ҵ�ͷ���ϴ�·��*/
    HOMEPAGE("homepage/", "��ҳ·��"),
    SHOPTEMPLATEPREVIEW("shopTemplatePreviewPic/","��������ģ�� "),
    ARTICLE("article/","����ͼƬ"),
    ACTIVITY("activity/","�ͼƬ"),
    ;
    private static Map<String, EnumImagePath> map = new HashMap<String, EnumImagePath>();
    static {
        for (EnumImagePath type : EnumImagePath.values()) {
            map.put(type.getValue(), type);
        }
    }
    
    private String value;
    private String desp;
    
    private EnumImagePath(String value, String desp) {
        this.value = value;
        this.desp = desp;
    }

    public String getValue() {
        return value;
    }

    public String getDesp() {
        return desp;
    }
    
    public static EnumImagePath getByValue(Integer value) {
        return map.get(value);
    }
}
