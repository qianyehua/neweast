package com.skyjoo.neweast.biz.art.dao;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtPropertyOption;
import com.skyjoo.neweast.biz.art.domain.CategoryOptionDTO;

public interface ArtPropertyOptionDAO {

	public List<ArtPropertyOption> getArtPropertyOptionById(Long optionId);

	/**
	 * 获取艺术品属性选项
	 * 
	 * @param proId
	 *            属性id
	 * @return List
	 */
	public List<ArtPropertyOption> getArtPropertyOptionByProId(Long proId,
			Long categoryId);

	/**
	 * 获取艺术品属性选项，包括已删除的选项
	 * 
	 * @param ProId
	 * @return
	 */
	public List<ArtPropertyOption> getAllPropertyOptionByProId(Long ProId);

	/**
	 * 修改艺术品选项
	 * 
	 * @param option
	 * @return
	 */
	public int editPropertyOption(ArtPropertyOption option);

	/**
	 * 添加属性选项
	 * 
	 * @param option
	 * @return
	 */
	public Long addPropertyOption(ArtPropertyOption option);

	/**
	 * 删除选项
	 * 
	 * @param optionId
	 * @return
	 */
	public long removePropertyOption(Long optionId);

	/**
	 * 根据属性id删除选项
	 * 
	 * @param propertyId
	 * @return
	 */
	public long removePropertyOptionByPropertyId(Long propertyId);

	/**
	 * 插入CATEGORY_X_OPTION表数据
	 * 
	 * @param categoryID
	 * @param optionID
	 * @return
	 */
	public Long insertCategory_X_Option(CategoryOptionDTO dto);

	/**
	 * 通过选项ID删除Category_X_OptionById表数据
	 * 
	 * @param optionID
	 * @return
	 */
	public int deleteCategory_X_OptionByOptionId(Long optionID);

	/**
	 * 
	 * @param optionID
	 * @param categoryId
	 * @return
	 */
	public int deleteCategory_X_OptionWithOptionIdAndCategoryId(Long optionID,
			Long categoryId);

	/**
	 * 获取其他类目使用该选项的数目
	 * 
	 * @param opid
	 * @param cid
	 * @return
	 */
	public int countCategory_X_OptionByOptionId(Long opid, Long cid);

	/**
	 * 统计关联表中optionid个数
	 * 
	 * @param opid
	 * @return
	 */
	public int countCategory_X_OptionByOption(Long opid);

	/**
	 * 根据属性Id和选项名称获取选项对象
	 * 
	 * @param name
	 * @param propertyId
	 * @return
	 */
	public ArtPropertyOption getArtPropertyOptionByPropertyIDAndName(
			String name, Long propertyId);

}
