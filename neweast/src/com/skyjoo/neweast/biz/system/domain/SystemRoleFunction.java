package com.skyjoo.neweast.biz.system.domain;

import java.util.Date;


/**
 * ϵͳ���ܽ�ɫ��ϵ���ݶ���
 * 
 * @author wm
 */
public class SystemRoleFunction {

    /* @property: */
    private Long              id;
    /* @property: */
    private Long              roleId;
    /* @property: */
    private Long              functionId;
    /* @property: */
    private Date              gmtCreate;
    /* @property: */
    private Date              gmtModify;
    /* @property: */
    private String            operator;

    /* Default constructor - creates a new instance with no values set. */
    public SystemRoleFunction() {
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
    public void setRoleId(Long obj) {
        this.roleId = obj;
    }

    /* @model:��ȡ */
    public Long getRoleId() {
        return this.roleId;
    }

    /* @model:���� */
    public void setFunctionId(Long obj) {
        this.functionId = obj;
    }

    /* @model:��ȡ */
    public Long getFunctionId() {
        return this.functionId;
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
