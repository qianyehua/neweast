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
        
         //������������ҳ�Ƽ�����������
        if(status!=0)
            {   
            Artise artise = artiseDAO.getArtiseById(artiseId);
            HomepageRecommendArtise homepageRecommendArtise = new HomepageRecommendArtise();
            homepageRecommendArtise.setArtiseId(artise.getArtiseId());
            homepageRecommendArtise.setStatus(-1); //�߼�ɾ��
            homepageRecommendArtise.setOperator(artise.getOperator());
            homepageRecommendArtiseDAO.updataHomepageRecommendArtiseStatusById(homepageRecommendArtise);
        }
        //����ɾ��
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

        //���������Ѿ����Ƽ�������£�ȡ���Ƽ�
        if (status != HomepageRecommendArtise.STATUS_DELETE) {
            if (status == HomepageRecommendArtise.STATUS_NORMAL) {
                homepageRecommendArtise.setStatus(HomepageRecommendArtise.STATUS_DELETE);
                homepageRecommendArtiseDAO
                    .updataHomepageRecommendArtiseStatusById(homepageRecommendArtise);
            }
            //�Ƽ�����û�и������ҵ�����������Ƽ�������
            else {

                homepageRecommendArtise.setArtiseId(artise.getArtiseId());
                homepageRecommendArtise.setStatus(HomepageRecommendArtise.STATUS_NORMAL);
                homepageRecommendArtise.setOperator(operator);
                homepageRecommendArtiseDAO.addHomepageRecommendArtise(homepageRecommendArtise);

            }
        }
        //���������Ѿ����Ƽ��ұ�ɾ��������£����������ҵ���Ϣ
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
            //��������פ
            ArtiseTrend artiseTrend = new ArtiseTrend();
            artiseTrend.setUserId(artise.getUserId());
            artiseTrend.setArtiseId(artise.getArtiseId());
            artiseTrend.setObjectType(EnumArtiseTrendType.JOIN.getValue());
            artiseTrend.setObjectId(artise.getArtiseId());  
            artiseTrendDAO.inserAtriseTrend(artiseTrend);
            
            Artise artise2 = artiseDAO.getArtiseById(artise.getArtiseId());
            
            //��������֤ͨ��������һ�������Ϣ
            Message msg = new Message();
            msg.setToId(artise2.getUserId());
            msg.setType(EnumMessageType.BECOMEARTIST.getValue());
            msg.setObjectId(artise2.getArtiseId());
            msg.setUrl(artise2.getPortrait());
            msg.setContent("���ѳɹ���פtakung art,��������������֮�ðɣ�"); //������ӱ��ػ�����
            msg.setReadStatus(EnumMessageStatusType.UNREAD.getValue());
            messageService.insertMessage(msg);  
        }
        return i;
    }

}
