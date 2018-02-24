package com.skyjoo.neweast.biz.trade.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * �����˻�ӵ�������ȼ����ݶ���
 * 
 * @author wangyf
 * @version $Id: TradeCommisionRate.java,v 0.1 2010-3-22 ����11:32:39 wangyf Exp $
 */
public class TradeCommisionRate extends DomainBase implements Serializable {

    private static final long serialVersionUID = -8913625681640385165L;
    /* @property:���к�ID */
    private Long              id;
    /*
     * @property:Ӷ�����
     */
    private BigDecimal		  commRate;
	/*
     * @property:���Ӷ���
     */
    private BigDecimal            minCommision;
    /* @property:��Ա�ȼ��İ汾�� */
    private Long              version;
    
    private Date      gmtValid;
    
    /*
     * @property:����Ա
     */
    private String            operator;
    /*
     * @property:����ʱ��
     */
    private Date              gmtCreate;
    /* @property:�޸�ʱ�� */
    private Date              gmtModify;
    /**
	 * @return the version
	 */
	public Long getVersion() {
		return version;
	}



	/**
	 * @param version the version to set
	 */
	public void setVersion(Long version) {
		this.version = version;
	}

	

    /**
	 * @return the commRate
	 */
	public BigDecimal getCommRate() {
		return commRate;
	}



	/**
	 * @param commRate the commRate to set
	 */
	public void setCommRate(BigDecimal commRate) {
		this.commRate = commRate;
	}

	/**
	 * @return the minCommision
	 */
	public BigDecimal getMinCommision() {
		return minCommision;
	}

	/**
	 * @param minCommision the minCommision to set
	 */
	public void setMinCommision(BigDecimal minCommision) {
		this.minCommision = minCommision;
	}

    /* @model:�������к�ID */
    public void setId(Long obj) {
        this.id = obj;
    }

    /* @model:��ȡ���к�ID */
    public Long getId() {
        return this.id;
    }

    /*
     * @model:���ò���Ա
     */
    public void setOperator(String obj) {
        this.operator = obj;
    }

    /*
     * @model:��ȡ����Ա
     */
    public String getOperator() {
        return this.operator;
    }

    /*
     * @model:���ô���ʱ��
     */
    public void setGmtCreate(Date obj) {
        this.gmtCreate = obj;
    }

    /*
     * @model:��ȡ����ʱ��
     */
    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    /* @model:�����޸�ʱ�� */
    public void setGmtModify(Date obj) {
        this.gmtModify = obj;
    }

    /* @model:��ȡ�޸�ʱ�� */
    public Date getGmtModify() {
        return this.gmtModify;
    }

	public Date getGmtValid() {
		return gmtValid;
	}

	public void setGmtValid(Date gmtValid) {
		this.gmtValid = gmtValid;
	}

}
