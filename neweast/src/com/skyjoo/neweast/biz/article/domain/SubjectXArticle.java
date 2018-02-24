package com.skyjoo.neweast.biz.article.domain;

import java.util.Date;

public class SubjectXArticle{
	//seq,pk
	private Long id;
	
	//专题id
	private Long subjectId;
	
	//文章id
	private Long articleId;
	
	//创建时间
	private Date gmtCreate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Long getArticleId() {
		return articleId;
	}

	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
}