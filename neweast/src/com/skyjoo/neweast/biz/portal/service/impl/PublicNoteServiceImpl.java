/**
 * 
 */
package com.skyjoo.neweast.biz.portal.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.portal.dao.PublicNoteDAO;
import com.skyjoo.neweast.biz.portal.domain.common.PublicNote;
import com.skyjoo.neweast.biz.portal.service.PublicNoteService;

/**
 * PublicNoteService µœ÷¿‡
 * @author liupc
 * @Date 2014-11-4 17:57:43
 * @version 1.0
 */
@Service
public class PublicNoteServiceImpl extends BaseManager implements PublicNoteService {

	
	@Autowired
	PublicNoteDAO publicNoteDao;
	
	
	@Override
	public Long addPublicNote(PublicNote publicNote) {
		return publicNoteDao.addPublicNote(publicNote);
	}

	@Override
	public PublicNote getPublicNote(Long publicNoteId) {
		return publicNoteDao.getPublicNote(publicNoteId);
	}

	@Override
	public Paginable<PublicNote> getPaginatedNote(
			Paginable<PublicNote> page) {
	    return publicNoteDao.getPaginatedCommonPublicNote(page);
	}
	
	@Override
	public Integer verifyPublicNote(PublicNote publicNote) {
		return publicNoteDao.verifyPublicNote(publicNote);
	}
	
	@Override
	public Integer removePublicNote(PublicNote publicNote) {
		return publicNoteDao.removePublicNote(publicNote);
	}
}
