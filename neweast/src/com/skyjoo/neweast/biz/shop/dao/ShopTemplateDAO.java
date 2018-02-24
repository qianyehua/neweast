package com.skyjoo.neweast.biz.shop.dao;

import com.skyjoo.neweast.biz.shop.domain.ShopTemplate;

/**
 * 店铺模版
 * @author LZW
 */
public interface ShopTemplateDAO {
	
	/** 分页  */
	public void getShopTemplatePage(ShopTemplate template);

	/** 详情 **/
	public ShopTemplate getShopTemplateByID(Long id);

	/** 获取标题存在数 */
	public Integer getCountByTitle(String title);

	/** 新增模版 **/
	public Long addShopTemplate(ShopTemplate template);

	/** 删除模版 **/
	public Integer remove(Long id);
	
}
