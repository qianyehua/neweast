package com.skyjoo.neweast.biz.shop.service;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.common.CommResult;
import com.skyjoo.neweast.biz.shop.domain.Shop;
import com.skyjoo.neweast.biz.shop.domain.query.ShopQuery;

/**
 * ����
 * @author lxh
 *
 */
public interface ShopService {
	
	/**
	 * ��ҳ��ȡ����
	 * @param query
	 */
	public void getShopPage(ShopQuery query);
	
	/**
	 * ����ID��ȡ����
	 * @return
	 */
	public Shop getShopById(Long id);

	/**
	 * �޸Ŀ���
	 * @param shop
	 */
	public CommResult changeSwtich(Shop shop);

	/**
	 * �رյ���
	 * @param shop
	 * @return
	 */
	public CommResult closeShop(Shop shop);

	/**
	 * �ָ��ɹ�
	 * @param shop
	 * @return
	 */
	public CommResult resumeShop(Shop shop);
	
    /**
     * ���ݻ�ԱID��ȡ����
     * @param id
     * @return
     */
    public Shop getShopByAccountId(Long accountId);
    
    /**
     * �������޸ĵ���
     * @param shop
     * @return
     */
    public Result<Shop> createOrUpdateShop(Shop shop);
}
