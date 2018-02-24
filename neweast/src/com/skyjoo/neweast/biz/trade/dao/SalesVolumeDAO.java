package com.skyjoo.neweast.biz.trade.dao;

import java.util.List;

import com.skyjoo.neweast.biz.trade.domain.SalesVolume;

/**
 * ����DAO
 * @author lxh
 * @version 2015��5��27�� ����1:57:14
 */
public interface SalesVolumeDAO {
	
	/**
	 * ��ȡ����������¼
	 * @return
	 */
	public List<SalesVolume> groupSalesVolumeByShopAndCategory(String startDate, String endDate);

	/**
	 * ���ƶ�������
	 * @param entDate
	 */
	public void dealMoveToHis(String beforeStartDate);
	/**
	 * ɾ����������
	 * @param startDate
	 */
	public void deleteAfterMove(String beforeStartDate);
}
