/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.homepage.dao.HomepagePicDAO;
import com.skyjoo.neweast.biz.homepage.domain.common.HomepagePic;
import com.skyjoo.neweast.biz.homepage.service.HomepagePicService;

/**
 * HomepagePicService µœ÷¿‡
 * @author liupc
 * @date 2014-11-12 10:46:10
 */
@Service
public class HomepagePicServiceImpl extends BaseManager implements
		HomepagePicService {
	
	@Autowired
	private HomepagePicDAO homepagePicDAO;
	
	
	@Override
	public List<HomepagePic> getHomepagePic() {
		return homepagePicDAO.getHomepagePic();
	}

	@Override
	public HomepagePic getHomepagePicById(Long homepagePicId) {
		return homepagePicDAO.getHomepagePicById(homepagePicId);
	}
	
	@Override
	public Long addHomepagePic(HomepagePic homepagePic) {
		return homepagePicDAO.addHomepagePic(homepagePic);
	}

	@Override
	public Integer removeHomepagePic(HomepagePic homepagePic) {
		return homepagePicDAO.removeHomepagePic(homepagePic);
	}

    @Override
    public Integer updateHomepagePic(HomepagePic homepagePic) {
        return homepagePicDAO.updateHomepagePic(homepagePic);
    }

    /**
     * @return
     * @see com.skyjoo.neweast.biz.homepage.service.HomepagePicService#getPCHomepage()
     */
    @Override
    public List<HomepagePic> getPCHomepage() {
        return homepagePicDAO.getPCHomepage();
    }

    /**
     * @return
     * @see com.skyjoo.neweast.biz.homepage.service.HomepagePicService#getAPPHomepage()
     */
    @Override
    public List<HomepagePic> getAPPHomepage() {
        return homepagePicDAO.getAPPHomepage();
    }
    
    @Override
    public List<HomepagePic> getAPPStartHomepage() {
        return homepagePicDAO.getAPPStartHomepage();
    }
}
