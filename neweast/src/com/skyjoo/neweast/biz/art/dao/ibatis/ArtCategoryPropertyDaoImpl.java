package com.skyjoo.neweast.biz.art.dao.ibatis;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;
import com.skyjoo.neweast.biz.art.dao.ArtCategoryPropertyDAO;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryPropertyName;
import com.skyjoo.neweast.biz.art.domain.CategoryProperty;

@SuppressWarnings("deprecation")
@Repository
public class ArtCategoryPropertyDaoImpl implements ArtCategoryPropertyDAO {

    private static final String  SQLMAP_SPACE = "ART_CATEGORY_PROPERTY.";

    @Autowired
    private SqlMapClientTemplate sqlMapClient;

    @SuppressWarnings("unchecked")
    @Override
    public List<ArtCategoryProperty> getCategoryPropertyByCatId(Long catId) {
        return this.sqlMapClient.queryForList(SQLMAP_SPACE + "getCategoryPropertyByCatId", catId);
    }

    @Override
    public List<ArtCategoryProperty> getAllCategoryPropertyByCatId(Long catId) {
        return this.sqlMapClient.queryForList(SQLMAP_SPACE + "getAllCategoryPropertyByCatId", catId);
    }
    
    @Override
    public List<ArtCategoryProperty> getArtCategoryPropertys() {
        return (List<ArtCategoryProperty>) this.sqlMapClient
            .queryForList(SQLMAP_SPACE + "getArtCategoryPropertyList");

    }
    
    @Override
    public int editCategoryProperty(ArtCategoryProperty artCategoryProperty) {
        return this.sqlMapClient.update(SQLMAP_SPACE + "editCategoryProperty", artCategoryProperty);
    }

    /*@SuppressWarnings("unchecked")
    @Override
    public List<ArtCategoryProperty> getCategoryPropertyById(Long propertyId) {
        return this.sqlMapClient.queryForList(SQLMAP_SPACE + "getNewCategoryPropertyById1", 
            propertyId);
        //		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getCategoryPropertyById", propertyId);

    }*/

    @Override
    public int addCategoryProperty(ArtCategoryProperty artCategoryProperty) {
        try {
            this.sqlMapClient.insert(SQLMAP_SPACE + "addCategoryProperty", artCategoryProperty);
        } catch (Exception e) {
            return 0;
        }
        return 1;
    }

    @Override
    public int removeCategoryProperty(Long propertyId) {
        return this.sqlMapClient.delete(SQLMAP_SPACE + "removeCatecoryProperty", propertyId);
    }

    @SuppressWarnings("unchecked")
    @Override
    public List<ArtCategoryProperty> getAllPropertyById(Long propertyId) {
        return this.sqlMapClient.queryForList(SQLMAP_SPACE + "getAllPropertybyId", propertyId);
    }

    @Override
    public List<ArtCategoryProperty> getWholeProperty() {
        return this.sqlMapClient.queryForList(SQLMAP_SPACE + "getWholeProperty");
    }

    @Override
    public Long  addnewCategoryProperty(ArtCategoryProperty artCategoryProperty) {
        return (Long) this.sqlMapClient.insert(SQLMAP_SPACE + "addnewCategoryProperty", artCategoryProperty);
    }

    @Override
    public Long selectPropertyIdByName(String content) {
        return (Long) this.sqlMapClient.queryForObject(SQLMAP_SPACE + "selectPropertyIdByName",
            content);
    }

    @Override
    public Long addCategoryPropertyName(ArtCategoryPropertyName artCategoryPropertyName) {
        return (Long) this.sqlMapClient.insert(SQLMAP_SPACE + "addCategoryPropertyName",
            artCategoryPropertyName);
    }

