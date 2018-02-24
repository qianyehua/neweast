package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * 销量表
 * @author lxh
 * @version 2015-05-27 13:47:58
 */
public class SalesVolume extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4129128529465724139L;
	//seq,pk
	private Long id;
	//销售日期，完成日期
	private String tradeDate;
	//店铺ID
	private Long shopId;
	//艺术品ID
	private Long artId;
	//销售数量
	private Integer amount;
	//修改时间
	private Date gmtCreate;
	//
	private Date gmtModify;
	//类目ID
	private Long categoryId;
	
	public SalesVolume() {
	
	}
	
	public SalesVolume(String tradeDate, Long shopId, Long artId, Integer amount) {
		this.tradeDate = tradeDate;
		this.shopId = shopId;
		this.artId = artId;
		this.amount = amount;
	}
	
	/**设置seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取seq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**设置销售日期，完成日期*/
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	/**获取销售日期，完成日期*/
	public String getTradeDate() {
		return this.tradeDate;
	}
	
	/**设置店铺ID*/
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	/**获取店铺ID*/
	public Long getShopId() {
		return this.shopId;
	}
	
	/**设置艺术品ID*/
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	/**获取艺术品ID*/
	public Long getArtId() {
		return this.artId;
	}
	
	/**设置销售数量*/
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	/**获取销售数量*/
	public Integer getAmount() {
		return this.amount;
	}
	/**增加销量*/
	public void addSalesVolume(Integer amount) {
		this.amount = this.amount + amount;
	}
	
	/**设置修改时间*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**获取修改时间*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**设置*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**获取*/
	public Date getGmtModify() {
		return this.gmtModify;
	}

	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
}