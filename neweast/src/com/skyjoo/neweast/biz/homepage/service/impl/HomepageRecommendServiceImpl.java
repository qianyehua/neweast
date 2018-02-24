/**
 * 
 */
package com.skyjoo.neweast.biz.homepage.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.art.dao.ArtCategoryDAO;
import com.skyjoo.neweast.biz.art.dao.ArtDAO;
import com.skyjoo.neweast.biz.art.domain.Art;
import com.skyjoo.neweast.biz.art.domain.ArtCategory;
import com.skyjoo.neweast.biz.common.CommResult;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.homepage.dao.HomepageRecommendDAO;
import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommend;
import com.skyjoo.neweast.biz.homepage.service.HomepageRecommendService;

/**
 * ��ҳ�Ƽ�����Ʒserviceʵ��
 * @date 2014-11-12 10:45:02
 */
@Service
public class HomepageRecommendServiceImpl extends BaseManager implements HomepageRecommendService {
	
	@Autowired
	private HomepageRecommendDAO homepageRecommendDAO;
	@Autowired
	private ArtDAO artDAO;
	@Autowired
	private ArtCategoryDAO artCategoryDAO;
	
	@Value("${recommend.art.max}")
	private Integer maxRecommendArt = 100;
	
	@Override
	public CommResult chRecommend(Long artId, boolean isRecommend, String operator) {
		CommResult result = new CommResult(true);
		
		HomepageRecommend recommend = homepageRecommendDAO.selectHomepageRecommendByArtId(artId);
		if(isRecommend) {//�Ƽ�
			List<Art> arts = artDAO.getArtListById(artId);
			Art art;
			if(arts.isEmpty() || !(art = arts.get(0)).isStatusNormal()) {
				result.setSuccess(false);
				result.setErrorMsg("����Ʒ�쳣");
				return result;
			}
			
			List<ArtCategory> categories = artCategoryDAO.getartCategoryListbyId(art.getCategoryId());
			if(categories.isEmpty()) {
				result.setSuccess(false);
				result.setErrorMsg("����Ʒ�쳣");
				return result;
			}
			
			//������Ŀ�Ƽ��鲻�ܴ�������Ƽ���
			int totalCount = homepageRecommendDAO.selectTotalHomepageRecommendCountByCategroyId(categories.get(0).getId());
			if(totalCount >= maxRecommendArt) {
				result.setSuccess(false);
				result.setErrorMsg("�Ƽ�������������");
				return result;
			}
			
			if(recommend == null) {
				recommend = new HomepageRecommend();
				recommend.setArtId(artId);
				recommend.setArtCategoryId(categories.get(0).getParentId());
				recommend.setStatus(HomepageRecommend.STATUS_NORMAL);
				recommend.setOperator(operator);
				homepageRecommendDAO.insertHomepageRecommend(recommend);
			} else {
				if(!recommend.isNormal()) {
					recommend.setStatus(HomepageRecommend.STATUS_NORMAL);
					recommend.setOperator(operator);
					homepageRecommendDAO.updateHomepageRecommend(recommend);
				}
			}
		} else {//�����Ƽ�
			if(recommend == null) {
				result.setSuccess(false);
				result.setErrorMsg("��Ч����");
			} else {
				recommend.setStatus(HomepageRecommend.STATUS_DELETE);
				recommend.setOperator(operator);
				homepageRecommendDAO.updateHomepageRecommend(recommend);
			}
		}
		
		return result;
	}

    @Override
    public void deleteRecommendByArtId(Long artId) {
        HomepageRecommend recommend = new HomepageRecommend();
        recommend.setArtId(artId);
        recommend.setStatus(HomepageRecommend.STATUS_DELETE);
        homepageRecommendDAO.updateHomepageRecommendByArtId(recommend);
    }
	
	
}
