/**
*@title
*@author dengjz
*@version 1.0
*/
package com.skyjoo.neweast.biz.art.domain.query;

import java.util.Date;

import com.eyeieye.melos.util.StringUtil;
import com.skyjoo.neweast.biz.common.page.Pagination;
import com.skyjoo.wudadao.common.enums.mall.art.EnumArtStatus;

/**
 *@Description 
 *@author dengjz
 *@version 1.0
 *@date 2014年11月6日 上午9:27:13
 */
public class ArtCheckQuery extends Pagination<ArtCheckQuery> {

	/**
	 * 艺术品审核列表
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * seq,pk
	 */
	private Long id;
	/**
	 * 艺术品所属类目id
	 */
	private Long categoryId;
	/**
	 * 艺术品的类目
	 */
	private String categoryContent;
	/**
	 * 艺术品名称
	 */
	private String name;
	/**
	 * 艺术品编号
	 */
	private String artCode;
	/**
	 * 艺术品所属类目代码
	 */
	private String catCode;
	/**
	 * 艺术品价格
	 */
	private Long price;
	/**
	 * 艺术家
	 */
	private String artise;
	/**
	 * 运费类型 1-双方协商 2-免运费
	 */
	private Integer freightType;
	/**
	 * 库存
	 */
	private Integer stock;
	/**
	 * 状态 0-未审核 1-正常 2-审核不通过 3-交易锁定 4-已下架
	 */
	private Integer status;
	/**
	 * 操作员
	 */
	private String operator;
	/**
	 * 创建时间
	 */
	private Date gmtCreate;
	/**
	 * 最后修改时间
	 */
	private Date gmtModify;
	/**
     * 推荐时间
     */
    private Date gmtRecommend;
	/**
	 * 卖家id
	 */
	private Long userId;
	
	/**
	 * 开始时间
	 */
	private Date startDate;
	/**
	 * 结束时间
	 */
	private Date endDate;
	/**
	 * 卖家email
	 */
	private String email;
	/**
	 * 设置查询时是否查询全部艺术品 0-全部 1-只查未审核的艺术品
	 */
	private int isAll;
	private Long artParentCategoryId;
	private Long articleId;
	
	//是否已推荐
	private Boolean isRecommend = null;
	//附件
	private String attachment;

	private String queryName;
	//艺术品类型
	private String artType;
	
	//是否包含艺术品
	private Boolean isArtiseWork = false; 

    //是否包分账
	private Long isLedger;
	
	//活动id
	private Long activityId;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	public String getCategoryContent() {
		return categoryContent;
	}
	public void setCategoryContent(String categoryContent) {
		this.categoryContent = categoryContent;
	}
	public String getName() {
		return name;
	}
	
	public String getQueryName() {
//		if(StringUtil.isNotBlank(this.queryName)) {
//	    	try {
//	    		return new String(this.queryName.getBytes("iso8859-1"),"utf-8");
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//    	}
		return queryName;
	}
	public void setQueryName(String queryName) {
		this.queryName = queryName;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArtCode() {
		return artCode;
	}
	public void setArtCode(String artCode) {
		this.artCode = artCode;
	}
	public String getCatCode() {
		return catCode;
	}
	public void setCatCode(String catCode) {
		this.catCode = catCode;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getArtise() {
		return artise;
	}
	public void setArtise(String artise) {
		this.artise = artise;
	}
	public Integer getFreightType() {
		return freightType;
	}
	public void setFreightType(Integer freightType) {
		this.freightType = freightType;
	}
	public Integer getStock() {
		return stock;
	}
	public void setStock(Integer stock) {
		this.stock = stock;
	}
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModify() {
		return gmtModify;
	}
	public void setGmtModify(Date gmtModify) {
		this.gmtModify = gmtModify;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public int getIsAll() {
		return isAll;
	}
	public void setIsAll(int isAll) {
		this.isAll = isAll;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Long getArtParentCategoryId() {
		return artParentCategoryId;
	}
	public void setArtParentCategoryId(Long artParentCategoryId) {
		this.artParentCategoryId = artParentCategoryId;
	}
	
	public Boolean getIsRecommend() {
		return isRecommend;
	}
	public void setIsRecommend(Boolean isRecommend) {
		this.isRecommend = isRecommend;
	}
	public boolean isRecommend() {
		return Boolean.TRUE.equals(this.isRecommend);
	}
	public String getAttachment() {
		return attachment;
	}
	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}
	public String[] getAttachmentList() {
		if (StringUtil.isBlank(this.attachment)) {
			return null;
		}
		String[] attachmentArr = this.attachment.split("\\|");
		return attachmentArr;
	}
	
	public String getArtType() {
        return artType;
    }
    public void setArtType(String artType) {
        this.artType = artType;
    }
    public boolean isNormal() {
		return EnumArtStatus.NORMAL.getValue().equals(this.status);
	}
    public Boolean getIsArtiseWork() {
        return isArtiseWork;
    }
    public void setIsArtiseWork(Boolean isArtiseWork) {
        this.isArtiseWork = isArtiseWork;
    }
    public Long getIsLedger() {
        return isLedger;
    }
    public void setIsLedger(Long isLedger) {
        this.isLedger = isLedger;
    }
    public Long getArticleId() {
        return articleId;
    }
    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }
    public Date getGmtRecommend() {
        return gmtRecommend;
    }
    public void setGmtRecommend(Date gmtRecommend) {
        this.gmtRecommend = gmtRecommend;
    }
    public Long getActivityId() {
        return activityId;
    }
    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }
    
}
