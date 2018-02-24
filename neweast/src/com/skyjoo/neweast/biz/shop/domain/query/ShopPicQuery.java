package com.skyjoo.neweast.biz.shop.domain.query;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.shop.domain.ShopPic;

/**
 * 店铺图片查询
 * @author LZW
 */
public class ShopPicQuery extends Pagination<ShopPic> {
	private static final long serialVersionUID = -5717182378759842295L;
	
	private String email;//卖家邮箱
	private String name;//店铺名称（右模糊）
	private Integer status = 0;//审核状态（ 0未审核  1正常  -1审核失败）
	
	//图片创建日期（开始日期，结束日期）
	private String gmtCreateStart;
	private String gmtCreateEnd;
	
	private Long picID;//图片id
	private String picPath;//图片路径
	private Date gmtCreate;//图片上传时间
	
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getGmtCreateStart() {
		return gmtCreateStart;
	}
	public void setGmtCreateStart(String gmtCreateStart) {
		this.gmtCreateStart = gmtCreateStart;
	}
	public String getGmtCreateEnd() {
		return gmtCreateEnd;
	}
	public void setGmtCreateEnd(String gmtCreateEnd) {
		this.gmtCreateEnd = gmtCreateEnd;
	}

	public Long getPicID() {
		return picID;
	}
	public void setPicID(Long picID) {
		this.picID = picID;
	}
	public String getPicPath() {
		return picPath;
	}
	public void setPicPath(String picPath) {
		this.picPath = picPath;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	
	
	
}
