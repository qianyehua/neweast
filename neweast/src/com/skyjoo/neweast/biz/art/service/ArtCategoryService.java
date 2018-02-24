package com.skyjoo.neweast.biz.art.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.art.domain.ArtCategory;

public interface ArtCategoryService {
	/**
	 * 获取艺术品一级类目
	 * @return List 艺术品类目
	 */
	public List<ArtCategory> getFirstCategoryList();
	
	/**
	 * 通过id获取类目
	 * @param id
	 * @return
	 */
	public ArtCategory getCategoryListbyId(Long id);
	
	/**
	 * 通过父id获取二级类目
	 * @param parId
	 * @return
	 */
	public List<ArtCategory> getCategoryListByParid(Long parId);
	
	/**
	 * 插入一级类目录
	 * @param artCategory
	 * @return
	 */
	public Long addArtFirstCategory(ArtCategory artCategory);

	/**
	 * 修改指定id的类目
	 * @param artCategory
	 * @return
	 */
	public int editArtCategory(ArtCategory artCategory);
	
	/**
	 * 删除指定的类目
	 * @param categoryId
	 * @return
	 */
	public int removeArtCategory(Long categoryId);
	
	/**
	 * 修改艺术品前缀
	 * @param category
	 * @return
	 */
	public int editArtCode(ArtCategory artCategory);
	
	/**
	 * 判断类目是否可以被删除
	 * @param categoryId
	 * @return
	 */
	public boolean canDeleted(Long categoryId);

	/**
	 * 获取所有类目
	 * @return
	 */
	public List<ArtCategory> getCategoryList();
	
	
	 /**
     * 获得所有目录（下拉列表显示）
     * @return
     * @author wm
     */
    public List<Map<String,Object>> getArtCategoryNames();
    
    /**
     * 获取类目列表
     * @return
     */
    public List<ArtCategory> getArtCategoryList();

    /**
     * 获取类目最后更新时间
     * @return
     */
    public Date getLastModifyCategoryDate();
}
