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
 *@date 2014年11月6日 上午9:11:07
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
	 * 获取艺术品的类目 格式：一级类目->二级类目
	 * @param arts
	 * @return
	 */
	public Paginable<ArtCheckQuery> getCategoryContent(Paginable<ArtCheckQuery> arts){	
		Iterator<ArtCheckQuery> iterator = arts.getData().iterator();
		while(iterator.hasNext()){
			ArtCheckQuery artCheckQuery = (ArtCheckQuery) iterator.next();
			//得到艺术品的类目id
			Long categoryId = artCheckQuery.getCategoryId();
			artCheckQuery.setCategoryContent(this.getArtCategory(categoryId)); 
		}
		return arts;
	}
	
	/**
	 * 通过id查询艺术品  
	 */
	@Override
	public List<Art> getArtListById(Long artId) {
		return artDAO.getArtListById(artId);
	}

	/**
	 * 获取艺术品的相关信息，艺术品审核时用到此方法
	 */
	@Override
	public List<Art> getArtInformById(Long artId) {
		List<Art> artList = artDAO.getArtInformById(artId);
		if(artList != null && artList.size() > 0){
			//如果结果集不为空
			Art art = artList.get(0);
			//得到艺术品的类目 
			art.setCategoryContent(this.getArtCategory(art.getCategoryId()));
			//得到艺术品的属性
			art.setProperty(this.getPropertyContent(art.getId()));
		}
		return artList;	
	}

	/**
	 * 根据艺术品的类目id得到类目，格式为： 一级类目->二级类目
	 * @param CategoryId
	 * @return
	 */
	public String getArtCategory(Long CategoryId){
		List<ArtCategory> artCategories = artCategoryDAO.getartCategoryListbyId(CategoryId);//私有属性		
		if(artCategories != null && artCategories.size() > 0){
			ArtCategory artCategory = artCategories.get(0);
			//得到类目的名称
			String categoryName = artCategory.getName();
			//判断是一级类目还是二级类目
			if(artCategory.getParentId() == 0){
				//如果是一级类目,直接设置categoryContent
				return categoryName;
			}
			else{
				//如果是二级类目，再获取父类目的名称
				String parentCategoryName = artCategoryDAO.getartCategoryListbyId(artCategory.getParentId()).get(0).getName();
				return parentCategoryName+"->"+categoryName;
			}
		}
		return "无类目";
	}
	
	/**
	 * 根据艺术品id得到属性该内容
	 * @param artId
	 * @return
	 */
	public String getPropertyContent(Long artId){
		String content = "";
		//根据艺术品id得到属性值,排好序
		List<ArtPropertyValue> artPropertyValues = artPropertyValueDAO.getArtPropertyValuesByArtId(artId);
		if(artPropertyValues != null && artPropertyValues.size() > 0){
			//如果存在属性
			for(ArtPropertyValue artPropertyValue : artPropertyValues){
				//得到属性id
				Long propertyId = artPropertyValue.getPropertyId();
				//得到属性
				//List<ArtCategoryProperty> properties = artCategoryPropertyDAO.getCategoryPropertyById(propertyId);
				List<ArtCategoryProperty> properties = artCategoryPropertyDAO.getAllPropertyById(propertyId);
				if(properties != null && properties.size() > 0){
					//如果找到了属性
					ArtCategoryProperty property = properties.get(0);
					//判断书信各类型是是选择类型还是文本类型
					int propertyType = property.getPropertyType();
					if(propertyType == 3 || propertyType == 4){
						//如果是文本类型
						content += property.getContent()+":"+artPropertyValue.getArtOption();
//						if(property.getIsDeleted().compareTo(1) == 0){
//							content = content + "=已删除";
//						}
						content = content + ";";	
					}else{
						//如果是选择类型
						//如果是选择框,先得该属性下的所有选择项
						//List<ArtPropertyOption> options = artPropertyOptionDAO.getArtPropertyOptionByProId(property.getId());
						List<ArtPropertyOption> options = artPropertyOptionDAO.getAllPropertyOptionByProId(property.getId());
						//得到该艺术品的选项id 在表中多个id以英文逗号连接
						String[] idStr = artPropertyValue.getArtOption().split(",");
						//propertyContent保存属性选项的内容
						content = content + property.getContent() + ":";
						//依次得到选项的值
						for(String id : idStr){
							for (ArtPropertyOption option : options) {
								if(id.equals(option.getId().toString())){
									content = content + option.getContent();								
									// if(option.getIsDeleted().compareTo(1) ==
									// 0){
									// content = content + "=已删除";
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
	    
	    //审核通过需要添加艺术家动态
        if(i>0&&(5 == art.getStatus() || 1 == art.getStatus())){
            //判断该作品是不是已经添加过动态信息
            int z = artiseTrendDAO.getArtiseTrendCount(art.getId());
            if(z==0){
                //插入艺术家动态信息表
                ArtiseTrend artiseTrend = new ArtiseTrend();
                artiseTrend.setUserId(art.getUserId());
                artiseTrend.setArtiseId(art.getArtiseId());
                artiseTrend.setObjectType(EnumArtiseTrendType.PUBLISH.getValue());
                artiseTrend.setObjectId(art.getId());  
                artiseTrendDAO.inserAtriseTrend(artiseTrend);
                
                //插入关注该艺术家作品的用户，发送作品消息               
                //查询关注该艺术家的用户列表
                List<UserFollow> follows = artiseDAO.getUserFollowListByUserID(art.getUserId());
                List<Art>  list_art = artDAO.getArtInformById(art.getId());
                Art art1 = list_art.get(0);
                if(follows != null){
                    for(UserFollow us:follows){
                        //作品审核通过，创建作品消息，通知关注该艺术家的用户
                        Message msg = new Message();
                        msg.setArtId(art.getId());
                        msg.setToId(us.getUserId());
                        msg.setType(EnumMessageType.ART.getValue());
                        msg.setObjectId(art.getId());
                        msg.setContent("您关注的艺术家发布了新作品，赶紧去围观吧！"); //后续添加本地化语言
                        msg.setReadStatus(EnumMessageStatusType.UNREAD.getValue());
                        messageService.insertMessage(msg); 
                    }
                }
                
                //作品通过审核，给作者发一个消息
                Message msg = new Message();
                msg.setArtId(art.getId());
                msg.setToId(art.getUserId());
                msg.setType(EnumMessageType.ART.getValue());
                msg.setObjectId(art.getId());
                msg.setContent("恭喜您！您发布的《"+art1.getName()+"》已审核通过。"); //后续添加本地化语言
                msg.setReadStatus(EnumMessageStatusType.UNREAD.getValue());
                messageService.insertMessage(msg);                  
           }
        }	
        
        return i;
	}

	@Override
	public int offshelf(Art art) {
	    //强制下架以后，同时艺术品首页推荐和店铺的首页推荐也得下架
	    Art preArt =  artDAO.getArtListById(art.getId()).get(0);
	    art.setUserId(preArt.getUserId());
	    int i = artDAO.offshelf(art);
	    //下架成功，删除首页推荐和店铺推荐的
	    if(i>0){
	        //首页艺术品删除
	        homepageRecommendService.deleteRecommendByArtId(art.getId());
	        //查询店铺装修是否有存在该艺术品 
	       List<ShopDecorateContent> undefined_recommend =  shopDecorateContentService.getShopDecorateContentByUserId(art.getUserId(), EnumShopDecorateAreaType.UNDEFINED_RECOMMEND.getValue());
	       List<ShopDecorateContent> seller_recommend = shopDecorateContentService.getShopDecorateContentByUserId(art.getUserId(), EnumShopDecorateAreaType.SELLER_RECOMMEND.getValue());
	       //如果存在，则删除艺术品，并更新店铺装修数据库
	       for(ShopDecorateContent ur:undefined_recommend){
	           JSONObject json = JSONObject.fromObject(ur.getContent());
	           List<String> ids = JSONArray.toList(json.getJSONArray("artIds"));
	           for(int y=0;y<ids.size();y++){
	               if((art.getId().toString()).equals(ids.get(y))){
	                   ids.remove(y);
	                   json.put("artIds", JSONArray.fromObject(ids).toString());
	                   //更新店铺推荐页产品
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
                       //更新店铺推荐页产品
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
                
                //先删除属性
                artPropertyValueDAO.deleteArtPropertyValuesByArtId(art.getId());
                // 新增属性
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
