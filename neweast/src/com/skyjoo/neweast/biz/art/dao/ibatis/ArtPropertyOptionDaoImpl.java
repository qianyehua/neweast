package com.skyjoo.neweast.biz.art.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.art.dao.ArtPropertyOptionDAO;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyOption;
import com.skyjoo.neweast.biz.art.domain.CategoryOptionDTO;

@SuppressWarnings("deprecation")
@Repository
public class ArtPropertyOptionDaoImpl implements ArtPropertyOptionDAO {

	private static final String SQLMAP_SPACE = "ART_PROPERTY_OPTION.";

	@Autowired
	private SqlMapClientTemplate sqlMapClient;

	@SuppressWarnings("unchecked")
	@Override
	public List<ArtPropertyOption> getArtPropertyOptionByProId(Long proId,Long categoryId) {
		Map map = new HashMap();
		map.put("proId", proId);
		map.put("categoryId", categoryId);
		return this.sqlMapClient.queryForList(SQLMAP_SPACE
				+ "getArtPropertyOptionByProId", map);
	}

	@Override
	public int editPropertyOption(ArtPropertyOption option) {
		return this.sqlMapClient.update(SQLMAP_SPACE + "editPropertyOption",
				option);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArtPropertyOption> getArtPropertyOptionById(Long optionId) {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE
				+ "getArtPropertyOptionById", optionId);
	}

	@Override
	public Long addPropertyOption(ArtPropertyOption option) {
		return (Long) this.sqlMapClient.insert(SQLMAP_SPACE
				+ "addPropertyOption", option);
	}

	@Override
	public long removePropertyOption(Long optionId) {
		return this.sqlMapClient.delete(SQLMAP_SPACE
				+ "removePropertyOptionById", optionId);
	}

	@Override
	public long removePropertyOptionByPropertyId(Long propertyId) {
		return this.sqlMapClient.delete(SQLMAP_SPACE
				+ "removePropertyOptionByPropertyId", propertyId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArtPropertyOption> getAllPropertyOptionByProId(Long propertyId) {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE
				+ "getAllArtPropertyOptionByProId", propertyId);
	}

	@Override
	public Long insertCategory_X_Option(CategoryOptionDTO dto) {
		return (Long) this.sqlMapClient.insert(SQLMAP_SPACE+"insertCategory_X_Option", dto);
	}

	@Override
	public int deleteCategory_X_OptionByOptionId(Long optionID) {
		return this.sqlMapClient.delete(SQLMAP_SPACE+"deleteCategory_X_OptionByOptionId", optionID);
	}

	@Override
	public int countCategory_X_OptionByOptionId(Long opid, Long cid) {
		Map map = new HashMap();
		map.put("opid", opid);
		map.put("cid", cid);
		return (int) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"countCategory_X_OptionByOptionId", map);
	}

	@Override
	public int deleteCategory_X_OptionWithOptionIdAndCategoryId(Long optionID,
			Long categoryId) {
		Map map = new HashMap();
		map.put("optionID", optionID);
		map.put("categoryId", categoryId);
		return this.sqlMapClient.delete(SQLMAP_SPACE+"deleteCategory_X_OptionWithOptionIdAndCategoryId", map);
	}

	@Override
	public ArtPropertyOption getArtPropertyOptionByPropertyIDAndName(
			String name, Long propertyId) {
		Map map = new HashMap();
		map.put("propertyId", propertyId);
		map.put("name", name);
		return (ArtPropertyOption) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"getArtPropertyOptionByPropertyIDAndName", map);
	}

	@Override
	public int countCategory_X_OptionByOption(Long opid) {
		return (int) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"countCategory_X_OptionByOption", opid);
	}


}
