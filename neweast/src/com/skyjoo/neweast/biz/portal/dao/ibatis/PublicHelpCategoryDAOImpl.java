/**
*@title
*@author liupc
*@version 1.0
*/
package com.skyjoo.neweast.biz.portal.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.portal.dao.PublicHelpCategoryDAO;
import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpCategory;

/**
 *∞Ô÷˙¿‡ƒøibatis
 *@author liupc
 *@version 1.0
 *@date 2014-11-4 …œŒÁ10:47:55
 */
@Repository
public class PublicHelpCategoryDAOImpl extends BaseDaoiBatis implements PublicHelpCategoryDAO {
	@SuppressWarnings("deprecation")
	@Override
	public PublicHelpCategory getPublicHelpCategoryById(Long id) {
		return (PublicHelpCategory)this.getSqlMapClientTemplate().
			queryForObject("PublicHelpCategory.getPublicHelpCategoryById", id);
	}

	@SuppressWarnings({ "unchecked", "deprecation" })
	@Override
	public List<PublicHelpCategory> getPublicHelpCategoryByPid(Long pid) {
		return this.getSqlMapClientTemplate().
			queryForList("PublicHelpCategory.getPublicHelpCategorysByPid", pid);
	}


	@SuppressWarnings("deprecation")
	@Override
	public Long addPublicHelpCategory(PublicHelpCategory publicHelpCategory) {
		return (Long)this.getSqlMapClientTemplate().
				insert("PublicHelpCategory.insertPublicHelpCategory", 
						publicHelpCategory);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Integer editPublicHelpCategory(PublicHelpCategory publicHelpCategory) {
		return (Integer)this.getSqlMapClientTemplate().
				update("PublicHelpCategory.updatePublicHelpCategory", 
						publicHelpCategory);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Integer removePublicHelpCategory(
			PublicHelpCategory publicHelpCategory) {
		return this.getSqlMapClientTemplate().
				delete("PublicHelpCategory.deletePublicHelpCategory",
						publicHelpCategory);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Integer getCategoriesById(Long catId) {
		return (Integer)this.getSqlMapClientTemplate().
			queryForObject("PublicHelpCategory.getCategoriesById", catId);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Integer getLevelById(Long catId) {
		Integer i = (Integer) this.getSqlMapClientTemplate().
				queryForObject("PublicHelpCategory.getLevelById", catId);
		if(i==null){
			i=0;
		}
		return i;
	}

	@SuppressWarnings("deprecation")
	@Override
	public Integer getCategeoryByName(PublicHelpCategory publicHelpCategory) {
		Integer i = (Integer)this.getSqlMapClientTemplate().
				queryForObject("PublicHelpCategory.getCategeoryByName",
						publicHelpCategory);
		return i;
	}
}
