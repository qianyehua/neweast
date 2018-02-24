package com.skyjoo.neweast.biz.art.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.art.dao.ArtCategoryDAO;
import com.skyjoo.neweast.biz.art.dao.ArtCategoryPropertyDAO;
import com.skyjoo.neweast.biz.art.dao.ArtDAO;
import com.skyjoo.neweast.biz.art.dao.ArtPropertyOptionDAO;
import com.skyjoo.neweast.biz.art.domain.Art;
import com.skyjoo.neweast.biz.art.domain.ArtCategory;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;
import com.skyjoo.neweast.biz.art.domain.ArtPropertyOption;
import com.skyjoo.neweast.biz.art.service.ArtCategoryPropertyService;
import com.skyjoo.neweast.biz.art.service.ArtCategoryService;
import com.skyjoo.neweast.biz.art.service.ArtPropertyOptionService;

@Service
public class ArtCategoryServiceImpl implements ArtCategoryService{

	@Autowired
	private ArtCategoryDAO artCategoryDAO;
	
	@Autowired
	private ArtCategoryPropertyDAO artCategoryPropertyDAO;
	
	@Autowired 
	private ArtPropertyOptionDAO artPropertyOptionDAO;
	
	@Autowired
	private ArtCategoryPropertyService artCategoryPropertyService;
	
	@Autowired 
	private ArtPropertyOptionService artPropertyOptionService;
	
	@Autowired
	private ArtDAO artDAO;
	
	@Override
	public List<ArtCategory> getFirstCategoryList(){
		//��ȡ��ѯ���Ľ����
		List<ArtCategory> categories = artCategoryDAO.getArtFirstCategoryList();
		for(ArtCategory category : categories){
			//������Ŀ�Ƿ���Ա�ɾ��
			category.setCanDeleted(this.canDeleted(category.getId()));
		}
		return categories;
	}

	@Override
	public List<ArtCategory> getCategoryListByParid(Long parId) {
		//��ȡ��ѯ�����
		List<ArtCategory> categories = artCategoryDAO.getArtCategoryListbyParId(parId);
		for(ArtCategory category : categories){
			category.setCanDeleted(this.canDeleted(category.getId()));
		}
		return categories;
	}

	@Override
	public Long addArtFirstCategory(ArtCategory artCategory) {	
		//�ж����ӵ��ǵڼ�����Ŀ
		Long pid = artCategory.getParentId();
		if(pid == 0){
			//�����һ����Ŀ�ͽ���Ŀ������Ϊ1
			artCategory.setCatLevel(1);
		}
		else{
			//������Ƕ�����Ŀ�ͽ���Ŀ������Ϊ2
			artCategory.setCatLevel(2);
		}
		return artCategoryDAO.insertArtFirstCategory(artCategory);
	}

	@Override
	public ArtCategory getCategoryListbyId(Long id) {
		List<ArtCategory> list = artCategoryDAO.getartCategoryListbyId(id);
		if(list != null && list.size() > 0 ){
			ArtCategory category = list.get(0);
			category.setCanDeleted(this.canDeleted(category.getId()));
			category.setCanEditArtCode(this.canEditArtCode(category.getId()));
			return category;
		}
		return null;
	}

	@Override
	public int editArtCategory(ArtCategory artCategory) {
		return artCategoryDAO.editArtCategory(artCategory);
	}

	@Override
	public int removeArtCategory(Long categoryId) {
		
		return this.delete(categoryId);
	}
	
