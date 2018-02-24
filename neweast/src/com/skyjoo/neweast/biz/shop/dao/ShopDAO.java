package com.skyjoo.neweast.biz.shop.dao;

import java.util.List;

import com.skyjoo.neweast.biz.shop.domain.Shop;
import com.skyjoo.neweast.biz.shop.domain.query.ShopQuery;

/**
 * ����
 * @author lxh
 *
 */
public interface ShopDAO {
	
	/**
	 * ��ҳ��ȡ����
	 * @param query
	 */
	public void getShopPage(ShopQuery query);
	
	/**
	 * ����ID��ȡ����
	 * @param id
	 * @return
	 */
	public Shop selectShopById(Long id);
	
	/**
	 * �����û�ID��ȡ����
	 * @param accountId
	 * @return
	 */
	public Shop selectShopByAccountId(Long accountId);
	
	/**
	 * �޸ĵ���
	 * @param shop
	 * @return
	 */
	public int updateShop(Shop shop);

	
	/**
	 * �������µ���
	 * @param shopList
	 * @return
	 */
	public int batchUpdateShop(List<Shop> shopList);
	
	   /**
     * �������
     * @param shop
     * @return
     */
    public Long insertShop(Shop shop);
	
}
