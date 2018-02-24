package com.skyjoo.neweast.biz.system.domain;

import java.util.Date;


/**
 * 系统功能角色关系数据对象
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

    /* @model:设置 */
    public void setId(Long obj) {
        this.id = obj;
    }

    /* @model:获取 */
    public Long getId() {
        return this.id;
    }

    /* @model:设置 */
    public void setRoleId(Long obj) {
        this.roleId = obj;
    }

    /* @model:获取 */
    public Long getRoleId() {
        return this.roleId;
    }

    /* @model:设置 */
    public void setFunctionId(Long obj) {
        this.functionId = obj;
    }

    /* @model:获取 */
    public Long getFunctionId() {
        return this.functionId;
    }

    /* @model:设置 */
    public void setGmtCreate(Date obj) {
        this.gmtCreate = obj;
    }

    /* @model:获取 */
    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    /* @model:设置 */
    public void setGmtModify(Date obj) {
        this.gmtModify = obj;
    }

    /* @model:获取 */
    public Date getGmtModify() {
        return this.gmtModify;
    }

    /* @model:设置 */
    public void setOperator(String obj) {
        this.operator = obj;
    }

    /* @model:获取 */
    public String getOperator() {
        return this.operator;
    }
}
