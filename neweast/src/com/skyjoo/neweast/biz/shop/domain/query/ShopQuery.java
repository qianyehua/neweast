package com.skyjoo.neweast.biz.shop.domain.query;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.shop.domain.Shop;

/**
 * ���̲�ѯ
 * @author lxh
 *
 */
public class ShopQuery extends Pagination<Shop> {
	private static final long serialVersionUID = -5717182334759842295L;
	
	private String email;//��������
	private String name;//�������ƣ���ģ����
	private Integer status;//����״̬���������رգ�
	//���̴������ڣ���ʼ���ڣ��������ڣ�
	private String gmtCreateStart;
	private String gmtCreateEnd;
	
	//�Ƿ����Ƽ�
	private Boolean isRecommend = null;
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
//		if(StringUtil.isNotBlank(this.name)) {
//	    	try {
//	    		return new String(this.name.getBytes("iso8859-1"),"utf-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//    	}
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
	public Boolean getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
	}
	public boolean isRecommend() {
		return Boolean.TRUE.equals(this.isRecommend);
	}
}
