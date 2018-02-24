/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.domain;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;

/**
 * 首页推荐艺术品类
 * @date 2014-11-12 10:47:14
 */
public class HomepageRecommend extends Pagination<HomepageRecommend> {

	private static final long serialVersionUID = 7283051431686524189L;
	
	public static final int STATUS_NORMAL = 0;
	public static final int STATUS_DELETE = 1;
	
	//pk,seq
	private Long id;
	//艺术品ID
	private Long artId;
	//状态：0-正常，1-已删除
	private Integer status;
	//操作员
	private String operator;
	//创建时间
	private Date gmtCreate;
	//最后修改时间
	private Date gmtModify;
	//一级类目ID
	private Long artCategoryId;

	/**设置pk,seq*/
	public void setId(Long id) {
		this.id = id;
	}
	/**获取pk,seq*/
	public Long getId() {
		return this.id;
	}
	
	/**设置艺术品ID*/
	public void setArtId(Long artId) {
		this.artId = artId;
	}
	/**获取艺术品ID*/
	public Long getArtId() {
		return this.artId;
	}
	
	/**设置状态：0-正常，1-已删除*/
	public void setStatus(Integer status) {
		this.status = status;
	}
	/**获取状态：0-正常，1-已删除*/
	public Integer getStatus() {
		return this.status;
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
	
	/**设置一级类目ID*/
	public void setArtCategoryId(Long artCategoryId) {
		this.artCategoryId = artCategoryId;
	}
	/**获取一级类目ID*/
	public Long getArtCategoryId() {
		return this.artCategoryId;
	}
	
	public boolean isNormal() {
		return this.status.intValue() == STATUS_NORMAL;
	}
}
