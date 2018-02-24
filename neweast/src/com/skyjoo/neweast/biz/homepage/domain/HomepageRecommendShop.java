package com.skyjoo.neweast.biz.homepage.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * ��ҳ�����ƹ��
 * @author lxh
 * @version 2015-05-26 13:44:46
 */
public class HomepageRecommendShop extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1472014826219981179L;
	
	public static final int STATUS_NORMAL = 1;
	public static final int STATUS_DELETE = -1;
	
	//seq,pk
	private Long id;
	//����ID
	private Long shopId;
	//״̬��1������-1��ɾ��
	private Integer status;
	//����Ա
	private String operator;
	//�޸�ʱ��
	private Date gmtCreate;
	//
	private Date gmtModify;

	/**����seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡseq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**���õ���ID*/
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	/**��ȡ����ID*/
	public Long getShopId() {
		return this.shopId;
	}
	
	/**����״̬��1������-1��ɾ��*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**��ȡ״̬��1������-1��ɾ��*/
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
	
	/**�����޸�ʱ��*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**��ȡ�޸�ʱ��*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**����*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**��ȡ*/
	public Date getGmtModify() {
		return this.gmtModify;
	}
	
	public boolean isNormal() {
		return this.status.intValue() == STATUS_NORMAL;
	}
}