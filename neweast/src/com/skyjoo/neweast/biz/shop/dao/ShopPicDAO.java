package com.skyjoo.neweast.biz.shop.dao;

import com.skyjoo.neweast.biz.shop.domain.ShopPic;
import com.skyjoo.neweast.biz.shop.domain.query.ShopPicQuery;

/**
 * µÍ∆ÃÕº∆¨
 * @author LZW
 */
public interface ShopPicDAO {
	
	/** ∑÷“≥ªÒ»°µÍ∆ÃÕº∆¨ */
	public void getShopPicPage(ShopPicQuery query);
	/** …Û∫À  **/
	public Integer audit(ShopPic sp);

	
}
