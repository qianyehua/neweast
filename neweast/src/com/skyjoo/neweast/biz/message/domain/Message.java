package com.skyjoo.neweast.biz.message.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * 消息表
 * @author paul
 * @version 2016-3-17 上午11:14:50
 */
public class Message extends DomainBase {
	
	private static final long serialVersionUID = 1L;

	// pk
	private Long 	id;
	
	//艺术品Id
	private Long 	artId;
	
	//消息发送者Id
	private Long 	fromId;
	
	//消息接收者Id
	private Long 	toId;
	
	//消息体对象Id(例如：回复评论,则为CommentID)
	private Long 	objectId;
	
	//消息内容
	private String 	content;
	
	//消息体链接地址
	private String 	url;
	
	//消息体链接对应的文字
	private String 	urlContent;
	
	//消息类型(0:系统消息 1:评论消息 2:咨询消息 3：私信消息)
	private Integer type;
	
	//阅读状态（0-已发，1-未读，2-已读）
	private Integer readStatus;
	
	//消息发送时间
	private Date 	sendDate;
	
	//消息阅读时间
	private Date 	readDate;
	
	//创建时间
	private Date 	gmtCreate;
	
	/**
	 * 消息类型文字
	 */
	private String 	typeStr;
	
	/**
	 * 消息发送人名称
	 */
	private String 	fromName;
	
	/**
	 * 消息接收人名称
	 */
	private String 	toName;
	
	/**
	 * 用户名
	 */
	private Long 	userId;	
	
	/**
	 * 艺术品名称
	 */
	private String  artName;
	
    /**
     * 卖家账户
     */
    private String sellerStockAccount;
    
    /**
     * 买家账户
     */
    private String buyerStockAccount;	
		

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getArtId() {
		return artId;
	}

	public void setArtId(Long artId) {
		this.artId = artId;
	}

	public Long getFromId() {
		return fromId;
	}

	public void setFromId(Long fromId) {
		this.fromId = fromId;
	}

	public Long getToId() {
		return toId;
	}

	public void setToId(Long toId) {
		this.toId = toId;
	}

	public Long getObjectId() {
		return objectId;
	}

	public void setObjectId(Long objectId) {
		this.objectId = objectId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlContent() {
		return urlContent;
	}

	public void setUrlContent(String urlContent) {
		this.urlContent = urlContent;
	}

	public Integer getType() {
		return type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	public Integer getReadStatus() {
		return readStatus;
	}

	public void setReadStatus(Integer readStatus) {
		this.readStatus = readStatus;
	}

	public Date getSendDate() {
		return sendDate;
	}

	public void setSendDate(Date sendDate) {
		this.sendDate = sendDate;
	}

	public Date getReadDate() {
		return readDate;
	}

	public void setReadDate(Date readDate) {
		this.readDate = readDate;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}

	public String getTypeStr() {
		return typeStr;
	}

	public void setTypeStr(String typeStr) {
		this.typeStr = typeStr;
	}

	public String getFromName() {
		return fromName;
	}

	public void setFromName(String fromName) {
		this.fromName = fromName;
	}

	public String getToName() {
		return toName;
	}

	public void setToName(String toName) {
		this.toName = toName;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

	public String getSellerStockAccount() {
		return sellerStockAccount;
	}

	public void setSellerStockAccount(String sellerStockAccount) {
		this.sellerStockAccount = sellerStockAccount;
	}

	public String getBuyerStockAccount() {
		return buyerStockAccount;
	}

	public void setBuyerStockAccount(String buyerStockAccount) {
		this.buyerStockAccount = buyerStockAccount;
	}
	
}
