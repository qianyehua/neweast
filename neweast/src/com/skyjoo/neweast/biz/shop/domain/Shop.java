package com.skyjoo.neweast.biz.shop.domain;

import java.util.Date;
import java.util.List;

import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopStatus;


/**
 * 店铺表
 * @author lxh
 * @version 2015-04-14 11:54:25
 */
public class Shop extends DomainBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5783862809876621563L;
	//seq,pk
	private Long id;
	//店铺名称
	private String name;
	//会员ID
	private Long accountId;
	private String sellerName;
	private String email;
	//店铺LOGO地址
	private String logoPath;
	//店铺介绍
	private String description;
	//联系手机
	private String mobile;
	//省份
	private String province;
	//城市
	private String city;
	//地址
	private String address;
	//状态1：正常-1：关闭
	private Integer status;
	//艺术品发布审核开关Y：开N：关
	private String atrAuditOn;
	//图片发布审核开关Y：开N：关
	private String imgAuditOn;
	//备注
	private String memo;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;
	//销量
	private Integer salesVolume;
    //主营业务
    private String  mainBiz;
    
	private List<ShopBusinessHours> businessHours;

	/**获取主营业务*/
	public String getMainBiz() {
		return mainBiz;
	}
	/**设置主营业务*/
	public void setMainBiz(String mainBiz) {
		this.mainBiz = mainBiz;
	}
	/**设置seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取seq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**设置店铺名称*/
	public void setName(String name) {
		this.name = name;
	}
	/**获取店铺名称*/
	public String getName() {
		return this.name;
	}
	
	/**设置会员ID*/
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	/**获取会员ID*/
	public Long getAccountId() {
		return this.accountId;
	}
	
	public String getSellerName() {
		return sellerName;
	}
	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	/**设置店铺LOGO地址*/
	public void setLogoPath(String logoPath) {
		this.logoPath = logoPath;
	}
	/**获取店铺LOGO地址*/
	public String getLogoPath() {
		return this.logoPath;
	}
	
	/**设置店铺介绍*/
	public void setDescription(String description) {
		this.description = description;
	}
	/**获取店铺介绍*/
	public String getDescription() {
		return this.description;
	}
	
	/**设置联系手机*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**获取联系手机*/
	public String getMobile() {
		return this.mobile;
	}
	
	/**设置省份*/
	public void setProvince(String province) {
		this.province = province;
	}
	/**获取省份*/
	public String getProvince() {
		return this.province;
	}
	
	/**设置城市*/
	public void setCity(String city) {
		this.city = city;
	}
	/**获取城市*/
	public String getCity() {
		return this.city;
	}
	
	/**设置地址*/
	public void setAddress(String address) {
		this.address = address;
	}
	/**获取地址*/
	public String getAddress() {
		return this.address;
	}
	
	/**设置状态1：正常-1：关闭*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setStatus(EnumShopStatus status) {
		this.status = status.getValue();
	}
	/**获取状态1：正常-1：关闭*/
	public Integer getStatus() {
		return this.status;
	}
	
	/**设置艺术品发布审核开关Y：开N：关*/
	public void setAtrAuditOn(String atrAuditOn) {
		this.atrAuditOn = atrAuditOn;
	}
	/**获取艺术品发布审核开关Y：开N：关*/
	public String getAtrAuditOn() {
		return this.atrAuditOn;
	}
	
	/**设置图片发布审核开关Y：开N：关*/
	public void setImgAuditOn(String imgAuditOn) {
		this.imgAuditOn = imgAuditOn;
	}
	/**获取图片发布审核开关Y：开N：关*/
	public String getImgAuditOn() {
		return this.imgAuditOn;
	}
	
	/**设置备注*/
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**获取备注*/
	public String getMemo() {
		return this.memo;
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
	
	/**获取销量*/
	public Integer getSalesVolume() {
		return salesVolume;
	}
	/**设置销量*/
	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}
	
	public List<ShopBusinessHours> getBusinessHours() {
		return businessHours;
	}
	public void setBusinessHours(List<ShopBusinessHours> businessHours) {
		this.businessHours = businessHours;
	}
	
	public boolean isNormal() {
		return EnumShopStatus.NORMAL.getValue().equals(this.status);
	}
	
	public boolean isClosed() {
		return EnumShopStatus.CLOSED.getValue().equals(this.status);
	}
	
    public boolean isUpdate() {
        return this.id != null;
    }
}