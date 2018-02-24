package com.skyjoo.neweast.biz.article.dao;

import java.util.List;

import com.skyjoo.neweast.biz.article.domain.Article;
import com.skyjoo.neweast.biz.article.domain.query.ArticleCheckQuery;
import com.skyjoo.neweast.biz.common.page.Paginable;

public interface ArticleDAO {
	/**
	 * 分页查询,得到全部文章
	 * @param page
	 * @return
	 */
	public Paginable<ArticleCheckQuery> getPaginategArticle(Paginable<ArticleCheckQuery> page);
	
	/**
	 * 文章创建
	 * @param article
	 * @return
	 */
	public Long addArticle(Article article);
	/**
	 * 根据id获取文章详情
	 * @param id
	 * @return
	 */
	public Article getArticleById(Long id);
	/**
	 * 批量删除文章
	 * @param ids
	 * @return
	 */
	public Integer deleteArticleByIds(String[] ids);
	
	/**
	 * 文章编辑
	 * @param article
	 * @return
	 */
	public Integer updateArticle(Article article);
    /**
     * 根据专题id查询其下文章数目
     * @param subjectId
     * @return
     */
    public Integer  getArticleCount(Long subjectId);
    /**
     * 根据文章id更新文章评论数
     * @param id
     * @return
     */
    public Integer updateCommentCount(Long  id);
    /**
     * 删除该专题下所有文章
     * @param subjectId
     * @return
     */
    public Integer removeArticleBysubjectId(Long subjectId);
}
