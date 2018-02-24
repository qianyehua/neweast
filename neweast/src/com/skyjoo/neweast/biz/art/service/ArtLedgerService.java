/**
*@title 分账设置
*@author paul
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.service;

import com.skyjoo.neweast.biz.art.domain.ArtLedger;



public interface ArtLedgerService {

	/**
	 * 插入分账设置
	 * @param artLedger
	 * @return
	 */
	public Long insertArtLedger(ArtLedger artLedger);
	
	
	/**
	 * 更新分账设置
	 * @param artLedger
	 */
	public void updateArtLedger(ArtLedger artLedger);
	
	/**
	 * 获取分账信息
	 * @param artLedgerId
	 * @return
	 */
	public ArtLedger getArtLedgerById(Long artLedgerId);

	
}
