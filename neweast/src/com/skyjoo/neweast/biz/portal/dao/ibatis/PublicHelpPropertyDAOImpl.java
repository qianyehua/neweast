/**
*@title
*@author liupc
*@version 1.0
*/
package com.skyjoo.neweast.biz.portal.dao.ibatis;


import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.portal.dao.PublicHelpPropertyDAO;
import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpProperty;

/**
 *PublicHelpPropertyDAO实现类 
 *@author liupc
 *@version 1.0
 *@date 2014-11-5 上午9:15:15
 */
@Repository
public class PublicHelpPropertyDAOImpl extends BaseDaoiBatis implements
		PublicHelpPropertyDAO {

	@SuppressWarnings("deprecation")
	@Override
	public Long addPublicHelpProperty(PublicHelpProperty publicHelpProperty) {
		return (Long)this.getSqlMapClientTemplate().
				insert("publicHelpProperty.addPublicHelpProperty", publicHelpProperty);
	}

	@SuppressWarnings("deprecation")
	@Override
	public PublicHelpProperty getPublicHelpProperty(Long publicHelpPropertyId) {
		return (PublicHelpProperty)this.getSqlMapClientTemplate().
				queryForObject("publicHelpProperty.getPublicHelpProperty",
						publicHelpPropertyId);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Paginable<PublicHelpProperty> getPaginatedPublicHelpProperty(
			Paginable<PublicHelpProperty> page) {
		 try
	        {
			 	PublicHelpProperty php = (PublicHelpProperty)page;
			 	Long id = php.getCategoryId();
			 	Integer catLevel = 0;
			 	if(id!=null){
					catLevel = (Integer) this.getSqlMapClientTemplate().
							queryForObject("PublicHelpCategory.getLevelById",id);
					if(catLevel==null){
						catLevel = 0;
						php.setCategoryId(null);
						page = php;
					}
			 	}
			 	switch(catLevel){
/*					case 1 :
						super.paginate(page,
			        			"publicHelpProperty.getPublicHelpPropertyCountOne", 
			        			"publicHelpProperty.getPaginatedPublicHelpPropertyOne");
						return page;
					case 2 :
						super.paginate(page,
			        			"publicHelpProperty.getPublicHelpPropertyCountTwo", 
			        			"publicHelpProperty.getPaginatedPublicHelpPropertyTwo");
						return page;*/
					default:
						super.paginate(page,
			        			"publicHelpProperty.getPublicHelpPropertyCount", 
			        			"publicHelpProperty.getPaginatedPublicHelpProperty");
						return page;
				}
	        }catch(Exception e)
	        {
	            
	        }
	        return null;
	}
	
	@SuppressWarnings("deprecation")
	public Long getPublicHelpPropertyByCatId(Long catId){
		return (Long) this.getSqlMapClientTemplate().
			queryForObject("publicHelpProperty.getPublicHelpPropertyByCatId",
					catId);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Integer updateStatus(PublicHelpProperty publicHelpProperty) {
		return this.getSqlMapClientTemplate().
				update("publicHelpProperty.updateStatus",publicHelpProperty);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Integer updatePublicHelpProperty(PublicHelpProperty publicHelpProperty) {
		return this.getSqlMapClientTemplate().
				update("publicHelpProperty.updatePublicHelpProperty",
						publicHelpProperty);
	}
}
