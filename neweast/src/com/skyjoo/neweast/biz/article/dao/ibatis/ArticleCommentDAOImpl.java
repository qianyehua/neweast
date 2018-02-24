package com.skyjoo.neweast.biz.article.dao.ibatis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.article.dao.ArticleCommentDAO;
import com.skyjoo.neweast.biz.article.domain.query.ArticleCommentQuery;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
@Repository("articleCommentDAO")
public class ArticleCommentDAOImpl   extends BaseDaoiBatis  implements  ArticleCommentDAO{
	private static String SQLMAP_SPACE = "ARTICLE_COMMENT.";
	@Autowired
	private SqlMapClientTemplate sqlMapClient;
	@Override
	public void getArticleComment(ArticleCommentQuery articleCommentQuery) {
		this.paginate(articleCommentQuery, SQLMAP_SPACE + "pageCount", SQLMAP_SPACE + "page");
		
	}
    @Override
    public Integer deleteCommentByIds(Long id) { 
        return this.sqlMapClient.delete(SQLMAP_SPACE+"deleteCommentByIds", id);
    }

}
