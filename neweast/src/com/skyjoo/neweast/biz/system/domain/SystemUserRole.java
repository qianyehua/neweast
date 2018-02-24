package com.skyjoo.neweast.biz.system.domain;

import java.util.Date;


/**
 * �û���ɫ��ϵ���ݶ���
 * 
 * @author wm
 */
public class SystemUserRole {

    /* @property: */
    private Long              id;
    /* @property: */
    private Long              userId;
    /* @property: */
    private Long              roleId;
    /* @property: */
    private Date              gmtCreate;
    /* @property: */
    private Date              gmtModify;
    /* @property: */
    private String            operator;

    /* Default constructor - creates a new instance with no values set. */
    public SystemUserRole() {
    }

    /* @model:���� */
    public void setId(Long obj) {
        this.id = obj;
    }

    /* @model:��ȡ */
    public Long getId() {
        return this.id;
    }

    /* @model:���� */
    public void setUserId(Long obj) {
        this.userId = obj;
    }

    /* @model:��ȡ */
    public Long getUserId() {
        return this.userId;
    }

    /* @model:���� */
    public void setRoleId(Long obj) {
        this.roleId = obj;
    }

    /* @model:��ȡ */
    public Long getRoleId() {
        return this.roleId;
    }

    /* @model:���� */
    public void setGmtCreate(Date obj) {
        this.gmtCreate = obj;
    }

    /* @model:��ȡ */
    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    /* @model:���� */
    public void setGmtModify(Date obj) {
        this.gmtModify = obj;
    }

    /* @model:��ȡ */
    public Date getGmtModify() {
        return this.gmtModify;
    }

    /* @model:���� */
    public void setOperator(String obj) {
        this.operator = obj;
    }

    /* @model:��ȡ */
    public String getOperator() {
        return this.operator;
    }
}
