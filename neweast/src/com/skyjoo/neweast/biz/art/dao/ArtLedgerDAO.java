/**
*@title
*@author paul
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.dao;

import com.skyjoo.neweast.biz.art.domain.ArtLedger;


/**
 * @author JIANGFENGXU
 *
 */
public interface ArtLedgerDAO {

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
