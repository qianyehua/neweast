
package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * @author paul
 *
 */
public class ArtConsulting extends DomainBase {

    private static final long serialVersionUID = 2240052100096784770L;

    // ����
    private Long   id;

    // �����û�ID
    private Long   buyerId;

    // ����ID
    private Long   sellerId;

    // ������ƷID
    private Long   artId;

    // ��������
    private String content;

    // �ظ�����
    private String replyContent;

    // ״̬��0-δ�ظ���1-�ѻظ�
    private int    status;

    // ����ʱ��
    private Date   gmtCreate;

    // ����޸�ʱ��
    private Date   gmtModify;
    
    //�������
    private String email;
    
    //�������
    private String buyerName;


	//����Ʒ����
    private String artName;
    
    //�ѻظ�����
    private String reply;
    
    //δ�ظ�����
    private String unreply;
    
    
    /**
     * �����˺�
     */
    private String sellerStockAccount;
    
    /**
     * ����˺�
     */
    private String buyerStockAccount;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getArtId() {
        return artId;
    }

    public void setArtId(Long artId) {
        this.artId = artId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getReplyContent() {
        return replyContent;
    }

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
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

    
    public String getEmail() {
        return email;
    }

    
    public void setEmail(String email) {
        this.email = email;
    }

    
    public String getArtName() {
        return artName;
    }

    
    public void setArtName(String artName) {
        this.artName = artName;
    }

    
    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    
    public String getReply() {
        return reply;
    }

    
    public void setReply(String reply) {
        this.reply = reply;
    }

    
    public String getUnreply() {
        return unreply;
    }

    
    public void setUnreply(String unreply) {
        this.unreply = unreply;
    }

    
    public String getBuyerName() {
		return buyerName;
	}

	public void setBuyerName(String buyerName) {
		this.buyerName = buyerName;
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
