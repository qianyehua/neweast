
package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * @author paul
 *
 */
public class ArtConsulting extends DomainBase {

    private static final long serialVersionUID = 2240052100096784770L;

    // 主键
    private Long   id;

    // 留言用户ID
    private Long   buyerId;

    // 卖家ID
    private Long   sellerId;

    // 卖家商品ID
    private Long   artId;

    // 留言内容
    private String content;

    // 回复内容
    private String replyContent;

    // 状态：0-未回复，1-已回复
    private int    status;

    // 创建时间
    private Date   gmtCreate;

    // 最后修改时间
    private Date   gmtModify;
    
    //买家邮箱
    private String email;
    
    //买家姓名
    private String buyerName;


	//艺术品名称
    private String artName;
    
    //已回复留言
    private String reply;
    
    //未回复留言
    private String unreply;
    
    
    /**
     * 卖家账号
     */
    private String sellerStockAccount;
    
    /**
     * 买家账号
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
