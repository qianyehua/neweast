/**
*@title
*@author liupc
*@version 1.0
*/
package com.skyjoo.neweast.biz.portal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.portal.dao.PublicHelpCategoryDAO;
import com.skyjoo.neweast.biz.portal.dao.PublicHelpPropertyDAO;
import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpProperty;
import com.skyjoo.neweast.biz.portal.service.PublicHelpPropertyService;

/**
 *@Description 
 *@author liupc
 *@version 1.0
 *@date 2014-11-5 ÉÏÎç10:25:31
 */
@Service
public class PublicHelpPropertyServiceImpl extends BaseManager implements
		PublicHelpPropertyService {

	@Autowired
	PublicHelpPropertyDAO publicHelpPropertyDao;

	@Autowired
	PublicHelpCategoryDAO publicHelpCategoryDao;
	
	@Override
	public Long addPublicHelpProperty(PublicHelpProperty publicHelpProperty) {
		return publicHelpPropertyDao.addPublicHelpProperty(publicHelpProperty);
	}

	@Override
	public PublicHelpProperty getPublicHelpProperty(Long publicHelpPropertyId) {
		return publicHelpPropertyDao.getPublicHelpProperty(publicHelpPropertyId);
	}

	@Override
	public Paginable<PublicHelpProperty> getPaginatedPublicHelpProperty(
			Paginable<PublicHelpProperty> page) {
		return publicHelpPropertyDao.getPaginatedPublicHelpProperty(page);
	}

	@Override
	public Integer updateStatus(PublicHelpProperty publicHelpProperty) {
		return publicHelpPropertyDao.updateStatus(publicHelpProperty);
	}

	@Override
	public Integer updatePublicHelpProperty(PublicHelpProperty publicHelpProperty) {
		return publicHelpPropertyDao.updatePublicHelpProperty(publicHelpProperty);
	}
}
