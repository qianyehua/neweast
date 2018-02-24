/**
*@title
*@author dengjz
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.dao;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.Art;
import com.skyjoo.neweast.biz.art.domain.AuditLog;
import com.skyjoo.neweast.biz.art.domain.query.ArtCheckQuery;
import com.skyjoo.neweast.biz.common.page.Paginable;

/**
 *@Description 
 *@author dengjz
 *@version 1.0
 *@date 2014年11月5日 上午11:26:46
 */
public interface ArtDAO {
	
	/**
	 * 通过类目id获取艺术品
	 * @param cetegoryID
	 * @return
	 */
	public List<Art> getArtListByCategoryId(Long cetegoryID);
	
	/**
	 * 通过id获取艺术品，若id为空，则获取全部
	 * @param artId
	 * @return
	 */
	public List<Art> getArtListById(Long artId);
	
	/**
	 * 分页查询,得到未审核的艺术品
	 * @param page
	 * @return
	 */
	public Paginable<ArtCheckQuery> getPaginategArt(Paginable<ArtCheckQuery> page);
	/**
	 * 分页查询，得到所有的艺术品
	 * @param page
	 * @return
	 */
	public Paginable<ArtCheckQuery> getPaginategAllArt(Paginable<ArtCheckQuery> page);
	
	/**
	 * 获取艺术品的相关信息，艺术品审核时用到此方法
	 * @param artId
	 * @return
	 */
	public List<Art> getArtInformById(Long artId);
	
	/**
	 * 修改艺术品信息
	 * @param art
	 * @return
	 */
	public int editArt(Art art);

	/**
	 * 下架该用户下的所有艺术品
	 * @param userId
	 * @return
	 */
	public int underCarriageArtByUserId(Long userId);
	
	/**强制 下架**/
	public int offshelf(Art art);

	/**新增 审核流水记录**/
	public Long addAuditLog(AuditLog log);

	/**
	 * 获取阻碍会员销户的艺术品数量 i.e.当前发布正常的艺术品
	 * @param id
	 * @return
	 */
	public int selectArtLimitCountForCancel(Long userId);

    /**
    * 更新艺术品的类目
    * @param art
    * @return
    */
    public Integer updateCategory(Art art);
    
    /**
     * 分页显示要推广的艺术品
     */
    public Paginable<ArtCheckQuery> getPaginatedRecommendArt(Paginable<ArtCheckQuery> page);
    /**
     * 分页显示首页推荐艺术品
     */
    public Paginable<ArtCheckQuery> getPaginatedHomeRecommendArt(Paginable<ArtCheckQuery> page);
    /**
     * 分页显示活动的艺术品
     */
    public Paginable<ArtCheckQuery> getPaginatedActivityXArt(Paginable<ArtCheckQuery> page);

    
    /**
     * 根据艺术家id获取艺术品列表
     * @param artiseId
     * @return
     */
    public List<Art> getArtListByArtiseId(Long artiseId);

}
