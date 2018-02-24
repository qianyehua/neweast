package com.skyjoo.neweast.biz.art.dao;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtPropertyOption;
import com.skyjoo.neweast.biz.art.domain.CategoryOptionDTO;

public interface ArtPropertyOptionDAO {

	public List<ArtPropertyOption> getArtPropertyOptionById(Long optionId);

	/**
	 * ��ȡ����Ʒ����ѡ��
	 * 
	 * @param proId
	 *            ����id
	 * @return List
	 */
	public List<ArtPropertyOption> getArtPropertyOptionByProId(Long proId,
			Long categoryId);

	/**
	 * ��ȡ����Ʒ����ѡ�������ɾ����ѡ��
	 * 
	 * @param ProId
	 * @return
	 */
	public List<ArtPropertyOption> getAllPropertyOptionByProId(Long ProId);

	/**
	 * �޸�����Ʒѡ��
	 * 
	 * @param option
	 * @return
	 */
	public int editPropertyOption(ArtPropertyOption option);

	/**
	 * �������ѡ��
	 * 
	 * @param option
	 * @return
	 */
	public Long addPropertyOption(ArtPropertyOption option);

	/**
	 * ɾ��ѡ��
	 * 
	 * @param optionId
	 * @return
	 */
	public long removePropertyOption(Long optionId);

	/**
	 * ��������idɾ��ѡ��
	 * 
	 * @param propertyId
	 * @return
	 */
	public long removePropertyOptionByPropertyId(Long propertyId);

	/**
	 * ����CATEGORY_X_OPTION������
	 * 
	 * @param categoryID
	 * @param optionID
	 * @return
	 */
	public Long insertCategory_X_Option(CategoryOptionDTO dto);

	/**
	 * ͨ��ѡ��IDɾ��Category_X_OptionById������
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
	 * ��ȡ������Ŀʹ�ø�ѡ�����Ŀ
	 * 
	 * @param opid
	 * @param cid
	 * @return
	 */
	public int countCategory_X_OptionByOptionId(Long opid, Long cid);

	/**
	 * ͳ�ƹ�������optionid����
	 * 
	 * @param opid
	 * @return
	 */
	public int countCategory_X_OptionByOption(Long opid);

	/**
	 * ��������Id��ѡ�����ƻ�ȡѡ�����
	 * 
	 * @param name
	 * @param propertyId
	 * @return
	 */
	public ArtPropertyOption getArtPropertyOptionByPropertyIDAndName(
			String name, Long propertyId);

}
