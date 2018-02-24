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
 *@date 2014��11��6�� ����9:09:27
 */
public interface ArtService {

	/**
	 * ��ҳ��ѯ ��ȡδ��˵�����Ʒ
	 * @param page
	 * @return
	 */
	public Paginable<ArtCheckQuery> getPaginatedArt(Paginable<ArtCheckQuery> page);
	
	/**
	 * ��ҳ��ѯ ��ȡ��������Ʒ
	 * @param page
	 * @return
	 */
	public Paginable<ArtCheckQuery> getPaginatedAllArt(Paginable<ArtCheckQuery> page);
	
	/**
	 * ͨ��id��ȡ����Ʒ����idΪ�գ����ѯȫ��
	 * @param artId
	 * @return
	 */
	public List<Art> getArtListById(Long artId);
	
	/**
	 * ����������id��ȡ����Ʒ�б�
	 * @param artiseId
	 * @return
	 */
	public List<Art> getArtListByArtiseId(Long artiseId);

	/**
	 * ��ȡ����Ʒ�������Ϣ
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

	/**ǿ���¼�**/
	public int offshelf(Art art);

	/**���� �����ˮ��¼**/
	public Long addAuditLog(AuditLog log);
	
    /**
     * �޸�����Ʒ��Ŀ
     * @param art
     */
    public Integer editCategory(Art art);
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
}
