package com.skyjoo.neweast.biz.portal.service;


import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpProperty;

/**
 * ��̨�������ݹ������
 * @author liupc
 * @version 1.0 
 * @date 2014-10-31 09:41:07
 */
public interface PublicHelpPropertyService {

	/**
	 * ���һ��PublicHelpProperty��¼
	 * @param PublicHelpProperty
	 * @return
	 */
	public Long addPublicHelpProperty(PublicHelpProperty publicHelpProperty);
	
	/**
	 * ��ѯһ��PublicHelpProperty�����
	 * @param publicHelpPropertyId
	 * @return PublicHelpProperty����
	 */
 	public PublicHelpProperty getPublicHelpProperty(Long publicHelpPropertyId);

 	/**
 	 * ��ҳ��ѯ����PublicHelpProperty�����
 	 * @param page
 	 * @return ��ҳ����ļ��� 
 	 */
    public Paginable<PublicHelpProperty> getPaginatedPublicHelpProperty(Paginable<PublicHelpProperty> page);

    /**
     * �޸�һ��PublicHelpProperty��¼��״̬
     * @param publicHelpProperty
     * @return
     */
 	public Integer updateStatus(PublicHelpProperty publicHelpProperty);
 	
 	/**
 	 * �༭PublicHelpProperty����
 	 * @param publicHelpProperty
 	 * @return
 	 */
 	public Integer updatePublicHelpProperty(PublicHelpProperty publicHelpProperty);
}
