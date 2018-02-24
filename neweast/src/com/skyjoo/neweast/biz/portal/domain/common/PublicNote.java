package com.skyjoo.neweast.biz.portal.domain.common;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.portal.domain.enums.EnumPublicNoteStatus;
import com.skyjoo.neweast.biz.portal.domain.enums.EnumPublicNoteType;

/**
 * 公告类
 * @author liupc
 * @version 1.0 
 * @date 2014-10-31 09:48:20
 */
public class PublicNote extends Pagination<PublicNote> {

	private static final long serialVersionUID = -5011922979082560125L;
	/* @property:PK */
	private Long id;
	/* @property:创建时间 */
	private Date gmtCreate;
	/* @property:最后修改时间 */
	private Date gmtModified;
	/* @property:标题 */
	private String title;
	/* @property:公告具体内容 */
	private String content;
	/* @property:公告类型，取自字典表 */
	private Integer type;
	/* @property:状态 2：未通过 0：待审核 1：通过  3:已删除*/
	private Integer status;
	/* @property:操作员 */
	private String operator;
	/* @property:发布时间*/
	private Date noticeTime;
	/* @property:备注 */
	private String memo;
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public Date getNoticeTime() {
		return noticeTime;
	}

	public void setNoticeTime(Date noticeTime) {
		this.noticeTime = noticeTime;
	}
    private String startDate;
	public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    private String endDate;

	/* Default constructor - creates a new instance with no values set. */
	public PublicNote() {
	}

	/* @model:设置PK */
	public void setId(Long obj) {
		this.id = obj;
	}

	/* @model:获取PK */
	public Long getId() {
		return this.id;
	}

	/* @model:设置创建时间 */
	public void setGmtCreate(Date obj) {
		this.gmtCreate = obj;
	}

	/* @model:获取创建时间 */
	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	/* @model:设置最后修改时间 */
	public void setGmtModified(Date obj) {
		this.gmtModified = obj;
	}

	/* @model:获取最后修改时间 */
	public Date getGmtModified() {
		return this.gmtModified;
	}

	/* @model:设置标题 */
	public void setTitle(String obj) {
		this.title = obj;
	}

	/* @model:获取标题 */
	public String getTitle() {
		return this.title;
	}

	/* @model:设置公告具体内容 */
	public void setContent(String obj) {
		this.content = obj;
	}

	/* @model:获取公告具体内容 */
	public String getContent() {
		return this.content;
	}

	/* @model:设置公告类型，取自字典表 */
	public void setType(Integer obj) {
		this.type = obj;
	}

	public void setType(EnumPublicNoteType type) {
	    this.type = type.getValue();
	}

	/* @model:获取公告类型，取自字典表 */
	public Integer getType() {
		return this.type;
	}

	/* @model:设置状态 2：未通过 0：待审核 1：通过 3:已删除*/
	public void setStatus(Integer obj) {
		this.status = obj;
	}

	public void setStatus(EnumPublicNoteStatus status) {
	    this.status = status.getValue();
	}

	/* @model:获取状态2：未通过 0：待审核 1：通过 3:已删除*/
	public Integer getStatus() {
		return this.status;
	}

	/* @model:设置操作员 */
	public void setOperator(String obj) {
		this.operator = obj;
	}

	/* @model:获取操作员 */
	public String getOperator() {
		return this.operator;
	}
}
