package com.skyjoo.neweast.biz.shop.dao;

import com.skyjoo.neweast.biz.shop.domain.ShopTemplate;

/**
 * ����ģ��
 * @author LZW
 */
public interface ShopTemplateDAO {
	
	/** ��ҳ  */
	public void getShopTemplatePage(ShopTemplate template);

	/** ���� **/
	public ShopTemplate getShopTemplateByID(Long id);

	/** ��ȡ��������� */
	public Integer getCountByTitle(String title);

	/** ����ģ�� **/
	public Long addShopTemplate(ShopTemplate template);

	/** ɾ��ģ�� **/
	public Integer remove(Long id);
	
}
