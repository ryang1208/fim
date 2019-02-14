package com.huaxin.fim.entity.response;

/**
 * 关注基金结果对象
 * 
 * @author wangdl
 *
 */
public class InvestedCombinationFundResponse {
	//产品id
	private String id;
	//产品名称
	private String productName;
	//成份基金数目
	private String memberFundCount;
	//基金管理人
	private String fundManagerMan;
	//基金经理
	private String fundManager;
	//产品规模
	private String initialAsset;
	// 成立日期
	private String createDate; 
	//最新净值
    private String netNewestValue;
    //今年以来收益率:KPI--020032
  	private String thisYear;
  	// 是否关注
  	private String isConcentration;
  	
  	// 是否是母基金
 	private String isParentProduct;
 	
 	//机构
 	private String organizationId;
  	
	public String getOrganizationId() {
		return organizationId;
	}
	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}
	public String getIsParentProduct() {
		return isParentProduct;
	}
	public void setIsParentProduct(String isParentProduct) {
		this.isParentProduct = isParentProduct;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getMemberFundCount() {
		return memberFundCount;
	}
	public void setMemberFundCount(String memberFundCount) {
		this.memberFundCount = memberFundCount;
	}
	public String getFundManagerMan() {
		return fundManagerMan;
	}
	public void setFundManagerMan(String fundManagerMan) {
		this.fundManagerMan = fundManagerMan;
	}
	public String getFundManager() {
		return fundManager;
	}
	public void setFundManager(String fundManager) {
		this.fundManager = fundManager;
	}
	public String getInitialAsset() {
		return initialAsset;
	}
	public void setInitialAsset(String initialAsset) {
		this.initialAsset = initialAsset;
	}
	public String getCreateDate() {
		return createDate;
	}
	public void setCreateDate(String createDate) {
		this.createDate = createDate;
	}
	public String getNetNewestValue() {
		return netNewestValue;
	}
	public void setNetNewestValue(String netNewestValue) {
		this.netNewestValue = netNewestValue;
	}
	public String getThisYear() {
		return thisYear;
	}
	public void setThisYear(String thisYear) {
		this.thisYear = thisYear;
	}
	public String getIsConcentration() {
		return isConcentration;
	}
	public void setIsConcentration(String isConcentration) {
		this.isConcentration = isConcentration;
	}
  	
}
