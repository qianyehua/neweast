package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * 交易订单商品表
 * @author lxh
 * @version 2015-04-28 18:57:10
 */
public class TradeOrderItem extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3874237899896074225L;
	//pk,seq
	private Long id;
	//订单ID
	private Long orderId;
	//订单号
	private String tradeNo;
	//商品id
	private Long artId;
	//商品图片地址
	private String attachment;
	//商品类目代码
	private String catCode;
	//商品标题
	private String artName;
	//购买数量
	private Long artNumber;
	//购买价格,单位分
	private Long artPrice;
	//创建时间
	private Date gmtCreate;

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
	
	/**设置商品id*/
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	/**获取商品id*/
	public Long getArtId() {
		return this.artId;
	}
	
	/**设置商品图片地址*/
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	/**获取商品图片地址*/
	public String getAttachment() {
		return this.attachment;
	}
	
	/**设置商品类目代码*/
	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}
	/**获取商品类目代码*/
	public String getCatCode() {
		return this.catCode;
	}
	
	/**设置商品标题*/
	public void setArtName(String artName) {
		this.artName = artName;
	}
	/**获取商品标题*/
	public String getArtName() {
		return this.artName;
	}
	
	/**设置购买数量*/
	public void setArtNumber(Long artNumber) {
		this.artNumber = artNumber;
	}
	/**获取购买数量*/
	public Long getArtNumber() {
		return this.artNumber;
	}
	
	/**设置购买价格,单位分*/
	public void setArtPrice(Long artPrice) {
		this.artPrice = artPrice;
	}
	/**获取购买价格,单位分*/
	public Long getArtPrice() {
		return this.artPrice;
	}
	
	/**设置创建时间*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**获取创建时间*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
}