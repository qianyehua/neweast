package com.skyjoo.neweast.biz.system.domain;

import java.util.Date;
import java.util.List;

import com.hundsun.wudadao.common.DomainBase;


/**
 * 系统角色表
 * @author lxh
 * @version 2014-10-29 17:45:24
 */
public class SystemRole extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6442680380900166666L;
	//pk,seq
	private Long id;
	//名称
	private String name;
	//描述
	private String description;
	//操作员
	private String operator;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;
	
	private List<SystemFunction> systemFunctionList;

    private boolean selected;
   
    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

	/**设置pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取pk,seq*/
	public Long getId() {
		return this.id;
	}
	
	/**设置名称*/
	public void setName(String name) {
		this.name = name;
	}
	/**获取名称*/
	public String getName() {
		return this.name;
	}
	
	/**设置描述*/
	public void setDescription(String description) {
		this.description = description;
	}
	/**获取描述*/
	public String getDescription() {
		return this.description;
	}
	
	/**设置操作员*/
	public void setOperator(String operator) {
		this.operator = operator;
	}
	/**获取操作员*/
	public String getOperator() {
		return this.operator;
	}
	
	/**设置创建时间*/
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	/**获取创建时间*/
	public Date getGmtCreate() {
		return this.gmtCreate;
	}
	
	/**设置最后修改时间*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**获取最后修改时间*/
	public Date getGmtModify() {
		return this.gmtModify;
	}

	public List<SystemFunction> getSystemFunctionList() {
		return systemFunctionList;
	}

	public void setSystemFunctionList(List<SystemFunction> systemFunctionList) {
		this.systemFunctionList = systemFunctionList;
	}
	
}