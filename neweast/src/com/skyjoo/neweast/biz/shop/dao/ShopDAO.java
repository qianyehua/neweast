package com.skyjoo.neweast.biz.shop.dao;

import java.util.List;

import com.skyjoo.neweast.biz.shop.domain.Shop;
import com.skyjoo.neweast.biz.shop.domain.query.ShopQuery;

/**
 * 店铺
 * @author lxh
 *
 */
public interface ShopDAO {
	
	/**
	 * 分页获取店铺
	 * @param query
	 */
	public void getShopPage(ShopQuery query);
	
	/**
	 * 根据ID获取店铺
	 * @param id
	 * @return
	 */
	public Shop selectShopById(Long id);
	
	/**
	 * 根据用户ID获取店铺
	 * @param accountId
	 * @return
	 */
	public Shop selectShopByAccountId(Long accountId);
	
	/**
	 * 修改店铺
	 * @param shop
	 * @return
	 */
	public int updateShop(Shop shop);

	
	/**
	 * 批量更新店铺
	 * @param shopList
	 * @return
	 */
	public int batchUpdateShop(List<Shop> shopList);
	
	   /**
     * 插入店铺
     * @param shop
     * @return
     */
    public Long insertShop(Shop shop);
	
}
