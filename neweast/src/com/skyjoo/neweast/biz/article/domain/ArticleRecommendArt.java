package com.skyjoo.neweast.biz.article.domain;

import java.util.Date;

public class ArticleRecommendArt {
    //pk,seq
    private Long id;
   
    //文章id
    private Long articleId;
    
    //艺术品id
    private Long artId;
    
    //推广表述
    private String introduction;
    
    // 创建时间
    private Date gmtCreate;

    // 修改时间
    private Date gmtModify;
    
    //艺术家名字
    private String artistName;
    
    //艺术品名称
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
