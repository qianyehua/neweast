/**
*@title
*@author liupc
*@version 1.0
*/
package com.skyjoo.neweast.biz.portal.domain.common;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.portal.domain.enums.EnumPublicHelpStatusType;

/**
 *����������
 *@author liupc
 *@version 1.0
 *@date 2014-11-4 ����9:42:38
 */
public class PublicHelpProperty extends Pagination<PublicHelpProperty>{
	
	private static final long serialVersionUID = -1778657750566817467L;

	/* ����  */
	private Long id;
	/* ����  --���� */
	private String title;
	/* ��������  */
	private String content;
	/* ����������Ŀid  */
	private Long categoryId;
	/* ������Ŀ����  */
	private String catCode;
	/* ״̬  */
	private int status;
	/* ����Ա  */
	private String operator;
	/* ����ʱ��  */
	private Date gmtCreate;
	/* ����޸�ʱ��  */
	private Date gmtModify;
	
	/* �洢��ѯʱ����Ŀ���� */
	private int catLevel;
	public int getCatLevel() {
		return catLevel;
	}

	public void setCatLevel(int catLevel) {
		this.catLevel = catLevel;
	}

	//ʱ��� ��ʼ
	private String startDate;
	//ʱ��� ����
	private String endDate;
	
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}

	public String getCatCode() {
		return catCode;
	}

	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
	public void setStatus(EnumPublicHelpStatusType status) {
		this.status = status.getValue();
	}
	public String getOperator() {
		return operator;
	}

	public void setOperator(String operator) {
		this.operator = operator;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public Date getGmtModify() {
		return gmtModify;
	}

	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
}
