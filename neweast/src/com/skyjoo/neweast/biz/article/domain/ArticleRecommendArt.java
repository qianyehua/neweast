package com.skyjoo.neweast.biz.article.domain;

import java.util.Date;

public class ArticleRecommendArt {
    //pk,seq
    private Long id;
   
    //����id
    private Long articleId;
    
    //����Ʒid
    private Long artId;
    
    //�ƹ����
    private String introduction;
    
    // ����ʱ��
    private Date gmtCreate;

    // �޸�ʱ��
    private Date gmtModify;
    
    //����������
    private String artistName;
    
    //����Ʒ����
    private String artName;
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

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
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

    public Long getArtId() {
        return artId;
    }

    public void setArtId(Long artId) {
        this.artId = artId;
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getArtName() {
        return artName;
    }

    public void setArtName(String artName) {
        this.artName = artName;
    }
    
    

}
