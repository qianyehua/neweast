/**
 * 
 */
package com.skyjoo.neweast.biz.portal.dao.ibatis;


import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.portal.dao.PublicNoteDAO;
import com.skyjoo.neweast.biz.portal.domain.common.PublicNote;

/**
 * PublicNoteDAO µœ÷¿‡
 * @author admin
 * @version 1.0
 * @date 2014-11-4 18:01:14
 */
@Repository
public class PublicNoteDAOImpl extends BaseDaoiBatis implements PublicNoteDAO {
	
	@SuppressWarnings("deprecation")
	@Override
	public Long addPublicNote(PublicNote publicNote) {
		return (Long)this.getSqlMapClientTemplate().
				insert("publicNote.addPublicNote", publicNote);
	}

	
	@SuppressWarnings("deprecation")
	@Override
	public PublicNote getPublicNote(Long publicNoteId) {
		return (PublicNote)this.getSqlMapClientTemplate().
				queryForObject("publicNote.getPublicNote", publicNoteId);
	}

	@Override
	public Paginable<PublicNote> getPaginatedCommonPublicNote(
			Paginable<PublicNote> page) {
	        
		super.paginate(page, "publicNote.getPublicNoteCount",
				"publicNote.getPaginatedPublicNote");
		return page;

	}

	
	@SuppressWarnings("deprecation")
	@Override
	public Integer verifyPublicNote(PublicNote publicNote) {
		return this.getSqlMapClientTemplate().
				update("publicNote.verifyPublicNote",publicNote);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Integer removePublicNote(PublicNote publicNote) {
		return this.getSqlMapClientTemplate().
				update("publicNote.removePublicNote",publicNote);
	}
	
}
