package com.skyjoo.neweast.biz.trade.domain;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * 交易账户拥挤比例等级数据对象
 * 
 * @author wangyf
 * @version $Id: TradeCommisionRate.java,v 0.1 2010-3-22 上午11:32:39 wangyf Exp $
 */
public class TradeCommisionRate extends DomainBase implements Serializable {

    private static final long serialVersionUID = -8913625681640385165L;
    /* @property:序列号ID */
    private Long              id;
    /*
     * @property:佣金比例
     */
    private BigDecimal		  commRate;
	/*
     * @property:最低佣金额
     */
    private BigDecimal            minCommision;
    /* @property:会员等级的版本号 */
    private Long              version;
    
    private Date      gmtValid;
    
    /*
     * @property:操作员
     */
    private String            operator;
    /*
     * @property:创建时间
     */
    private Date              gmtCreate;
    /* @property:修改时间 */
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

    /* @model:设置序列号ID */
    public void setId(Long obj) {
        this.id = obj;
    }

    /* @model:获取序列号ID */
    public Long getId() {
        return this.id;
    }

    /*
     * @model:设置操作员
     */
    public void setOperator(String obj) {
        this.operator = obj;
    }

    /*
     * @model:获取操作员
     */
    public String getOperator() {
        return this.operator;
    }

    /*
     * @model:设置创建时间
     */
    public void setGmtCreate(Date obj) {
        this.gmtCreate = obj;
    }

    /*
     * @model:获取创建时间
     */
    public Date getGmtCreate() {
        return this.gmtCreate;
    }

    /* @model:设置修改时间 */
    public void setGmtModify(Date obj) {
        this.gmtModify = obj;
    }

    /* @model:获取修改时间 */
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
