package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

public class TradeLog {

	/**
	 * pk,seq
	 */
	private Long id;
	/**
	 * ����id
	 */
	private Long orderId;
	/**
	 * ������
	 */
	private String tradeNo;
	/**
	 * ������
	 */
	private String operator;
	/**
	 * ����ip
	 */
	private String operateIP;
	/**
	 * ����ǰ����״̬
	 */
	private String preTradeStatus;
	/**
	 * �����󶩵�״̬
	 */
	private String postTradeStatus;
	/**
	 * �˿�id
	 */
	private Long refundId;
	/**
	 * ����ǰ�˿�״̬
	 */
	private String preRefundStatus;
	/**
	 * �������˿�״̬
	 */
	private String postRefundStatus;
	/**
	 * ����ʱ��
	 */
	private Date gmtCreate;
	/**
	 * ���email
	 */
	private String buyerEmail;
	/**
	 * ����email
	 */
	private String sellerEmail;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getOrderId() {
		return orderId;
	}
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	public String getTradeNo() {
		return tradeNo;
	}
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public String getOperateIP() {
		return operateIP;
	}
	public void setOperateIP(String operateIP) {
		this.operateIP = operateIP;
	}
	public String getPreTradeStatus() {
		return preTradeStatus;
	}
	public void setPreTradeStatus(String preTradeStatus) {
		this.preTradeStatus = preTradeStatus;
	}
	public String getPostTradeStatus() {
		return postTradeStatus;
	}
	public void setPostTradeStatus(String postTradeStatus) {
		this.postTradeStatus = postTradeStatus;
	}
	public Long getRefundId() {
		return refundId;
	}
	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}
	public String getPreRefundStatus() {
		return preRefundStatus;
	}
	public void setPreRefundStatus(String preRefundStatus) {
		this.preRefundStatus = preRefundStatus;
	}
	public String getPostRefundStatus() {
		return postRefundStatus;
	}
	public void setPostRefundStatus(String postRefundStatus) {
		this.postRefundStatus = postRefundStatus;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	
}
