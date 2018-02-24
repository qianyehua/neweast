package com.skyjoo.neweast.biz.portal.service;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpCategory;


/**
 * ����������Ŀ����
 * @author liupc
 * @date 2014-11-4 17:26:07
 * @version 1.0
 */
public interface PublicHelpCategoryService {

    /**
     * ����id�����Ŀ����
     * @param id
     * @return
     * @author liupc
     * @date 2014-11-4 17:24:46
     */
    public PublicHelpCategory getPublicHelpCategoryById(Long id);
    
    /**
     * ���ݸ�id��ȡ��һ����Ŀ�б�
     * @param pid ��id
     * @return
     * @author liupc
     * @date  2014-11-4 17:22:00
     */
    public List<PublicHelpCategory> getPublicHelpCategoryByPid(Long pid);
    
    /**
     * �����Ŀ
     * @param publicHelpCategory
     * @return
     * @author liupc
     * @date  2014-11-4 17:22:00
     */
    public Long addPublicHelpCategory(PublicHelpCategory publicHelpCategory);
    
    /**
     * �޸���Ŀ
     * @param publicHelpCategory
     * @return Integer
     * @author liupc
     * @date  2014-11-4 17:22:00
     */
    public Integer editPublicHelpCategory(PublicHelpCategory publicHelpCategory);
    
   /**
    * ɾ����Ŀ
    * @param id
    * @return
    * @author liupc
    * @date 2014-11-4 17:22:00
    */
    public Integer removePublicHelpCategory(PublicHelpCategory publicHelpCategory);
    
    /**
     * ���������Ŀ
     * @return
     */
    public List<Map<String,Object>> getPublicHelpCategorySelNames();
    
    
    /**
     * ����catId��ȡlevel
     * @param catId
     * @return
     */
    public Integer getCatLevel(Long catId);
    
    /**
     * ����name�ͼ����ȡͬ����Ŀ
     * @param name
     * @return
     */
    public Integer getCategeoryByName(PublicHelpCategory publicHelpCategory);
}
