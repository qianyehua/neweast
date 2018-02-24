package com.skyjoo.neweast.biz.common.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skyjoo.neweast.biz.art.domain.ArtCategory;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;
import com.skyjoo.neweast.biz.art.service.ArtCategoryPropertyService;
import com.skyjoo.neweast.biz.art.service.ArtCategoryService;
import com.skyjoo.neweast.biz.common.service.CacheService;

@Service("cacheService")
public class CacheServiceImpl implements CacheService{
    private Date lastModifyCategoryDate = null;
    private List<Map<String, Object>> categoryNames = new ArrayList<Map<String, Object>>();
    private List<ArtCategory> artCategories = new ArrayList<ArtCategory>();
    private List<ArtCategoryProperty> artCategoryProperties = new ArrayList<ArtCategoryProperty>();
    private Date lastModifyCatPropertyDate = null;
    @Autowired
    private ArtCategoryService  artCategoryService;
    @Autowired
    private ArtCategoryPropertyService artCategoryPropertyService;
    
    public List<Map<String, Object>> getArtCategoryNames(){
        updateArtCategory();
        
        return categoryNames;
    }
    
    public List<ArtCategory> getArtCategories(){
        updateArtCategory();
        
        return artCategories;
    }
    
    public List<ArtCategoryProperty> getArtCategoryProperties(){
        if(artCategoryProperties == null || artCategoryProperties.size() <= 0 || lastModifyCatPropertyDate == null){
            loadArtCategoryProperties();  
        }else{
            Date newModifyCatPropertyDate = artCategoryPropertyService.getLastModifyPropertyDate();
            if(newModifyCatPropertyDate.after(lastModifyCatPropertyDate)){
                loadArtCategoryProperties();
            }
        }
        
        return artCategoryProperties;
    }
    
    private void updateArtCategory(){
        if(categoryNames == null || categoryNames.size() <= 0 || artCategories == null || artCategories.size() <= 0 || lastModifyCategoryDate == null){
            loadArtCategoryNames();
            loadArtCategories();
        }else{
            Date newModifyCategoryDate = artCategoryService.getLastModifyCategoryDate();
            if(newModifyCategoryDate.after(lastModifyCategoryDate)){
                loadArtCategoryNames();
                loadArtCategories();
            }
        }
    }
    
    private void loadArtCategoryNames(){
        lastModifyCategoryDate = new Date();
        categoryNames = artCategoryService.getArtCategoryNames();
    }
    
    private void loadArtCategories(){
        lastModifyCategoryDate = new Date();
        artCategories = artCategoryService.getArtCategoryList();
    }
    
    private void loadArtCategoryProperties(){
        lastModifyCatPropertyDate = new Date();
        artCategoryProperties = artCategoryPropertyService
                .getArtCategoryPropertyListForHomepage();
    }
}
