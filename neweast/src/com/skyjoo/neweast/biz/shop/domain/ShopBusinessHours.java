package com.skyjoo.neweast.biz.shop.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;
import com.skyjoo.wudadao.common.enums.mall.shop.EnumShopBizHourType;

/**
 * ����Ӫҵʱ���
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
	//����ID
	private Long shopId;
	//����1��������2��˫����/�ڼ���
	private Integer type;
	//��ʼʱ��
	private Date gmtStart;
	//����ʱ��
	private Date gmtEnd;
	//�ͷ���Ա
	private String customerService;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;

	public ShopBusinessHours() {
	
	}
	
	public ShopBusinessHours(Long shopId, EnumShopBizHourType type) {
		this.shopId = shopId;
		this.type = type.getValue();
	}
	
	/**����seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡseq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**���õ���ID*/
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	/**��ȡ����ID*/
	public Long getShopId() {
		return this.shopId;
	}
	
	/**��������1��������2��˫����/�ڼ���*/
	public void setType(Integer type) {
		this.type = type;
	}
	/**��ȡ����1��������2��˫����/�ڼ���*/
	public Integer getType() {
		return this.type;
	}
	public String getTypeStr() {
		EnumShopBizHourType type = EnumShopBizHourType.getByValue(this.type);
		if(type == null) return "";
		return type.getDesp();
	}
	
	/**���ÿ�ʼʱ��*/
	public void setGmtStart(Date gmtStart) {
		this.gmtStart = gmtStart;
	}
	/**��ȡ��ʼʱ��*/
	public Date getGmtStart() {
		return this.gmtStart;
	}
	
	/**���ý���ʱ��*/
	public void setGmtEnd(Date gmtEnd) {
		this.gmtEnd = gmtEnd;
	}
	/**��ȡ����ʱ��*/
	public Date getGmtEnd() {
		return this.gmtEnd;
	}
	/**���ÿͷ���Ա*/
	public void setCustomerService(String customerService) {
		this.customerService = customerService;
	}
	/**��ȡ�ͷ���Ա*/
	public String getCustomerService() {
		return this.customerService;
	}
	
	/**���ô���ʱ��*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**��ȡ����ʱ��*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**��������޸�ʱ��*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**��ȡ����޸�ʱ��*/
	public Date getGmtModify() {
		return this.gmtModify;
	}
	/**�ڼ���*/
	public boolean isHoliday() {
		return EnumShopBizHourType.HOLIDAY.getValue().equals(this.type);
	}
	/**������*/
	public boolean isWorkday() {
		return EnumShopBizHourType.WORKDAY.getValue().equals(this.type);
	}
}