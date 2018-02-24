package com.skyjoo.neweast.biz.homepage.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

public class HomepageRecommendArtise extends DomainBase {
    
     private static final long serialVersionUID =14787915448994464L;
     
     public static final int STATUS_NORMAL = 1; //正常
     public static final int STATUS_DELETE = -1;     
     
     /**
      * seq,pk
      */
     private Long id;
     /**
      * 艺术家id
      */
     private Long artiseId;
     /**
      * 状态：0-正常，1-已删除
      */
     private Integer status;
     /**
      * 操作员
      */
     private String operator;
     /**
      * 创建时间
      */
     private Date gmt_Create;
     /**
      * 修改时间
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
