package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * 交易超时任务表
 * @author lxh
 * @version 2015-04-29 10:06:29
 */
public class TradeTimeout extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6263270635049333703L;
	//pk,seq
	private Long id;
	//订单ID
	private Long orderId;
	//订单号
	private String tradeNo;
	//超时方买方buyer卖家seller
	private String payType;
	//超时方id
	private Long userId;
	//对应退款id
	private Long refundId;
	//对应物流id
	private Long logisticId;
	//处理类名称
	private String processorName;
	//预警时间
	private Date warningDate;
	//超时时间
	private Date timeoutDate;
	//状态enabledisable
	private String status;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;
	//备注
	private String memo;

	/**设置pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取pk,seq*/
	public Long getId() {
		return this.id;
	}
	
	/**设置订单ID*/
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**获取订单ID*/
	public Long getOrderId() {
		return this.orderId;
	}
	
	/**设置订单号*/
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	/**获取订单号*/
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	/**设置超时方买方buyer卖家seller*/
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**获取超时方买方buyer卖家seller*/
	public String getPayType() {
		return this.payType;
	}
	
	/**设置超时方id*/
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**获取超时方id*/
	public Long getUserId() {
		return this.userId;
	}
	
	/**设置对应退款id*/
	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}
	/**获取对应退款id*/
	public Long getRefundId() {
		return this.refundId;
	}
	
	/**设置对应物流id*/
	public void setLogisticId(Long logisticId) {
		this.logisticId = logisticId;
	}
	/**获取对应物流id*/
	public Long getLogisticId() {
		return this.logisticId;
	}
	
	/**设置处理类名称*/
	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}
	/**获取处理类名称*/
	public String getProcessorName() {
		return this.processorName;
	}
	
	/**设置预警时间*/
	public void setWarningDate(Date warningDate) {
		this.warningDate = warningDate;
	}
	/**获取预警时间*/
	public Date getWarningDate() {
		return this.warningDate;
	}
	
	/**设置超时时间*/
	public void setTimeoutDate(Date timeoutDate) {
		this.timeoutDate = timeoutDate;
	}
	/**获取超时时间*/
	public Date getTimeoutDate() {
		return this.timeoutDate;
	}
	
	/**设置状态enabledisable*/
	public void setStatus(String status) {
		this.status = status;
	}
	/**获取状态enabledisable*/
	public String getStatus() {
		return this.status;
	}
	
	/**设置创建时间*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**获取创建时间*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**设置最后修改时间*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**获取最后修改时间*/
	public Date getGmtModify() {
		return this.gmtModify;
	}
	
	/**设置备注*/
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**获取备注*/
	public String getMemo() {
		return this.memo;
	}
	
}