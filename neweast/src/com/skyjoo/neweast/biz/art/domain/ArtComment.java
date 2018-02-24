
package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;
/**
 * @author paul
 * @version 2016-1-17 ����17:17:16
 */
public class ArtComment extends DomainBase {

    private static final long serialVersionUID = -836935834634218052L;

    // ����
    private Long id;
    
    // ����ƷID
    private Long artId;
    
    //�������� 0:����Ʒ���� 1���ظ����� Ĭ���ǣ�0
    private Integer comment_Type;

    // �û�����ID
    private Long userId;
    
    //�ظ�����ID
    private Long comment_Id;
    
    //������id
    private Long reply_Id;
    
    //��������
    private String content;
    
    //��ͬ������Ĭ���ǣ�0
    private Integer approve;

    // ����ʱ��
    private Date gmtCreate;

    // ����޸�ʱ��
    private Date gmtModify;
    
    //������ID
    private Long theme_CommentId;
    
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
    
    /**
     * ����
     */
    private String fromName;
    
    /**
     *����
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
