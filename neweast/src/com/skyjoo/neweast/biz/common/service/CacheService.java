package com.skyjoo.neweast.biz.common.service;

import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.art.domain.ArtCategory;
import com.skyjoo.neweast.biz.art.domain.ArtCategoryProperty;


public interface CacheService {
    /**
     * �������Ŀ¼�������б���ʾ��
     * @return
     */
    public List<Map<String, Object>> getArtCategoryNames();
    
    /**
     * ��ȡ������Ŀ
     * @return
     */
    public List<ArtCategory> getArtCategories();
    
    /**
     * ��ȡ��������
     * @return
     */
    public List<ArtCategoryProperty> getArtCategoryProperties();
}
