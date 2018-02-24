package com.skyjoo.neweast.biz.shop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eyeieye.melos.util.StringUtil;
import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthStatus;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopAuthType;

/**
 * 会员开店申请表
 * @author lxh
 * @version 2015-04-13 10:38:20
 */
public class ShopAuthApply extends DomainBase {
	/**
	 * 
	 */
	private static final long serialVersionUID = 7862558225255328918L;
	//seq,pk
	private Long id;
	//会员ID
	private Long accountId;
	//登录ID，电邮地址
	private String loginId;
	//0个人1企业
	private Integer type;
	//地区
	private String region;
	//姓名
	private String realName;
	//英文名
	private String enName;
	//证件类型：P01身份证B营业执照
	private String licenseType;
	//证件号
	private String license;
	//证件有效期
	private Date gmtLicenseExpiry;
	//性别0：男1：女2:其他
	private Integer gender;
	//从事行业
	private String major;
	//省份，从字典表获得
	private String province;
	//城市，从字典表获得
	private String city;
	//详细地址
	private String address;
	//手机号码
	private String mobile;
	//附件，多个附件用”|”分割
	private String attachment;
	//申请日期
	private Date gmtApply;
	//状态-2黑名单-1审核失败0审核中1审核成功
	private Integer status;
	//备注
	private String memo;
	//操作人
	private String operator;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;
	//企业附加信息
	private ShopAuthApplyOrg applyOrg;
	
	//审核时间
	private Date gmtAccepted;
	
	/**设置seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取seq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**设置会员ID*/
	public void setAccountId(Long accountId) {
		this.accountId = accountId;
	}
	/**获取会员ID*/
	public Long getAccountId() {
		return this.accountId;
	}
	
	/**设置登录ID，电邮地址*/
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	/**获取登录ID，电邮地址*/
	public String getLoginId() {
		return this.loginId;
	}
	
	/**设置0个人1企业*/
	public void setType(Integer type) {
		this.type = type;
	}
	public void setType(EnumShopAuthType type) {
		this.type = type.getValue();
	}
	/**获取0个人1企业*/
	public Integer getType() {
		return this.type;
	}
	
	/**设置地区*/
	public void setRegion(String region) {
		this.region = region;
	}
	/**获取地区*/
	public String getRegion() {
		return this.region;
	}
	
	/**设置姓名*/
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**获取姓名*/
	public String getRealName() {
		return this.realName;
	}
	
	/**设置英文名*/
	public void setEnName(String enName) {
		this.enName = enName;
	}
	/**获取英文名*/
	public String getEnName() {
		if(StringUtil.isNotBlank(this.enName)) {
			this.enName = this.enName.replace("_", " ");
		}
		return this.enName;
	}
	
	/**设置证件类型：P01身份证B营业执照*/
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	/**获取证件类型：P01身份证B营业执照*/
	public String getLicenseType() {
		return this.licenseType;
	}
	
	/**设置证件号*/
	public void setLicense(String license) {
		this.license = license;
	}
	/**获取证件号*/
	public String getLicense() {
		return this.license;
	}
	
	public Date getGmtLicenseExpiry() {
		return this.gmtLicenseExpiry;
	}
	public void setGmtLicenseExpiry(Date gmtLicenseExpiry) {
		this.gmtLicenseExpiry = gmtLicenseExpiry;
	}
	/**设置性别0：男1：女2:其他*/
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	/**获取性别0：男1：女2:其他*/
	public Integer getGender() {
		return this.gender;
	}
	
	/**设置从事行业*/
	public void setMajor(String major) {
		this.major = major;
	}
	/**获取从事行业*/
	public String getMajor() {
		return this.major;
	}
	
	/**设置省份，从字典表获得*/
	public void setProvince(String province) {
		this.province = province;
	}
	/**获取省份，从字典表获得*/
	public String getProvince() {
		return this.province;
	}
	
	/**设置城市，从字典表获得*/
	public void setCity(String city) {
		this.city = city;
	}
	/**获取城市，从字典表获得*/
	public String getCity() {
		return this.city;
	}
	
	/**设置详细地址*/
	public void setAddress(String address) {
		this.address = address;
	}
	/**获取详细地址*/
	public String getAddress() {
		return this.address;
	}
	
	/**设置手机号码*/
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	/**获取手机号码*/
	public String getMobile() {
		return this.mobile;
	}
	
	/**设置附件，多个附件用”|”分割*/
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	/**获取附件，多个附件用”|”分割*/
	public String getAttachment() {
		return this.attachment;
	}
	
	public List<String> getAttachmentList() {
		List<String> list = new ArrayList<String>();
		if(StringUtil.isNotBlank(this.attachment)) {
			for (String atta : this.attachment.split("\\|")) {
				list.add(atta);
			}
		}
		return list;
	}
	
	/**设置申请日期*/
	public void setGmtApply(Date gmtApply) {
		this.gmtApply = gmtApply;
	}
	/**获取申请日期*/
	public Date getGmtApply() {
		return this.gmtApply;
	}
	
	/**设置状态-2黑名单-1审核失败0审核中1审核成功*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	public void setStatus(EnumShopAuthStatus status) {
		this.status = status.getValue();
	}
	/**获取状态-2黑名单-1审核失败0审核中1审核成功*/
	public Integer getStatus() {
		return this.status;
	}
	
	/**设置备注*/
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**获取备注*/
	public String getMemo() {
		return this.memo;
	}
	
	/**设置操作人*/
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**获取操作人*/
	public String getOperator() {
		return this.operator;
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
	public ShopAuthApplyOrg getApplyOrg() {
		return applyOrg;
	}
	public void setApplyOrg(ShopAuthApplyOrg applyOrg) {
		this.applyOrg = applyOrg;
	}
	
    public Date getGmtAccepted() {
        return gmtAccepted;
    }
    public void setGmtAccepted(Date gmtAccepted) {
        this.gmtAccepted = gmtAccepted;
    }
	
	/**
	 * 个人
	 * @return
	 */
	public boolean isPersonal() {
		return EnumShopAuthType.PERSONAL.getValue().equals(this.type);
	}
	
	/**
	 * 企业
	 * @return
	 */
	public boolean isCompany() {
		return EnumShopAuthType.COMPANY.getValue().equals(this.type);
	}
	
	public boolean isSuccess() {
		return EnumShopAuthStatus.AUDIT_SUCCESS.getValue().equals(this.status);
	}
	
	public boolean isFailed() {
		return EnumShopAuthStatus.AUDIT_FAILED.getValue().equals(this.status);
	}
	
	public boolean isAuditing() {
		return EnumShopAuthStatus.AUDITING.getValue().equals(this.status);
	}

}