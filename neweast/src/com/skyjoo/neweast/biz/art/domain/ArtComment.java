
package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;
/**
 * @author paul
 * @version 2016-1-17 下午17:17:16
 */
public class ArtComment extends DomainBase {

    private static final long serialVersionUID = -836935834634218052L;

    // 主键
    private Long id;
    
    // 艺术品ID
    private Long artId;
    
    //评论类型 0:艺术品评论 1：回复评论 默认是：0
    private Integer comment_Type;

    // 用户序列ID
    private Long userId;
    
    //回复评论ID
    private Long comment_Id;
    
    //评论人id
    private Long reply_Id;
    
    //评论内容
    private String content;
    
    //赞同数量，默认是：0
    private Integer approve;

    // 创建时间
    private Date gmtCreate;

    // 最后修改时间
    private Date gmtModify;
    
    //评论主ID
    private Long theme_CommentId;
    
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
    
    /**
     * 来自
     */
    private String fromName;
    
    /**
     *评论
     */
    private String toName;
		   

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

	public Integer getComment_Type() {
		return comment_Type;
	}

	public void setComment_Type(Integer comment_Type) {
		this.comment_Type = comment_Type;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getComment_Id() {
		return comment_Id;
	}

	public void setComment_Id(Long comment_Id) {
		this.comment_Id = comment_Id;
	}

	public Long getReply_Id() {
		return reply_Id;
	}

	public void setReply_Id(Long reply_Id) {
		this.reply_Id = reply_Id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getApprove() {
		return approve;
	}

	public void setApprove(Integer approve) {
		this.approve = approve;
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

	public Long getTheme_CommentId() {
		return theme_CommentId;
	}

	public void setTheme_CommentId(Long theme_CommentId) {
		this.theme_CommentId = theme_CommentId;
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

}
