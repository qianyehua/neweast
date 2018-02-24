/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.dao.ibatis;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.homepage.dao.HomepageRecommendDAO;
import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommend;

/**
 * 首页推荐艺术品DAO实现类
 * @date 2014-11-12 10:50:01
 */
@Repository
@SuppressWarnings("deprecation")
public class HomepageRecommendDAOImpl extends BaseDaoiBatis implements
		HomepageRecommendDAO {

	private static String SQLMAP_SPACE = "HOMEPAGE_RECOMMEND.";
	
	@Override
	public Long insertHomepageRecommend(HomepageRecommend recommend) {
		return (Long) getSqlMapClientTemplate().insert(SQLMAP_SPACE + "insert", recommend);
	}

	@Override
	public HomepageRecommend selectHomepageRecommendByArtId(Long artId) {
		return (HomepageRecommend) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectByArtId", artId);
	}

	@Override
	public int updateHomepageRecommend(HomepageRecommend recommend) {
		return getSqlMapClientTemplate().update(SQLMAP_SPACE + "update", recommend);
	}

	@Override
	public int selectTotalHomepageRecommendCountByCategroyId(Long categroyId) {
		return (Integer) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectTotalCount", categroyId);
	}

    @Override
    public int updateHomepageRecommendByArtId(HomepageRecommend recommend) {
        return getSqlMapClientTemplate().update(SQLMAP_SPACE + "updateByArtId", recommend);
    }

	

}
