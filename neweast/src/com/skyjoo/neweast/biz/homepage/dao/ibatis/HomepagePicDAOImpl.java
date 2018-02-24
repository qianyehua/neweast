/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.dao.ibatis;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.homepage.dao.HomepagePicDAO;
import com.skyjoo.neweast.biz.homepage.domain.common.HomepagePic;

/**
 * HomepagePicDAO µœ÷¿‡
 * @author liupc
 * @date 2014-11-12 10:50:21
 */
@Repository
public class HomepagePicDAOImpl extends BaseDaoiBatis implements HomepagePicDAO {

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<HomepagePic> getHomepagePic() {
		return  this.getSqlMapClientTemplate().
				queryForList("homepagePic.getHomepagePic");
	}

	@SuppressWarnings("deprecation")
	@Override
	public HomepagePic getHomepagePicById(Long homepagePicId) {
		return(HomepagePic) this.getSqlMapClientTemplate().
				queryForObject("homepagePic.getHomepagePicById",homepagePicId);
	}
	
	@SuppressWarnings("deprecation")
	@Override
	public Long addHomepagePic(HomepagePic homepagePic) {
		return (Long) this.getSqlMapClientTemplate().
				insert("homepagePic.addHomepagePic", homepagePic);
	}

	@SuppressWarnings("deprecation")
	@Override
	public Integer removeHomepagePic(HomepagePic homepagePic) {
		return this.getSqlMapClientTemplate().
				delete("homepagePic.removeHomepagePic", homepagePic);
	}

    @Override
    public Integer updateHomepagePic(HomepagePic homepagePic) {
        return this.getSqlMapClientTemplate().update("homepagePic.updateHomepagePic", homepagePic);
    }

    /**
     * @return
     * @see com.skyjoo.neweast.biz.homepage.dao.HomepagePicDAO#getPCHomepage()
     */
    @Override
    public List<HomepagePic> getPCHomepage() {
        return this.getSqlMapClientTemplate().queryForList("homepagePic.getPCHomepagePic");
    }

    /**
     * @return
     * @see com.skyjoo.neweast.biz.homepage.dao.HomepagePicDAO#getAPPHomepage()
     */
    @Override
    public List<HomepagePic> getAPPHomepage() {
        return this.getSqlMapClientTemplate().queryForList("homepagePic.getAPPHomepagePic");
    }
    /**
     * @return
     * @see com.skyjoo.neweast.biz.homepage.dao.HomepagePicDAO#getAPPHomepage()
     */
    @Override
    public List<HomepagePic> getAPPStartHomepage() {
        return this.getSqlMapClientTemplate().queryForList("homepagePic.getAPPStartHomepagePic");
    }
}
