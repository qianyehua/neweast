package com.skyjoo.neweast.biz.art.service;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtPropertyOption;
import com.skyjoo.neweast.biz.art.domain.CategoryOptionDTO;

public interface ArtPropertyOptionService {

	/**
	 * 通过id获取选项
	 * 
	 * @param propertyId
	 * @return
	 */
	public ArtPropertyOption getPropertyOptyById(Long optionId);

	/**
	 * 通过属性id获取选项
	 * 
	 * @param proId
	 * @return
	 */
	public List<ArtPropertyOption> getPropertyOptionByProId(Long proId,
			Long categoryId);

	/**
	 * 修改艺术品选项
	 * 
	 * @param option
	 * @return
	 */
	public long editPropertyOption(ArtPropertyOption option);

	/**
	 * 更新艺术品选项
	 * 
	 * @param option
	 * @return
	 */
	public long updatePropertyOption(ArtPropertyOption option);

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
	 * @param propertyId
	 * @return
	 */
	public long removePropertyOption(Long optionId, Long propertyID,
			Long categoryID);

	/**
	 * 插入CATEGORY_X_OPTION表数据
	 * 
	 * @param categoryID
	 * @param optionID
	 * @return
	 */
	public Long insertCategory_X_Option(CategoryOptionDTO dto);

	/**
	 * 根据类目ID和属性ID删除下面的选项
	 * 
	 * @param pid
	 * @param cid
	 * @return
	 */
	public Long deleteOptionByPropertyID(Long pid, Long cid);

	/**
	 * 根据类目ID和属性ID删除下面的选项 --
	 * 
	 * @param pid
	 * @param cid
	 * @return
	 */
	public Long deleteOptionByPropertyIDForDeleteCategory(Long pid, Long cid);

	/**
	 * 判断属性是否能删除
	 * 
	 * @param propertyId
	 * @param cid
	 * @return
	 */
	// public boolean checkdeleteOptionByPropertyWithValidator(Long propertyId,
	// Long cid);

}
