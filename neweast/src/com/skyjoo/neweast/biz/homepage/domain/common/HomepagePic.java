/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.domain.common;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

/**
 * ��ҳͼƬ��
 * @author liupc
 * @date 2014-11-10 10:48:59
 */
public class HomepagePic extends Pagination<HomepagePic> {

    /**
     * 
     */
    private static final long serialVersionUID = -2211811093086345298L;
    /* ����   */
    private Long              id;
    /* ͼƬ�ƹ�����   */
    private String            extendUrl;
    /* ͼƬ������ַ   */
    private String            attachment;
    /* ״̬��1 ��ɾ���� 0 ����   */
    private Integer           status;
    /* ����Ա   */
    private String            operator;
    /* ����ʱ��  */
    private Date              gmtCreate;
    /* �޸�ʱ��   */
    private Date              gmtModify;
    /*ͼƬ���� 1-PC��2-App*/
    private int               type;
    /**
     * ͼƬ����
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
