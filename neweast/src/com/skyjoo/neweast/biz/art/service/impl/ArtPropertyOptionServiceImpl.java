package com.skyjoo.neweast.biz.art.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.art.dao.ArtDAO;
import com.skyjoo.neweast.biz.art.dao.ArtPropertyOptionDAO;
import com.skyjoo.neweast.biz.art.dao.ArtPropertyValueDAO;
import com.skyjoo.neweast.biz.art.domain.Art;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyOption;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyValue;
import com.skyjoo.neweast.biz.art.domain.CategoryOptionDTO;
import com.skyjoo.neweast.biz.art.service.ArtPropertyOptionService;

@Service
public class ArtPropertyOptionServiceImpl implements ArtPropertyOptionService {

	@Autowired
	private ArtPropertyOptionDAO artPropertyOptionDAO;

	@Autowired
	private ArtPropertyValueDAO artPropertyValueDAO;

	@Autowired
	private ArtDAO artDAO;

	@Override
	public List<ArtPropertyOption> getPropertyOptionByProId(Long proId,
			Long categoryId) {
		List<ArtPropertyOption> options = artPropertyOptionDAO
				.getArtPropertyOptionByProId(proId, categoryId);
		/*
		 * if (options != null && options.size() > 0) { for (ArtPropertyOption
		 * option : options) { option.setCanDeleted(this.canDeleted(option)); }
		 * }
		 */
		return options;
	}

	/**
	 * 判断选项是否可以被删除
	 * 
	 * @param option
	 * @return
	 */
	public boolean canDeleted(ArtPropertyOption option) {
		Long propertyId = option.getPropertyId();
		List<ArtPropertyValue> propertyValues = artPropertyValueDAO
				.getArtPropertyValuesByProId(propertyId);
		if (propertyValues != null && propertyValues.size() > 0) {
			for (ArtPropertyValue value : propertyValues) {
				// 得到选项值，并分割
				String[] arr_optionValue = value.getArtOption().split(",");
				for (String str : arr_optionValue) {
					if (StringUtils.isBlank(str)) {
						continue;
					}
					Long optionId = Long.parseLong(str);
					if (optionId.compareTo(option.getId()) == 0) {
						Long artId = value.getArtId();
						List<Art> artList = artDAO.getArtListById(artId);
						if (artList != null && artList.size() > 0) {
							for (Art art : artList) {
								if (art.getStatus() != 4
										&& art.getStatus() != 2
										&& art.getStatus() != 7) {
									return false;
								}
							}
						}
						// return false;
					}
				}
			}
			return true;
		} else {
			return false;
		}
	}

	
	@Override
	public long editPropertyOption(ArtPropertyOption option) {
		if (option.getCategoryId() == -1) {
			return artPropertyOptionDAO.editPropertyOption(option);
		}
		ArtPropertyOption apo = artPropertyOptionDAO
				.getArtPropertyOptionByPropertyIDAndName(option.getContent(),
						option.getPropertyId());
		artPropertyOptionDAO.deleteCategory_X_OptionWithOptionIdAndCategoryId(
				option.getId(), option.getCategoryId());
		if (artPropertyOptionDAO.countCategory_X_OptionByOption(option.getId()) == 0) {
			artPropertyOptionDAO.removePropertyOption(option.getId());
		}
		// 其他类目中有同名选项，删除旧的关联表、插入关联表
		if (apo != null) {
			if (option.getOrdering().intValue()!=apo.getOrdering().intValue()) {
				apo.setOrdering(option.getOrdering());
				artPropertyOptionDAO.editPropertyOption(apo);
			}
			apo.setCategoryId(option.getCategoryId());
			return insertIntoOpertaionXCategory(apo);
		} else {// 其他类目中无同名选项，新建选项，插入关联表
			artPropertyOptionDAO.addPropertyOption(option);
			return insertIntoOpertaionXCategory(option);
		}

	}

