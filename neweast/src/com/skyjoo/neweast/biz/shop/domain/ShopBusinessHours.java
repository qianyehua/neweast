package com.skyjoo.neweast.biz.shop.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopBizHourType;

/**
 * 店铺营业时间表
 * @author lxh
 * @version 2015-04-14 11:54:36
 */
public class ShopBusinessHours extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7171446450225501L;
	//seq,pk
	private Long id;
	//店铺ID
	private Long shopId;
	//类型1：工作日2：双休日/节假日
	private Integer type;
	//开始时间
	private Date gmtStart;
	//结束时间
	private Date gmtEnd;
	//客服人员
	private String customerService;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;

	public ShopBusinessHours() {
	
	}
	
	public ShopBusinessHours(Long shopId, EnumShopBizHourType type) {
		this.shopId = shopId;
		this.type = type.getValue();
	}
	
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
	
	/**设置类型1：工作日2：双休日/节假日*/
	public void setType(Integer type) {
		this.type = type;
	}
	/**获取类型1：工作日2：双休日/节假日*/
	public Integer getType() {
		return this.type;
	}
	public String getTypeStr() {
		EnumShopBizHourType type = EnumShopBizHourType.getByValue(this.type);
		if(type == null) return "";
		return type.getDesp();
	}
	
	/**设置开始时间*/
	public void setGmtStart(Date gmtStart) {
		this.gmtStart = gmtStart;
	}
	/**获取开始时间*/
	public Date getGmtStart() {
		return this.gmtStart;
	}
	
	/**设置结束时间*/
	public void setGmtEnd(Date gmtEnd) {
		this.gmtEnd = gmtEnd;
	}
	/**获取结束时间*/
	public Date getGmtEnd() {
		return this.gmtEnd;
	}
	/**设置客服人员*/
	public void setCustomerService(String customerService) {
		this.customerService = customerService;
	}
	/**获取客服人员*/
	public String getCustomerService() {
		return this.customerService;
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
	/**节假日*/
	public boolean isHoliday() {
		return EnumShopBizHourType.HOLIDAY.getValue().equals(this.type);
	}
	/**工作日*/
	public boolean isWorkday() {
		return EnumShopBizHourType.WORKDAY.getValue().equals(this.type);
	}
}