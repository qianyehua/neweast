package com.skyjoo.neweast.biz.trade.dao;

import java.util.List;

import com.skyjoo.neweast.biz.trade.domain.SalesVolume;

/**
 * 销量DAO
 * @author lxh
 * @version 2015年5月27日 下午1:57:14
 */
public interface SalesVolumeDAO {
	
	/**
	 * 获取所有销量记录
	 * @return
	 */
	public List<SalesVolume> groupSalesVolumeByShopAndCategory(String startDate, String endDate);

	/**
	 * 复制多余数据
	 * @param entDate
	 */
	public void dealMoveToHis(String beforeStartDate);
	/**
	 * 删除遗留数据
	 * @param startDate
	 */
	public void deleteAfterMove(String beforeStartDate);
}
