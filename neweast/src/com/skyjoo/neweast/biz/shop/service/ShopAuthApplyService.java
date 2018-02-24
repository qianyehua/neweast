package com.skyjoo.neweast.biz.shop.service;

import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.common.CommResult;
import com.skyjoo.neweast.biz.shop.domain.ShopAuthApply;
import com.skyjoo.neweast.biz.shop.domain.query.ShopAuthApplyQuery;

/**
 * ������֤
 * @author lxh
 *
 */
public interface ShopAuthApplyService {
	
	/**
	 * ��ҳ��ȡ
	 * @param query
	 */
	public void getShopAuthApplyPage(ShopAuthApplyQuery query);
	
	/**
	 * ����ID��ȡ������֤��Ϣ
	 * @return
	 */
	public ShopAuthApply getShopAuthApplyById(Long id);

	/**
	 * ���
	 * @param apply
	 * @param success 
	 * @param operator 
	 * @return
	 */
	public CommResult auditShopAuthApply(ShopAuthApply apply, boolean success, String operator);
	
	/**
     * ������֤����
     * @param apply
     */
    public Result<ShopAuthApply> createShopAuthApply(ShopAuthApply apply);
}
