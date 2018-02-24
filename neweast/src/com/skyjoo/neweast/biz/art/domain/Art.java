package com.skyjoo.neweast.biz.art.domain;

import java.util.Date;
import java.util.List;

import com.eyeieye.melos.util.StringUtil;
import com.skyjoo.wudadao.common.enums.mall.art.EnumFreightType;

public class Art {
	/**
	 * pk,seq
	 */
	private Long id;
	/**
	 * 一级类目
	 */
	private Long firstCategory;
	/**
	 * 艺术品所属类目ID
	 */
	private Long categoryId;
	/**
	 * 艺术品类目，若是二级类目，则 一级类目->二级类目
	 */
	private String categoryContent;
	/**
	 * 卖家id
	 */
	private Long userId;
	/**
	 * 艺术品名称
	 */
	private String name;
	/**
	 * 艺术品编号
	 */
	private String artCode;
	/**
	 * 艺术品类目代码
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
	 * 运费类型1-双方协商，2-免运费
	 */
	private Integer freightType;
	/**
	 * 库存
	 */
	private Integer stock;
	/**
	 * 状态：0-未审核，1-正常，2-审核不通过，3-交易锁定，4-已下架
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
	 * 附件
	 */
	private String attachment;
	/**
	 * 描述
	 */
	private String description;
	/**
	 * 艺术品属性
	 */
	private String property;
	/**
	 * 备注
	 */
	private String memo;
    /**
     * 鉴定证书编号
     */	
	private String certNo;
    /**
     * 免邮区域
     */ 	
	private String freeArea;
	
	//销量
	private Integer salesVolume;
	
	//类型 0：作品 1：艺术品
	private Integer type;
	
	//作者ID
	private Long artiseId;
	
	private List<ArtPropertyValue> artPropertyValues;
		
	public String getMemo() {
		return memo;
	}

	public void setMemo(String memo) {
		this.memo = memo;
	}

	public boolean isStatusNormal() {
		return this.status != null && (this.status == 1 || this.status == 5);
	}
	
	/**
	 * 免运费	
	 * @return
	 */
	public boolean isFreightTypeFree() {
		return EnumFreightType.FREE.getValue().equals(this.freightType);
	}
	
	/**
	 * 双方协商
	 * @return
	 */
	public boolean isFreightTypeUndecided() {
		return EnumFreightType.UNDECIDED.getValue().equals(this.freightType);
	}
	
	/**
	 * 有免邮区域
	 * @return
	 */
	public boolean hasFreeArea() {
		return isFreightTypeUndecided() && StringUtil.isNotBlank(this.freeArea);
	}

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
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

	public String getAttachment() {
		return attachment;
	}

	public void setAttachment(String attachment) {
		this.attachment = attachment;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String[] getAttachmentList() {
		if (StringUtil.isBlank(this.attachment)) {
			return null;
		}
		String[] attachmentArr = this.attachment.split("\\|");
		return attachmentArr;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getCertNo() {
		return certNo;
	}

	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}

	public String getFreeArea() {
		return freeArea;
	}

	public void setFreeArea(String freeArea) {
		this.freeArea = freeArea;
	}

	/**获取销量*/
	public Integer getSalesVolume() {
		return salesVolume;
	}
	/**设置销量*/
	public void setSalesVolume(Integer salesVolume) {
		this.salesVolume = salesVolume;
	}

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
    
 

    public Long getArtiseId() {
        return artiseId;
    }

    public void setArtiseId(Long artiseId) {
        this.artiseId = artiseId;
    }

    public Long getFirstCategory() {
        return firstCategory;
    }

    public void setFirstCategory(Long firstCategory) {
        this.firstCategory = firstCategory;
    }

    public List<ArtPropertyValue> getArtPropertyValues() {
        return artPropertyValues;
    }

    public void setArtPropertyValues(List<ArtPropertyValue> artPropertyValues) {
        this.artPropertyValues = artPropertyValues;
    }
}
