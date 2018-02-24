package com.skyjoo.neweast.biz.article.service;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import com.google.zxing.WriterException;
import com.hundsun.wudadao.common.Result;
import com.skyjoo.neweast.biz.article.domain.Article;
import com.skyjoo.neweast.biz.article.domain.query.ArticleCheckQuery;
import com.skyjoo.neweast.biz.common.page.Paginable;
import com.skyjoo.neweast.biz.common.upload.UploadFileException;

public interface ArticleService {
	/**
	 * 分页查询 获取所有文章
	 * @param page
	 * @return
	 */
	public Paginable<ArticleCheckQuery> getPaginatedArticle(Paginable<ArticleCheckQuery> page);
	
	/**
	 * 文章创建
	 * @param article
	 * @return
	 */
	public Integer addArticle(Article article);
	/**
	 * 根据id获取文章详情
	 * @param id
	 * @return
	 */
	public Article getArticleById(Long id);

	/**
	 * 更新文章相关处理
	 * @param article
	 * @return
	 */
	public Integer update(Article article);
	
	/**
	 * 批量删除文章
	 * @param ids
	 * @return
	 */
	public Integer deleteArticleByIds(String[] ids);
	
	/**
	 * 更新文章信息
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
	
    /**
     * 根据url获取解析过的微信文章内容
     * @param url
     * @return
     */
    public String getUrlContent(String url);
    
    /**
     * 根据图片的base64上传图片
     * @param imgStr
     * @return
     */
    public Result<String> getUploadPic(String imgStr);
}
