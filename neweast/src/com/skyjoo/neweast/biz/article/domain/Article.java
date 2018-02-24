package com.skyjoo.neweast.biz.article.domain;

import java.util.Date;
import java.util.List;

import com.skyjoo.neweast.biz.subject.domain.Subject;

public class Article {
	// seq,pk
	private Long id;

	// 文章标题
	private String articleTitle;

	// 文章摘要
	private String articleAbstract;

	// 文章图片路径
	private String articlePic;

	// 过度页面图片
	private String transitionPic;

	// 媒体ID
	private Long mediaId;
	// 媒体名称
	private String mediaName;
	//媒体访问类型
	private Integer visitType;
	// 专题id列表
	private List<Long> subjectIds;
	// 文章所属专题
	private String subjects;

	// 原文链接
	private String originalUrl;

	// 本地读取路径
	private String localUrl;

	// 二维码地址
	private String urCode;

	// 评论数
	private Integer commentCount;

	// 浏览量
	private Integer browseCount;

	// 点赞数
	private Integer praiseCount;

	// 文章状态
	private Integer status;

	// 备注
	private String memo;

	// 创建时间
	private Date gmtCreate;

	// 修改时间
	private Date gmtModify;
	
	//文章内容
	private String content;
	
	//图片的base64
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
