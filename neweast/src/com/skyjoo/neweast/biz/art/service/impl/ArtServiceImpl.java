/**
*@title
*@author dengjz
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.service.impl;

import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import com.eyeieye.melos.util.StringUtil;
import com.skyjoo.neweast.biz.art.dao.ArtCategoryDAO;
import com.skyjoo.neweast.biz.art.dao.ArtCategoryPropertyDAO;
import com.skyjoo.neweast.biz.art.dao.ArtDAO;
import com.skyjoo.neweast.biz.art.dao.ArtPropertyOptionDAO;
import com.skyjoo.neweast.biz.art.dao.ArtPropertyValueDAO;
import com.skyjoo.neweast.biz.art.domain.Art;
import com.skyjoo.neweast.biz.art.domain.ArtCategory;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyOption;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyValue;
import com.skyjoo.neweast.biz.art.domain.AuditLog;
import com.skyjoo.neweast.biz.art.domain.query.ArtCheckQuery;
import com.skyjoo.neweast.biz.art.service.ArtService;
import com.skyjoo.neweast.biz.artise.dao.ArtiseDAO;
import com.skyjoo.neweast.biz.artise.dao.ArtiseTrendDAO;
import com.skyjoo.neweast.biz.artise.domain.ArtiseTrend;
import com.skyjoo.neweast.biz.artise.domain.UserFollow;
import com.skyjoo.neweast.biz.artise.enums.EnumArtiseTrendType;
import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.homepage.service.HomepageRecommendService;
import com.skyjoo.neweast.biz.message.domain.Message;
import com.skyjoo.neweast.biz.message.enums.EnumMessageStatusType;
import com.skyjoo.neweast.biz.message.enums.EnumMessageType;
import com.skyjoo.neweast.biz.message.service.MessageService;
import com.skyjoo.neweast.biz.shop.domain.ShopDecorateContent;
import com.skyjoo.neweast.biz.shop.enums.EnumShopDecorateAreaType;
import com.skyjoo.neweast.biz.shop.service.ShopDecorateContentService;

/**
 *@Description 
 *@author dengjz
 *@version 1.0
 *@date 2014��11��6�� ����9:11:07
 */
@Service
public class ArtServiceImpl extends BaseManager implements ArtService {

	@Autowired
	private ArtDAO artDAO;
	
	@Autowired
	private ArtCategoryDAO artCategoryDAO;
	
	@Autowired
	private ArtPropertyValueDAO artPropertyValueDAO;
	
	@Autowired
	private ArtCategoryPropertyDAO artCategoryPropertyDAO;
	
	@Autowired
	private ArtPropertyOptionDAO artPropertyOptionDAO;
	
    @Autowired
    private HomepageRecommendService homepageRecommendService;
    
     @Autowired
    private ShopDecorateContentService shopDecorateContentService;
     
     @Autowired
     private ArtiseTrendDAO artiseTrendDAO;
     
     @Autowired
     private ArtiseDAO artiseDAO;
     
     @Autowired
     private MessageService messageService;
     //private MessageRemoteService messageRemoteService;

    @Autowired
    private TransactionTemplate        transactionTemplate;

    @Override
	public Paginable<ArtCheckQuery> getPaginatedArt(
			Paginable<ArtCheckQuery> page) {
		return  artDAO.getPaginategArt(page); 
	}
	
	@Override
	public Paginable<ArtCheckQuery> getPaginatedAllArt(
			Paginable<ArtCheckQuery> page) {
		return  artDAO.getPaginategAllArt(page); 
	}
	
	/**
	 * ��ȡ����Ʒ����Ŀ ��ʽ��һ����Ŀ->������Ŀ
	 * @param arts
	 * @return
	 */
	public Paginable<ArtCheckQuery> getCategoryContent(Paginable<ArtCheckQuery> arts){	
		Iterator<ArtCheckQuery> iterator = arts.getData().iterator();
		while(iterator.hasNext()){
			ArtCheckQuery artCheckQuery = (ArtCheckQuery) iterator.next();
			//�õ�����Ʒ����Ŀid
			Long categoryId = artCheckQuery.getCategoryId();
			artCheckQuery.setCategoryContent(this.getArtCategory(categoryId)); 
		}
		return arts;
	}
	
