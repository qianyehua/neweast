package com.skyjoo.neweast.biz.art.dao.ibatis;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.art.dao.ArtCategoryDAO;
import com.skyjoo.neweast.biz.art.domain.ArtCategory;
@SuppressWarnings("deprecation")
@Repository
public class ArtCategoryDaoImpl implements ArtCategoryDAO {

	private static final String SQLMAP_SPACE = "ART_CATEGORY.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClient;
	
	@SuppressWarnings({ "unchecked" })
	@Override
	public List<ArtCategory> getArtFirstCategoryList() {
		return (List<ArtCategory>)this.sqlMapClient.queryForList(SQLMAP_SPACE + "getArtFirstCategoryList");
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArtCategory> getArtCategoryListbyParId(Long parId) {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getArtCategoryListByParId",parId);
	}

	@Override
	public Long insertArtFirstCategory(ArtCategory artCategory) {		
		return (Long) this.sqlMapClient.insert(SQLMAP_SPACE+"addFirstCategory", artCategory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArtCategory> getartCategoryListbyId(Long id) {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getArtCategoryListById", id) ;
	}

	@Override
	public Long insertArtSecondCategory(ArtCategory artCategory) {
		this.sqlMapClient.insert(SQLMAP_SPACE+"addFirstCategory", artCategory);
		return 1l;
	}

	@Override
	public int editArtCategory(ArtCategory artCategory) {
		return this.sqlMapClient.update(SQLMAP_SPACE+"editArtCategory",artCategory);
	}

	@Override
	public int removeArtCategory(Long categoryId) {
		return this.sqlMapClient.update(SQLMAP_SPACE+"removeArtCategory",categoryId);
	}

	@Override
	public int editArtCode(ArtCategory artCategory) {
		return this.sqlMapClient.update(SQLMAP_SPACE+"editArtCode",artCategory);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArtCategory> getArtCategoryList() {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getArtCategoryList");
	}

	@Override
	public int checkCategoryNameUnique(ArtCategory artCategory) {
		return (Integer) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"getCountByCategoryName", artCategory);
	}

    @Override
    public Date getLastModifyCategoryDate() {
        return (Date) this.sqlMapClient.queryForObject(SQLMAP_SPACE + "getLastModifyCategoryDate");
    }
}
