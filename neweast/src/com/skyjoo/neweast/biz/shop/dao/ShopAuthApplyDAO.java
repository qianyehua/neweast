package com.skyjoo.neweast.biz.shop.dao;

import com.skyjoo.neweast.biz.shop.domain.ShopAuthApply;
import com.skyjoo.neweast.biz.shop.domain.query.ShopAuthApplyQuery;

/**
 * 开店认证
 * @author lxh
 *
 */
public interface ShopAuthApplyDAO {
	
	/**
	 * 分页获取
	 * @param query
	 */
	public void getShopAuthApplyPage(ShopAuthApplyQuery query);
	
	/**
	 * 根据ID获取
	 * @param id
	 */
	public ShopAuthApply selectShopAuthApplyById(Long id);
	
	/**
	 * 修改
	 * @param apply
	 * @return
	 */
	public int updateShopAuthApply(ShopAuthApply apply);
	
	   /**
     * 根据登录ID获取
     * @param loginId
     * @return
     */
    public ShopAuthApply selectShopAuthApplyByLoginId(String loginId);
    

    /**
     * 插入记录
     * @param apply
     * @return
     */
    public Long insertShopAuthApply(ShopAuthApply apply);
    
    
}
