package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * ���׶�����Ʒ��
 * @author lxh
 * @version 2015-04-28 18:57:10
 */
public class TradeOrderItem extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3874237899896074225L;
	//pk,seq
	private Long id;
	//����ID
	private Long orderId;
	//������
	private String tradeNo;
	//��Ʒid
	private Long artId;
	//��ƷͼƬ��ַ
	private String attachment;
	//��Ʒ��Ŀ����
	private String catCode;
	//��Ʒ����
	private String artName;
	//��������
	private Long artNumber;
	//����۸�,��λ��
	private Long artPrice;
	//����ʱ��
	private Date gmtCreate;

	/**����pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**��ȡpk,seq*/
	public Long getId() {
		return this.id;
	}
	
	/**���ö���ID*/
	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}
	/**��ȡ����ID*/
	public Long getOrderId() {
		return this.orderId;
	}
	
	/**���ö�����*/
	public void setTradeNo(String tradeNo) {
		this.tradeNo = tradeNo;
	}
	/**��ȡ������*/
	public String getTradeNo() {
		return this.tradeNo;
	}
	
	/**������Ʒid*/
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	/**��ȡ��Ʒid*/
	public Long getArtId() {
		return this.artId;
	}
	
	/**������ƷͼƬ��ַ*/
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	/**��ȡ��ƷͼƬ��ַ*/
	public String getAttachment() {
		return this.attachment;
	}
	
	/**������Ʒ��Ŀ����*/
	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}
	/**��ȡ��Ʒ��Ŀ����*/
	public String getCatCode() {
		return this.catCode;
	}
	
	/**������Ʒ����*/
	public void setArtName(String artName) {
		this.artName = artName;
	}
	/**��ȡ��Ʒ����*/
	public String getArtName() {
		return this.artName;
	}
	
	/**���ù�������*/
	public void setArtNumber(Long artNumber) {
		this.artNumber = artNumber;
	}
	/**��ȡ��������*/
	public Long getArtNumber() {
		return this.artNumber;
	}
	
	/**���ù���۸�,��λ��*/
	public void setArtPrice(Long artPrice) {
		this.artPrice = artPrice;
	}
	/**��ȡ����۸�,��λ��*/
	public Long getArtPrice() {
		return this.artPrice;
	}
	
	/**���ô���ʱ��*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**��ȡ����ʱ��*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
}