	@Override
	public ArtPropertyOption getPropertyOptyById(Long optionId) {
		List<ArtPropertyOption> list = artPropertyOptionDAO
				.getArtPropertyOptionById(optionId);
		if (list != null && list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public Long addPropertyOption(ArtPropertyOption option) {
		ArtPropertyOption apo = artPropertyOptionDAO
				.getArtPropertyOptionByPropertyIDAndName(option.getContent(),
						option.getPropertyId());
		// 同属性下其他类目中有同名选项，插入关联表
		if (apo != null) {
			if (option.getOrdering().intValue()!=apo.getOrdering().intValue()) {
				apo.setOrdering(option.getOrdering());
				artPropertyOptionDAO.editPropertyOption(apo);
			}
			apo.setCategoryId(option.getCategoryId());
			return insertIntoOpertaionXCategory(apo);
		} else {// 同属性下其他类目中无同名选项，新建选项、插入关联表
			artPropertyOptionDAO.addPropertyOption(option);
			return insertIntoOpertaionXCategory(option);
		}
	}

	/**
	 * 根据ArtPropertyOption插入关联表
	 * 
	 * @param apo
	 */
	private long insertIntoOpertaionXCategory(ArtPropertyOption apo) {
		if (apo.getCategoryId() != -1) {
			CategoryOptionDTO dto = new CategoryOptionDTO();
			dto.setCategoryId(apo.getCategoryId());
			dto.setOptionId(apo.getId());
			return artPropertyOptionDAO.insertCategory_X_Option(dto);
		}
		return 1;
	}

	@Override
	public long removePropertyOption(Long optionId, Long propertyID,
			Long categoryID) {
		// 查询是否有在用
		if (usedByArt(optionId, propertyID, categoryID)) {
			// 有被使用无其他操作
			return 0;
		} else {
			// if
			// (artPropertyOptionDAO.countCategory_X_OptionByOptionId(optionId,
			// categoryID) > 0) {
			// return 0;
			// }

			artPropertyValueDAO.removeArtPropertyValueByDeleteOption(
					optionId.toString(), propertyID, categoryID);// 删除value表中对应的单选选项
			artPropertyValueDAO.updateArtPropertyValue(optionId.toString(),
					propertyID, categoryID);// 更新value表中多选option数据
			artPropertyValueDAO.deleteArtPropertyValueByNull(propertyID);// 删除属性下空数据
			if (categoryID == -1) {
				return artPropertyOptionDAO.removePropertyOption(optionId);
			}
			artPropertyOptionDAO
					.deleteCategory_X_OptionWithOptionIdAndCategoryId(optionId,
							categoryID);
			if (artPropertyOptionDAO.countCategory_X_OptionByOption(optionId) == 0) {
				artPropertyOptionDAO.removePropertyOption(optionId);
			}
			return 1;// 删除关联表
			// return artPropertyOptionDAO.removePropertyOption(optionId);
		}

	}

	@Override
	public Long insertCategory_X_Option(CategoryOptionDTO dto) {
		return artPropertyOptionDAO.insertCategory_X_Option(dto);
	}

	@Override
	public Long deleteOptionByPropertyID(Long pid, Long cid) {
		if (cid == null) {
			cid = -1L;
		}
		List<ArtPropertyOption> options = artPropertyOptionDAO
				.getArtPropertyOptionByProId(pid, cid);
		for (ArtPropertyOption artPropertyOption : options) {
			if (cid == -1) {
				artPropertyOptionDAO.removePropertyOption(artPropertyOption
						.getId());
				continue;
			}
			artPropertyOptionDAO
					.deleteCategory_X_OptionWithOptionIdAndCategoryId(
							artPropertyOption.getId(), cid);
		}
		return null;
	}

	@Override
	public Long deleteOptionByPropertyIDForDeleteCategory(Long pid, Long cid) {
		if (cid == null) {
			cid = -1L;
			return null;
		}
		List<ArtPropertyOption> options = artPropertyOptionDAO.getArtPropertyOptionByProId(pid, cid);
		for (ArtPropertyOption artPropertyOption : options) {
			artPropertyOptionDAO.deleteCategory_X_OptionWithOptionIdAndCategoryId(artPropertyOption.getId(),cid);
			// artPropertyOptionDAO.removePropertyOption(artPropertyOption.getId());
	
		}
		return null;
	}

	// public boolean checkdeleteOptionByPropertyWithValidator(Long propertyId,
	// Long cid) {
	// List<ArtPropertyOption> options = artPropertyOptionDAO
	// .getArtPropertyOptionByProId(propertyId, cid);
	// for (ArtPropertyOption artPropertyOption : options) {
	// if (canDeleteOption(artPropertyOption.getId())) {
	//
	// }
	//
	// if (artPropertyOptionDAO.countCategory_X_OptionByOptionId(
	// artPropertyOption.getId(), cid) > 0) {
	//
	// return false;
	// }
	// }
	//
	// return true;
	// }

	/**
	 * 判断选项是否被其他艺术品使用
	 * 
	 * @param optionId
	 * @return
	 */
	private boolean usedByArt(Long optionId, Long propertyID, Long categoryID) {
		int i = artPropertyValueDAO.checkArtPropertyValue(
				String.valueOf(optionId), propertyID, categoryID);
		if (i > 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public long updatePropertyOption(ArtPropertyOption option) {
		return  artPropertyOptionDAO.editPropertyOption(option);
	}
}
