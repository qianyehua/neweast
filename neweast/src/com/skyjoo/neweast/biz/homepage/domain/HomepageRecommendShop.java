package com.skyjoo.neweast.biz.homepage.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * 首页店铺推广表
 * @author lxh
 * @version 2015-05-26 13:44:46
 */
public class HomepageRecommendShop extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1472014826219981179L;
	
	public static final int STATUS_NORMAL = 1;
	public static final int STATUS_DELETE = -1;
	
	//seq,pk
	private Long id;
	//店铺ID
	private Long shopId;
	//状态：1正常，-1已删除
	private Integer status;
	//操作员
	private String operator;
	//修改时间
	private Date gmtCreate;
	//
	private Date gmtModify;

	/**设置seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取seq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**设置店铺ID*/
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	/**获取店铺ID*/
	public Long getShopId() {
		return this.shopId;
	}
	
	/**设置状态：1正常，-1已删除*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**获取状态：1正常，-1已删除*/
	public Integer getStatus() {
		return this.status;
	}
	
	/**设置操作员*/
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**获取操作员*/
	public String getOperator() {
		return this.operator;
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
	
	public boolean isNormal() {
		return this.status.intValue() == STATUS_NORMAL;
	}
}