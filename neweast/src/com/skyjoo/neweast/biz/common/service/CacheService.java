package com.skyjoo.neweast.biz.common.service;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.art.domain.ArtCategory;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;


public interface CacheService {
    /**
     * 获得所有目录（下拉列表显示）
     * @return
     */
    public List<Map<String, Object>> getArtCategoryNames();
    
    /**
     * 获取所有类目
     * @return
     */
    public List<ArtCategory> getArtCategories();
    
    /**
     * 获取所有属性
     * @return
     */
    public List<ArtCategoryProperty> getArtCategoryProperties();
}
