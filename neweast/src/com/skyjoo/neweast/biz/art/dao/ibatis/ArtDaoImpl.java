/**
*@title
*@author dengjz
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.dao.ibatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.art.dao.ArtDAO;
import com.skyjoo.neweast.biz.art.domain.Art;
import com.skyjoo.neweast.biz.art.domain.AuditLog;
import com.skyjoo.neweast.biz.art.domain.query.ArtCheckQuery;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.common.page.Paginable;

/**
 *@Description 
 *@author dengjz
 *@version 1.0
 *@date 2014年11月5日 上午11:28:32
 */
@SuppressWarnings("deprecation")
@Repository
public class ArtDaoImpl extends BaseDaoiBatis  implements ArtDAO {

	private static final String SQLMAP_SPACE = "ART.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClient;
	
	/**
	 * 通过类目id获取艺术品
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Art> getArtListByCategoryId(Long cetegoryID) {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getArtByCategoryId", cetegoryID);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Art> getArtListById(Long artId) {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getArtById", artId) ;
	}

	@Override
	public Paginable<ArtCheckQuery> getPaginategArt(Paginable<ArtCheckQuery> page) {
		super.paginate(page, SQLMAP_SPACE+"getArtCount", SQLMAP_SPACE+"getArtPage");
		return page;
	}

	@Override
	public Paginable<ArtCheckQuery> getPaginategAllArt(
			Paginable<ArtCheckQuery> page) {
		super.paginate(page, SQLMAP_SPACE+"getAllArtCount", SQLMAP_SPACE+"getPaginatedArtCheckQuery");
		return page;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Art> getArtInformById(Long artId) {
		return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getArtInform", artId);
	}

	@Override
	public int editArt(Art art) {
		return this.sqlMapClient.update(SQLMAP_SPACE+"editArt", art);
	}

	
	@Override
	public int underCarriageArtByUserId(Long userId) {
		return this.sqlMapClient.update(SQLMAP_SPACE + "underCarriageByUserId", userId);
	}


	@Override
	public int offshelf(Art art) {
		return this.sqlMapClient.update(SQLMAP_SPACE+"offshelf", art);
	}

	@Override
	public Long addAuditLog(AuditLog log) {
		return (Long) this.sqlMapClient.insert(SQLMAP_SPACE+"addAuditLog", log);
	}

	@Override
	public int selectArtLimitCountForCancel(Long userId) {
		return (Integer) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectLimitCountForCancel", userId);
	}
	
    @Override
    public Integer updateCategory(Art art) {
        return this.sqlMapClient.update(SQLMAP_SPACE + "updateCategory", art);
    }

    @Override
    public Paginable<ArtCheckQuery> getPaginatedRecommendArt(Paginable<ArtCheckQuery> page
                                                           ) {
        super.paginate(page, SQLMAP_SPACE+"getRecommendArtCount", SQLMAP_SPACE+"getPaginatedRecommendArt");
        return page;
    }

    @Override
    public Paginable<ArtCheckQuery> getPaginatedHomeRecommendArt(Paginable<ArtCheckQuery> page) {
        super.paginate(page, SQLMAP_SPACE+"getHomeRecommendArtCount", SQLMAP_SPACE+"getPaginatedHomeRecommendArt");
        return page;
    }
    
    @Override
    public Paginable<ArtCheckQuery> getPaginatedActivityXArt(Paginable<ArtCheckQuery> page
                                                           ) {
        super.paginate(page, SQLMAP_SPACE+"getActivityXArtCount", SQLMAP_SPACE+"getPaginatedActivityXArt");
        return page;
    }

    
    @Override
    public List<Art> getArtListByArtiseId(Long artiseId){
        return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getArtListByArtiseId", artiseId) ;
    }

}
