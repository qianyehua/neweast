package com.skyjoo.neweast.biz.art.service;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.skyjoo.neweast.biz.art.domain.ArtCategory;

public interface ArtCategoryService {
	/**
	 * ��ȡ����Ʒһ����Ŀ
	 * @return List ����Ʒ��Ŀ
	 */
	public List<ArtCategory> getFirstCategoryList();
	
	/**
	 * ͨ��id��ȡ��Ŀ
	 * @param id
	 * @return
	 */
	public ArtCategory getCategoryListbyId(Long id);
	
	/**
	 * ͨ����id��ȡ������Ŀ
	 * @param parId
	 * @return
	 */
	public List<ArtCategory> getCategoryListByParid(Long parId);
	
	/**
	 * ����һ����Ŀ¼
	 * @param artCategory
	 * @return
	 */
	public Long addArtFirstCategory(ArtCategory artCategory);

	/**
	 * �޸�ָ��id����Ŀ
	 * @param artCategory
	 * @return
	 */
	public int editArtCategory(ArtCategory artCategory);
	
	/**
	 * ɾ��ָ������Ŀ
	 * @param categoryId
	 * @return
	 */
	public int removeArtCategory(Long categoryId);
	
	/**
	 * �޸�����Ʒǰ׺
	 * @param category
	 * @return
	 */
	public int editArtCode(ArtCategory artCategory);
	
	/**
	 * �ж���Ŀ�Ƿ���Ա�ɾ��
	 * @param categoryId
	 * @return
	 */
	public boolean canDeleted(Long categoryId);

	/**
	 * ��ȡ������Ŀ
	 * @return
	 */
	public List<ArtCategory> getCategoryList();
	
	
	 /**
     * �������Ŀ¼�������б���ʾ��
     * @return
     * @author wm
     */
    public List<Map<String,Object>> getArtCategoryNames();
    
    /**
     * ��ȡ��Ŀ�б�
     * @return
     */
    public List<ArtCategory> getArtCategoryList();

    /**
     * ��ȡ��Ŀ������ʱ��
     * @return
     */
    public Date getLastModifyCategoryDate();
}
