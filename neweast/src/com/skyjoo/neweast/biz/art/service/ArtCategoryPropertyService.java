package com.skyjoo.neweast.biz.art.service;

import java.util.Date;
import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryPropertyName;
import com.skyjoo.neweast.biz.art.domain.CategoryProperty;

public interface ArtCategoryPropertyService {
	
	/**
	 * ͨ����Ŀid��ȡָ������Ŀ����
	 * @param CatId
	 * @return
	 */
	public List<ArtCategoryProperty> getCategoryPropertyByCatId(Long catId);
	/**
	 * ��ȡȫ������
	 * @return
	 */
	public List<ArtCategoryProperty> getWholeProperty();
	
	/**
	 * ͨ��id��ȡָ��������
	 * @param propertyId
	 * @return
	 */
	/*public ArtCategoryProperty getCategoryPropertyById(Long propertyId);*/
	 /**
     * (��)ͨ��id��ȡָ��������
     * @param propertyId
     * @return
     */
	public ArtCategoryProperty getNewCategoryPropertyById(Long propertyId, Long categoryId);
	/**
	 * �޸�ָ��������
	 * @param artCategoryProperty
	 * @return
	 */
	public int editCategoryProperty(ArtCategoryProperty artCategoryProperty);
	/**
	 * �޸���������
	 * @param artCategoryPropertyName
	 * @return
	 */
	public int editCategoryPropertyName(ArtCategoryProperty artCategoryProperty);
	/**
	 * ��������
	 * @param artCategoryProperty
	 * @return
	 */
	public int addCategoryProperty(ArtCategoryProperty artCategoryProperty);
	/**
	 * ��������
	 * @param artCategoryProperty
	 * @return
	 */
	public Long addnewCategoryProperty(ArtCategoryProperty artCategoryProperty);
	
	/**
	 * ɾ��ָ������Ŀ����
	 * @param propertyId
	 * @return
	 */
	public int removeCategoryProperty(Long propertyId, Long categoryId);
	/**
	 * �����������Ʋ�����������ID
	 * @param name
	 * @return
	 */
	public Long selectPropertyIdByName(String content);
	/**
	 * ����������id��ȡ������
	 * @param Id
	 * @return
	 */
	public ArtCategoryProperty selectPropertyNameById(Long nameId);
	/**
	 * ������������
	 * @param artCategoryPropertyName
	 * @return
	 */
	public Long addCategoryPropertyName(ArtCategoryPropertyName artCategoryPropertyName);
	/**
	 * ������������ID�Ͷ�����ĿID��ѯ��������
	 * @param nameId
	 * @param categoryId
	 * @return
	 */
	public Integer getartCategoryPropertyCount(Long nameId, Long categoryId, Long propertyId);
	/**
	 * �������ø����Ե���������Ʒ��Ŀ
	 * @param propertyId
	 * @return
	 */
	public Integer getartCountByPropertyId(Long propertyId);
	
	/**
     * ����������idɾ��������
     * @param nameId
     * @return
     */
    public int removeCategoryPropertyName(Long nameId);
    /**
     * ����������Ŀ����
     * @param categoryProperty
     * @return
     */
    public Long addCategoryProperty(CategoryProperty categoryProperty);
    /**
     * ɾ��������Ŀ������
     * @param categoryId
     * @param propertyId
     * @return
     */
    public int removeCategoryXProperty(Long categoryId, Long propertyId);
    /**
     * �޸�������Ŀ������
     * @param categoryId
     * @param newPropertyId
     * @param oldPropertyId
     * @return
     */
    public int editCategoryXProperty(Long categoryId, Long newPropertyId, Long oldPropertyId);
    /**
     * ��ѯ��������Ŀ��ͬ��˽����������
     * @param propertyId
     * @param categoryId
     * @return
     */
    public int getOtherCategoryProperty(Long propertyId, Long categoryId);
    /**
     * ��ѯ����Ŀ�¸����Ա������������õ�����
     * @param propertyId
     * @param categoryId
     * @return
     */
    public Integer getartCountByCategoryProperty(Long propertyId, Long categoryId);
    
    /**
	 * ɾ��ָ������Ŀ���ԡ���ɾ����Ŀʹ��
	 * @param propertyId
	 * @return
	 */
	public int removeCategoryProperty(Long categoryId);
    
	/**
	 * ��ȡ��Ŀ����
	 * @return
	 */
	public List<ArtCategoryProperty> getArtCategoryPropertyListForHomepage();
	
    /**
     * ��ȡ�������������Ʒ��Ŀ��ص��޸�ʱ��
     * @return
     */
    public Date getLastModifyPropertyDate();
}
