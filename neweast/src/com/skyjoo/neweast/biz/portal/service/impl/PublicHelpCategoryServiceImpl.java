package com.skyjoo.neweast.biz.portal.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.common.base.BaseManager;
import com.skyjoo.neweast.biz.portal.dao.PublicHelpCategoryDAO;
import com.skyjoo.neweast.biz.portal.dao.PublicHelpPropertyDAO;
import com.skyjoo.neweast.biz.portal.domain.common.PublicHelpCategory;
import com.skyjoo.neweast.biz.portal.service.PublicHelpCategoryService;
/**
 * PublicHelpCategoryService实现类
 * @author admin
 * @version 1.0
 * @DATE 2014-11-4 18:04:50
 */
@Service
public class PublicHelpCategoryServiceImpl extends BaseManager 
							implements PublicHelpCategoryService {

	@Autowired
    private PublicHelpCategoryDAO publicHelpCategoryDao;
	
	@Autowired
    private PublicHelpPropertyDAO publicHelpPropertyDAO;

    @Override
    public Long addPublicHelpCategory(PublicHelpCategory publicHelpCategory) {
    	publicHelpCategory.setCatLevel(publicHelpCategoryDao.
    			getLevelById(publicHelpCategory.getParentId())+1);
        return publicHelpCategoryDao.addPublicHelpCategory(publicHelpCategory);
    }

    @Override
    public Integer editPublicHelpCategory(PublicHelpCategory publicHelpCategory) {
        return publicHelpCategoryDao.editPublicHelpCategory(publicHelpCategory);
    }

    @Override
    public PublicHelpCategory getPublicHelpCategoryById(Long id) {
        return publicHelpCategoryDao.getPublicHelpCategoryById(id);
    }

    @Override
    public List<PublicHelpCategory> getPublicHelpCategoryByPid(Long pid) {
        List<PublicHelpCategory> list = publicHelpCategoryDao.
        		getPublicHelpCategoryByPid(pid);
        for (PublicHelpCategory cat : list) {
            if(cat.getCatLevel().compareTo(3)==0){
            	//文章判断
            	Long s = publicHelpPropertyDAO.
            			getPublicHelpPropertyByCatId(cat.getId());
            	if(s!=null&&s!=0L){
            		cat.setCanDeleted(false);
            	}else
            	cat.setCanDeleted(true);
            }else{
            	//子类目判断
            	if (publicHelpCategoryDao.getCategoriesById(cat.getId()) > 0) {
                	cat.setCanDeleted(false);
                } else {
                	cat.setCanDeleted(true);
                }
            }
        }
        return list;
    }

    @Override
    public Integer removePublicHelpCategory(PublicHelpCategory publicHelpCategory) {
        return publicHelpCategoryDao.removePublicHelpCategory(publicHelpCategory);
    }

	@Override
	public List<Map<String, Object>> getPublicHelpCategorySelNames() {
		List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
		return this.getSonCategoryNames(list, 0L, -1L, "");
	}

	private List<Map<String, Object>> getSonCategoryNames(
			List<Map<String, Object>> list, Long pid, Long id, String psign) {
		if (pid.longValue() == 0L) {
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("id", 0);
            map.put("name", "请选择");
            list.add(map);
        }
		
		List<PublicHelpCategory> list_cat = publicHelpCategoryDao.
				getPublicHelpCategoryByPid(pid);
		for (int i = 0; i < list_cat.size(); i++) {
			PublicHelpCategory cat = list_cat.get(i);
            if (cat.getId().longValue() != id.longValue()) {
                Map<String, Object> map = new HashMap<String, Object>();
                map.put("id", cat.getId());
                String str = "";
                //新的第二种 完美展示
                if (psign.endsWith("┗")) {
                    str = psign.substring(0, psign.lastIndexOf("┗")) + ";&nbsp;";
                } else if (psign.endsWith("┣")) {
                    str = psign.substring(0, psign.lastIndexOf("┣")) + "┃";
                }
                if (i == list_cat.size() - 1
                    || (i + 2 == list_cat.size() && list_cat.get(i + 1).
                    getId().longValue() == id.longValue())) {
                    str += "┗";
                } else {
                    str += "┣";
                }

                map.put("name", str + cat.getName());
                list.add(map);
                getSonCategoryNames(list, cat.getId(), id, str);
            }
        }
		return list;
	}

	@Override
	public Integer getCatLevel(Long catId) {
		return publicHelpCategoryDao.getLevelById(catId);
	}

	@Override
	public Integer getCategeoryByName(PublicHelpCategory publicHelpCategory) {
		publicHelpCategory.setCatLevel(publicHelpCategoryDao.
    			getLevelById(publicHelpCategory.getParentId())+1);
		return publicHelpCategoryDao.getCategeoryByName(publicHelpCategory);
	}
}
