package com.skyjoo.neweast.biz.article.domain.query;

import java.util.Date;

import com.skyjoo.neweast.biz.article.domain.ArticleComment;
import com.skyjoo.neweast.biz.common.page.Pagination;

public class ArticleCommentQuery extends Pagination<ArticleComment>{
	
	private static final long serialVersionUID = 1L;
    //pk
    private Long              id;
    //����id
    private Long              articleId;
    //��������
    private String              articleName;
    //��������
    private Long              commentTpye;
    //�û�id
    private Long              userId;
    //�ظ����۵�id
    private Long              commentId;
    //������id
    private Long              replyId;
    //�������۵�����id
    private Long              themeCommentId;
    //���۵�����
    private Long              comment_approve;
    //��������
    private String            content;
    //����ʱ��
    private Date              gmtCreate;
    //�޸�ʱ��
    private Date              gmtModify;
    //��ʼʱ��
    private Date              startDate;
    //����ʱ��
    private Date              endDate;

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

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getArticleName() {
        return articleName;
    }

    public void setArticleName(String articleName) {
        this.articleName = articleName;
    }

    

}