	/**
	 * ɾ����Ŀ
	 * ����һ����Ŀ����ɾ��һ����Ŀ���ٵ���deleteSecendCetegory����ɾ�����ж�����Ŀ
	 * ���Ƕ�����Ŀ��ֱ�ӵ���deleteSecendCetegory����ɾ��
	 * @param categoryId
	 * @return
	 */
	public int delete(Long categoryId){
		ArtCategory artCategory = artCategoryDAO.getartCategoryListbyId(categoryId).get(0);
		if(artCategory.getParentId() == 0){
			//�����Ŀ��һ����Ŀ
			List<ArtCategory> artCategories = artCategoryDAO.getArtCategoryListbyParId(categoryId);
			if(artCategories != null && artCategories.size() > 0){
				for(ArtCategory category : artCategories){
					this.deleteSecendCetegory(category.getId());
				}
			}
			return artCategoryDAO.removeArtCategory(categoryId);
			
		}else{
			return this.deleteSecendCetegory(categoryId);
		}
	}
	
	/**
	 * ɾ��������Ŀ ����Ŀ����ֵ��ɾ�ˣ�
	 * @param categoryId
	 * @return
	 */
	public int deleteSecendCetegory(Long categoryId){
		/*
		//����Ƕ�����Ŀ��Ҫ��ͬɾ�����Ժ�ѡ��
		List<ArtCategoryProperty> properties = artCategoryPropertyDAO.getCategoryPropertyByCatId(categoryId);
		if(properties != null && properties.size() > 0){
			//�����������,�ȵõ���ѡ��
			for(ArtCategoryProperty property : properties){
				//artCategoryPropertyDAO.removeCategoryProperty(property.getId());
				artCategoryPropertyService.removeCategoryProperty(categoryId);
				
				List<ArtPropertyOption> options = artPropertyOptionDAO.getArtPropertyOptionByProId(property.getId(),categoryId);
				if(options != null && options.size() > 0){
					for(ArtPropertyOption option : options){
						//ɾ��ѡ��
						//artPropertyOptionDAO.removePropertyOption(option.getId());
						artPropertyOptionService.deleteOptionByPropertyID(property.getId(), categoryId);
					}						
				}
				
			}
			artCategoryPropertyService.removeCategoryProperty(categoryId);
			return artCategoryDAO.removeArtCategory(categoryId);				
		}else{
			//���û������
			return artCategoryDAO.removeArtCategory(categoryId);
		}*/
		//����Ƕ�����Ŀ��Ҫ��ͬɾ�����Ժ�ѡ��
		artCategoryPropertyService.removeCategoryProperty(categoryId);
		return artCategoryDAO.removeArtCategory(categoryId);	
	}
	
	/**
	 * �ж���Ŀ�Ƿ���Ա�ɾ��
	 * @param categoryId
	 * @return
	 */
	@Override
	public boolean canDeleted(Long categoryId){
		//���жϸ���Ŀ�Ƿ�����Ʒ����
		List<Art> artList = artDAO.getArtListByCategoryId(categoryId);
		if(artList != null && artList.size() > 0){
			//�������Ŀ������Ʒ���ã����ж�����Ʒ��״̬
			for(Art art : artList){
				//�������Ŀ����δ�¼ܵ�����Ʒ���򲻿�ɾ�� 20170728 ��˲�ͨ��Ҳ��ɾ
				if(art.getStatus() != 2 &&art.getStatus() != 4 && art.getStatus() != 7){
					return false;
				}
			}
			return true;
		}else{
			//����Ŀû�б�����Ʒ���� ���ж���һ����Ŀ���Ƕ�����Ŀ
			List<ArtCategory> categories = artCategoryDAO.getartCategoryListbyId(categoryId);
			if(categories != null && categories.size() > 0){
				//�õ�ָ��id����Ŀ
				ArtCategory artCategory = categories.get(0);
				if(artCategory.getParentId() == 0){
					//�����һ����Ŀ,���ж��Ƿ��ж�����Ŀ
					List<ArtCategory> secendCategories = artCategoryDAO.getArtCategoryListbyParId(categoryId);
					if(secendCategories != null && secendCategories.size() > 0){
						//��һ����Ŀ������Ŀ�����ж϶�����Ŀ�Ƿ�����
						for(ArtCategory secendCategory : secendCategories){
							return this.canDeleted(secendCategory.getId());
						}
					}else{
						return true;
					}					
				}else{
					//����Ƕ�����Ŀ�������ɾ��
					return true;
				}				
			}
			return true;
		}
	}
	
