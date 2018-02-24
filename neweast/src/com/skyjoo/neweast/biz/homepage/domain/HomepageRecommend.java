/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

/**
 * ��ҳ�Ƽ�����Ʒ��
 * @date 2014-11-12 10:47:14
 */
public class HomepageRecommend extends Pagination<HomepageRecommend> {

	private static final long serialVersionUID = 7283051431686524189L;
	
	public static final int STATUS_NORMAL = 0;
	public static final int STATUS_DELETE = 1;
	
	//pk,seq
	private Long id;
	//����ƷID
	private Long artId;
	//״̬��0-������1-��ɾ��
	private Integer status;
	//����Ա
	private String operator;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;
	//һ����ĿID
	private Long artCategoryId;

	/**����pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡpk,seq*/
	public Long getId() {
		return this.id;
	}
	
	/**��������ƷID*/
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	/**��ȡ����ƷID*/
	public Long getArtId() {
		return this.artId;
	}
	
	/**����״̬��0-������1-��ɾ��*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**��ȡ״̬��0-������1-��ɾ��*/
	public Integer getStatus() {
		return this.status;
	}
	
	/**���ò���Ա*/
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**��ȡ����Ա*/
	public String getOperator() {
		return this.operator;
	}
	
	/**���ô���ʱ��*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**��ȡ����ʱ��*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**��������޸�ʱ��*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**��ȡ����޸�ʱ��*/
	public Date getGmtModify() {
		return this.gmtModify;
	}
	
	/**����һ����ĿID*/
	public void setArtCategoryId(Long artCategoryId) {
		this.artCategoryId = artCategoryId;
	}
	/**��ȡһ����ĿID*/
	public Long getArtCategoryId() {
		return this.artCategoryId;
	}
	
	public boolean isNormal() {
		return this.status.intValue() == STATUS_NORMAL;
	}
}
