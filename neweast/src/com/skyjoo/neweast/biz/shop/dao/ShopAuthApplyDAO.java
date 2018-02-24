package com.skyjoo.neweast.biz.shop.dao;

import com.skyjoo.neweast.biz.shop.domain.ShopAuthApply;
import com.skyjoo.neweast.biz.shop.domain.query.ShopAuthApplyQuery;

/**
 * ������֤
 * @author lxh
 *
 */
public interface ShopAuthApplyDAO {
	
	/**
	 * ��ҳ��ȡ
	 * @param query
	 */
	public void getShopAuthApplyPage(ShopAuthApplyQuery query);
	
	/**
	 * ����ID��ȡ
	 * @param id
	 */
	public ShopAuthApply selectShopAuthApplyById(Long id);
	
	/**
	 * �޸�
	 * @param apply
	 * @return
	 */
	public int updateShopAuthApply(ShopAuthApply apply);
	
	   /**
     * ���ݵ�¼ID��ȡ
     * @param loginId
     * @return
     */
    public ShopAuthApply selectShopAuthApplyByLoginId(String loginId);
    

    /**
     * �����¼
     * @param apply
     * @return
     */
    public Long insertShopAuthApply(ShopAuthApply apply);
    
    
}
