package com.skyjoo.neweast.biz.art.domain.query;

import java.util.Date;

import com.skyjoo.neweast.biz.art.domain.ArtComment;
import com.skyjoo.neweast.biz.common.page.Pagination;



/**
 * @author Paul
 * @version 2016-3-17 上午11:02:48
 */
public class ArtCommentQuery extends Pagination<ArtComment> {

	private static final long serialVersionUID = 1L;
	
    /**
     * 开始咨询时间
     */
    private Date startDate;
    
    /**
     * 结束咨询时间
     */
    private Date endDate;
    
    /**
     * 艺术品名称
     */
    private String artName;
    
    /**
     * 卖家账户
     */
    private String sellerStockAccount;
    
    /**
     * 买家账户
     */
    private String buyerStockAccount;

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getArtName() {
		return artName;
	}

	public void setArtName(String artName) {
		this.artName = artName;
	}

	public String getSellerStockAccount() {
		return sellerStockAccount;
	}

	public void setSellerStockAccount(String sellerStockAccount) {
		this.sellerStockAccount = sellerStockAccount;
	}

	public String getBuyerStockAccount() {
		return buyerStockAccount;
	}

	public void setBuyerStockAccount(String buyerStockAccount) {
		this.buyerStockAccount = buyerStockAccount;
	}
	
	public boolean enable() {
		return true;
	}
	
	
	
}
