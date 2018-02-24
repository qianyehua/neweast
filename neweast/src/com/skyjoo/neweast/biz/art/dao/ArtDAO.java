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
 *@date 2014��11��5�� ����11:26:46
 */
public interface ArtDAO {
	
	/**
	 * ͨ����Ŀid��ȡ����Ʒ
	 * @param cetegoryID
	 * @return
	 */
	public List<Art> getArtListByCategoryId(Long cetegoryID);
	
	/**
	 * ͨ��id��ȡ����Ʒ����idΪ�գ����ȡȫ��
	 * @param artId
	 * @return
	 */
	public List<Art> getArtListById(Long artId);
	
	/**
	 * ��ҳ��ѯ,�õ�δ��˵�����Ʒ
	 * @param page
	 * @return
	 */
	public Paginable<ArtCheckQuery> getPaginategArt(Paginable<ArtCheckQuery> page);
	/**
	 * ��ҳ��ѯ���õ����е�����Ʒ
	 * @param page
	 * @return
	 */
	public Paginable<ArtCheckQuery> getPaginategAllArt(Paginable<ArtCheckQuery> page);
	
	/**
	 * ��ȡ����Ʒ�������Ϣ������Ʒ���ʱ�õ��˷���
	 * @param artId
	 * @return
	 */
	public List<Art> getArtInformById(Long artId);
	
	/**
	 * �޸�����Ʒ��Ϣ
	 * @param art
	 * @return
	 */
	public int editArt(Art art);

	/**
	 * �¼ܸ��û��µ���������Ʒ
	 * @param userId
	 * @return
	 */
	public int underCarriageArtByUserId(Long userId);
	
	/**ǿ�� �¼�**/
	public int offshelf(Art art);

	/**���� �����ˮ��¼**/
	public Long addAuditLog(AuditLog log);

	/**
	 * ��ȡ�谭��Ա����������Ʒ���� i.e.��ǰ��������������Ʒ
	 * @param id
	 * @return
	 */
	public int selectArtLimitCountForCancel(Long userId);

    /**
    * ��������Ʒ����Ŀ
    * @param art
    * @return
    */
    public Integer updateCategory(Art art);
    
    /**
     * ��ҳ��ʾҪ�ƹ������Ʒ
     */
    public Paginable<ArtCheckQuery> getPaginatedRecommendArt(Paginable<ArtCheckQuery> page);
    /**
     * ��ҳ��ʾ��ҳ�Ƽ�����Ʒ
     */
    public Paginable<ArtCheckQuery> getPaginatedHomeRecommendArt(Paginable<ArtCheckQuery> page);
    /**
     * ��ҳ��ʾ�������Ʒ
     */
    public Paginable<ArtCheckQuery> getPaginatedActivityXArt(Paginable<ArtCheckQuery> page);

    
    /**
     * ����������id��ȡ����Ʒ�б�
     * @param artiseId
     * @return
     */
    public List<Art> getArtListByArtiseId(Long artiseId);

}
