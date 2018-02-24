package com.skyjoo.neweast.biz.shop.dao.ibatis;

import java.sql.SQLException;
import java.util.List;

import org.springframework.orm.ibatis.SqlMapClientCallback;
import org.springframework.stereotype.Repository;

import com.ibatis.sqlmap.client.SqlMapExecutor;
import com.skyjoo.neweast.biz.common.base.BaseDaoiBatis;
import com.skyjoo.neweast.biz.shop.dao.ShopDAO;
import com.skyjoo.neweast.biz.shop.domain.Shop;
import com.skyjoo.neweast.biz.shop.domain.query.ShopQuery;

@Repository
@SuppressWarnings("deprecation")
public class ShopDAOImpl extends BaseDaoiBatis implements ShopDAO {

	private static final String SQLMAP_SPACE = "SHOP.";
	
	@Override
	public void getShopPage(ShopQuery query) {
		this.paginate(query, SQLMAP_SPACE + "pageCount", SQLMAP_SPACE + "page");
	}

	@Override
	public Shop selectShopById(Long id) {
		return (Shop) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectById", id);
	}

	@Override
	public Shop selectShopByAccountId(Long accountId) {
		return (Shop) getSqlMapClientTemplate().queryForObject(SQLMAP_SPACE + "selectByAccountId", accountId);
	}

	@Override
	public int updateShop(Shop shop) {
		return getSqlMapClientTemplate().update(SQLMAP_SPACE + "update", shop);
	}


    @Override
    public int batchUpdateShop(final List<Shop> shopList) {
        return getSqlMapClientTemplate().execute(new SqlMapClientCallback<Integer>() {

            @Override
            public Integer doInSqlMapClient(SqlMapExecutor executor) throws SQLException {
                executor.startBatch();
                for (Shop shop : shopList) {
                	getSqlMapClientTemplate().update(SQLMAP_SPACE + "batchUpdateShop", shop);
                }
                return executor.executeBatch();
            }
        });
    }

    @Override
    public Long insertShop(Shop shop) {
        return (Long) getSqlMapClientTemplate().insert(SQLMAP_SPACE + "insert", shop);
    }

}
