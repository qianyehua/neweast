/**
 * 
 */
package com.skyjoo.neweast.biz.portal.dao;


import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.portal.domain.common.PublicNote;


/**
 * 公告表dao
 * @author liupc
 * @version 1.0
 * @date 2014-11-4 18:02:57
 */
public interface PublicNoteDAO {

	
	/**
	 * 添加一条PublicNote记录 
	 * @param PublicNote
	 * @return
	 */
 	Long addPublicNote(PublicNote publicNote);
 	
 	/**
 	 * 查询一个PublicNote结果集
 	 * @param PublicNoteId
 	 * @return 返回PublicNote对象
 	 */
 	PublicNote getPublicNote(Long publicNoteId);
 	
 	/**
 	 * 分页查询
 	 * @param page
 	 * @return 返回分页对象
 	 */
    public Paginable<PublicNote> getPaginatedCommonPublicNote(Paginable<PublicNote> page);

    /**
     * 审核公告
     * @param PublicNote
     * @return
     */
    Integer verifyPublicNote(PublicNote publicNote);
    
    /**
     * 删除公告
     * @param publicNote
     * @return
     */
    Integer removePublicNote(PublicNote publicNote);
}
