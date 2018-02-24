package com.skyjoo.neweast.biz.point.domain.query;

import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.neweast.biz.point.domain.UserPoint;

public class UserPointQuery extends Pagination<UserPoint> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 6789395045415064959L;
	private String tradeAccount;

	public String getTradeAccount() {
		return tradeAccount;
	}

	public void setTradeAccount(String tradeAccount) {
		this.tradeAccount = tradeAccount;
	}

}
