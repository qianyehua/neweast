package com.skyjoo.neweast.biz.trade.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * ���׳�ʱ�����
 * @author lxh
 * @version 2015-04-29 10:06:29
 */
public class TradeTimeout extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6263270635049333703L;
	//pk,seq
	private Long id;
	//����ID
	private Long orderId;
	//������
	private String tradeNo;
	//��ʱ����buyer����seller
	private String payType;
	//��ʱ��id
	private Long userId;
	//��Ӧ�˿�id
	private Long refundId;
	//��Ӧ����id
	private Long logisticId;
	//����������
	private String processorName;
	//Ԥ��ʱ��
	private Date warningDate;
	//��ʱʱ��
	private Date timeoutDate;
	//״̬enabledisable
	private String status;
	//����ʱ��
	private Date gmtCreate;
	//����޸�ʱ��
	private Date gmtModify;
	//��ע
	private String memo;

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
	
	/**���ó�ʱ����buyer����seller*/
	public void setPayType(String payType) {
		this.payType = payType;
	}
	/**��ȡ��ʱ����buyer����seller*/
	public String getPayType() {
		return this.payType;
	}
	
	/**���ó�ʱ��id*/
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	/**��ȡ��ʱ��id*/
	public Long getUserId() {
		return this.userId;
	}
	
	/**���ö�Ӧ�˿�id*/
	public void setRefundId(Long refundId) {
		this.refundId = refundId;
	}
	/**��ȡ��Ӧ�˿�id*/
	public Long getRefundId() {
		return this.refundId;
	}
	
	/**���ö�Ӧ����id*/
	public void setLogisticId(Long logisticId) {
		this.logisticId = logisticId;
	}
	/**��ȡ��Ӧ����id*/
	public Long getLogisticId() {
		return this.logisticId;
	}
	
	/**���ô���������*/
	public void setProcessorName(String processorName) {
		this.processorName = processorName;
	}
	/**��ȡ����������*/
	public String getProcessorName() {
		return this.processorName;
	}
	
	/**����Ԥ��ʱ��*/
	public void setWarningDate(Date warningDate) {
		this.warningDate = warningDate;
	}
	/**��ȡԤ��ʱ��*/
	public Date getWarningDate() {
		return this.warningDate;
	}
	
	/**���ó�ʱʱ��*/
	public void setTimeoutDate(Date timeoutDate) {
		this.timeoutDate = timeoutDate;
	}
	/**��ȡ��ʱʱ��*/
	public Date getTimeoutDate() {
		return this.timeoutDate;
	}
	
	/**����״̬enabledisable*/
	public void setStatus(String status) {
		this.status = status;
	}
	/**��ȡ״̬enabledisable*/
	public String getStatus() {
		return this.status;
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
	
	/**���ñ�ע*/
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**��ȡ��ע*/
	public String getMemo() {
		return this.memo;
	}
	
}