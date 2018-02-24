package com.skyjoo.neweast.biz.shop.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.eyeieye.melos.util.StringUtil;
import com.hundsun.wudadao.common.DomainBase;

/**
 * 开店经办人表
 * @author lxh
 * @version 2015-04-13 10:38:35
 */
public class ShopAuthApplyOrg extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 369988508618690112L;
	//seq,pk
	private Long id;
	//申请ID
	private Long applyId;
	//姓名
	private String realName;
	//证件类型：P01身份证
	private String licenseType;
	//证件号
	private String license;
	//附件，多个附件用”|”分割
	private String attachment;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;

	/**设置seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取seq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**设置申请ID*/
	public void setApplyId(Long applyId) {
		this.applyId = applyId;
	}
	/**获取申请ID*/
	public Long getApplyId() {
		return this.applyId;
	}
	
	/**设置姓名*/
	public void setRealName(String realName) {
		this.realName = realName;
	}
	/**获取姓名*/
	public String getRealName() {
		return this.realName;
	}
	
	/**设置证件类型：P01身份证*/
	public void setLicenseType(String licenseType) {
		this.licenseType = licenseType;
	}
	/**获取证件类型：P01身份证*/
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
	
}