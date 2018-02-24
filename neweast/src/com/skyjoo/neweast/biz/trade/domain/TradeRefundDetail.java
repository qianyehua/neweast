package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

public class TradeRefundDetail {
	/**
	 * ����id
	 * 
	 */
	private Long orderId;
	/**
	 * ������
	 */
	private String tradeNo;
	/**
	 * ����״̬
	 */
	private String orderStatus;
	/**
	 * ����Ʒ�۸�
	 */
	private Long artPrice;
	/**
	 * �˷�
	 */
	private Long logisticFund;
	/**
	 * Ӷ�� ������ѣ�
	 */
	private Long serviceFee;
	/**
	 * �����ܼ�
	 */
	private long totalFee;
	/**
	 * ��������ʱ��
	 */
	private Date orderGmtCreate;
	/**
	 * ����֧��ʱ��
	 */
	private Date orderPayTime;
	/**
	 * ��������ʱ��
	 */
	private Date orderDeliverTime;
	/**
	 * ����ȷ���ջ�ʱ��
	 */
	private Date confirmGoodsTime;
	/**
	 * ��ʱ����ʱ��
	 */
	private Date timeOutDate;
	/**
	 * ��ʱ��ִ�еĶ���
	 */
	private String processorName;
	/**
	 * �������
	 */
	private String buyerEmail;
	/**
	 * �������
	 */
	private String buyerName;
	/**
	 * ����ֻ���
	 */
	private String buyerMobile;
	/**
	 * ��ҵ绰
	 */
	private String buyerTel;
	/**
	 * ��������
	 */
	private String sellerEmail;
	/**
	 * ��������
	 */
	private String sellerName;
	/**
	 * �����ֻ���
	 */
	private String sellerMobile;
	/**
	 * ���ҵ绰
	 */
	private String sellerTel;
	/**
	 * �˿���
	 */
	private Long refundId;
	/**
	 * �˿�����ʱ��
	 */
	private Date refundApplyTime;
	/**
	 * �˿�ԭ��
	 */
	private String refundCause;
	/**
	 * �˿�ƾ֤
	 */
	private String refundEvidence;
	/**
	 * ������Ӧʱ��
	 */
	private Date respondTime;
	/**
	 * �˿�����
	 */
	private String refundNote;
	/**
	 * ���Ҿܾ�ԭ��
	 */
	private String rejectCause;
	/**
	 * ���Ҿܾ�ƾ֤
	 */
	private String rejectEvidence;
	/**
	 * �˿�״̬
	 */
	private String refundStatus;
	/**
	 * ��ݹ�˾
	 */
	private String company;
	/**
	 *�˵���
	 */
	private String logisticNo;
	/**
	 * �ջ� ����
	 */
	private String country;
	/**
	 * �ջ� ʡ
	 */
	private String province;
	/**
	 * �ջ� ��
	 */
	private String city;
	/**
	 * �ջ���ϸ��ַ
	 */
	private String address;
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
	public String getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Long getArtPrice() {
		return artPrice;
	}
	public void setArtPrice(Long artPrice) {
		this.artPrice = artPrice;
	}
	public Long getLogisticFund() {
		return logisticFund;
	}
	public void setLogisticFund(Long logisticFund) {
		this.logisticFund = logisticFund;
	}
	public Long getServiceFee() {
		return serviceFee;
	}
	public void setServiceFee(Long serviceFee) {
		this.serviceFee = serviceFee;
	}
	public Date getOrderGmtCreate() {
		return orderGmtCreate;
	}
	public void setOrderGmtCreate(Date orderGmtCreate) {
		this.orderGmtCreate = orderGmtCreate;
	}
	public Date getOrderPayTime() {
		return orderPayTime;
	}
	public void setOrderPayTime(Date orderPayTime) {
		this.orderPayTime = orderPayTime;
	}
	public Date getOrderDeliverTime() {
		return orderDeliverTime;
	}
	public void setOrderDeliverTime(Date orderDeliverTime) {
		this.orderDeliverTime = orderDeliverTime;
	}
	public Date getConfirmGoodsTime() {
		return confirmGoodsTime;
	}
	public void setConfirmGoodsTime(Date confirmGoodsTime) {
		this.confirmGoodsTime = confirmGoodsTime;
	}
	public Date getTimeOutDate() {
		return timeOutDate;
	}
	public void setTimeOutDate(Date timeOutDate) {
		this.timeOutDate = timeOutDate;
	}
	public String getProcessorName() {
		return processorName;
	}
	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}
	public String getBuyerEmail() {
		return buyerEmail;
	}
	public void setBuyerEmail(String buyerEmail) {
		this.buyerEmail = buyerEmail;
	}
	public String getBuyerName() {
		return buyerName;
	}
	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
	}
	public String getBuyerMobile() {
		return buyerMobile;
	}
	public void setBuyerMobile(String buyerMobile) {
		this.buyerMobile = buyerMobile;
	}
	public String getBuyerTel() {
		return buyerTel;
	}
	public void setBuyerTel(String buyerTel) {
		this.buyerTel = buyerTel;
	}
	public String getSellerEmail() {
		return sellerEmail;
	}
	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	public String getSellerMobile() {
		return sellerMobile;
	}
	public void setSellerMobile(String sellerMobile) {
		this.sellerMobile = sellerMobile;
	}
	public String getSellerTel() {
		return sellerTel;
	}
	public void setSellerTel(String sellerTel) {
		this.sellerTel = sellerTel;
	}
	public Long getRefundId() {
		return refundId;
	}
	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}
	public Date getRefundApplyTime() {
		return refundApplyTime;
	}
	public void setRefundApplyTime(Date refundApplyTime) {
		this.refundApplyTime = refundApplyTime;
	}
	public String getRefundCause() {
		return refundCause;
	}
	public void setRefundCause(String refundCause) {
		this.refundCause = refundCause;
	}
	public String getRefundEvidence() {
		return refundEvidence;
	}
	public void setRefundEvidence(String refundEvidence) {
		this.refundEvidence = refundEvidence;
	}
	public Date getRespondTime() {
		return respondTime;
	}
	public void setRespondTime(Date respondTime) {
		this.respondTime = respondTime;
	}
	public String getRefundNote() {
		return refundNote;
	}
	public void setRefundNote(String refundNote) {
		this.refundNote = refundNote;
	}
	public String getRejectEvidence() {
		return rejectEvidence;
	}
	public void setRejectEvidence(String rejectEvidence) {
		this.rejectEvidence = rejectEvidence;
	}
	public String getRefundStatus() {
		return refundStatus;
	}
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	public String getCompany() {
		return company;
	}
	public void setCompany(String company) {
		this.company = company;
	}
	public String getLogisticNo() {
		return logisticNo;
	}
	public void setLogisticNo(String logisticNo) {
		this.logisticNo = logisticNo;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getRejectCause() {
		return rejectCause;
	}
	public void setRejectCause(String rejectCause) {
		this.rejectCause = rejectCause;
	}
	public long getTotalFee() {
		return totalFee;
	}
	public void setTotalFee(long totalFee) {
		this.totalFee = totalFee;
	}
	
	
}
