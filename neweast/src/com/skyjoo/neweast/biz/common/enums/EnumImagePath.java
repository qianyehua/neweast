package com.skyjoo.neweast.biz.common.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * @author JIANGFENGXU
 * @version 2016-7-14 下午4:46:33
 */
public enum EnumImagePath {
    /**我的头像上传路径*/
    HOMEPAGE("homepage/", "首页路径"),
    SHOPTEMPLATEPREVIEW("shopTemplatePreviewPic/","新增店铺模版 "),
    ARTICLE("article/","文章图片"),
    ACTIVITY("activity/","活动图片"),
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
