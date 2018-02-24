package com.skyjoo.neweast.biz.article.dao.ibatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.skyjoo.neweast.biz.article.dao.ArticleDAO;
import com.skyjoo.neweast.biz.article.domain.Article;
import com.skyjoo.neweast.biz.article.domain.query.ArticleCheckQuery;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.common.page.Paginable;

@SuppressWarnings("deprecation")
@Repository
public class ArticleDAOImpl extends BaseDaoiBatis  implements ArticleDAO {

	private static final String SQLMAP_SPACE = "ARTICLE.";
	
	@Autowired
	private SqlMapClientTemplate sqlMapClient;

	@Override
	public Paginable<ArticleCheckQuery> getPaginategArticle(Paginable<ArticleCheckQuery> page) {
		super.paginate(page, SQLMAP_SPACE+"getArticleCount", SQLMAP_SPACE+"getPaginatedArticleCheckQuery");
		return page;
	}
	
	@Override
	public Long addArticle(Article article){
		 return (Long) this.getSqlMapClientTemplate().insert(SQLMAP_SPACE + "addArticle", article);
	}

	@Override
	public Article getArticleById(Long id) {
		return (Article)this.sqlMapClient.queryForObject(SQLMAP_SPACE+"getArticleById",id);
	}
	
	@Override
	public Integer deleteArticleByIds(String[] ids){
		 return this.getSqlMapClientTemplate().update(SQLMAP_SPACE + "deleteArticleByIds", ids);
	}
	
	@Override
	public Integer updateArticle(Article article){
		 return (Integer) this.getSqlMapClientTemplate().update(SQLMAP_SPACE + "updateArticle", article);
	}

    @Override
    public Integer getArticleCount(Long subjectId) {
        return (Integer) this.getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "getArticleXSujectCount", subjectId);
    }

    @Override
    public Integer updateCommentCount(Long id) {
        return (Integer) this.getSqlMapClientTemplate().update(SQLMAP_SPACE + "updateCommentCount", id);
    }

    @Override
    public Integer removeArticleBysubjectId(Long subjectId) {
        return (Integer) this.getSqlMapClientTemplate().delete(SQLMAP_SPACE + "removeArticleBysubjectId", subjectId);
    }


}
