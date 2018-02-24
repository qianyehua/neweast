package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

public class TradeLog {

	/**
	 * pk,seq
	 */
	private Long id;
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 订单号
	 */
	private String tradeNo;
	/**
	 * 操作人
	 */
	private String operator;
	/**
	 * 操作ip
	 */
	private String operateIP;
	/**
	 * 操作前订单状态
	 */
	private String preTradeStatus;
	/**
	 * 操作后订单状态
	 */
	private String postTradeStatus;
	/**
	 * 退款id
	 */
	private Long refundId;
	/**
	 * 操作前退款状态
	 */
	private String preRefundStatus;
	/**
	 * 操作后退款状态
	 */
	private String postRefundStatus;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 买家email
	 */
	private String buyerEmail;
	/**
	 * 卖家email
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
