package com.skyjoo.neweast.biz.portal.service;


import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpProperty;

/**
 * 后台帮助内容管理操作
 * @author liupc
 * @version 1.0 
 * @date 2014-10-31 09:41:07
 */
public interface PublicHelpPropertyService {

	/**
	 * 添加一条PublicHelpProperty记录
	 * @param PublicHelpProperty
	 * @return
	 */
	public Long addPublicHelpProperty(PublicHelpProperty publicHelpProperty);
	
	/**
	 * 查询一个PublicHelpProperty结果集
	 * @param publicHelpPropertyId
	 * @return PublicHelpProperty对象
	 */
 	public PublicHelpProperty getPublicHelpProperty(Long publicHelpPropertyId);

 	/**
 	 * 分页查询所有PublicHelpProperty结果集
 	 * @param page
 	 * @return 分页对象的集合 
 	 */
    public Paginable<PublicHelpProperty> getPaginatedPublicHelpProperty(Paginable<PublicHelpProperty> page);

    /**
     * 修改一条PublicHelpProperty记录的状态
     * @param publicHelpProperty
     * @return
     */
 	public Integer updateStatus(PublicHelpProperty publicHelpProperty);
 	
 	/**
 	 * 编辑PublicHelpProperty内容
 	 * @param publicHelpProperty
 	 * @return
 	 */
 	public Integer updatePublicHelpProperty(PublicHelpProperty publicHelpProperty);
}
