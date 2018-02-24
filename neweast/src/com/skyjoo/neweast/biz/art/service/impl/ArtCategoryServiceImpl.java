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
		//获取查询到的结果集
		List<ArtCategory> categories = artCategoryDAO.getArtFirstCategoryList();
		for(ArtCategory category : categories){
			//设置类目是否可以被删除
			category.setCanDeleted(this.canDeleted(category.getId()));
		}
		return categories;
	}

	@Override
	public List<ArtCategory> getCategoryListByParid(Long parId) {
		//获取查询结果集
		List<ArtCategory> categories = artCategoryDAO.getArtCategoryListbyParId(parId);
		for(ArtCategory category : categories){
			category.setCanDeleted(this.canDeleted(category.getId()));
		}
		return categories;
	}

	@Override
	public Long addArtFirstCategory(ArtCategory artCategory) {	
		//判读增加的是第几级类目
		Long pid = artCategory.getParentId();
		if(pid == 0){
			//如果是一级类目就将类目级别设为1
			artCategory.setCatLevel(1);
		}
		else{
			//如果是是二级类目就将类目级别设为2
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
	 * 删除类目
	 * 若是一级类目，先删除一级类目后再调用deleteSecendCetegory方法删除所有二级类目
	 * 若是二级类目，直接调用deleteSecendCetegory方法删除
	 * @param categoryId
	 * @return
	 */
	public int delete(Long categoryId){
		ArtCategory artCategory = artCategoryDAO.getartCategoryListbyId(categoryId).get(0);
		if(artCategory.getParentId() == 0){
			//如果类目是一级类目
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
	 * 删除二级类目 （类目属性值不删了）
	 * @param categoryId
	 * @return
	 */
	public int deleteSecendCetegory(Long categoryId){
		/*
		//如果是二级类目，要连同删除属性和选项
		List<ArtCategoryProperty> properties = artCategoryPropertyDAO.getCategoryPropertyByCatId(categoryId);
		if(properties != null && properties.size() > 0){
			//如果存在属性,先得到其选项
			for(ArtCategoryProperty property : properties){
				//artCategoryPropertyDAO.removeCategoryProperty(property.getId());
				artCategoryPropertyService.removeCategoryProperty(categoryId);
				
				List<ArtPropertyOption> options = artPropertyOptionDAO.getArtPropertyOptionByProId(property.getId(),categoryId);
				if(options != null && options.size() > 0){
					for(ArtPropertyOption option : options){
						//删除选项
						//artPropertyOptionDAO.removePropertyOption(option.getId());
						artPropertyOptionService.deleteOptionByPropertyID(property.getId(), categoryId);
					}						
				}
				
			}
			artCategoryPropertyService.removeCategoryProperty(categoryId);
			return artCategoryDAO.removeArtCategory(categoryId);				
		}else{
			//如果没有属性
			return artCategoryDAO.removeArtCategory(categoryId);
		}*/
		//如果是二级类目，要连同删除属性和选项
		artCategoryPropertyService.removeCategoryProperty(categoryId);
		return artCategoryDAO.removeArtCategory(categoryId);	
	}
	
	/**
	 * 判断类目是否可以被删除
	 * @param categoryId
	 * @return
	 */
	@Override
	public boolean canDeleted(Long categoryId){
		//先判断该类目是否被艺术品引用
		List<Art> artList = artDAO.getArtListByCategoryId(categoryId);
		if(artList != null && artList.size() > 0){
			//如果该类目被艺术品引用，则判断艺术品的状态
			for(Art art : artList){
				//如果该类目存在未下架的艺术品，则不可删除 20170728 审核不通过也能删
				if(art.getStatus() != 2 &&art.getStatus() != 4 && art.getStatus() != 7){
					return false;
				}
			}
			return true;
		}else{
			//若类目没有被艺术品引用 先判断是一级类目还是二级类目
			List<ArtCategory> categories = artCategoryDAO.getartCategoryListbyId(categoryId);
			if(categories != null && categories.size() > 0){
				//得到指定id的类目
				ArtCategory artCategory = categories.get(0);
				if(artCategory.getParentId() == 0){
					//如果是一级类目,则判断是否有二级类目
					List<ArtCategory> secendCategories = artCategoryDAO.getArtCategoryListbyParId(categoryId);
					if(secendCategories != null && secendCategories.size() > 0){
						//若一级类目有子类目，则判断二级类目是否被引用
						for(ArtCategory secendCategory : secendCategories){
							return this.canDeleted(secendCategory.getId());
						}
					}else{
						return true;
					}					
				}else{
					//如果是二级类目，则可以删除
					return true;
				}				
			}
			return true;
		}
	}
	
	/**
	 * 判断前缀是否可以被修改
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
     * 获得子菜单列表
     * @param list 结果列表
     * @param pid 父id
     * @param id 修改时判断要修改的原目录
     * @param psign 分支符号
     * @return
     * @author 
     * @date 2014-11-4
     */
    private List<Map<String, Object>> getSonFunNames(List<Map<String, Object>> list, Long pid,
                                                     Long id, String psign) {
//    	if (pid.longValue() == 0L) {
//            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("id", 0);
//            map.put("name", "请选择");
//            list.add(map);
//        }
        List<ArtCategory> list_fun = artCategoryDAO.getArtCategoryListbyParId(pid);     
        for (int i = 0; i < list_fun.size(); i++) {
        	ArtCategory fun = list_fun.get(i);
            if (fun.getId().longValue() != id.longValue()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", fun.getId());
                String str = "";
                if (psign.endsWith("┗")) {
                    str = psign.substring(0, psign.lastIndexOf("┗")) + ";&nbsp; ";
                } else if (psign.endsWith("┣")) {
                    str = psign.substring(0, psign.lastIndexOf("┣")) + "┃";
                }
                if (i == list_fun.size() - 1
                    || (i + 2 == list_fun.size() && list_fun.get(i + 1).getId().longValue() == id
                        .longValue())) {
                    str += "┗";
                } else {
                    str += "┣";
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
                // 是否是二级类目，是的话查询其属性
                if (category.isSecondCategory()) {
                    List<ArtCategoryProperty> properties = artCategoryPropertyDAO.getAllCategoryPropertyByCatId(category.getId());
                    if (null != properties && properties.size() > 0) {
                        for (ArtCategoryProperty property : properties) {
                            // 是否是选择类属性,是的话查询其选项
                            if (property.isSelectProperty()) {
                                List<ArtPropertyOption> options = artPropertyOptionDAO.getArtPropertyOptionByProId(property.getId(),property.getType().equals(1)?-1:category.getId());
                                // 设置选项
                                property.setOptions(options);
                            }
                        }
                    }
                    // 设置属性
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
