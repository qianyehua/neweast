package com.skyjoo.neweast.biz.article.dao.ibatis;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.orm.ibatis.SqlMapClientTemplate;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.skyjoo.neweast.biz.article.dao.ArticleRecommendArtDAO;
import com.skyjoo.neweast.biz.article.domain.ArticleRecommendArt;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;

@Repository("articleRecommendArtDAO")
public class ArticleRecommendArtDAOImpl extends BaseDaoiBatis implements ArticleRecommendArtDAO {
    private static String SQLMAP_SPACE = "ARTICLE_RECOMMEND_ART.";
    @Autowired
    private SqlMapClientTemplate sqlMapClient;
    @Override
    public List<ArticleRecommendArt> getRecommendArtByArticleId(Long articleId) {
        return this.sqlMapClient.queryForList(SQLMAP_SPACE+"getRecommendArtByArticleId",articleId);
    }
    @Override
    public List<Long> batchInsertRecommendArt(final List<ArticleRecommendArt> Recommendarts) {
        return this.sqlMapClient.execute(new SqlMapClientCallback<List<Long>>() {
            
            @Override
            public List<Long> doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                List<Long> ids = new ArrayList<Long>();
                executor.startBatch();
                for (ArticleRecommendArt ss : Recommendarts) {
                    ids.add((Long) executor.insert(SQLMAP_SPACE + "insert", ss));
                }
                executor.executeBatch();
                return ids;
            }
        });
       
    }
    @Override
    public ArticleRecommendArt getRecommendArt(Long id) {
        return (ArticleRecommendArt) this.sqlMapClient.queryForObject(SQLMAP_SPACE+"getRecommendArt",id);
    }
    @Override
    public Integer editArticleRecommendArt(ArticleRecommendArt articleRecommendArt) {
        return this.sqlMapClient.update(SQLMAP_SPACE+"update",articleRecommendArt);
    }
    @Override
    public Integer removeRecommendArt(Long id) {
      
        return this.sqlMapClient.delete(SQLMAP_SPACE+"removeRecommendArt",id);
    }

    
}
