package com.skyjoo.neweast.biz.datadic.domain;

import java.util.Date;

import com.hundsun.wudadao.common.DomainBase;

/**
 * 数据字典表
 * @author lxh
 * @version 2014-11-03 10:11:33
 */
public class CommDatadic extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -6263412340387365532L;
	//序列号ID
	private Long id;
	//名称
	private String name;
	//代码
	private String code;
	//值
	private String value;
	//组名，对于相同属性的可以进行分组管理
	private String groupName;
	//父级ID
	private Long parentId;
	//排序
	private Integer ordering;
	//备注
	private String memo;
	//操作员
	private String operator;
	//创建时间
	private Date gmtCreate;
	//修改时间
	private Date gmtModify;

	/**设置序列号ID*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取序列号ID*/
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
	
	/**设置代码*/
	public void setCode(String code) {
		this.code = code;
	}
	/**获取代码*/
	public String getCode() {
		return this.code;
	}
	
	/**设置值*/
	public void setValue(String value) {
		this.value = value;
	}
	/**获取值*/
	public String getValue() {
		return this.value;
	}
	
	/**设置组名，对于相同属性的可以进行分组管理*/
	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}
	/**获取组名，对于相同属性的可以进行分组管理*/
	public String getGroupName() {
		return this.groupName;
	}
	
	/**设置父级ID*/
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**获取父级ID*/
	public Long getParentId() {
		return this.parentId;
	}
	
	/**设置排序*/
	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}
	/**获取排序*/
	public Integer getOrdering() {
		return this.ordering;
	}
	
	/**设置备注*/
	public void setMemo(String memo) {
		this.memo = memo;
	}
	/**获取备注*/
	public String getMemo() {
		return this.memo;
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
	
	/**设置修改时间*/
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	/**获取修改时间*/
	public Date getGmtModify() {
		return this.gmtModify;
	}
	
}