	/**
	 * ͨ��id��ѯ����Ʒ  
	 */
	@Override
	public List<Art> getArtListById(Long artId) {
		return artDAO.getArtListById(artId);
	}

	/**
	 * ��ȡ����Ʒ�������Ϣ������Ʒ���ʱ�õ��˷���
	 */
	@Override
	public List<Art> getArtInformById(Long artId) {
		List<Art> artList = artDAO.getArtInformById(artId);
		if(artList != null && artList.size() > 0){
			//����������Ϊ��
			Art art = artList.get(0);
			//�õ�����Ʒ����Ŀ 
			art.setCategoryContent(this.getArtCategory(art.getCategoryId()));
			//�õ�����Ʒ������
			art.setProperty(this.getPropertyContent(art.getId()));
		}
		return artList;	
	}

	/**
	 * ��������Ʒ����Ŀid�õ���Ŀ����ʽΪ�� һ����Ŀ->������Ŀ
	 * @param CategoryId
	 * @return
	 */
	public String getArtCategory(Long CategoryId){
		List<ArtCategory> artCategories = artCategoryDAO.getartCategoryListbyId(CategoryId);//˽������		
		if(artCategories != null && artCategories.size() > 0){
			ArtCategory artCategory = artCategories.get(0);
			//�õ���Ŀ������
			String categoryName = artCategory.getName();
			//�ж���һ����Ŀ���Ƕ�����Ŀ
			if(artCategory.getParentId() == 0){
				//�����һ����Ŀ,ֱ������categoryContent
				return categoryName;
			}
			else{
				//����Ƕ�����Ŀ���ٻ�ȡ����Ŀ������
				String parentCategoryName = artCategoryDAO.getartCategoryListbyId(artCategory.getParentId()).get(0).getName();
				return parentCategoryName+"->"+categoryName;
			}
		}
		return "����Ŀ";
	}
	
	/**
	 * ��������Ʒid�õ����Ը�����
	 * @param artId
	 * @return
	 */
	public String getPropertyContent(Long artId){
		String content = "";
		//��������Ʒid�õ�����ֵ,�ź���
		List<ArtPropertyValue> artPropertyValues = artPropertyValueDAO.getArtPropertyValuesByArtId(artId);
		if(artPropertyValues != null && artPropertyValues.size() > 0){
			//�����������
			for(ArtPropertyValue artPropertyValue : artPropertyValues){
				//�õ�����id
				Long propertyId = artPropertyValue.getPropertyId();
				//�õ�����
				//List<ArtCategoryProperty> properties = artCategoryPropertyDAO.getCategoryPropertyById(propertyId);
				List<ArtCategoryProperty> properties = artCategoryPropertyDAO.getAllPropertyById(propertyId);
				if(properties != null && properties.size() > 0){
					//����ҵ�������
					ArtCategoryProperty property = properties.get(0);
					//�ж����Ÿ���������ѡ�����ͻ����ı�����
					int propertyType = property.getPropertyType();
					if(propertyType == 3 || propertyType == 4){
						//������ı�����
						content += property.getContent()+":"+artPropertyValue.getArtOption();
//						if(property.getIsDeleted().compareTo(1) == 0){
//							content = content + "=��ɾ��";
//						}
						content = content + ";";	
					}else{
						//�����ѡ������
						//�����ѡ���,�ȵø������µ�����ѡ����
						//List<ArtPropertyOption> options = artPropertyOptionDAO.getArtPropertyOptionByProId(property.getId());
						List<ArtPropertyOption> options = artPropertyOptionDAO.getAllPropertyOptionByProId(property.getId());
						//�õ�������Ʒ��ѡ��id �ڱ��ж��id��Ӣ�Ķ�������
						String[] idStr = artPropertyValue.getArtOption().split(",");
						//propertyContent��������ѡ�������
						content = content + property.getContent() + ":";
						//���εõ�ѡ���ֵ
						for(String id : idStr){
							for (ArtPropertyOption option : options) {
								if(id.equals(option.getId().toString())){
									content = content + option.getContent();								
									// if(option.getIsDeleted().compareTo(1) ==
									// 0){
									// content = content + "=��ɾ��";
									// }
									content = content + ";";
								}
							}
						}
					}
				}			
			}
		}
		return content;
	}

