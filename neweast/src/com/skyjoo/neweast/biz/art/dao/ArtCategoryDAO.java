package com.skyjoo.neweast.biz.art.dao;

import java.util.Date;
import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtCategory;

public interface ArtCategoryDAO {
	
	/**
	 * 获取艺术品一级类目
	 */
	public List<ArtCategory> getArtFirstCategoryList();
	
	/**
	 * 获取所有类目
	 * @return
	 */
	public List<ArtCategory> getArtCategoryList();
	
	/**
	 * 通过id获取类目
	 * @param id
	 * @return
	 */
	public List<ArtCategory> getartCategoryListbyId(Long id);
	
	/**
	 * 通过父id获取类目
	 * @param parId
	 * @return
	 */
	public List<ArtCategory> getArtCategoryListbyParId(Long parId);
	
	/**
	 * 插入一级类目录
	 * @param artCategory
	 * @return
	 */
	public Long insertArtFirstCategory(ArtCategory artCategory);
	
	/**
	 * 插入艺术品二级类目
	 * @param artCategory
	 * @return
	 */
	public Long insertArtSecondCategory(ArtCategory artCategory);
	
	/**
	 * 修改指定id的类目
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
	 * @param artCategory
	 * @return
	 */
	public int editArtCode(ArtCategory artCategory);
	
	/**
	 * 验证类目名称唯一性
	 * @param artCategory
	 * @return
	 */
	public int checkCategoryNameUnique(ArtCategory artCategory);
	
	/**
     * 获取最新类目的修改时间
     * @return
     */
    public Date getLastModifyCategoryDate();
}
