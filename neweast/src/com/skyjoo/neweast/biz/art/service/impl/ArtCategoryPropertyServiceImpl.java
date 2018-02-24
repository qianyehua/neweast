package com.skyjoo.neweast.biz.art.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.art.dao.ArtCategoryPropertyDAO;
import com.skyjoo.neweast.biz.art.dao.ArtDAO;
import com.skyjoo.neweast.biz.art.dao.ArtPropertyOptionDAO;
import com.skyjoo.neweast.biz.art.dao.ArtPropertyValueDAO;
import com.skyjoo.neweast.biz.art.domain.Art;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryPropertyName;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyOption;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyValue;
import com.skyjoo.neweast.biz.art.domain.CategoryProperty;
import com.skyjoo.neweast.biz.art.service.ArtCategoryPropertyService;
import com.skyjoo.neweast.biz.art.service.ArtPropertyOptionService;

@Service
public class ArtCategoryPropertyServiceImpl implements ArtCategoryPropertyService {

	@Autowired
	private ArtCategoryPropertyDAO artCategoryPropertyDAO;
	
	@Autowired
	private ArtPropertyOptionDAO artPropertyOptionDAO;
	
	@Autowired
	private ArtPropertyValueDAO artPropertyValueDAO;
	
	@Autowired
	private ArtDAO artDAO;
	@Autowired
    private ArtPropertyOptionService  artPropertyOptionService;
	
	@Override
	public List<ArtCategoryProperty> getCategoryPropertyByCatId(Long catId) {
		List<ArtCategoryProperty> properties = artCategoryPropertyDAO.getCategoryPropertyByCatId(catId);
		for(ArtCategoryProperty property : properties){
			property.setCanDeleted(this.canDeleted(property.getId(), catId));
		}
		return properties;
	}

	@Override
	public int editCategoryProperty(ArtCategoryProperty artCategoryProperty) {
		return artCategoryPropertyDAO.editCategoryProperty(artCategoryProperty);
	}

	/*@Override
	public ArtCategoryProperty getCategoryPropertyById(Long propertyId) {
		List<ArtCategoryProperty> list = artCategoryPropertyDAO.getCategoryPropertyById(propertyId);
		if(list != null && list.size() > 0){
			ArtCategoryProperty property = list.get(0);
			property.setCanDeleted(this.canDeleted(property.getId(), null));
			return property;
		}
		return null;
	}*/

	@Override
	public int addCategoryProperty(ArtCategoryProperty artCategoryProperty) {	
		return artCategoryPropertyDAO.addCategoryProperty(artCategoryProperty);
	}

	@Override
	public int removeCategoryProperty(Long propertyId, Long categoryId) {
		return this.delete(propertyId, categoryId);
	}
	
	public int delete(Long propertyId, Long categoryId){
	    int artCount = 0;
	    //�Ƿ���������Ʒ����
	    if(categoryId !=null){
	         artCount = artCategoryPropertyDAO.getartCountByCategoryProperty(propertyId, categoryId);  
	    }else{
	         artCount = artCategoryPropertyDAO.getartCountByPropertyId(propertyId); 
	    }      
        if (artCount == 0) {
            //�ָ���id�õ�����
            ArtCategoryProperty property = artCategoryPropertyDAO.selectPropertyNameById(propertyId);                
            if (property.getPropertyType() == 1 || property.getPropertyType() == 2) {
                //��������ǵ�ѡ���߶�ѡ����ɾ�����Ե�ѡ��
                artPropertyOptionService.deleteOptionByPropertyID(propertyId, categoryId);       
            }
            int valueCount = artCategoryPropertyDAO.getArtValueCount(propertyId, categoryId);
            if(valueCount==0){
                //ɾ������Ʒ�ĸ�����ֵ
                artPropertyValueDAO.removeArtPropertyValue(propertyId);               
            }
            //ȫ������ֱ��ɾ����������.˽�����Բ������������г���Ҳֱ��ɾ��������
            if(categoryId == null ){
                return  removeCategoryPropertyName(propertyId);
            }
            //˽������ɾ�����Թ�����(���������û�б�������Ŀ����ͬʱҲɾ�����Ա�)
            if(getOtherCategoryProperty(propertyId, categoryId)==0 ){            
                removeCategoryPropertyName(propertyId);
            }
            return removeCategoryXProperty(categoryId, propertyId);
            
        } else {
            //2:��ʾ�����Ա������޷���ɾ��
            return 2;
        }
	}
	
	/**
	 * �ж������Ƿ���Ա�ɾ��
	 * @param propertyId
	 * @return
	 */
	public boolean canDeleted(Long propertyId, Long categoryId){
		//�õ�����ֵ
		List<ArtPropertyValue> propertyValues = artPropertyValueDAO.getArtPropertyValuesByProId(propertyId);
		if(propertyValues != null && propertyValues.size() > 0){
			//�������ֵ��Ϊ�գ����θ�������ֵ������Ʒid�õ�����Ʒ
			for(ArtPropertyValue propertyValue : propertyValues){
				List<Art> artList = artDAO.getArtListById(propertyValue.getArtId());
				if(artList != null && artList.size() > 0){
					for(Art art : artList){
						//�������Ʒ״̬Ϊ���¼� �����ɾ��
						if(art.getStatus().compareTo(4) != 0 && art.getStatus().compareTo(2) != 0 && art.getStatus().compareTo(7) != 0 && art.getCategoryId().equals(categoryId) ){
							return false;
						}
					}
				}
			}
			
		}
		return true;
	}

