package com.skyjoo.neweast.biz.shop.domain.query;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.shop.domain.ShopPic;

/**
 * ����ͼƬ��ѯ
 * @author LZW
 */
public class ShopPicQuery extends Pagination<ShopPic> {
	private static final long serialVersionUID = -5717182378759842295L;
	
	private String email;//��������
	private String name;//�������ƣ���ģ����
	private Integer status = 0;//���״̬�� 0δ���  1����  -1���ʧ�ܣ�
	
	//ͼƬ�������ڣ���ʼ���ڣ��������ڣ�
	private String gmtCreateStart;
	private String gmtCreateEnd;
	
	private Long picID;//ͼƬid
	private String picPath;//ͼƬ·��
	private Date gmtCreate;//ͼƬ�ϴ�ʱ��
	
	
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
