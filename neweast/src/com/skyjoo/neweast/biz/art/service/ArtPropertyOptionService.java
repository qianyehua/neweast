package com.skyjoo.neweast.biz.art.service;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtPropertyOption;
import com.skyjoo.neweast.biz.art.domain.CategoryOptionDTO;

public interface ArtPropertyOptionService {

	/**
	 * ͨ��id��ȡѡ��
	 * 
	 * @param propertyId
	 * @return
	 */
	public ArtPropertyOption getPropertyOptyById(Long optionId);

	/**
	 * ͨ������id��ȡѡ��
	 * 
	 * @param proId
	 * @return
	 */
	public List<ArtPropertyOption> getPropertyOptionByProId(Long proId,
			Long categoryId);

	/**
	 * �޸�����Ʒѡ��
	 * 
	 * @param option
	 * @return
	 */
	public long editPropertyOption(ArtPropertyOption option);

	/**
	 * ��������Ʒѡ��
	 * 
	 * @param option
	 * @return
	 */
	public long updatePropertyOption(ArtPropertyOption option);

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
	 * @param propertyId
	 * @return
	 */
	public long removePropertyOption(Long optionId, Long propertyID,
			Long categoryID);

	/**
	 * ����CATEGORY_X_OPTION������
	 * 
	 * @param categoryID
	 * @param optionID
	 * @return
	 */
	public Long insertCategory_X_Option(CategoryOptionDTO dto);

	/**
	 * ������ĿID������IDɾ�������ѡ��
	 * 
	 * @param pid
	 * @param cid
	 * @return
	 */
	public Long deleteOptionByPropertyID(Long pid, Long cid);

	/**
	 * ������ĿID������IDɾ�������ѡ�� --
	 * 
	 * @param pid
	 * @param cid
	 * @return
	 */
	public Long deleteOptionByPropertyIDForDeleteCategory(Long pid, Long cid);

	/**
	 * �ж������Ƿ���ɾ��
	 * 
	 * @param propertyId
	 * @param cid
	 * @return
	 */
	// public boolean checkdeleteOptionByPropertyWithValidator(Long propertyId,
	// Long cid);

}
