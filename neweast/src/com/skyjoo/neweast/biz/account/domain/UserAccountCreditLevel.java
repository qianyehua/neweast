package com.skyjoo.neweast.biz.account.domain;

import java.util.Date;

public class UserAccountCreditLevel  {

    // ����
    private Long   id;

    // �ȼ���
    private Long   levelNo;

    // �ȼ�����
    private String levelName;

    // ����ֵ����
    private Long   lowLimit;

    // �汾��
    private Long   version;

    // ��Ч����
    private Date   gmtValid;

    // ����Ա
    private String operator;

    // ����ʱ��
    private Date   gmtCreate;

    // ����޸�ʱ��
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
