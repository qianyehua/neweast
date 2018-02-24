package com.skyjoo.neweast.biz.artise.domain.query;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

public class ArtiseQuery extends Pagination<ArtiseQuery> {
      /**
       * �������б�
       */
    
     private static final long  serialVersionUID =454646466541123L;
     /**
      * seq��pk
      */
     private Long artiseId;
     /**
      * �û�id
      */
     private Long userId;
     /**
      * ����������
      */
     private String artiseName;
     /**
      * ��������Ƭ
      */
     private String portrait;
     /**
      * ���˼��
      */
     private String profile;
     /**
      * ������ƷͼƬ��ַ
      */
     private String artWorks;
     /**
      * ����֤��ͼƬ��ַ
      */
     private String certifications;
     /**
      * ״̬
      */
     private Integer status;
     /**
      * ��˱�ע
      */
     private String memo;
     /**
      * ְ��
      */
     private String title;
     /**
      * �����
      */
     private String  visitCount;
     /**
      * ��ע��
      */
     private String  followCount;
     /**
      * ������
      */
     private String  commnetCount;
     /**
      * �ղ���
      */
     private String  collectCount;
     /**
      * ������
     */
     private String  operator;
     /**
      * ���ʱ��
      */
     private Date  gmt_Identify;
     /**
      * ����ʱ��
      */
     private Date  gmt_Create;
     /**
      * �޸�ʱ��
      */
     private Date gmt_Modify;
     /**
      * ��ʼʱ��
      */
     private Date startDate;
     /**
      * ����ʱ��
      */
     private Date endDate;
    /**
     * �Ƿ��Ƽ�
     */
     private Long ifrecommend;
     /**
      * �����ҵ���Ʒ��Ŀ
      */
     private Long arts;
     
     // �û�����  1:��ͨ�û� 2.�����û�
    private Integer roleType;
    
    //���������ƣ�Ŀǰ��Ի�������Artise��
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
