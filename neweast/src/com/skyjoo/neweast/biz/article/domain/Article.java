package com.skyjoo.neweast.biz.article.domain;

import java.util.Date;
import java.util.List;

import com.skyjoo.neweast.biz.subject.domain.Subject;

public class Article {
	// seq,pk
	private Long id;

	// ���±���
	private String articleTitle;

	// ����ժҪ
	private String articleAbstract;

	// ����ͼƬ·��
	private String articlePic;

	// ����ҳ��ͼƬ
	private String transitionPic;

	// ý��ID
	private Long mediaId;
	// ý������
	private String mediaName;
	//ý���������
	private Integer visitType;
	// ר��id�б�
	private List<Long> subjectIds;
	// ��������ר��
	private String subjects;

	// ԭ������
	private String originalUrl;

	// ���ض�ȡ·��
	private String localUrl;

	// ��ά���ַ
	private String urCode;

	// ������
	private Integer commentCount;

	// �����
	private Integer browseCount;

	// ������
	private Integer praiseCount;

	// ����״̬
	private Integer status;

	// ��ע
	private String memo;

	// ����ʱ��
	private Date gmtCreate;

	// �޸�ʱ��
	private Date gmtModify;
	
	//��������
	private String content;
	
	//ͼƬ��base64
	private String basePic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getArticleTitle() {
		return articleTitle;
	}

	public void setArticleTitle(String articleTitle) {
		this.articleTitle = articleTitle;
	}

	public String getArticleAbstract() {
		return articleAbstract;
	}

	public void setArticleAbstract(String articleAbstract) {
		this.articleAbstract = articleAbstract;
	}

	public String getArticlePic() {
		return articlePic;
	}

	public void setArticlePic(String articlePic) {
		this.articlePic = articlePic;
	}

	public String getTransitionPic() {
		return transitionPic;
	}

	public void setTransitionPic(String transitionPic) {
		this.transitionPic = transitionPic;
	}

	public Long getMediaId() {
		return mediaId;
	}

	public void setMediaId(Long mediaId) {
		this.mediaId = mediaId;
	}

	public String getOriginalUrl() {
		return originalUrl;
	}

	public void setOriginalUrl(String originalUrl) {
		this.originalUrl = originalUrl;
	}

	public String getLocalUrl() {
		return localUrl;
	}

	public void setLocalUrl(String localUrl) {
		this.localUrl = localUrl;
	}

	public String getUrCode() {
		return urCode;
	}

	public void setUrCode(String urCode) {
		this.urCode = urCode;
	}

	public Integer getCommentCount() {
		return commentCount;
	}

	public void setCommentCount(Integer commentCount) {
		this.commentCount = commentCount;
	}

	public Integer getBrowseCount() {
		return browseCount;
	}

	public void setBrowseCount(Integer browseCount) {
		this.browseCount = browseCount;
	}

	public Integer getPraiseCount() {
		return praiseCount;
	}

	public void setPraiseCount(Integer praiseCount) {
		this.praiseCount = praiseCount;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
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

	public List<Long> getSubjectIds() {
		return subjectIds;
	}

	public void setSubjectIds(List<Long> subjectIds) {
		this.subjectIds = subjectIds;
	}

	public String getSubjects() {
		return subjects;
	}

	public void setSubjects(String subjects) {
		this.subjects = subjects;
	}

	public String getMediaName() {
		return mediaName;
	}

	public void setMediaName(String mediaName) {
		this.mediaName = mediaName;
	}

	public Integer getVisitType() {
		return visitType;
	}

	public void setVisitType(Integer visitType) {
		this.visitType = visitType;
	}

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getBasePic() {
        return basePic;
    }

    public void setBasePic(String basePic) {
        this.basePic = basePic;
    }
	
	
	
}
