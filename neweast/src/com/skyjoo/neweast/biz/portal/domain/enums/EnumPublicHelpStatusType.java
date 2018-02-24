/**
*@title
*@author liupc
*@version 1.0
*/
package com.skyjoo.neweast.biz.portal.domain.enums;

/**
 *��������״̬��
 *@author liupc
 *@version 1.0
 *@date 2014-11-4 ����9:50:19
 */
public enum EnumPublicHelpStatusType {
	NORMAL(0,"����"),
	DELETE(1,"��ɾ��");
	
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
