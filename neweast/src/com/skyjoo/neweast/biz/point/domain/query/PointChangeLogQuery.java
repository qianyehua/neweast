package com.skyjoo.neweast.biz.point.domain.query;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.point.domain.PointChangeLog;

public class PointChangeLogQuery extends Pagination<PointChangeLog> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 857704148446637362L;

	private String tradeAccount;
	private String startTime;
	private String endTime;

	public String getTradeAccount() {
		return tradeAccount;
	}

	public void setTradeAccount(String tradeAccount) {
		this.tradeAccount = tradeAccount;
	}

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	 
}