    @Override
    public List<ArtCategoryProperty> getWholeProperty() {     
        return artCategoryPropertyDAO.getWholeProperty();
    }

    @Override
    public Long addnewCategoryProperty(ArtCategoryProperty artCategoryProperty) {   
        return artCategoryPropertyDAO.addnewCategoryProperty(artCategoryProperty);
    }

    @Override
    public Long selectPropertyIdByName(String content) {
        return artCategoryPropertyDAO.selectPropertyIdByName(content);
    }

    @Override
    public Long addCategoryPropertyName(ArtCategoryPropertyName artCategoryPropertyName) {  
        return artCategoryPropertyDAO.addCategoryPropertyName(artCategoryPropertyName);
    }

    @Override
    public Integer getartCategoryPropertyCount(Long nameId, Long categoryId,Long propertyId) {
        return artCategoryPropertyDAO.getartCategoryPropertyCount(nameId, categoryId, propertyId);
    }

    @Override
    public ArtCategoryProperty getNewCategoryPropertyById(Long propertyId, Long categoryId) {
        return artCategoryPropertyDAO.getNewCategoryPropertyById(propertyId,categoryId);
    }

    @Override
    public int editCategoryPropertyName(ArtCategoryProperty artCategoryProperty) {
        return artCategoryPropertyDAO.editCategoryPropertyName(artCategoryProperty);
    }

    @Override
    public Integer getartCountByPropertyId(Long propertyId) {
        return artCategoryPropertyDAO.getartCountByPropertyId(propertyId);
    }

    @Override
    public ArtCategoryProperty selectPropertyNameById(Long nameId) {
        return artCategoryPropertyDAO.selectPropertyNameById(nameId);
    }

    @Override
    public int removeCategoryPropertyName(Long nameId) {
        return artCategoryPropertyDAO.removeCategoryPropertyName(nameId);
    }

    @Override
    public Long addCategoryProperty(CategoryProperty categoryProperty) {
        return artCategoryPropertyDAO.addCategoryProperty(categoryProperty);
    }

    @Override
    public int getOtherCategoryProperty(Long propertyId, Long categoryId) {    
        return artCategoryPropertyDAO.getOtherCategoryProperty(propertyId, categoryId);
    }

    @Override
    public int removeCategoryXProperty(Long categoryId, Long propertyId) {
        return artCategoryPropertyDAO.removeCategoryXProperty(categoryId, propertyId);
    }

    @Override
    public int editCategoryXProperty(Long categoryId, Long newPropertyId, Long oldPropertyId) {
        return artCategoryPropertyDAO.editCategoryXProperty(categoryId, newPropertyId, oldPropertyId);
    }

    @Override
    public Integer getartCountByCategoryProperty(Long propertyId, Long categoryId) {
        return artCategoryPropertyDAO.getartCountByCategoryProperty(propertyId, categoryId);
    }

	@Override
	public int removeCategoryProperty(Long categoryId) {
		List<ArtCategoryProperty> properties = artCategoryPropertyDAO.getCategoryPropertyByCatId(categoryId);
		if(properties != null && properties.size() > 0){
			for(ArtCategoryProperty property : properties){
				int artCount = artCategoryPropertyDAO.getartCountByCategoryProperty(property.getId(), categoryId);  
				Long propertyId = property.getId();
		        if (artCount == 0) {
		                    
		            if (property.getPropertyType() == 1 || property.getPropertyType() == 2) {
		                //��������ǵ�ѡ���߶�ѡ����ɾ�����Ե�ѡ��
		                artPropertyOptionService.deleteOptionByPropertyIDForDeleteCategory(propertyId, categoryId);       
		            }
		            int valueCount = artCategoryPropertyDAO.getArtValueCount(propertyId, categoryId);
		            if(valueCount==0){
		                //ɾ������Ʒ�ĸ�����ֵ
		                artPropertyValueDAO.removeArtPropertyValue(propertyId);               
		            }
		            //˽�����Բ������������г���Ҳֱ��ɾ��������
		            if(getOtherCategoryProperty(propertyId, categoryId)==0 ){            
		                removeCategoryPropertyName(propertyId);
		            }
		            removeCategoryXProperty(categoryId, propertyId);
		        } else {
		            return 2;
		        }
			}
		}
		return 0;
	}

    @Override
    public List<ArtCategoryProperty> getArtCategoryPropertyListForHomepage() {
        List<ArtCategoryProperty> properties = artCategoryPropertyDAO.getArtCategoryPropertys();
        if (null != properties && properties.size() > 0) {
            for (ArtCategoryProperty property : properties) {
                // �Ƿ���ѡ��������,�ǵĻ���ѯ��ѡ��
                if (property.isSelectProperty()) {
                    List<ArtPropertyOption> options = artPropertyOptionDAO
                        .getArtPropertyOptionByProId(property.getId(),property.getCategoryId()==null?-1:property.getCategoryId());
                    //����ѡ��
                    property.setOptions(options);
                }
            }
        }
        return properties;
    }

    @Override
    public Date getLastModifyPropertyDate() {
        return artCategoryPropertyDAO.getLastModifyPropertyDate();
    }
}
