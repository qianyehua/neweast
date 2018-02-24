package com.skyjoo.neweast.biz.homepage.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

public class HomepageRecommendArtise extends DomainBase {
    
     private static final long serialVersionUID =14787915448994464L;
     
     public static final int STATUS_NORMAL = 1; //����
     public static final int STATUS_DELETE = -1;     
     
     /**
      * seq,pk
      */
     private Long id;
     /**
      * ������id
      */
     private Long artiseId;
     /**
      * ״̬��0-������1-��ɾ��
      */
     private Integer status;
     /**
      * ����Ա
      */
     private String operator;
     /**
      * ����ʱ��
      */
     private Date gmt_Create;
     /**
      * �޸�ʱ��
      */
     private Date gmt_Modify;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
  
    
     
    public Long getArtiseId() {
        return artiseId;
    }
    public void setArtiseId(Long artiseId) {
        this.artiseId = artiseId;
    }
    public Integer getStatus() {
        return status;
    }
    public void setStatus(Integer status) {
        this.status = status;
    }
    public String getOperator() {
        return operator;
    }
    public void setOperator(String operator) {
        this.operator = operator;
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
    
     
}