	@Override
	public int editArt(Art art) {
	    int i = artDAO.editArt(art);
	    
	    //���ͨ����Ҫ��������Ҷ�̬
        if(i>0&&(5 == art.getStatus() || 1 == art.getStatus())){
            //�жϸ���Ʒ�ǲ����Ѿ���ӹ���̬��Ϣ
            int z = artiseTrendDAO.getArtiseTrendCount(art.getId());
            if(z==0){
                //���������Ҷ�̬��Ϣ��
                ArtiseTrend artiseTrend = new ArtiseTrend();
                artiseTrend.setUserId(art.getUserId());
                artiseTrend.setArtiseId(art.getArtiseId());
                artiseTrend.setObjectType(EnumArtiseTrendType.PUBLISH.getValue());
                artiseTrend.setObjectId(art.getId());  
                artiseTrendDAO.inserAtriseTrend(artiseTrend);
                
                //�����ע����������Ʒ���û���������Ʒ��Ϣ               
                //��ѯ��ע�������ҵ��û��б�
                List<UserFollow> follows = artiseDAO.getUserFollowListByUserID(art.getUserId());
                List<Art>  list_art = artDAO.getArtInformById(art.getId());
                Art art1 = list_art.get(0);
                if(follows != null){
                    for(UserFollow us:follows){
                        //��Ʒ���ͨ����������Ʒ��Ϣ��֪ͨ��ע�������ҵ��û�
                        Message msg = new Message();
                        msg.setArtId(art.getId());
                        msg.setToId(us.getUserId());
                        msg.setType(EnumMessageType.ART.getValue());
                        msg.setObjectId(art.getId());
                        msg.setContent("����ע�������ҷ���������Ʒ���Ͻ�ȥΧ�۰ɣ�"); //������ӱ��ػ�����
                        msg.setReadStatus(EnumMessageStatusType.UNREAD.getValue());
                        messageService.insertMessage(msg); 
                    }
                }
                
                //��Ʒͨ����ˣ������߷�һ����Ϣ
                Message msg = new Message();
                msg.setArtId(art.getId());
                msg.setToId(art.getUserId());
                msg.setType(EnumMessageType.ART.getValue());
                msg.setObjectId(art.getId());
                msg.setContent("��ϲ�����������ġ�"+art1.getName()+"�������ͨ����"); //������ӱ��ػ�����
                msg.setReadStatus(EnumMessageStatusType.UNREAD.getValue());
                messageService.insertMessage(msg);                  
           }
        }	
        
        return i;
	}

