package com.skyjoo.neweast.biz.system.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.hundsun.wudadao.common.DomainBase;

/**
 * 系统功能表
 * @author lxh
 * @version 2014-10-29 17:16:36
 */
public class SystemFunction extends DomainBase {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3320817601236631458L;
	//PK
	private Long id;
	//父级功能ID
	private Long parentId;
	//名称
	private String name;
	//链接地址
	private String url;
	//描述
	private String description;
	//顺序
	private Integer ordering;
	//是否菜单：0否；1是
	private Integer isMenu;
	//0正常；1已删除
	private Integer isDeleted;
	//能否删除：true能;false不能
	private boolean canDeleted;
	//操作员
	private String operator;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;
	
	//子功能
	private List<SystemFunction> subfunctions = new ArrayList<SystemFunction>();

	/**设置PK*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取PK*/
	public Long getId() {
		return this.id;
	}
	
	/**设置父级功能ID*/
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	/**获取父级功能ID*/
	public Long getParentId() {
		return this.parentId;
	}
	
	/**设置名称*/
	public void setName(String name) {
		this.name = name;
	}
	/**获取名称*/
	public String getName() {
		return this.name;
	}
	
	/**设置链接地址*/
	public void setUrl(String url) {
		this.url = url;
	}
	/**获取链接地址*/
	public String getUrl() {
		return this.url;
	}
	
	/**设置描述*/
	public void setDescription(String description) {
		this.description = description;
	}
	/**获取描述*/
	public String getDescription() {
		return this.description;
	}
	
	/**设置顺序*/
	public void setOrdering(Integer ordering) {
		this.ordering = ordering;
	}
	/**获取顺序*/
	public Integer getOrdering() {
		return this.ordering;
	}
	
	/**设置是否菜单：0否；1是*/
	public void setIsMenu(Integer isMenu) {
		this.isMenu = isMenu;
	}
	/**获取是否菜单：0否；1是*/
	public Integer getIsMenu() {
		return this.isMenu;
	}
	
	/**设置0正常；1已删除*/
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**获取0正常；1已删除*/
	public Integer getIsDeleted() {
		return this.isDeleted;
	}
	
	public boolean isCanDeleted() {
		return canDeleted;
	}
	public void setCanDeleted(boolean canDeleted) {
		this.canDeleted = canDeleted;
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
	
	/**获取子功能*/
	public List<SystemFunction> getSubfunctions() {
		return subfunctions;
	}
	/**设置子功能*/
	public void setSubfunctions(List<SystemFunction> subfunctions) {
		this.subfunctions = subfunctions;
	}
	/**
	 * 添加子功能
	 * @param function
	 */
	public void addSubFunction(SystemFunction function) {
		this.subfunctions.add(function);
	}
	/**
	 * 添加多个子功能
	 * @param function
	 */
	public void addSubFunction(List<SystemFunction> functions) {
		this.subfunctions.addAll(functions);
	}	
	
}