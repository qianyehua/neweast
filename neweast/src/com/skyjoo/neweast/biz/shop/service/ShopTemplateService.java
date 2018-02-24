package com.skyjoo.neweast.biz.shop.service;

import com.skyjoo.neweast.biz.shop.domain.ShopTemplate;

/**
 * ����ģ��
 * @author LZW
 */
public interface ShopTemplateService {
	
	/** ��ҳ  */
	public void getShopTemplatePage(ShopTemplate template);

	/** ���� **/
	public ShopTemplate getShopTemplateByID(Long id);

	/** �����ظ� **/
	public boolean hasTitle(String title);
	
	/** ����ģ�� **/
	public Long addShopTemplate(ShopTemplate template);

	/** ɾ��ģ�� **/
	public Integer remove(Long id);
	
}
