/**
 * 
 */
package com.skyjoo.neweast.biz.portal.dao;



import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpProperty;


/**
 * �������ݱ�dao
 * @author liupc
 * @version 1.0
 * @date 2014-11-4 18:02:57
 */
public interface PublicHelpPropertyDAO {

	
	/**
	 * ���һ��PublicHelpProperty��¼ 
	 * @param PublicNote
	 * @return
	 */
 	Long addPublicHelpProperty(PublicHelpProperty publicHelpProperty);
 	
 	/**
 	 * ��ѯһ��PublicHelpProperty�����
 	 * @param publicHelpPropertyId
 	 * @return ����PublicHelpProperty����
 	 */
 	PublicHelpProperty getPublicHelpProperty(Long publicHelpPropertyId);
 	
 	/**
 	 * ��ҳ��ѯ
 	 * @param page
 	 * @return ���ط�ҳ����
 	 */
    public Paginable<PublicHelpProperty> getPaginatedPublicHelpProperty(Paginable<PublicHelpProperty> page);

    /**
     * �޸�һ��PublicHelpProperty��¼��status 
     * @param PublicHelpProperty
     * @return
     */
 	Integer updateStatus(PublicHelpProperty publicHelpProperty);
 	
 	/**
 	 * �޸�һ��PublicHelpProperty��¼
 	 * @param publicHelpProperty
 	 * @return
 	 */
 	Integer updatePublicHelpProperty(PublicHelpProperty publicHelpProperty);
 	
 	/**
 	 * ����������Ŀid��ȡ������������
 	 * @param catId
 	 * @return
 	 */
 	Long getPublicHelpPropertyByCatId(Long catId);
}
