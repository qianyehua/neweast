package com.skyjoo.neweast.biz.message.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * ��Ϣ��
 * @author paul
 * @version 2016-3-17 ����11:14:50
 */
public class Message extends DomainBase {
	
	private static final long serialVersionUID = 1L;

	// pk
	private Long 	id;
	
	//����ƷId
	private Long 	artId;
	
	//��Ϣ������Id
	private Long 	fromId;
	
	//��Ϣ������Id
	private Long 	toId;
	
	//��Ϣ�����Id(���磺�ظ�����,��ΪCommentID)
	private Long 	objectId;
	
	//��Ϣ����
	private String 	content;
	
	//��Ϣ�����ӵ�ַ
	private String 	url;
	
	//��Ϣ�����Ӷ�Ӧ������
	private String 	urlContent;
	
	//��Ϣ����(0:ϵͳ��Ϣ 1:������Ϣ 2:��ѯ��Ϣ 3��˽����Ϣ)
	private Integer type;
	
	//�Ķ�״̬��0-�ѷ���1-δ����2-�Ѷ���
	private Integer readStatus;
	
	//��Ϣ����ʱ��
	private Date 	sendDate;
	
	//��Ϣ�Ķ�ʱ��
	private Date 	readDate;
	
	//����ʱ��
	private Date 	gmtCreate;
	
	/**
	 * ��Ϣ��������
	 */
	private String 	typeStr;
	
	/**
	 * ��Ϣ����������
	 */
	private String 	fromName;
	
	/**
	 * ��Ϣ����������
	 */
	private String 	toName;
	
	/**
	 * �û���
	 */
	private Long 	userId;	
	
	/**
	 * ����Ʒ����
	 */
	private String  artName;
	
    /**
     * �����˻�
     */
    private String sellerStockAccount;
    
    /**
     * ����˻�
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