    @SuppressWarnings("unchecked")
    @Override
    public Integer getartCategoryPropertyCount(Long nameId, Long categoryId, Long propertyId) {
        Map map = new HashMap();
        map.put("nameId", nameId);
        map.put("categoryId", categoryId);
        map.put("propertyId", propertyId);
        if (propertyId == null) {
            if (categoryId == null) {
                //增加全局属性的查询去重
                return (Integer) this.sqlMapClient.queryForObject(
                    SQLMAP_SPACE + "selectALLartCategoryPropertyCount", map);
            }
            //增加私有属性的查询去重
            return (Integer) this.sqlMapClient.queryForObject(SQLMAP_SPACE
                                                              + "selectartCategoryPropertyCount",
                map);
        } else {
            //编辑全局属性的去重
            if (categoryId == null) {
                return (Integer) this.sqlMapClient.queryForObject(
                    SQLMAP_SPACE + "getALLartCategoryPropertyCount", map);
            }
            //编辑私有属性的查询去重
            return (Integer) this.sqlMapClient.queryForObject(SQLMAP_SPACE
                                                              + "getartCategoryPropertyCount", map);
        }
    }

    @Override
    public ArtCategoryProperty getNewCategoryPropertyById(Long propertyId,Long categoryId) {
        Map map = new HashMap();
        map.put("categoryId", categoryId);
        map.put("propertyId", propertyId);
        return (ArtCategoryProperty) this.sqlMapClient.queryForObject(
            SQLMAP_SPACE + "getNewCategoryPropertyById", map);
    }

    @Override
    public int editCategoryPropertyName(ArtCategoryProperty artCategoryProperty) {
        return this.sqlMapClient.update(SQLMAP_SPACE + "editCategoryPropertyName",
            artCategoryProperty);
    }

    @Override
    public Integer getartCountByPropertyId(Long propertyId) {
        return (Integer) this.sqlMapClient.queryForObject(SQLMAP_SPACE + "getartCountByPropertyId",
            propertyId);
    }

    @Override
    public int removeCategoryPropertyName(Long nameId) {
        return this.sqlMapClient.delete(SQLMAP_SPACE + "removeCatecoryPropertyName", nameId);
    }

    @Override
    public ArtCategoryProperty selectPropertyNameById(Long nameId) {
        return (ArtCategoryProperty) this.sqlMapClient.queryForObject(
            SQLMAP_SPACE + "selectPropertyNameById", nameId);
    }

    @Override
    public Long addCategoryProperty(CategoryProperty categoryProperty) {
        return (Long) this.sqlMapClient.insert(SQLMAP_SPACE + "addCategoryProperty",
            categoryProperty);
     
    }

    @Override
    public int getOtherCategoryProperty(Long propertyId, Long categoryId) {
        Map map = new HashMap();
        map.put("categoryId", categoryId);
        map.put("propertyId", propertyId);
        return (Integer) this.sqlMapClient.queryForObject(
            SQLMAP_SPACE + "getOtherCategoryProperty", map);
    }

    @Override
    public int removeCategoryXProperty(Long categoryId, Long propertyId) {
        Map map = new HashMap();
        map.put("categoryId", categoryId);
        map.put("propertyId", propertyId);
        return this.sqlMapClient.delete(SQLMAP_SPACE + "removeCategoryXProperty", map);
    }

    @Override
    public int editCategoryXProperty(Long categoryId, Long newPropertyId, Long oldPropertyId) {
        Map map = new HashMap();
        map.put("categoryId", categoryId);
        map.put("newPropertyId", newPropertyId);
        map.put("oldPropertyId", oldPropertyId);
      return this.sqlMapClient.update(SQLMAP_SPACE + "editCategoryXProperty",
          map);
    }

    @Override
    public Integer getartCountByCategoryProperty(Long propertyId, Long categoryId) {
        Map map = new HashMap();
        map.put("categoryId", categoryId);
        map.put("propertyId", propertyId);
        return (Integer) this.sqlMapClient.queryForObject(SQLMAP_SPACE + "getartCountByCategoryProperty",
            map);
    }

    @Override
    public Integer getArtValueCount(Long propertyId, Long categoryId) {
        Map map = new HashMap();
        map.put("categoryId", categoryId);
        map.put("propertyId", propertyId);
        return (Integer) this.sqlMapClient.queryForObject(SQLMAP_SPACE + "getArtValueCount",
            map);
    }
    
    @Override
    public Date getLastModifyPropertyDate() {
        return (Date) this.sqlMapClient.queryForObject(SQLMAP_SPACE + "getLastModifyPropertyDate");

    }
}
