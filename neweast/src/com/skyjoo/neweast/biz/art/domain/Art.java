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
	 * һ����Ŀ
	 */
	private Long firstCategory;
	/**
	 * ����Ʒ������ĿID
	 */
	private Long categoryId;
	/**
	 * ����Ʒ��Ŀ�����Ƕ�����Ŀ���� һ����Ŀ->������Ŀ
	 */
	private String categoryContent;
	/**
	 * ����id
	 */
	private Long userId;
	/**
	 * ����Ʒ����
	 */
	private String name;
	/**
	 * ����Ʒ���
	 */
	private String artCode;
	/**
	 * ����Ʒ��Ŀ����
	 */
	private String catCode;
	/**
	 * ����Ʒ�۸�
	 */
	private Long price;
	/**
	 * ������
	 */
	private String artise;
	/**
	 * �˷�����1-˫��Э�̣�2-���˷�
	 */
	private Integer freightType;
	/**
	 * ���
	 */
	private Integer stock;
	/**
	 * ״̬��0-δ��ˣ�1-������2-��˲�ͨ����3-����������4-���¼�
	 */
	private Integer status;
	/**
	 * ����Ա
	 */
	private String operator;
	/**
	 * ����ʱ��
	 */
	private Date gmtCreate;
	/**
	 * ����޸�ʱ��
	 */
	private Date gmtModify;

	/**
	 * ����
	 */
	private String attachment;
	/**
	 * ����
	 */
	private String description;
	/**
	 * ����Ʒ����
	 */
	private String property;
	/**
	 * ��ע
	 */
	private String memo;
    /**
     * ����֤����
     */	
	private String certNo;
    /**
     * ��������
     */ 	
	private String freeArea;
	
	//����
	private Integer salesVolume;
	
	//���� 0����Ʒ 1������Ʒ
	private Integer type;
	
	//����ID
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
	 * ���˷�	
	 * @return
	 */
	public boolean isFreightTypeFree() {
		return EnumFreightType.FREE.getValue().equals(this.freightType);
	}
	
	/**
	 * ˫��Э��
	 * @return
	 */
	public boolean isFreightTypeUndecided() {
		return EnumFreightType.UNDECIDED.getValue().equals(this.freightType);
	}
	
	/**
	 * ����������
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

	/**��ȡ����*/
	public Integer getSalesVolume() {
		return salesVolume;
	}
	/**��������*/
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
