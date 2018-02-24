package com.skyjoo.neweast.biz.artise.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.artise.dao.ArtiseDAO;
import com.skyjoo.neweast.biz.artise.dao.ArtiseTrendDAO;
import com.skyjoo.neweast.biz.artise.domain.Artise;
import com.skyjoo.neweast.biz.artise.domain.ArtiseTrend;
import com.skyjoo.neweast.biz.artise.domain.query.ArtiseQuery;
import com.skyjoo.neweast.biz.artise.enums.EnumArtiseTrendType;
import com.skyjoo.neweast.biz.artise.service.ArtiseService;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.homepage.dao.HomepageRecommendArtiseDAO;
import com.skyjoo.neweast.biz.homepage.domain.HomepageRecommendArtise;
import com.skyjoo.neweast.biz.message.domain.Message;
import com.skyjoo.neweast.biz.message.enums.EnumMessageStatusType;
import com.skyjoo.neweast.biz.message.enums.EnumMessageType;
import com.skyjoo.neweast.biz.message.service.MessageService;

@Service("artiseService")
public class ArtiseServiceImpl extends BaseManager implements ArtiseService {

    @Autowired
    private ArtiseDAO                  artiseDAO;
    @Autowired
    private ArtiseTrendDAO             artiseTrendDAO;
    @Autowired
    private HomepageRecommendArtiseDAO homepageRecommendArtiseDAO;
    
    @Autowired
    private MessageService  messageService;

    @Override
    public void getArtisePage(ArtiseQuery query) {
        artiseDAO.getArtisePage(query);
    }

    @Override
    public void getCheckArtisePage(ArtiseQuery query) {
        artiseDAO.getCheckArtisePage(query);
    }

    @Override
    public Artise getArtiseById(Long artiseId) {

        return artiseDAO.getArtiseById(artiseId);
    }

    @Override
    public void deleteArtiseById(Long artiseId) {
        int status = 0;
        status = homepageRecommendArtiseDAO.getHomepageRecommendArtiseStatusById(artiseId);
        
         //该艺术家在首页推荐表里面的情况
        if(status!=0)
            {   
            Artise artise = artiseDAO.getArtiseById(artiseId);
            HomepageRecommendArtise homepageRecommendArtise = new HomepageRecommendArtise();
            homepageRecommendArtise.setArtiseId(artise.getArtiseId());
            homepageRecommendArtise.setStatus(-1); //逻辑删除
            homepageRecommendArtise.setOperator(artise.getOperator());
            homepageRecommendArtiseDAO.updataHomepageRecommendArtiseStatusById(homepageRecommendArtise);
        }
        //物理删除
        artiseDAO.deleteArtiseById(artiseId);

    }

    @Override
    public Artise addHomepageRecommendArtiseById(Long artiseId,String operator) {
        int status = 0;
        status = homepageRecommendArtiseDAO.getHomepageRecommendArtiseStatusById(artiseId);
        Artise artise = artiseDAO.getArtiseById(artiseId);

        HomepageRecommendArtise homepageRecommendArtise = new HomepageRecommendArtise();
        homepageRecommendArtise.setArtiseId(artise.getArtiseId());
        homepageRecommendArtise.setOperator(operator);

        //该艺术家已经被推荐的情况下，取消推荐
        if (status != HomepageRecommendArtise.STATUS_DELETE) {
            if (status == HomepageRecommendArtise.STATUS_NORMAL) {
                homepageRecommendArtise.setStatus(HomepageRecommendArtise.STATUS_DELETE);
                homepageRecommendArtiseDAO
                    .updataHomepageRecommendArtiseStatusById(homepageRecommendArtise);
            }
            //推荐表中没有该艺术家的情况。增加推荐艺术家
            else {

                homepageRecommendArtise.setArtiseId(artise.getArtiseId());
                homepageRecommendArtise.setStatus(HomepageRecommendArtise.STATUS_NORMAL);
                homepageRecommendArtise.setOperator(operator);
                homepageRecommendArtiseDAO.addHomepageRecommendArtise(homepageRecommendArtise);

            }
        }
        //该艺术家已经被推荐且被删除的情况下，更新艺术家的信息
        if (status == HomepageRecommendArtise.STATUS_DELETE) {
            homepageRecommendArtise.setStatus(HomepageRecommendArtise.STATUS_NORMAL);

            homepageRecommendArtiseDAO
                .updataHomepageRecommendArtiseStatusById(homepageRecommendArtise);

        }

        return artise;
    }

    @Override
    public int offHomepageRecommendArtiseById(Long artiseId,String operator) {

        Artise artise = artiseDAO.getArtiseById(artiseId);
        HomepageRecommendArtise homepageRecommendArtise = new HomepageRecommendArtise();
        homepageRecommendArtise.setOperator(operator);
        homepageRecommendArtise.setStatus(HomepageRecommendArtise.STATUS_DELETE);
        return homepageRecommendArtiseDAO.updataHomepageRecommendArtiseStatusById(homepageRecommendArtise);
    }

    @Override
    public Long updateArtiseById(Artise artise) {
        Long i = artiseDAO.updateArtiseById(artise);
        if(i>0 && 1 == artise.getStatus()){
            //艺术家入驻
            ArtiseTrend artiseTrend = new ArtiseTrend();
            artiseTrend.setUserId(artise.getUserId());
            artiseTrend.setArtiseId(artise.getArtiseId());
            artiseTrend.setObjectType(EnumArtiseTrendType.JOIN.getValue());
            artiseTrend.setObjectId(artise.getArtiseId());  
            artiseTrendDAO.inserAtriseTrend(artiseTrend);
            
            Artise artise2 = artiseDAO.getArtiseById(artise.getArtiseId());
            
            //艺术家认证通过，插入一条审核信息
            Message msg = new Message();
            msg.setToId(artise2.getUserId());
            msg.setType(EnumMessageType.BECOMEARTIST.getValue());
            msg.setObjectId(artise2.getArtiseId());
            msg.setUrl(artise2.getPortrait());
            msg.setContent("您已成功入驻takung art,开启您愉快的艺术之旅吧！"); //后续添加本地化语言
            msg.setReadStatus(EnumMessageStatusType.UNREAD.getValue());
            messageService.insertMessage(msg);  
        }
        return i;
    }

}
