package com.skyjoo.neweast.biz.art.dao;

import java.util.Date;
import java.util.List;

import com.skyjoo.neweast.biz.art.domain.ArtCategory;

public interface ArtCategoryDAO {
	
	/**
	 * ��ȡ����Ʒһ����Ŀ
	 */
	public List<ArtCategory> getArtFirstCategoryList();
	
	/**
	 * ��ȡ������Ŀ
	 * @return
	 */
	public List<ArtCategory> getArtCategoryList();
	
	/**
	 * ͨ��id��ȡ��Ŀ
	 * @param id
	 * @return
	 */
	public List<ArtCategory> getartCategoryListbyId(Long id);
	
	/**
	 * ͨ����id��ȡ��Ŀ
	 * @param parId
	 * @return
	 */
	public List<ArtCategory> getArtCategoryListbyParId(Long parId);
	
	/**
	 * ����һ����Ŀ¼
	 * @param artCategory
	 * @return
	 */
	public Long insertArtFirstCategory(ArtCategory artCategory);
	
	/**
	 * ��������Ʒ������Ŀ
	 * @param artCategory
	 * @return
	 */
	public Long insertArtSecondCategory(ArtCategory artCategory);
	
	/**
	 * �޸�ָ��id����Ŀ
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
	 * @param artCategory
	 * @return
	 */
	public int editArtCode(ArtCategory artCategory);
	
	/**
	 * ��֤��Ŀ����Ψһ��
	 * @param artCategory
	 * @return
	 */
	public int checkCategoryNameUnique(ArtCategory artCategory);
	
	/**
     * ��ȡ������Ŀ���޸�ʱ��
     * @return
     */
    public Date getLastModifyCategoryDate();
}
