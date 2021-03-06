package com.skyjoo.neweast.biz.article.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;
/**
 * 文章评论表
 * @author qgm
 *
 */
public class ArticleComment extends DomainBase {
	
	private static final long serialVersionUID = 56L;
	
	//pk
	private Long  id;
	//文章id
	private Long articleId;
	//评论类型
	private Long commentTpye;
	//用户id
	private Long userId;
	//回复评论的id
	private Long commentId;
	//评论人id
	private Long  replyId;
	//二级评论的主题id
	private Long  themeCommentId;
	//评论点赞数
	private Long  comment_approve;
	//评论内容
	private String content;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModify;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	public Long getCommentTpye() {
		return commentTpye;
	}
	public void setCommentTpye(Long commentTpye) {
		this.commentTpye = commentTpye;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getCommentId() {
		return commentId;
	}
	public void setCommentId(Long commentId) {
		this.commentId = commentId;
	}
	public Long getReplyId() {
		return replyId;
	}
	public void setReplyId(Long replyId) {
		this.replyId = replyId;
	}
	public Long getThemeCommentId() {
		return themeCommentId;
	}
	public void setThemeCommentId(Long themeCommentId) {
		this.themeCommentId = themeCommentId;
	}
	public Long getComment_approve() {
		return comment_approve;
	}
	public void setComment_approve(Long comment_approve) {
		this.comment_approve = comment_approve;
	}

	public String getContent() {
        return content;
    }
    public void setContent(String content) {
        this.content = content;
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
	
	
}
