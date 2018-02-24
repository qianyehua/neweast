package com.skyjoo.neweast.biz.shop.dao;

import java.util.List;

import com.skyjoo.neweast.biz.shop.domain.ShopBusinessHours;

/**
 * ����Ӫҵʱ��
 * @author lxh
 * @version 2015��4��14�� ����1:22:26
 */
public interface ShopBusinessHoursDAO {
	
	/**
	 * ���ݻ�ԱID��ȡ����Ӫҵʱ��
	 * @param accountId
	 * @return
	 */
	public List<ShopBusinessHours> selectShopBusinessHoursByShopId(Long shopId);
	
	   
    /**
     * ɾ��
     * @param shopId
     * @return
     */
    public int deleteShopBusinessHoursByShopId(Long shopId);
}
