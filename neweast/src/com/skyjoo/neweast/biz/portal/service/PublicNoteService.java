package com.skyjoo.neweast.biz.portal.service;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.portal.domain.common.PublicNote;

/**
 * ��̨�������
 * @author liupc
 * @version 1.0 
 * @date 2014-10-31 09:41:07
 */
public interface PublicNoteService {

	/**
	 * ���һ��PublicNote��¼
	 * @param publicNote
	 * @return
	 */
	public Long addPublicNote(PublicNote publicNote);
	
	/**
	 * ��ѯһ��PublicNote�����
	 * @param publicNoteId
	 * @return PublicNote����
	 */
 	public PublicNote getPublicNote(Long publicNoteId);

 	/**
 	 * ��ҳ��ѯ����PublicNote�����
 	 * @param page
 	 * @return ��ҳ����ļ��� 
 	 */
    public Paginable<PublicNote> getPaginatedNote(Paginable<PublicNote> page);

    /**
     * ��˹���
     * @param publicNote
     * @return
     */
 	public Integer verifyPublicNote(PublicNote publicNote);
 	
 	/**
 	 * ɾ������
 	 * @param publicNote
 	 * @return
 	 */
 	public Integer removePublicNote(PublicNote publicNote);
}