	/**
	 * �ж�ǰ׺�Ƿ���Ա��޸�
	 * @param categoryId
	 * @return
	 */
	public boolean canEditArtCode(Long categoryId){
		List<Art> artList = artDAO.getArtListByCategoryId(categoryId);
		if(artList != null && artList.size() > 0){
			for(Art art : artList){
				if(art.getStatus().compareTo(4) != 0){
					return false;
				}
			}
			return true;
		}
		return true;
	}

	@Override
	public int editArtCode(ArtCategory artCategory) {
		return artCategoryDAO.editArtCode(artCategory);
	}

	@Override
	public List<ArtCategory> getCategoryList() {
		return artCategoryDAO.getArtCategoryList();
	}

	/**
     * ����Ӳ˵��б�
     * @param list ����б�
     * @param pid ��id
     * @param id �޸�ʱ�ж�Ҫ�޸ĵ�ԭĿ¼
     * @param psign ��֧����
     * @return
     * @author 
     * @date 2014-11-4
     */
    private List<Map<String, Object>> getSonFunNames(List<Map<String, Object>> list, Long pid,
                                                     Long id, String psign) {
//    	if (pid.longValue() == 0L) {
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("id", 0);
//            map.put("name", "��ѡ��");
//            list.add(map);
//        }
        List<ArtCategory> list_fun = artCategoryDAO.getArtCategoryListbyParId(pid);     
        for (int i = 0; i < list_fun.size(); i++) {
        	ArtCategory fun = list_fun.get(i);
            if (fun.getId().longValue() != id.longValue()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", fun.getId());
                String str = "";
                if (psign.endsWith("��")) {
                    str = psign.substring(0, psign.lastIndexOf("��")) + ";&nbsp; ";
                } else if (psign.endsWith("��")) {
                    str = psign.substring(0, psign.lastIndexOf("��")) + "��";
                }
                if (i == list_fun.size() - 1
                    || (i + 2 == list_fun.size() && list_fun.get(i + 1).getId().longValue() == id
                        .longValue())) {
                    str += "��";
                } else {
                    str += "��";
                }

                map.put("name", str + fun.getName());
                list.add(map);
                getSonFunNames(list, fun.getId(), id, str);
            }
        }
        return list;
    }

	@Override
	public List<Map<String, Object>> getArtCategoryNames() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        return this.getSonFunNames(list, 0L, -1L, "");
	}	
	
    @Override
    public List<ArtCategory> getArtCategoryList() {
        List<ArtCategory> categories = artCategoryDAO.getArtCategoryList();
        if (null != categories && categories.size() > 0) {
            for (ArtCategory category : categories) {
                // �Ƿ��Ƕ�����Ŀ���ǵĻ���ѯ������
                if (category.isSecondCategory()) {
                    List<ArtCategoryProperty> properties = artCategoryPropertyDAO.getAllCategoryPropertyByCatId(category.getId());
                    if (null != properties && properties.size() > 0) {
                        for (ArtCategoryProperty property : properties) {
                            // �Ƿ���ѡ��������,�ǵĻ���ѯ��ѡ��
                            if (property.isSelectProperty()) {
                                List<ArtPropertyOption> options = artPropertyOptionDAO.getArtPropertyOptionByProId(property.getId(),property.getType().equals(1)?-1:category.getId());
                                // ����ѡ��
                                property.setOptions(options);
                            }
                        }
                    }
                    // ��������
                    category.setProperties(properties);
                }
            }
        }
        return categories;
    }
    
    @Override
    public Date getLastModifyCategoryDate() {
        return artCategoryDAO.getLastModifyCategoryDate();
    }
}
