package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * ������
 * @author lxh
 * @version 2015-05-27 13:47:58
 */
public class SalesVolume extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4129128529465724139L;
	//seq,pk
	private Long id;
	//�������ڣ��������
	private String tradeDate;
	//����ID
	private Long shopId;
	//����ƷID
	private Long artId;
	//��������
	private Integer amount;
	//�޸�ʱ��
	private Date gmtCreate;
	//
	private Date gmtModify;
	//��ĿID
	private Long categoryId;
	
	public SalesVolume() {
	
	}
	
	public SalesVolume(String tradeDate, Long shopId, Long artId, Integer amount) {
		this.tradeDate = tradeDate;
		this.shopId = shopId;
		this.artId = artId;
		this.amount = amount;
	}
	
	/**����seq,pk*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡseq,pk*/
	public Long getId() {
		return this.id;
	}
	
	/**�����������ڣ��������*/
	public void setTradeDate(String tradeDate) {
		this.tradeDate = tradeDate;
	}
	/**��ȡ�������ڣ��������*/
	public String getTradeDate() {
		return this.tradeDate;
	}
	
	/**���õ���ID*/
	public void setShopId(Long shopId) {
		this.shopId = shopId;
	}
	/**��ȡ����ID*/
	public Long getShopId() {
		return this.shopId;
	}
	
	/**��������ƷID*/
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	/**��ȡ����ƷID*/
	public Long getArtId() {
		return this.artId;
	}
	
	/**������������*/
	public void setAmount(Integer amount) {
		this.amount = amount;
	}
	/**��ȡ��������*/
	public Integer getAmount() {
		return this.amount;
	}
	/**��������*/
	public void addSalesVolume(Integer amount) {
		this.amount = this.amount + amount;
	}
	
	/**�����޸�ʱ��*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**��ȡ�޸�ʱ��*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**����*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**��ȡ*/
	public Date getGmtModify() {
		return this.gmtModify;
	}

	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
}