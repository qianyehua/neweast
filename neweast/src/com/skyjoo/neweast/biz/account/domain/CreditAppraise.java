package com.skyjoo.neweast.biz.account.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

public class CreditAppraise extends DomainBase {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * pk,seq
	 */
	private Long id;
	/**
	 * ����ID
	 */
	private Long sellerId;
	/**
	 * ����ƷID
	 */
	private Long artId;
	/**
	 * ���ID
	 */
	private Long buyerId;
	/**
	 * ���۵ȼ���1-������2-������3-������
	 */
	private Integer appraiseLevel;
	/**
	 * ��������
	 */
	private String appraiseContant;
	/**
	 * �÷�
	 */
	private Long score;
	/**
	 * ����ʱ��
	 */
	private Date gmtCreate;
	/**
	 * ����޸�ʱ��
	 */
	private Date gmtModify;
	/**
	 * ������ص�orderId
	 */
	private Long orderId;
	//������ID�����ID������ID
	private Long operatorId;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getSellerId() {
		return sellerId;
	}
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	public Long getArtId() {
		return artId;
	}
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	public Long getBuyerId() {
		return buyerId;
	}
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	public Integer getAppraiseLevel() {
		return appraiseLevel;
	}
	public void setAppraiseLevel(Integer appraiseLevel) {
		this.appraiseLevel = appraiseLevel;
	}
	public String getAppraiseContant() {
		return appraiseContant;
	}
	public void setAppraiseContant(String appraiseContant) {
		this.appraiseContant = appraiseContant;
	}
	public Long getScore() {
		return score;
	}
	public void setScore(Long score) {
		this.score = score;
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

	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Long getOperatorId() {
		return operatorId;
	}
	public void setOperatorId(Long operatorId) {
		this.operatorId = operatorId;
	}
	
}
