package com.skyjoo.neweast.biz.internalMessage.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

public class CommInternalMessage extends Pagination<CommInternalMessage> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * pk,seq
	 */
	private Long id;
	/**
	 * �ռ�������
	 */
	private Integer addressType;
	/**
	 *�ռ���login_id
	 */
	private String addressee;
	/**
	 * ������
	 */
	private String messageSender;
	/**
	 * ����
	 */
	private String theme;
	/**
	 * ����
	 */
	private String content;
	/**
	 * ���ż�id
	 */
	private String messageId;
	/**
	 * �ظ�id
	 */
	private String replyId;
	/**
	 * ����ʱ��
	 */
	private Date sendDate;
	/**
	 * �ظ�ʱ��
	 */
	private Date replyDate;
	/**
	 * �Ķ�״̬ 0-�ѷ� 1-δ�� 2-�Ѷ�
	 */
	private Integer readStatus;
	/**
	 * �ظ�״̬ 0-δ�ظ� 1-�ѻָ�
	 */
	private Integer replyStatus;
	/**
	 * ����ʱ��
	 */
	private Date gmtCreate;
	/**
	 * ����޸�ʱ��
	 */
	private Date gmtModify;
	/**
	 * ��Աid
	 */
	private Long userId;
	/**
	 * �ظ�վ���ŵĹ���Ա����
	 */
	private String adminLoginName;
	/**
	 * ��Ϊ��ѯ����
	 */
	private Date sendStart;
	private Date sendEnd;
	private Date replyStart;
	private Date replyEnd;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Integer getAddressType() {
		return addressType;
	}
	public void setAddressType(Integer addressType) {
		this.addressType = addressType;
	}
	public String getAddressee() {
		return addressee;
	}
	public void setAddressee(String addressee) {
		this.addressee = addressee;
	}
	public String getTheme() {
		return theme;
	}
	public void setTheme(String theme) {
		this.theme = theme;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getMessageId() {
		return messageId;
	}
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	public String getReplyId() {
		return replyId;
	}
	public void setReplyId(String replyId) {
		this.replyId = replyId;
	}
	public Date getSendDate() {
		return sendDate;
	}
	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}
	public Date getReplyDate() {
		return replyDate;
	}
	public void setReplyDate(Date replyDate) {
		this.replyDate = replyDate;
	}
	public Integer getReadStatus() {
		return readStatus;
	}
	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}
	public Integer getReplyStatus() {
		return replyStatus;
	}
	public void setReplyStatus(Integer replyStatus) {
		this.replyStatus = replyStatus;
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
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Date getSendStart() {
		return sendStart;
	}
	public void setSendStart(Date sendStart) {
		this.sendStart = sendStart;
	}
	public Date getSendEnd() {
		return sendEnd;
	}
	public void setSendEnd(Date sendEnd) {
		this.sendEnd = sendEnd;
	}
	public Date getReplyStart() {
		return replyStart;
	}
	public void setReplyStart(Date replyStart) {
		this.replyStart = replyStart;
	}
	public Date getReplyEnd() {
		return replyEnd;
	}
	public void setReplyEnd(Date replyEnd) {
		this.replyEnd = replyEnd;
	}
	public String getMessageSender() {
		return messageSender;
	}
	public void setMessageSender(String messageSender) {
		this.messageSender = messageSender;
	}
	public String getAdminLoginName() {
		return adminLoginName;
	}
	public void setAdminLoginName(String adminLoginName) {
		this.adminLoginName = adminLoginName;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
