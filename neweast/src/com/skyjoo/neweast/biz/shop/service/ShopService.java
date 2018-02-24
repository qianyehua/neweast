package com.skyjoo.neweast.biz.shop.service;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.common.CommResult;
import com.skyjoo.neweast.biz.shop.domain.Shop;
import com.skyjoo.neweast.biz.shop.domain.query.ShopQuery;

/**
 * 店铺
 * @author lxh
 *
 */
public interface ShopService {
	
	/**
	 * 分页获取店铺
	 * @param query
	 */
	public void getShopPage(ShopQuery query);
	
	/**
	 * 根据ID获取店铺
	 * @return
	 */
	public Shop getShopById(Long id);

	/**
	 * 修改开关
	 * @param shop
	 */
	public CommResult changeSwtich(Shop shop);

	/**
	 * 关闭店铺
	 * @param shop
	 * @return
	 */
	public CommResult closeShop(Shop shop);

	/**
	 * 恢复成功
	 * @param shop
	 * @return
	 */
	public CommResult resumeShop(Shop shop);
	
    /**
     * 根据会员ID获取店铺
     * @param id
     * @return
     */
    public Shop getShopByAccountId(Long accountId);
    
    /**
     * 创建或修改店铺
     * @param shop
     * @return
     */
    public Result<Shop> createOrUpdateShop(Shop shop);
}
