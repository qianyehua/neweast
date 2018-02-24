package com.skyjoo.neweast.biz.portal.domain.common;

import java.util.Date;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.portal.domain.enums.EnumPublicNoteStatus;
import com.skyjoo.neweast.biz.portal.domain.enums.EnumPublicNoteType;

/**
 * ������
 * @author liupc
 * @version 1.0 
 * @date 2014-10-31 09:48:20
 */
public class PublicNote extends Pagination<PublicNote> {

	private static final long serialVersionUID = -5011922979082560125L;
	/* @property:PK */
	private Long id;
	/* @property:����ʱ�� */
	private Date gmtCreate;
	/* @property:����޸�ʱ�� */
	private Date gmtModified;
	/* @property:���� */
	private String title;
	/* @property:����������� */
	private String content;
	/* @property:�������ͣ�ȡ���ֵ�� */
	private Integer type;
	/* @property:״̬ 2��δͨ�� 0������� 1��ͨ��  3:��ɾ��*/
	private Integer status;
	/* @property:����Ա */
	private String operator;
	/* @property:����ʱ��*/
	private Date noticeTime;
	/* @property:��ע */
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

	/* @model:����PK */
	public void setId(Long obj) {
		this.id = obj;
	}

	/* @model:��ȡPK */
	public Long getId() {
		return this.id;
	}

	/* @model:���ô���ʱ�� */
	public void setGmtCreate(Date obj) {
		this.gmtCreate = obj;
	}

	/* @model:��ȡ����ʱ�� */
	public Date getGmtCreate() {
		return this.gmtCreate;
	}

	/* @model:��������޸�ʱ�� */
	public void setGmtModified(Date obj) {
		this.gmtModified = obj;
	}

	/* @model:��ȡ����޸�ʱ�� */
	public Date getGmtModified() {
		return this.gmtModified;
	}

	/* @model:���ñ��� */
	public void setTitle(String obj) {
		this.title = obj;
	}

	/* @model:��ȡ���� */
	public String getTitle() {
		return this.title;
	}

	/* @model:���ù���������� */
	public void setContent(String obj) {
		this.content = obj;
	}

	/* @model:��ȡ����������� */
	public String getContent() {
		return this.content;
	}

	/* @model:���ù������ͣ�ȡ���ֵ�� */
	public void setType(Integer obj) {
		this.type = obj;
	}

	public void setType(EnumPublicNoteType type) {
	    this.type = type.getValue();
	}

	/* @model:��ȡ�������ͣ�ȡ���ֵ�� */
	public Integer getType() {
		return this.type;
	}

	/* @model:����״̬ 2��δͨ�� 0������� 1��ͨ�� 3:��ɾ��*/
	public void setStatus(Integer obj) {
		this.status = obj;
	}

	public void setStatus(EnumPublicNoteStatus status) {
	    this.status = status.getValue();
	}

	/* @model:��ȡ״̬2��δͨ�� 0������� 1��ͨ�� 3:��ɾ��*/
	public Integer getStatus() {
		return this.status;
	}

	/* @model:���ò���Ա */
	public void setOperator(String obj) {
		this.operator = obj;
	}

	/* @model:��ȡ����Ա */
	public String getOperator() {
		return this.operator;
	}
}
