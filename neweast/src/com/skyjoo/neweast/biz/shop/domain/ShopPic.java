package com.skyjoo.neweast.biz.shop.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;


/** 店铺图片表 */
public class ShopPic extends DomainBase {

	private static final long serialVersionUID = 5723862809666621563L;
	//seq,pk
	private Long id ;
	//店铺ID
	private Long shopID ;
	//分类ID
	private Long  categoryID ;
	//图片路径
	private String imgPath ;
	//状态： 0未审核  1正常  -1审核失败
	private Integer status ;

	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getShopID() {
		return shopID;
	}
	public void setShopID(Long shopID) {
		this.shopID = shopID;
	}
	public Long getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(Long categoryID) {
		this.categoryID = categoryID;
	}
	public String getImgPath() {
		return imgPath;
	}
	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModify() {
		return gmtModify;
	}
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	
	
	
}