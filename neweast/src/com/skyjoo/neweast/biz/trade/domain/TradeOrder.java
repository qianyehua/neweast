package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.trade.TradeOrderStatus;

/**
 * 交易订单表
 * @author lxh
 * @version 2015-04-28 17:45:00
 */
public class TradeOrder extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6842607784875064967L;
	//pk,seq
	private Long id;
	//订单号(YYYYMMDD123456)
	private String tradeNo;
	//卖家id
	private Long sellerId;
	//卖家登录名
	private String sellerLoginId;
	//买家id
	private Long buyerId;
	//买家登录名
	private String buyerLoginId;
	//总价,包含运费,单位分
	private Long totalFee;
	//商品价格总和,不包含运费,单位分
	private Long totalGoods;
	//运费,单位分
	private Long logisticFund;
	//服务费率
	private Double serviceFeeRatio;
	//服务费
	private Long serviceFee;
	//商品归属卖家seller买家buyer
	private String goodsHolder;
	//交易状态等待买家付款等待卖家确认运费待确认汇款等待卖家发货等待买家确认收货交易成功交易完成已关闭
	private String tradeStatus;
	//当前有效退款状态无退款等待卖家响应等待买家发货等待卖家响应等待仲裁成功已关闭完成
	private String refundStatus;
	//付款时间
	private Date payTime;
	//确认收货时间
	private Date confirmGoodsTime;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;
	//退款ID
	private Long refundId;

	/**设置pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取pk,seq*/
	public Long getId() {
		return this.id;
	}
	
	/**设置订单号(YYYYMMDD123456)*/
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	/**获取订单号(YYYYMMDD123456)*/
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	/**设置卖家id*/
	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}
	/**获取卖家id*/
	public Long getSellerId() {
		return this.sellerId;
	}
	
	/**设置卖家登录名*/
	public void setSellerLoginId(String sellerLoginId) {
		this.sellerLoginId = sellerLoginId;
	}
	/**获取卖家登录名*/
	public String getSellerLoginId() {
		return this.sellerLoginId;
	}
	
	/**设置买家id*/
	public void setBuyerId(Long buyerId) {
		this.buyerId = buyerId;
	}
	/**获取买家id*/
	public Long getBuyerId() {
		return this.buyerId;
	}
	
	/**设置买家登录名*/
	public void setBuyerLoginId(String buyerLoginId) {
		this.buyerLoginId = buyerLoginId;
	}
	/**获取买家登录名*/
	public String getBuyerLoginId() {
		return this.buyerLoginId;
	}
	
	/**设置总价,包含运费,单位分*/
	public void setTotalFee(Long totalFee) {
		this.totalFee = totalFee;
	}
	/**获取总价,包含运费,单位分*/
	public Long getTotalFee() {
		return this.totalFee;
	}
	
	/**设置商品价格总和,不包含运费,单位分*/
	public void setTotalGoods(Long totalGoods) {
		this.totalGoods = totalGoods;
	}
	/**获取商品价格总和,不包含运费,单位分*/
	public Long getTotalGoods() {
		return this.totalGoods;
	}
	
	/**设置运费,单位分*/
	public void setLogisticFund(Long logisticFund) {
		this.logisticFund = logisticFund;
	}
	/**获取运费,单位分*/
	public Long getLogisticFund() {
		return this.logisticFund;
	}
	
	/**设置服务费率*/
	public void setServiceFeeRatio(Double serviceFeeRatio) {
		this.serviceFeeRatio = serviceFeeRatio;
	}
	/**获取服务费率*/
	public Double getServiceFeeRatio() {
		return this.serviceFeeRatio;
	}
	
	/**设置服务费*/
	public void setServiceFee(Long serviceFee) {
		this.serviceFee = serviceFee;
	}
	/**获取服务费*/
	public Long getServiceFee() {
		return this.serviceFee;
	}
	
	/**设置商品归属卖家seller买家buyer*/
	public void setGoodsHolder(String goodsHolder) {
		this.goodsHolder = goodsHolder;
	}
	/**获取商品归属卖家seller买家buyer*/
	public String getGoodsHolder() {
		return this.goodsHolder;
	}
	
	/**设置交易状态等待买家付款等待卖家确认运费待确认汇款等待卖家发货等待买家确认收货交易成功交易完成已关闭*/
	public void setTradeStatus(String tradeStatus) {
		this.tradeStatus = tradeStatus;
	}
	/**获取交易状态等待买家付款等待卖家确认运费待确认汇款等待卖家发货等待买家确认收货交易成功交易完成已关闭*/
	public String getTradeStatus() {
		return this.tradeStatus;
	}
	
	/**设置当前有效退款状态无退款等待卖家响应等待买家发货等待卖家响应等待仲裁成功已关闭完成*/
	public void setRefundStatus(String refundStatus) {
		this.refundStatus = refundStatus;
	}
	/**获取当前有效退款状态无退款等待卖家响应等待买家发货等待卖家响应等待仲裁成功已关闭完成*/
	public String getRefundStatus() {
		return this.refundStatus;
	}
	
	/**设置付款时间*/
	public void setPayTime(Date payTime) {
		this.payTime = payTime;
	}
	/**获取付款时间*/
	public Date getPayTime() {
		return this.payTime;
	}
	
	/**设置确认收货时间*/
	public void setConfirmGoodsTime(Date confirmGoodsTime) {
		this.confirmGoodsTime = confirmGoodsTime;
	}
	/**获取确认收货时间*/
	public Date getConfirmGoodsTime() {
		return this.confirmGoodsTime;
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
	public Long getRefundId() {
		return refundId;
	}
	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}
	
	public Long canRefundFee() {
		if(TradeOrderStatus.waitBuyerConfirmGoods.name().equals(this.tradeStatus)
				|| TradeOrderStatus.success.name().equals(this.tradeStatus)) {
			return this.totalGoods;
		} else {
			return this.totalFee;
		}
	}
}