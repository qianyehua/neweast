package com.skyjoo.neweast.biz.art.dao;

import java.util.Date;
import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryPropertyName;
import com.skyjoo.neweast.biz.art.domain.CategoryProperty;

public interface ArtCategoryPropertyDAO {
	
	/**
	 * ͨ����Ŀid��ȡ��Ŀ����
	 */
	public List<ArtCategoryProperty> getCategoryPropertyByCatId(Long catId);
	   
    /**
     * ͨ����Ŀid��ȡ��Ŀ����
     * ����ȫ������
     */
    public List<ArtCategoryProperty> getAllCategoryPropertyByCatId(Long catId);

    /**
     * ��ȡ���е�����
     * @return
     */
    public List<ArtCategoryProperty> getArtCategoryPropertys();
    
	/**
	 * ��ȡȫ������
	 * @return
	 */
	public List<ArtCategoryProperty> getWholeProperty();
	
	/**
	 * ͨ��id��ȡָ����״̬����������
	 * @param propertyId
	 * @return
	 */
	/*public List<ArtCategoryProperty> getCategoryPropertyById(Long propertyId);*/
	/**
	 * (��)ͨ��id��ȡָ������ֵ
	 * @param propertyId
	 * @return
	 */
	public ArtCategoryProperty getNewCategoryPropertyById(Long propertyId,Long categoryId);
	
	
	/**
	 * ����id�õ����ԣ�������ɾ��������
	 * @param propertyId
	 * @return
	 */
	public List<ArtCategoryProperty> getAllPropertyById(Long propertyId);
	
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
	 */
	public int addCategoryProperty(ArtCategoryProperty artCategoryProperty);
	/**
	 * ���������
	 * @param artCategoryProperty
	 * @return
	 */
	public Long addnewCategoryProperty(ArtCategoryProperty artCategoryProperty);
	/**
	 * ɾ��ָ������Ŀ����
	 * @param propertyId
	 * @return
	 */
	public int removeCategoryProperty(Long propertyId);
	/**
	 * ����������idɾ��������
	 * @param nameId
	 * @return
	 */
	public int removeCategoryPropertyName(Long nameId);
	/**
	 * �����������Ʋ�����������ID
	 * @param name
	 * @return
	 */
	public Long selectPropertyIdByName(String content);
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
     * ����������id��ȡ���Զ���
     * @param nameId
     * @return
     */
    public ArtCategoryProperty selectPropertyNameById(Long nameId); 
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
     * ��ѯ������Ŀ��ͬ��˽����������
     * @param propertyId
     * @param categoryId
     * @return
     */
    public int getOtherCategoryProperty(Long propertyId, Long categoryId);
    /**
     * �޸�������Ŀ������
     * @param categoryId
     * @param newPropertyId
     * @param oldPropertyId
     * @return
     */
    public int editCategoryXProperty(Long categoryId, Long newPropertyId, Long oldPropertyId);    
    /**
     * ��ѯ����Ŀ�¸����Ա���������Ʒ���õ�����
     * @param propertyId
     * @param categoryId
     * @return
     */
    public Integer getartCountByCategoryProperty(Long propertyId, Long categoryId);
    /**
     * ��ѯ����ֵ��������Ŀ�������Ƿ�����
     * @param propertyId
     * @param categoryId
     * @return
     */
    public Integer getArtValueCount(Long propertyId, Long categoryId);
    
    /**
     * ��ȡ�������������Ʒ��Ŀ������ص��޸�ʱ��
     * @return
     */
    public Date getLastModifyPropertyDate();
}
