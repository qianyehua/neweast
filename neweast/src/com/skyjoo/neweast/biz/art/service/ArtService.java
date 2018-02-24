/**
*@title
*@author dengjz
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.service;

import java.util.List;

import com.skyjoo.neweast.biz.art.domain.Art;
import com.skyjoo.neweast.biz.art.domain.AuditLog;
import com.skyjoo.neweast.biz.art.domain.query.ArtCheckQuery;
import com.skyjoo.neweast.biz.common.page.Paginable;

/**
 *@Description 
 *@author dengjz
 *@version 1.0
 *@date 2014年11月6日 上午9:09:27
 */
public interface ArtService {

	/**
	 * 分页查询 获取未审核的艺术品
	 * @param page
	 * @return
	 */
	public Paginable<ArtCheckQuery> getPaginatedArt(Paginable<ArtCheckQuery> page);
	
	/**
	 * 分页查询 获取所有艺术品
	 * @param page
	 * @return
	 */
	public Paginable<ArtCheckQuery> getPaginatedAllArt(Paginable<ArtCheckQuery> page);
	
	/**
	 * 通过id获取艺术品，若id为空，则查询全部
	 * @param artId
	 * @return
	 */
	public List<Art> getArtListById(Long artId);
	
	/**
	 * 根据艺术家id获取艺术品列表
	 * @param artiseId
	 * @return
	 */
	public List<Art> getArtListByArtiseId(Long artiseId);

	/**
	 * 获取艺术品的相关信息
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

	/**强制下架**/
	public int offshelf(Art art);

	/**新增 审核流水记录**/
	public Long addAuditLog(AuditLog log);
	
    /**
     * 修改艺术品类目
     * @param art
     */
    public Integer editCategory(Art art);
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
}
