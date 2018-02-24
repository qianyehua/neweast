package com.skyjoo.neweast.biz.shop.dao;

import com.skyjoo.neweast.biz.shop.domain.ShopAuthApplyOrg;

/**
 * 开店认证企业附加信息
 * @author lxh
 * @version 2015年4月14日 上午11:22:09
 */
public interface ShopAuthApplyOrgDAO {

	/**
	 * 根据开店认证申请ID获取附加记录
	 * @param applyId
	 * @return
	 */
	public ShopAuthApplyOrg selectShopAuthApplyOrgByApplyId(Long applyId);

}