	@Override
	public int offshelf(Art art) {
	    //ǿ���¼��Ժ�ͬʱ����Ʒ��ҳ�Ƽ��͵��̵���ҳ�Ƽ�Ҳ���¼�
	    Art preArt =  artDAO.getArtListById(art.getId()).get(0);
	    art.setUserId(preArt.getUserId());
	    int i = artDAO.offshelf(art);
	    //�¼ܳɹ���ɾ����ҳ�Ƽ��͵����Ƽ���
	    if(i>0){
	        //��ҳ����Ʒɾ��
	        homepageRecommendService.deleteRecommendByArtId(art.getId());
	        //��ѯ����װ���Ƿ��д��ڸ�����Ʒ 
	       List<ShopDecorateContent> undefined_recommend =  shopDecorateContentService.getShopDecorateContentByUserId(art.getUserId(), EnumShopDecorateAreaType.UNDEFINED_RECOMMEND.getValue());
	       List<ShopDecorateContent> seller_recommend = shopDecorateContentService.getShopDecorateContentByUserId(art.getUserId(), EnumShopDecorateAreaType.SELLER_RECOMMEND.getValue());
	       //������ڣ���ɾ������Ʒ�������µ���װ�����ݿ�
	       for(ShopDecorateContent ur:undefined_recommend){
	           JSONObject json = JSONObject.fromObject(ur.getContent());
	           List<String> ids = JSONArray.toList(json.getJSONArray("artIds"));
	           for(int y=0;y<ids.size();y++){
	               if((art.getId().toString()).equals(ids.get(y))){
	                   ids.remove(y);
	                   json.put("artIds", JSONArray.fromObject(ids).toString());
	                   //���µ����Ƽ�ҳ��Ʒ
	                   ur.setContent(json.toString());
	                  shopDecorateContentService.editShopDecorateContent(ur);
	               } 
	           }

	       }
	       
           for(ShopDecorateContent ur:seller_recommend){
               JSONObject json = JSONObject.fromObject(ur.getContent());
               List<String> ids = JSONArray.toList(json.getJSONArray("artIds"));
               for(int y=0;y<ids.size();y++){
                   if((art.getId().toString()).equals(ids.get(y))){
                       ids.remove(y);
                       json.put("artIds", JSONArray.fromObject(ids).toString());
                       //���µ����Ƽ�ҳ��Ʒ
                       ur.setContent(json.toString());
                       shopDecorateContentService.editShopDecorateContent(ur);
                   } 
               }
           }       
	        
	    }
		return i; 
	}

	@Override
	public Long addAuditLog(AuditLog log) {
		return artDAO.addAuditLog(log);
	}
	
	public Integer editCategory(final Art art){
        List<ArtCategory> cat = artCategoryDAO.getartCategoryListbyId(art.getCategoryId());
        if(cat == null || cat.size() == 0 || cat.get(0) == null || StringUtil.isBlank(cat.get(0).getArtCode())){
            return -1;
        }
        
        art.setCatCode(cat.get(0).getArtCode());
        
        final Integer id = transactionTemplate.execute(new TransactionCallback<Integer>() {

            @Override
            public Integer doInTransaction(TransactionStatus status) {
                artDAO.updateCategory(art);
                
                //��ɾ������
                artPropertyValueDAO.deleteArtPropertyValuesByArtId(art.getId());
                // ��������
                for (int i = 0; i < art.getArtPropertyValues().size(); i++) {
                    ArtPropertyValue artPropertyValue = art.getArtPropertyValues().get(
                            i);
                    artPropertyValue.setArtId(art.getId());
                    artPropertyValueDAO.addArtPropertyValues(artPropertyValue);
                }
                
                return 1;
            }
        });
        
        return id;
    }

    @Override
    public Paginable<ArtCheckQuery> getPaginatedRecommendArt(Paginable<ArtCheckQuery> page) { 
        return artDAO.getPaginatedRecommendArt(page);
    }

    @Override
    public Paginable<ArtCheckQuery> getPaginatedHomeRecommendArt(Paginable<ArtCheckQuery> page) {
        // TODO Auto-generated method stub
        return artDAO.getPaginatedHomeRecommendArt(page);
    }
    
    @Override
    public Paginable<ArtCheckQuery> getPaginatedActivityXArt(Paginable<ArtCheckQuery> page){
        return artDAO.getPaginatedActivityXArt(page);
    }
    
    public List<Art> getArtListByArtiseId(Long artiseId){
        return artDAO.getArtListByArtiseId(artiseId);
    }

}
