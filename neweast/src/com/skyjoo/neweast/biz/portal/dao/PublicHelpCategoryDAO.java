package com.skyjoo.neweast.biz.portal.dao;

import java.util.List;

import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpCategory;
/**
 * 帮助中心类目表dao
 * @author liupc
 * @version 1.0
 * @date 2014-11-4 17:42:45
 */
public interface PublicHelpCategoryDAO {

	/**
     * 根据id获得类目
     * @param id
     * @return
     */
    public PublicHelpCategory getPublicHelpCategoryById(Long id);
    
    /**
     * 根据父id获取子类目列表
     * @param pid
     * @return
     */
    public List<PublicHelpCategory> getPublicHelpCategoryByPid(Long pid);
    
    /**
     * 添加类目
     * @param publicHelpCategory
     * @return Long
     */
    public Long addPublicHelpCategory(PublicHelpCategory publicHelpCategory);
    
    /**
     * 修改类目
     * @param publicHelpCategory
     * @return Integer
     */
    public Integer editPublicHelpCategory(PublicHelpCategory publicHelpCategory);
    
   /**
    * 删除类目
    * @param publicHelpCategory
    * @return Integer
    */
    public Integer removePublicHelpCategory(PublicHelpCategory publicHelpCategory);
    
    /**
     * 根据id获取子类目数，用来判断是否能删除
     * @param catId
     * @return Integer
     */
    public Integer getCategoriesById(Long catId);
    
    /**
     * 根据id获取类目级别
     * @param catId
     * @return
     */
    public Integer getLevelById(Long catId);

    /**
     * 根据name和级别获取同类目下类目
     * @param publicHelpCategory
     * @return
     */
	public Integer getCategeoryByName(PublicHelpCategory publicHelpCategory);
}
