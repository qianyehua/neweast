package com.skyjoo.neweast.biz.portal.service;

import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.portal.domain.common.PublicNote;

/**
 * 后台公告操作
 * @author liupc
 * @version 1.0 
 * @date 2014-10-31 09:41:07
 */
public interface PublicNoteService {

	/**
	 * 添加一条PublicNote记录
	 * @param publicNote
	 * @return
	 */
	public Long addPublicNote(PublicNote publicNote);
	
	/**
	 * 查询一个PublicNote结果集
	 * @param publicNoteId
	 * @return PublicNote对象
	 */
 	public PublicNote getPublicNote(Long publicNoteId);

 	/**
 	 * 分页查询所有PublicNote结果集
 	 * @param page
 	 * @return 分页对象的集合 
 	 */
    public Paginable<PublicNote> getPaginatedNote(Paginable<PublicNote> page);

    /**
     * 审核公告
     * @param publicNote
     * @return
     */
 	public Integer verifyPublicNote(PublicNote publicNote);
 	
 	/**
 	 * 删除公告
 	 * @param publicNote
 	 * @return
 	 */
 	public Integer removePublicNote(PublicNote publicNote);
}
