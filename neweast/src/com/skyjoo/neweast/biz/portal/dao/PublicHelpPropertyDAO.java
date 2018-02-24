/**
 * 
 */
package com.skyjoo.neweast.biz.portal.dao;



import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpProperty;


/**
 * 帮助内容表dao
 * @author liupc
 * @version 1.0
 * @date 2014-11-4 18:02:57
 */
public interface PublicHelpPropertyDAO {

	
	/**
	 * 添加一条PublicHelpProperty记录 
	 * @param PublicNote
	 * @return
	 */
 	Long addPublicHelpProperty(PublicHelpProperty publicHelpProperty);
 	
 	/**
 	 * 查询一个PublicHelpProperty结果集
 	 * @param publicHelpPropertyId
 	 * @return 返回PublicHelpProperty对象
 	 */
 	PublicHelpProperty getPublicHelpProperty(Long publicHelpPropertyId);
 	
 	/**
 	 * 分页查询
 	 * @param page
 	 * @return 返回分页对象
 	 */
    public Paginable<PublicHelpProperty> getPaginatedPublicHelpProperty(Paginable<PublicHelpProperty> page);

    /**
     * 修改一条PublicHelpProperty记录的status 
     * @param PublicHelpProperty
     * @return
     */
 	Integer updateStatus(PublicHelpProperty publicHelpProperty);
 	
 	/**
 	 * 修改一条PublicHelpProperty记录
 	 * @param publicHelpProperty
 	 * @return
 	 */
 	Integer updatePublicHelpProperty(PublicHelpProperty publicHelpProperty);
 	
 	/**
 	 * 根据三级类目id获取旗下内容数量
 	 * @param catId
 	 * @return
 	 */
 	Long getPublicHelpPropertyByCatId(Long catId);
}
