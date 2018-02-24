/**
 * 
 */
package com.skyjoo.neweast.biz.portal.dao;


import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.portal.domain.common.PublicNote;


/**
 * �����dao
 * @author liupc
 * @version 1.0
 * @date 2014-11-4 18:02:57
 */
public interface PublicNoteDAO {

	
	/**
	 * ���һ��PublicNote��¼ 
	 * @param PublicNote
	 * @return
	 */
 	Long addPublicNote(PublicNote publicNote);
 	
 	/**
 	 * ��ѯһ��PublicNote�����
 	 * @param PublicNoteId
 	 * @return ����PublicNote����
 	 */
 	PublicNote getPublicNote(Long publicNoteId);
 	
 	/**
 	 * ��ҳ��ѯ
 	 * @param page
 	 * @return ���ط�ҳ����
 	 */
    public Paginable<PublicNote> getPaginatedCommonPublicNote(Paginable<PublicNote> page);

    /**
     * ��˹���
     * @param PublicNote
     * @return
     */
    Integer verifyPublicNote(PublicNote publicNote);
    
    /**
     * ɾ������
     * @param publicNote
     * @return
     */
    Integer removePublicNote(PublicNote publicNote);
}
