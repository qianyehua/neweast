package com.skyjoo.neweast.biz.art.domain.query;


import java.util.Date;

import com.skyjoo.neweast.biz.art.domain.ArtConsulting;
import com.skyjoo.neweast.biz.common.page.Pagination;


/**
 * @author JIANGFENGXU
 *
 */
public class ArtConsultingQuery extends Pagination<ArtConsulting>{

    /**
	 * 
	 */
	private static final long serialVersionUID = -7484416131752970920L;
    
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
