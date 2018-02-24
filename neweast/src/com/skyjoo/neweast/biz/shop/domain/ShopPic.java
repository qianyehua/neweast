package com.skyjoo.neweast.biz.shop.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;


/** ����ͼƬ�� */
public class ShopPic extends DomainBase {

	private static final long serialVersionUID = 5723862809666621563L;
	//seq,pk
	private Long id ;
	//����ID
	private Long shopID ;
	//����ID
	private Long  categoryID ;
	//ͼƬ·��
	private String imgPath ;
	//״̬�� 0δ���  1����  -1���ʧ��
	private Integer status ;

	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
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