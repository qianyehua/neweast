/**
*@title ��������
*@author paul
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.service;

import com.skyjoo.neweast.biz.art.domain.ArtLedger;



public interface ArtLedgerService {

	/**
	 * �����������
	 * @param artLedger
	 * @return
	 */
	public Long insertArtLedger(ArtLedger artLedger);
	
	
	/**
	 * ���·�������
	 * @param artLedger
	 */
	public void updateArtLedger(ArtLedger artLedger);
	
	/**
	 * ��ȡ������Ϣ
	 * @param artLedgerId
	 * @return
	 */
	public ArtLedger getArtLedgerById(Long artLedgerId);

	
}
