package com.skyjoo.neweast.biz.artise.domain.query;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

public class ArtiseQuery extends Pagination<ArtiseQuery> {
      /**
       * 艺术家列表
       */
    
     private static final long  serialVersionUID =454646466541123L;
     /**
      * seq，pk
      */
     private Long artiseId;
     /**
      * 用户id
      */
     private Long userId;
     /**
      * 艺术家姓名
      */
     private String artiseName;
     /**
      * 艺术家照片
      */
     private String portrait;
     /**
      * 个人简介
      */
     private String profile;
     /**
      * 个人作品图片地址
      */
     private String artWorks;
     /**
      * 个人证书图片地址
      */
     private String certifications;
     /**
      * 状态
      */
     private Integer status;
     /**
      * 审核备注
      */
     private String memo;
     /**
      * 职称
      */
     private String title;
     /**
      * 浏览量
      */
     private String  visitCount;
     /**
      * 关注量
      */
     private String  followCount;
     /**
      * 评论量
      */
     private String  commnetCount;
     /**
      * 收藏量
      */
     private String  collectCount;
     /**
      * 操作人
     */
     private String  operator;
     /**
      * 审核时间
      */
     private Date  gmt_Identify;
     /**
      * 创建时间
      */
     private Date  gmt_Create;
     /**
      * 修改时间
      */
     private Date gmt_Modify;
     /**
      * 开始时间
      */
     private Date startDate;
     /**
      * 结束时间
      */
     private Date endDate;
    /**
     * 是否推荐
     */
     private Long ifrecommend;
     /**
      * 艺术家的作品数目
      */
     private Long arts;
     
     // 用户类型  1:普通用户 2.机构用户
    private Integer roleType;
    
    //艺术家名称，目前针对机构来自Artise表
    private String  artist;
  
    public Long getArtiseId() {
        return artiseId;
    }
    public void setArtiseId(Long artiseId) {
        this.artiseId = artiseId;
    }
    public Long getUserId() {
        return userId;
    }
    public void setUserId(Long userId) {
        this.userId = userId;
    }
    public String getArtiseName() {
        return artiseName;
    }
    public void setArtiseName(String artiseName) {
        this.artiseName = artiseName;
    }
    public String getProfile() {
        return profile;
    }
    public void setProfile(String profile) {
        this.profile = profile;
    }
     
    public String getArtWorks() {
        return artWorks;
    }
    public void setArtWorks(String artWorks) {
        this.artWorks = artWorks;
    }
    public String getCertifications() {
        return certifications;
    }
    public void setCertifications(String certifications) {
        this.certifications = certifications;
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
     
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getVisitCount() {
        return visitCount;
    }
    public void setVisitCount(String visitCount) {
        this.visitCount = visitCount;
    }
    public String getFollowCount() {
        return followCount;
    }
    public void setFollowCount(String followCount) {
        this.followCount = followCount;
    }
    public String getCommnetCount() {
        return commnetCount;
    }
    public void setCommnetCount(String commnetCount) {
        this.commnetCount = commnetCount;
    }
    public String getCollectCount() {
        return collectCount;
    }
    public void setCollectCount(String collectCount) {
        this.collectCount = collectCount;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
    }
     
      
    public Date getGmt_Identify() {
        return gmt_Identify;
    }
    public void setGmt_Identify(Date gmt_Identify) {
        this.gmt_Identify = gmt_Identify;
    }
    public Date getGmt_Create() {
        return gmt_Create;
    }
    public void setGmt_Create(Date gmt_Create) {
        this.gmt_Create = gmt_Create;
    }
    public Date getGmt_Modify() {
        return gmt_Modify;
    }
    public void setGmt_Modify(Date gmt_Modify) {
        this.gmt_Modify = gmt_Modify;
    }
    public String getPortrait() {
        return portrait;
    }
    public void setPortrait(String portrait) {
        this.portrait = portrait;
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
    public Long getIfrecommend() {
        return ifrecommend;
    }
    public void setIfrecommend(Long ifrecommend) {
        this.ifrecommend = ifrecommend;
    }
    public Long getArts() {
        return arts;
    }
    public void setArts(Long arts) {
        this.arts = arts;
    }
    public String getTitles() {
        return title == null ? "" : title.replace("|", " ");
    }
    public Integer getRoleType() {
        return roleType;
    }
    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }
    public String getArtist() {
        return artist;
    }
    public void setArtist(String artist) {
        this.artist = artist;
    }  
    
}
