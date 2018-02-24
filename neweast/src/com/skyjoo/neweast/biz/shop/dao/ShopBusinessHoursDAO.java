package com.skyjoo.neweast.biz.shop.dao;

import java.util.List;

import com.skyjoo.neweast.biz.shop.domain.ShopBusinessHours;

/**
 * 店铺营业时间
 * @author lxh
 * @version 2015年4月14日 下午1:22:26
 */
public interface ShopBusinessHoursDAO {
	
	/**
	 * 根据会员ID获取店铺营业时间
	 * @param accountId
	 * @return
	 */
	public List<ShopBusinessHours> selectShopBusinessHoursByShopId(Long shopId);
	
	   
    /**
     * 删除
     * @param shopId
     * @return
     */
    public int deleteShopBusinessHoursByShopId(Long shopId);
}
