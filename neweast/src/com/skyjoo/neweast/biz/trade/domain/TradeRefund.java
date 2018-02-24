package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

import com.eyeieye.melos.util.StringUtil;
import com.hundsun.wudadao.common.DomainBase;
import com.hundsun.wudadao.common.Money;
import com.skyjoo.neweast.biz.common.util.MoneyUtils;

/**
 * 交易退款表
 * @author lxh
 * @version 2015-04-29 13:47:11
 */
public class TradeRefund extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3448479992593154253L;
	//pk,seq
	private Long id;
	//订单ID
	private Long orderId;
	//订单号
	private String tradeNo;
	//退款状态等待卖家响应等待买家发货等待仲裁成功已关闭
	private String status;
	//买家id
	private Long buyerId;
	private String buyerStockAccount;
	private String buyerRealName;
	//卖家id
	private Long sellerId;
	private String sellerStockAccount;
	private String sellerRealName;
	//订单总价,单位分
	private Long totalFee;
	//退款金额,单位分
	private Long refundFee;
	private String refundFeeStr;
	//退款证据
	private String evidence;
	//退款原因
	private String cause;
	//退款说明
	private String note;
	//是否退货
	private Integer retuenGoods;
	//拒绝退款证据
	private String rejectEvidence;
	//拒绝退款原因
	private String rejectCause;
	//拒绝退款说明
	private String rejectNote;
	//申请退货时间
	private Date applyTime;
	//响应退货时间
	private Date respondTime;
	//退款完成时间
	private Date completeTime;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;
	
	private String judgeMemo;

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
	
	/**设置退款状态等待卖家响应等待买家发货等待仲裁成功已关闭*/
	public void setStatus(String status) {
		this.status = status;
	}
	/**获取退款状态等待卖家响应等待买家发货等待仲裁成功已关闭*/
	public String getStatus() {
		return this.status;
	}
	
	/**设置买家id*/
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	/**获取买家id*/
	public Long getBuyerId() {
		return this.buyerId;
	}
	
	/**设置卖家id*/
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	/**获取卖家id*/
	public Long getSellerId() {
		return this.sellerId;
	}
	
	/**设置订单总价,单位分*/
	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}
	/**获取订单总价,单位分*/
	public Long getTotalFee() {
		return this.totalFee;
	}
	
	/**设置退款金额,单位分*/
	public void setRefundFee(Long refundFee) {
		this.refundFee = refundFee;
		if(this.refundFee == null) {
			this.refundFeeStr = null;
		} else {
			this.refundFeeStr = MoneyUtils.getMoneyDesc(refundFee);
		}
	}
	/**获取退款金额,单位分*/
	public Long getRefundFee() {
		return this.refundFee;
	}
	public String getRefundFeeStr() {
		return refundFeeStr;
	}
	public void setRefundFeeStr(String refundFeeStr) {
		this.refundFeeStr = refundFeeStr;
		if(StringUtil.isBlank(this.refundFeeStr)) {
			this.refundFee = 0L;
		} else {
			Money money = new Money(refundFeeStr);
			this.refundFee = money.getCent();
		}
	}
	/**设置退款证据*/
	public void setEvidence(String evidence) {
		this.evidence = evidence;
	}
	/**获取退款证据*/
	public String getEvidence() {
		return this.evidence;
	}
	
	/**设置退款原因*/
	public void setCause(String cause) {
		this.cause = cause;
	}
	/**获取退款原因*/
	public String getCause() {
		return this.cause;
	}
	
	/**设置退款说明*/
	public void setNote(String note) {
		this.note = note;
	}
	/**获取退款说明*/
	public String getNote() {
		return this.note;
	}
	
	/**设置是否退货*/
	public void setRetuenGoods(Integer retuenGoods) {
		this.retuenGoods = retuenGoods;
	}
	/**获取是否退货*/
	public Integer getRetuenGoods() {
		return this.retuenGoods;
	}
	
	/**设置拒绝退款证据*/
	public void setRejectEvidence(String rejectEvidence) {
		this.rejectEvidence = rejectEvidence;
	}
	/**获取拒绝退款证据*/
	public String getRejectEvidence() {
		return this.rejectEvidence;
	}
	
	/**设置拒绝退款原因*/
	public void setRejectCause(String rejectCause) {
		this.rejectCause = rejectCause;
	}
	/**获取拒绝退款原因*/
	public String getRejectCause() {
		return this.rejectCause;
	}
	
	/**设置拒绝退款说明*/
	public void setRejectNote(String rejectNote) {
		this.rejectNote = rejectNote;
	}
	/**获取拒绝退款说明*/
	public String getRejectNote() {
		return this.rejectNote;
	}
	
	/**设置申请退货时间*/
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}
	/**获取申请退货时间*/
	public Date getApplyTime() {
		return this.applyTime;
	}
	
	/**设置响应退货时间*/
	public void setRespondTime(Date respondTime) {
		this.respondTime = respondTime;
	}
	/**获取响应退货时间*/
	public Date getRespondTime() {
		return this.respondTime;
	}
	
	/**设置退款完成时间*/
	public void setCompleteTime(Date completeTime) {
		this.completeTime = completeTime;
	}
	/**获取退款完成时间*/
	public Date getCompleteTime() {
		return this.completeTime;
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
	public String getBuyerStockAccount() {
		return buyerStockAccount;
	}
	public void setBuyerStockAccount(String buyerStockAccount) {
		this.buyerStockAccount = buyerStockAccount;
	}
	public String getBuyerRealName() {
		return buyerRealName;
	}
	public void setBuyerRealName(String buyerRealName) {
		this.buyerRealName = buyerRealName;
	}
	public String getSellerStockAccount() {
		return sellerStockAccount;
	}
	public void setSellerStockAccount(String sellerStockAccount) {
		this.sellerStockAccount = sellerStockAccount;
	}
	public String getSellerRealName() {
		return sellerRealName;
	}
	public void setSellerRealName(String sellerRealName) {
		this.sellerRealName = sellerRealName;
	}
	public String getJudgeMemo() {
		return judgeMemo;
	}
	public void setJudgeMemo(String judgeMemo) {
		this.judgeMemo = judgeMemo;
	}
	
}