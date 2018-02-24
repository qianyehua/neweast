package com.skyjoo.neweast.biz.portal.service;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpCategory;


/**
 * 帮助中心类目管理
 * @author liupc
 * @date 2014-11-4 17:26:07
 * @version 1.0
 */
public interface PublicHelpCategoryService {

    /**
     * 根据id获得类目属性
     * @param id
     * @return
     * @author liupc
     * @date 2014-11-4 17:24:46
     */
    public PublicHelpCategory getPublicHelpCategoryById(Long id);
    
    /**
     * 根据父id获取下一级类目列表
     * @param pid 父id
     * @return
     * @author liupc
     * @date  2014-11-4 17:22:00
     */
    public List<PublicHelpCategory> getPublicHelpCategoryByPid(Long pid);
    
    /**
     * 添加类目
     * @param publicHelpCategory
     * @return
     * @author liupc
     * @date  2014-11-4 17:22:00
     */
    public Long addPublicHelpCategory(PublicHelpCategory publicHelpCategory);
    
    /**
     * 修改类目
     * @param publicHelpCategory
     * @return Integer
     * @author liupc
     * @date  2014-11-4 17:22:00
     */
    public Integer editPublicHelpCategory(PublicHelpCategory publicHelpCategory);
    
   /**
    * 删除类目
    * @param id
    * @return
    * @author liupc
    * @date 2014-11-4 17:22:00
    */
    public Integer removePublicHelpCategory(PublicHelpCategory publicHelpCategory);
    
    /**
     * 获得所有类目
     * @return
     */
    public List<Map<String,Object>> getPublicHelpCategorySelNames();
    
    
    /**
     * 根据catId获取level
     * @param catId
     * @return
     */
    public Integer getCatLevel(Long catId);
    
    /**
     * 根据name和级别获取同级类目
     * @param name
     * @return
     */
    public Integer getCategeoryByName(PublicHelpCategory publicHelpCategory);
}
