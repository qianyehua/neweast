package com.skyjoo.neweast.biz.account.domain;

import java.util.Date;

public class UserAccountCreditLevel  {

    // 主键
    private Long   id;

    // 等级号
    private Long   levelNo;

    // 等级名称
    private String levelName;

    // 信用值下限
    private Long   lowLimit;

    // 版本号
    private Long   version;

    // 生效日期
    private Date   gmtValid;

    // 操作员
    private String operator;

    // 创建时间
    private Date   gmtCreate;

    // 最后修改时间
    private Date   gmtModify;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getLevelNo() {
        return levelNo;
    }

    public void setLevelNo(Long levelNo) {
        this.levelNo = levelNo;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }

    public Long getLowLimit() {
        return lowLimit;
    }

    public void setLowLimit(Long lowLimit) {
        this.lowLimit = lowLimit;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Date getGmtValid() {
        return gmtValid;
    }

    public void setGmtValid(Date gmtValid) {
        this.gmtValid = gmtValid;
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

}
