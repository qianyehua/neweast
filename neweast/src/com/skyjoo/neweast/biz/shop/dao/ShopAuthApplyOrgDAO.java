package com.skyjoo.neweast.biz.shop.dao;

import com.skyjoo.neweast.biz.shop.domain.ShopAuthApplyOrg;

/**
 * ������֤��ҵ������Ϣ
 * @author lxh
 * @version 2015��4��14�� ����11:22:09
 */
public interface ShopAuthApplyOrgDAO {

	/**
	 * ���ݿ�����֤����ID��ȡ���Ӽ�¼
	 * @param applyId
	 * @return
	 */
	public ShopAuthApplyOrg selectShopAuthApplyOrgByApplyId(Long applyId);

}
