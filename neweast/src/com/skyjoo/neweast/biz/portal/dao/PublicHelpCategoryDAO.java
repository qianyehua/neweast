package com.skyjoo.neweast.biz.portal.dao;

import java.util.List;

import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpCategory;
/**
 * ����������Ŀ��dao
 * @author liupc
 * @version 1.0
 * @date 2014-11-4 17:42:45
 */
public interface PublicHelpCategoryDAO {

	/**
     * ����id�����Ŀ
     * @param id
     * @return
     */
    public PublicHelpCategory getPublicHelpCategoryById(Long id);
    
    /**
     * ���ݸ�id��ȡ����Ŀ�б�
     * @param pid
     * @return
     */
    public List<PublicHelpCategory> getPublicHelpCategoryByPid(Long pid);
    
    /**
     * �����Ŀ
     * @param publicHelpCategory
     * @return Long
     */
    public Long addPublicHelpCategory(PublicHelpCategory publicHelpCategory);
    
    /**
     * �޸���Ŀ
     * @param publicHelpCategory
     * @return Integer
     */
    public Integer editPublicHelpCategory(PublicHelpCategory publicHelpCategory);
    
   /**
    * ɾ����Ŀ
    * @param publicHelpCategory
    * @return Integer
    */
    public Integer removePublicHelpCategory(PublicHelpCategory publicHelpCategory);
    
    /**
     * ����id��ȡ����Ŀ���������ж��Ƿ���ɾ��
     * @param catId
     * @return Integer
     */
    public Integer getCategoriesById(Long catId);
    
    /**
     * ����id��ȡ��Ŀ����
     * @param catId
     * @return
     */
    public Integer getLevelById(Long catId);

    /**
     * ����name�ͼ����ȡͬ��Ŀ����Ŀ
     * @param publicHelpCategory
     * @return
     */
	public Integer getCategeoryByName(PublicHelpCategory publicHelpCategory);
}
