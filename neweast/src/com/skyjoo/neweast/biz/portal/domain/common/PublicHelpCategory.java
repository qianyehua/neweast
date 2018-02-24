/**
*@title
*@author liupc
*@version 1.0
*/
package com.skyjoo.neweast.biz.portal.domain.common;

import java.util.Date;
import java.util.List;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.portal.domain.enums.EnumPublicHelpStatusType;

/**
 *帮助中心类目类
 *@author liupc
 *@version 1.0
 *@date 2014-11-4 上午10:17:46
 */
public class PublicHelpCategory extends Pagination<PublicHelpCategory> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -2202456088310452221L;
	/* 主键 */
	private Long id;
	/* 上一级类目id */
	private Long parentId;
	/* 上一级类目名称  */
	private String parentName;
	/* 本级类目名称  */
	private String name;
	/* 描述  */
	private String description;
	/* 排序  */
	private Long ordering;
	/* 类目级别  */
	private Integer catLevel;
	/* 是否删除  */
	private Integer isDeleted;
	/* 操作员  */
	private String operator;
	/* 创建时间  */
	private Date gmtCreate;
	/* 修改时间  */
	private Date gmtModify;
	
	/* 子类目列表 */
	private List<PublicHelpCategory> categorys;
	
	public void setCategorys(List<PublicHelpCategory> categorys){
		this.categorys = categorys;
	}
	
	public List<PublicHelpCategory> getCategorys(){
		return categorys;
	}
	
	/* 能否删除 */
	private boolean canDeleted;
	
	public boolean getCanDeleted(){
		return canDeleted;
	}
	
	public void setCanDeleted(boolean canDeleted){
		this.canDeleted = canDeleted;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getParentId() {
		return parentId;
	}
	public void setParentId(Long parentId) {
		this.parentId = parentId;
	}
	public String getParentName() {
		return parentName;
	}
	public void setParentName(String parentName) {
		this.parentName = parentName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Long getOrdering() {
		return ordering;
	}
	public void setOrdering(Long ordering) {
		this.ordering = ordering;
	}
	public Integer getCatLevel() {
		return catLevel;
	}
	public void setCatLevel(Integer catLevel) {
		this.catLevel = catLevel;
	}
	public Integer getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Integer isDeleted) {
		this.isDeleted = isDeleted;
	}
	public void setIsDeleted(EnumPublicHelpStatusType isDeleted) {
		this.isDeleted = isDeleted.getValue();
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
	public void setGmtCreate(Date gmtCreate){
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModify() {
		return gmtModify;
	}
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
}
