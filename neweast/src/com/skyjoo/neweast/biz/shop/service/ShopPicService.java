package com.skyjoo.neweast.biz.shop.service;

import com.skyjoo.neweast.biz.shop.domain.ShopPic;
import com.skyjoo.neweast.biz.shop.domain.query.ShopPicQuery;

/**
 * ����ͼƬ
 * @author LZW
 */
public interface ShopPicService {
	
	/**��ҳ��ȡ����ͼƬ*/
	public void getShopPicPage(ShopPicQuery query);
	/** ���   **/
	public Integer audit(ShopPic sp);

}
