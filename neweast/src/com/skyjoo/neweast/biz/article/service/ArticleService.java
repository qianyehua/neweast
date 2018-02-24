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
	 * ��ҳ��ѯ ��ȡ��������
	 * @param page
	 * @return
	 */
	public Paginable<ArticleCheckQuery> getPaginatedArticle(Paginable<ArticleCheckQuery> page);
	
	/**
	 * ���´���
	 * @param article
	 * @return
	 */
	public Integer addArticle(Article article);
	/**
	 * ����id��ȡ��������
	 * @param id
	 * @return
	 */
	public Article getArticleById(Long id);

	/**
	 * ����������ش���
	 * @param article
	 * @return
	 */
	public Integer update(Article article);
	
	/**
	 * ����ɾ������
	 * @param ids
	 * @return
	 */
	public Integer deleteArticleByIds(String[] ids);
	
	/**
	 * ����������Ϣ
	 * @param article
	 * @return
	 */
	public Integer updateArticle(Article article);
	/**
	 * ����ר��id��ѯ����������Ŀ
	 * @param subjectId
	 * @return
	 */
	public Integer  getArticleCount(Long subjectId);
	/**
	 * ��������id��������������
	 * @param id
	 * @return
	 */
	public Integer updateCommentCount(Long  id);
    /**
     * ɾ����ר������������
     * @param subjectId
     * @return
     */
    public Integer removeArticleBysubjectId(Long subjectId);
	
    /**
     * ����url��ȡ��������΢����������
     * @param url
     * @return
     */
    public String getUrlContent(String url);
    
    /**
     * ����ͼƬ��base64�ϴ�ͼƬ
     * @param imgStr
     * @return
     */
    public Result<String> getUploadPic(String imgStr);
}
