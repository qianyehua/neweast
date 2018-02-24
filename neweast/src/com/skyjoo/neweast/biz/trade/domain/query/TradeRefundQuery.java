package com.skyjoo.neweast.biz.trade.domain.query;

import java.util.Date;

import com.eyeieye.melos.util.DateUtil;
import com.eyeieye.melos.util.StringUtil;
import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.trade.domain.TradeRefund;

/**
 * 交易退款表分页查询条件
 * @author lxh
 * @version 2015-04-29 13:47:11
 */
public class TradeRefundQuery extends Pagination<TradeRefund> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4066172127716357121L;
	
	//订单编号
	private String orderNo;
	//退款编号
	private Long id;
	//退款申请时间（开始时间，结束时间）
	private String gmtApplyStart = DateUtil.convertDateToString(new Date());;
	private String gmtApplyEnd = DateUtil.convertDateToString(new Date());;
	//退款状态
	private String status;
	//买家账号
	private String buyerStockAccount;
	//卖家账号
	private String sellerStockAccount;
	
	public String getOrderNo() {
		return orderNo;
	}
	public void setOrderNo(String orderNo) {
		this.orderNo = orderNo;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getGmtApplyStart() {
		return gmtApplyStart;
	}
	public void setGmtApplyStart(String gmtApplyStart) {
		this.gmtApplyStart = gmtApplyStart;
	}
	public String getGmtApplyEnd() {
		return gmtApplyEnd;
	}
	public void setGmtApplyEnd(String gmtApplyEnd) {
		this.gmtApplyEnd = gmtApplyEnd;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getBuyerStockAccount() {
		return buyerStockAccount;
	}
	public void setBuyerStockAccount(String buyerStockAccount) {
		this.buyerStockAccount = buyerStockAccount;
	}
	public String getSellerStockAccount() {
		return sellerStockAccount;
	}
	public void setSellerStockAccount(String sellerStockAccount) {
		this.sellerStockAccount = sellerStockAccount;
	}
	public boolean enable() {
		if(StringUtil.isBlank(this.gmtApplyStart)
				&& StringUtil.isBlank(this.gmtApplyEnd)
				&& StringUtil.isBlank(this.status)
				&& StringUtil.isBlank(this.buyerStockAccount)
				&& StringUtil.isBlank(this.sellerStockAccount)
				&& StringUtil.isBlank(this.orderNo)
				&& id == null) {
			return false;
		}
		return true;
	}
	
}