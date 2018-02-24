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
	 * 卖家ID
	 */
	private Long sellerId;
	/**
	 * 艺术品ID
	 */
	private Long artId;
	/**
	 * 买家ID
	 */
	private Long buyerId;
	/**
	 * 评价等级（1-好评，2-中评，3-差评）
	 */
	private Integer appraiseLevel;
	/**
	 * 评价内容
	 */
	private String appraiseContant;
	/**
	 * 得分
	 */
	private Long score;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 最后修改时间
	 */
	private Date gmtModify;
	/**
	 * 评价相关的orderId
	 */
	private Long orderId;
	//发起人ID：买家ID或卖家ID
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
