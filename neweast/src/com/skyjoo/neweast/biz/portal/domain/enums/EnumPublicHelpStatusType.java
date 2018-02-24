/**
*@title
*@author liupc
*@version 1.0
*/
package com.skyjoo.neweast.biz.portal.domain.enums;

/**
 *帮助中心状态类
 *@author liupc
 *@version 1.0
 *@date 2014-11-4 上午9:50:19
 */
public enum EnumPublicHelpStatusType {
	NORMAL(0,"正常"),
	DELETE(1,"已删除");
	
	private Integer value;
	private String description;
	
	private EnumPublicHelpStatusType(Integer value,String description){
		this.value = value;
		this.description = description;
	}
	public Integer getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }
}
