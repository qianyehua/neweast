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
	 * 收件人类型
	 */
	private Integer addressType;
	/**
	 *收件人login_id
	 */
	private String addressee;
	/**
	 * 发件人
	 */
	private String messageSender;
	/**
	 * 主题
	 */
	private String theme;
	/**
	 * 内容
	 */
	private String content;
	/**
	 * 主信件id
	 */
	private String messageId;
	/**
	 * 回复id
	 */
	private String replyId;
	/**
	 * 发件时间
	 */
	private Date sendDate;
	/**
	 * 回复时间
	 */
	private Date replyDate;
	/**
	 * 阅读状态 0-已发 1-未读 2-已读
	 */
	private Integer readStatus;
	/**
	 * 回复状态 0-未回复 1-已恢复
	 */
	private Integer replyStatus;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 最后修改时间
	 */
	private Date gmtModify;
	/**
	 * 会员id
	 */
	private Long userId;
	/**
	 * 回复站内信的管理员名称
	 */
	private String adminLoginName;
	/**
	 * 作为查询条件
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
