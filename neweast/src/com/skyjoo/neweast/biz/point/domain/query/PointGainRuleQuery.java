package com.skyjoo.neweast.biz.point.domain.query;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.point.domain.PointGainRule;

/*
 * ���ֻ�ȡ�����ѯ����
 */
public class PointGainRuleQuery extends Pagination<PointGainRule> {
	/**
	 * 
	 */
	private static final long serialVersionUID = -5213974677394400257L;
	private String eventType="";// �¼�����

	public String getEventType() {
		return eventType;
	}

	public void setEventType(String eventType) {
		this.eventType = eventType;
	}
}
