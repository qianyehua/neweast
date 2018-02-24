package com.skyjoo.neweast.biz.article.domain.query;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

public class ArticleCheckQuery extends Pagination<ArticleCheckQuery> {

	private static final long serialVersionUID = 1L;
	
	//seq,pk
	private Long id;
	
	//���±���
	private String articleTitle;
	
	//ý��id
	private Long mediaId;
	
	//ר��id
	private Long subjectId;
	//��������
	private Integer visitType;
	
	//״̬
	private Integer status;
	
	//����ʱ��
	private Date gmtCreate;
	
	//����ʱ��������ʼ
	private Date startDate;
	
	//����ʱ����������
	private Date endDate;

	//ý������
	private String mediaName;
	
	//ר������
	private String subjectName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	public Long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(Long subjectId) {
		this.subjectId = subjectId;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Date getGmtCreate() {
		return gmtCreate;
	}

	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
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

	public Integer getVisitType() {
		return visitType;
	}

	public void setVisitType(Integer visitType) {
		this.visitType = visitType;
	}
}
