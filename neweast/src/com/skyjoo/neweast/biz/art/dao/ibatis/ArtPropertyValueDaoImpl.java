/**
*@title
*@author dengjz
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.dao.ibatis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.art.dao.ArtPropertyValueDAO;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyValue;

/**
 *@Description 
 *@author dengjz
 *@version 1.0
 *@date 2014年11月5日 下午2:28:34
 */
@SuppressWarnings("deprecation")
@Repository
public class ArtPropertyValueDaoImpl implements ArtPropertyValueDAO {

private static final String SQLMAP_SPACE = "ART_PROPERTY_VALUE.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClient;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ArtPropertyValue> getArtPropertyValuesByArtId(Long artId) {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getArtPropertyValuesByArtId", artId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ArtPropertyValue> getArtPropertyValuesByProId(Long proId) {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getArtPropertyValuesByProId", proId);
	}

    @Override
    public Integer checkArtPropertyValue(String optionId, Long propertyID,
			Long categoryID) {
    	Map   map = new HashMap();
    	map.put("optionId", optionId);
    	map.put("propertyID", propertyID);
    	map.put("categoryID", categoryID);
        return (Integer) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"checkArtPropertyValue", map);
    }

    @Override
    public int removeArtPropertyValue(Long propertyId) {
        return this.sqlMapClient.delete(SQLMAP_SPACE+"removeArtPropertyValue",propertyId);
    }

    @Override
    public int removeArtPropertyValueByDeleteOption(String optionId, Long propertyID,
			Long categoryID) {
    	Map   map = new HashMap();
    	map.put("optionId", optionId);
    	map.put("propertyID", propertyID);
    	map.put("categoryID", categoryID);
        return this.sqlMapClient.delete(SQLMAP_SPACE+"removeArtPropertyValueByDeleteOption",map);
    }

    @Override
    public int updateArtPropertyValue(String optionId, Long propertyID,
			Long categoryID) {
    	Map   map = new HashMap();
    	map.put("optionId", optionId);
    	map.put("propertyID", propertyID);
    	map.put("categoryID", categoryID);
        return this.sqlMapClient.update(SQLMAP_SPACE+"updateArtPropertyValue",map);
    }

    @Override
    public int deleteArtPropertyValueByNull(long propertyId) {
       return this.sqlMapClient.delete(SQLMAP_SPACE+"deleteArtPropertyValueByNull", propertyId);
    }

    
    @Override
    public void addArtPropertyValues(ArtPropertyValue artPropertyValue) {
        this.sqlMapClient.insert(SQLMAP_SPACE+"insert", artPropertyValue);
    }

    @Override
    public void deleteArtPropertyValuesByArtId(Long id) {
        this.sqlMapClient.update(SQLMAP_SPACE+"delete", id);
    }
}
