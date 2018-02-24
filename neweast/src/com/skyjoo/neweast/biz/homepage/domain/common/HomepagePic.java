/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.domain.common;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

/**
 * 首页图片类
 * @author liupc
 * @date 2014-11-10 10:48:59
 */
public class HomepagePic extends Pagination<HomepagePic> {

    /**
     * 
     */
    private static final long serialVersionUID = -2211811093086345298L;
    /* 主键   */
    private Long              id;
    /* 图片推广链接   */
    private String            extendUrl;
    /* 图片附件地址   */
    private String            attachment;
    /* 状态：1 已删除， 0 正常   */
    private Integer           status;
    /* 操作员   */
    private String            operator;
    /* 创建时间  */
    private Date              gmtCreate;
    /* 修改时间   */
    private Date              gmtModify;
    /*图片类型 1-PC，2-App*/
    private int               type;
    /**
     * 图片排序
     */
    private Integer           picOrder         = 0;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getExtendUrl() {
        return extendUrl;
    }

    public void setExtendUrl(String extendUrl) {
        this.extendUrl = extendUrl;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
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

    public Integer getPicOrder() {
        return picOrder;
    }

    public void setPicOrder(Integer picOrder) {
        this.picOrder = picOrder;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
