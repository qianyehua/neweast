package com.skyjoo.neweast.biz.art.dao;

import java.util.Date;
import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryPropertyName;
import com.skyjoo.neweast.biz.art.domain.CategoryProperty;

public interface ArtCategoryPropertyDAO {
	
	/**
	 * 通过类目id获取类目属性
	 */
	public List<ArtCategoryProperty> getCategoryPropertyByCatId(Long catId);
	   
    /**
     * 通过类目id获取类目属性
     * 包含全局属性
     */
    public List<ArtCategoryProperty> getAllCategoryPropertyByCatId(Long catId);

    /**
     * 获取所有的属性
     * @return
     */
    public List<ArtCategoryProperty> getArtCategoryPropertys();
    
	/**
	 * 获取全局属性
	 * @return
	 */
	public List<ArtCategoryProperty> getWholeProperty();
	
	/**
	 * 通过id获取指定的状态正常的属性
	 * @param propertyId
	 * @return
	 */
	/*public List<ArtCategoryProperty> getCategoryPropertyById(Long propertyId);*/
	/**
	 * (新)通过id获取指定属性值
	 * @param propertyId
	 * @return
	 */
	public ArtCategoryProperty getNewCategoryPropertyById(Long propertyId,Long categoryId);
	
	
	/**
	 * 根据id得到属性，包括已删除的属性
	 * @param propertyId
	 * @return
	 */
	public List<ArtCategoryProperty> getAllPropertyById(Long propertyId);
	
	/**
	 * 修改指定的属性
	 * @param artCategoryProperty
	 * @return
	 */
	public int editCategoryProperty(ArtCategoryProperty artCategoryProperty);
	/**
	 * 修改属性名称
	 * @param artCategoryPropertyName
	 * @return
	 */
	public int editCategoryPropertyName(ArtCategoryProperty artCategoryProperty);
	/**
	 * 增加属性
	 * @param artCategoryProperty
	 */
	public int addCategoryProperty(ArtCategoryProperty artCategoryProperty);
	/**
	 * 新添加属性
	 * @param artCategoryProperty
	 * @return
	 */
	public Long addnewCategoryProperty(ArtCategoryProperty artCategoryProperty);
	/**
	 * 删除指定的类目属性
	 * @param propertyId
	 * @return
	 */
	public int removeCategoryProperty(Long propertyId);
	/**
	 * 根据属性名id删除属性名
	 * @param nameId
	 * @return
	 */
	public int removeCategoryPropertyName(Long nameId);
	/**
	 * 根据属性名称查找属性名称ID
	 * @param name
	 * @return
	 */
	public Long selectPropertyIdByName(String content);
	/**
	 * 增加属性名称
	 * @param artCategoryPropertyName
	 * @return
	 */
	public Long addCategoryPropertyName(ArtCategoryPropertyName artCategoryPropertyName);
	   /**
     * 根据属性名称ID和二级类目ID查询属性总数
     * @param nameId
     * @param categoryId
     * @return
     */
    public Integer getartCategoryPropertyCount(Long nameId, Long categoryId, Long propertyId);
    /**
     * 查找引用该属性的正常艺术品数目
     * @param propertyId
     * @return
     */
    public Integer getartCountByPropertyId(Long propertyId);
    /**
     * 根据属性名id获取属性对象
     * @param nameId
     * @return
     */
    public ArtCategoryProperty selectPropertyNameById(Long nameId); 
    /**
     * 增加属性类目关联
     * @param categoryProperty
     * @return
     */
    public Long addCategoryProperty(CategoryProperty categoryProperty);
    /**
     * 删除属性类目关联表
     * @param categoryId
     * @param propertyId
     * @return
     */
    public int removeCategoryXProperty(Long categoryId, Long propertyId);
    /**
     * 查询其他类目下同名私有属性数量
     * @param propertyId
     * @param categoryId
     * @return
     */
    public int getOtherCategoryProperty(Long propertyId, Long categoryId);
    /**
     * 修改属性类目关联表
     * @param categoryId
     * @param newPropertyId
     * @param oldPropertyId
     * @return
     */
    public int editCategoryXProperty(Long categoryId, Long newPropertyId, Long oldPropertyId);    
    /**
     * 查询此类目下该属性被正常艺术品引用的数量
     * @param propertyId
     * @param categoryId
     * @return
     */
    public Integer getartCountByCategoryProperty(Long propertyId, Long categoryId);
    /**
     * 查询属性值在其他类目属性下是否被引用
     * @param propertyId
     * @param categoryId
     * @return
     */
    public Integer getArtValueCount(Long propertyId, Long categoryId);
    
    /**
     * 获取更新最晚的艺术品类目属性相关的修改时间
     * @return
     */
    public Date getLastModifyPropertyDate();
}
