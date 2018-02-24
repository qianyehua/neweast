package com.skyjoo.neweast.biz.shop.service;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.common.CommResult;
import com.skyjoo.neweast.biz.shop.domain.ShopAuthApply;
import com.skyjoo.neweast.biz.shop.domain.query.ShopAuthApplyQuery;

/**
 * 开店认证
 * @author lxh
 *
 */
public interface ShopAuthApplyService {
	
	/**
	 * 分页获取
	 * @param query
	 */
	public void getShopAuthApplyPage(ShopAuthApplyQuery query);
	
	/**
	 * 根据ID获取开店认证信息
	 * @return
	 */
	public ShopAuthApply getShopAuthApplyById(Long id);

	/**
	 * 审核
	 * @param apply
	 * @param success 
	 * @param operator 
	 * @return
	 */
	public CommResult auditShopAuthApply(ShopAuthApply apply, boolean success, String operator);
	
	/**
     * 开店认证申请
     * @param apply
     */
    public Result<ShopAuthApply> createShopAuthApply(ShopAuthApply apply);
}
