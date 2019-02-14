package com.huaxin.fim.entity.sy.entity.investmentManager;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 投资管理人
 * @author sust
 *
 */
@Entity
@Table(name = "t_investment_manager", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})} )
public class InvestmentManager implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 公司名称
	@Column(name = "company_name", nullable = false, length = 200)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 200)
	private String companyName;
		
	// 公司网址
	@Column(name = "company_url", length = 200)
	@Length(min = 0, max = 200)
	private String companyUrl;
	
	// 注册资本
	@Column(name = "registered_capital", precision = 19, scale = 2)
	@Digits(integer = 16, fraction = 2)
	private BigDecimal registeredCapital;
	
	// 实收资本
	@Column(name = "paid_in_capital", precision = 19, scale = 2)
	@Digits(integer = 16, fraction = 2)
	private BigDecimal paidInCapital;
	
	// 营业执照
	@Column(name = "business_license", length = 100)
	@Length(min = 0, max = 100)
	private String businessLicense;
	
	// 法人代表
	@Column(name = "legal_representative",length = 30)
	@Length(min = 0, max = 100)
	private String legalRepresentative;
	
	//公司团队人数
	@Column(name = "company_number",length = 10)
	@Length(min = 0, max = 10)
	private String companyNumber;
	
	// 部门设置
	@Column(name = "sector_setting", length = 200)
	@Length(min = 0, max = 200)
	private String sectorSetting;
	
	// 公司住所
	@Column(name = "company_domicile", length = 200)
	@Length(min = 0, max = 200)
	private String companyDomicile;
	
	// 成立时间
	@Column(name = "company_establishment", length = 10)
	@Length(min = 0, max = 10)
	private String companyEstablishment ;
	
	
	// 省
	@Column(name = "province", length = 200)
	@Length(min = 0, max = 200)
	private String province;
	
	// 市
	@Column(name = "city", length = 200)
	@Length(min = 0, max = 200)
	private String city;
	
	// 联系地址
	@Column(name = "company_address", length = 200)
	@Length(min = 0, max = 200)
	private String companyAddress;
	
	// 管理人编码
	@Column(name = "investment_code", length = 200)
	@Length(min = 0, max = 200)
	private String investmentCode;
	
	// 是否具有投顾资格
	@Column(name = "has_qualification", length = 1)
	@Length(min = 0, max = 1)
	private String hasQualification;
	
	// 是否与国富期货有合作
	@Column(name = "has_gfcooperation", length = 1)
	@Length(min = 0, max = 1)
	private String hasGFCooperation;
	
	// 合作情况
	@Column(name = "cooperation")
	private String cooperation;
		
	// 自主管理规模期货及证券
	@Column(name = "zzglgmqhjzq", length = 100)
	@Length(min = 0, max = 100)
	private String zzglgmqhjzq;
	
	// 受托管理规模期货及证券
	@Column(name = "stglgmqhjzq", length = 100)
	@Length(min = 0, max = 100)
	private String stglgmqhjzq;
	
	//投资理念介绍
	@Column(name = "tzlljs")
	private String tzlljs;
	
	//期货自助管理规模
	@Column(name = "qhzzglgm", length = 100)
	@Length(min = 0, max = 100)
	private String qhzzglgm;
	
	//期货受托管理规模
	@Column(name = "qhstglgm", length = 100)
	@Length(min = 0, max = 100)
	private String qhstglgm;
	
	//证券自助管理规模
	@Column(name = "zqzzglgm", length = 100)
	@Length(min = 0, max = 100)
	private String zqzzglgm;
	
	//证券受托管理规模
	@Column(name = "zqstglgm", length = 100)
	@Length(min = 0, max = 100)
	private String zqstglgm;
	
	//其他自助管理规模
	@Column(name = "qtzzglgm", length = 100)
	@Length(min = 0, max = 100)
	private String qtzzglgm;
		
	//其他受托管理规模
	@Column(name = "qtstglgm", length = 100)
	@Length(min = 0, max = 100)
	private String qtstglgm;
	
	// 拟发行产品规模最高
	@Column(name = "nfxcpgmzg", length = 100)
	@Length(min = 0, max = 100)
	private String nfxcpgmzg;
	
	// 拟发行产品规模最低
	@Column(name = "nfxcpgmzd", length = 100)
	@Length(min = 0, max = 100)
	private String nfxcpgmzd;
	
	// 期货类交易策略
	@Column(name = "xhljycl", length = 100)
	@Length(min = 0, max = 100)
	private String xhljycl;
	
	// 期货类交易策略管理人自述
	@Column(name = "qhljyclglrzs")
	private String qhljyclglrzs;
	
	// 证券类交易策略
	@Column(name = "zqljycl", length = 100)
	@Length(min = 0, max = 100)
	private String zqljycl;
	
	// 证券类交易策略管理人自述
	@Column(name = "zqljyclglrzs", length = 1000)
	@Length(min = 0, max = 1000)
	private String zqljyclglrzs;
	
	// 其他类交易策略
	@Column(name = "qtljycl", length = 100)
	@Length(min = 0, max = 100)
	private String qtljycl;
	
	// 公司简介
	@Column(name = "gsjj")
	private String gsjj;
	
	// 公司股权结构
	@Column(name = "gsgqjg")
	private String gsgqjg;
	
	// 公司运营框架
	@Column(name = "gsyykj")
	private String gsyykj;	
	
	// 公司运营框架图
	@Column(name = "gsyykjt", length = 1000)
	@Length(min = 0, max = 200)
	private String gsyykjt;	
	
	// 风控架构图
	@Column(name = "fkjgt", length = 1000)
	@Length(min = 0, max = 200)
	private String fkjgt;	
	
	//风控体系介绍
	@Column(name = "fktxjs")
	private String fktxjs;
	
	//风控体系介绍
	@Column(name = "fkxtjs")
	private String fkxtjs;
	
	//交易系统介绍
	@Column(name = "jyxtjs")
	private String jyxtjs;
	
	// 申请人
	@Column(name = "applicant", length = 20)
	@Length(min = 0, max = 20)
	private String applicant;
	
	// 复核人
	@Column(name = "reviewer", length = 20)
	@Length(min = 0, max = 20)
	private String reviewer;
	
	// 申请日期(新增日期)
	@Column(name = "reg_date", length = 8)
	@Length(min = 0, max = 8)
	private String regDate;
	
	// 操作人
	@Column(name = "operator_id", length = 20)
	@Length(min = 0, max = 20)
	private String operatorID;

	// 操作日期
	@Column(name = "operate_date", length = 8)
	@Length(min = 0, max = 8)
	private String operateDate;

	// 操作时间
	@Column(name = "operate_time", length = 8)
	@Length(min = 0, max = 8)
	private String operateTime;
	
	//投顾状态
	@Column(name = "status", length = 8)
	@Length(min = 0, max = 8)
	private String status;

	//业务经理ID
	@Column(name = "service_manager_id", length = 20)
	@Length(min = 0, max = 20)
	private String serviceManagerID;
	
	//渠道ID
	@Column(name = "channel_user_id", length = 20)
	@Length(min = 0, max = 20)
	private String channelUserID;
	
	//投顾用户名
	@Column(name = "investment_user_id", length = 20)
	@Length(min = 0, max = 20)
	private String investmentUserID;
	
	@Column(name = "investment_source", nullable = true)
	@Length(min = 0, max = 1)
	private String investmentSource;//投顾来源
	
	@Column(name = "highest", length = 20)
	@Length(min = 0, max = 20)
	private String highest;
	
	@Column(name = "code", length = 20)
	@Length(min = 0, max = 20)
	private String code;
	
	@Column(name = "lowest", length = 20)
	@Length(min = 0, max = 20)
	private String lowest;
	
	@Column(name = "salt", length = 20)
	@Length(min = 0, max = 20)
	private String salt;
	
	@Column(name = "self_scale", length = 20)
	@Length(min = 0, max = 20)
	private String selfScale;
	
	@Column(name = "trustee_scale", length = 20)
	@Length(min = 0, max = 20)
	private String trusteeScale;
	
	//部门设置
	@Column(name = "department_set", length = 20)
	@Length(min = 0, max = 20)
	private String departmentSet;
	
	// 情况汇总
	@Column(name = "situation_summary" )
	private String situationSummary;
	
	// 投资策略
	@Column(name = "strategy_list", length = 100)
	@Length(min = 0, max = 100)
	private String strategyList;
	
	//投顾类型
	@Column(name = "investment_type",length = 10)
	@Length(min = 0, max = 10)
	private String investmentType;
	
	//主机构
	@Column(name = "organization_id",length = 10)
	@Length(min = 0, max = 30)
	private String organizationId;
		
	public String getOrganizationId() {
		return organizationId;
	}

	public void setOrganizationId(String organizationId) {
		this.organizationId = organizationId;
	}

	public String getInvestmentType() {
		return investmentType;
	}

	public void setInvestmentType(String investmentType) {
		this.investmentType = investmentType;
	}
		
	public String getSituationSummary() {
		return situationSummary;
	}

	public void setSituationSummary(String situationSummary) {
		this.situationSummary = situationSummary;
	}

	// 是否可以修改
	@Transient
	private Integer canUpdate;
	
	// 初审是否可以审核
	@Transient
	private Integer canTrial;
	
	// 复审是否可以审核
	@Transient
	private Integer canReview;
	
	// 投决会是否可以审核
	@Transient
	private Integer canJudgment;
	
	public String getTrusteeScale() {
		return trusteeScale;
	}

	public void setTrusteeScale(String trusteeScale) {
		this.trusteeScale = trusteeScale;
	}

	public String getSelfScale() {
		return selfScale;
	}

	public void setSelfScale(String selfScale) {
		this.selfScale = selfScale;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	public String getCompanyUrl() {
		return companyUrl;
	}

	public void setCompanyUrl(String companyUrl) {
		this.companyUrl = companyUrl;
	}

	public String getBusinessLicense() {
		return businessLicense;
	}

	public void setBusinessLicense(String businessLicense) {
		this.businessLicense = businessLicense;
	}

	public String getLegalRepresentative() {
		return legalRepresentative;
	}

	public void setLegalRepresentative(String legalRepresentative) {
		this.legalRepresentative = legalRepresentative;
	}

	public String getCompanyNumber() {
		return companyNumber;
	}

	public void setCompanyNumber(String companyNumber) {
		this.companyNumber = companyNumber;
	}

	public String getSectorSetting() {
		return sectorSetting;
	}

	public void setSectorSetting(String sectorSetting) {
		this.sectorSetting = sectorSetting;
	}

	public String getCompanyDomicile() {
		return companyDomicile;
	}

	public void setCompanyDomicile(String companyDomicile) {
		this.companyDomicile = companyDomicile;
	}

	public String getCompanyEstablishment() {
		return companyEstablishment;
	}

	public void setCompanyEstablishment(String companyEstablishment) {
		this.companyEstablishment = companyEstablishment;
	}

	public String getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	public String getInvestmentCode() {
		return investmentCode;
	}

	public void setInvestmentCode(String investmentCode) {
		this.investmentCode = investmentCode;
	}

	public String getHasQualification() {
		return hasQualification;
	}

	public void setHasQualification(String hasQualification) {
		this.hasQualification = hasQualification;
	}

	public String getZzglgmqhjzq() {
		return zzglgmqhjzq;
	}

	public void setZzglgmqhjzq(String zzglgmqhjzq) {
		this.zzglgmqhjzq = zzglgmqhjzq;
	}

	public String getStglgmqhjzq() {
		return stglgmqhjzq;
	}

	public void setStglgmqhjzq(String stglgmqhjzq) {
		this.stglgmqhjzq = stglgmqhjzq;
	}

	public String getNfxcpgmzg() {
		return nfxcpgmzg;
	}

	public void setNfxcpgmzg(String nfxcpgmzg) {
		this.nfxcpgmzg = nfxcpgmzg;
	}

	public String getNfxcpgmzd() {
		return nfxcpgmzd;
	}

	public void setNfxcpgmzd(String nfxcpgmzd) {
		this.nfxcpgmzd = nfxcpgmzd;
	}

	public String getXhljycl() {
		return xhljycl;
	}

	public void setXhljycl(String xhljycl) {
		this.xhljycl = xhljycl;
	}

	public String getQhljyclglrzs() {
		return qhljyclglrzs;
	}

	public void setQhljyclglrzs(String qhljyclglrzs) {
		this.qhljyclglrzs = qhljyclglrzs;
	}

	public String getZqljycl() {
		return zqljycl;
	}

	public void setZqljycl(String zqljycl) {
		this.zqljycl = zqljycl;
	}

	public String getZqljyclglrzs() {
		return zqljyclglrzs;
	}

	public void setZqljyclglrzs(String zqljyclglrzs) {
		this.zqljyclglrzs = zqljyclglrzs;
	}

	public String getGsjj() {
		return gsjj;
	}

	public void setGsjj(String gsjj) {
		this.gsjj = gsjj;
	}

	public String getGsgqjg() {
		return gsgqjg;
	}

	public void setGsgqjg(String gsgqjg) {
		this.gsgqjg = gsgqjg;
	}

	public String getGsyykj() {
		return gsyykj;
	}

	public void setGsyykj(String gsyykj) {
		this.gsyykj = gsyykj;
	}

	public String getApplicant() {
		return applicant;
	}

	public void setApplicant(String applicant) {
		this.applicant = applicant;
	}

	public String getReviewer() {
		return reviewer;
	}

	public void setReviewer(String reviewer) {
		this.reviewer = reviewer;
	}

	public String getRegDate() {
		return regDate;
	}

	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}

	public String getOperatorID() {
		return operatorID;
	}

	public void setOperatorID(String operatorID) {
		this.operatorID = operatorID;
	}

	public String getOperateDate() {
		return operateDate;
	}

	public void setOperateDate(String operateDate) {
		this.operateDate = operateDate;
	}

	public String getOperateTime() {
		return operateTime;
	}

	public void setOperateTime(String operateTime) {
		this.operateTime = operateTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getHasGFCooperation() {
		return hasGFCooperation;
	}

	public void setHasGFCooperation(String hasGFCooperation) {
		this.hasGFCooperation = hasGFCooperation;
	}

	public String getCooperation() {
		return cooperation;
	}

	public void setCooperation(String cooperation) {
		this.cooperation = cooperation;
	}

	public String getFkjgt() {
		return fkjgt;
	}

	public void setFkjgt(String fkjgt) {
		this.fkjgt = fkjgt;
	}

	public String getFktxjs() {
		return fktxjs;
	}

	public void setFktxjs(String fktxjs) {
		this.fktxjs = fktxjs;
	}

	public String getFkxtjs() {
		return fkxtjs;
	}

	public void setFkxtjs(String fkxtjs) {
		this.fkxtjs = fkxtjs;
	}

	public String getJyxtjs() {
		return jyxtjs;
	}

	public void setJyxtjs(String jyxtjs) {
		this.jyxtjs = jyxtjs;
	}

	public String getTzlljs() {
		return tzlljs;
	}

	public void setTzlljs(String tzlljs) {
		this.tzlljs = tzlljs;
	}

	public String getQhzzglgm() {
		return qhzzglgm;
	}

	public void setQhzzglgm(String qhzzglgm) {
		this.qhzzglgm = qhzzglgm;
	}

	public String getQhstglgm() {
		return qhstglgm;
	}

	public void setQhstglgm(String qhstglgm) {
		this.qhstglgm = qhstglgm;
	}

	public String getZqzzglgm() {
		return zqzzglgm;
	}

	public void setZqzzglgm(String zqzzglgm) {
		this.zqzzglgm = zqzzglgm;
	}

	public String getZqstglgm() {
		return zqstglgm;
	}

	public void setZqstglgm(String zqstglgm) {
		this.zqstglgm = zqstglgm;
	}

	public String getQtzzglgm() {
		return qtzzglgm;
	}

	public void setQtzzglgm(String qtzzglgm) {
		this.qtzzglgm = qtzzglgm;
	}

	public String getQtstglgm() {
		return qtstglgm;
	}

	public void setQtstglgm(String qtstglgm) {
		this.qtstglgm = qtstglgm;
	}

	public String getQtljycl() {
		return qtljycl;
	}

	public void setQtljycl(String qtljycl) {
		this.qtljycl = qtljycl;
	}

	public String getServiceManagerID() {
		return serviceManagerID;
	}

	public void setServiceManagerID(String serviceManagerID) {
		this.serviceManagerID = serviceManagerID;
	}

	public String getHighest() {
		return highest;
	}

	public void setHighest(String highest) {
		this.highest = highest;
	}

	public String getLowest() {
		return lowest;
	}

	public void setLowest(String lowest) {
		this.lowest = lowest;
	}

	public String getGsyykjt() {
		return gsyykjt;
	}

	public void setGsyykjt(String gsyykjt) {
		this.gsyykjt = gsyykjt;
	}

	public String getDepartmentSet() {
		return departmentSet;
	}

	public void setDepartmentSet(String departmentSet) {
		this.departmentSet = departmentSet;
	}

	public String getChannelUserID() {
		return channelUserID;
	}

	public void setChannelUserID(String channelUserID) {
		this.channelUserID = channelUserID;
	}

	public String getInvestmentUserID() {
		return investmentUserID;
	}

	public void setInvestmentUserID(String investmentUserID) {
		this.investmentUserID = investmentUserID;
	}

	public BigDecimal getRegisteredCapital() {
		return registeredCapital;
	}

	public void setRegisteredCapital(BigDecimal registeredCapital) {
		this.registeredCapital = registeredCapital;
	}

	public BigDecimal getPaidInCapital() {
		return paidInCapital;
	}

	public void setPaidInCapital(BigDecimal paidInCapital) {
		this.paidInCapital = paidInCapital;
	}

	public String getInvestmentSource() {
		return investmentSource;
	}

	public void setInvestmentSource(String investmentSource) {
		this.investmentSource = investmentSource;
	}

	public Integer getCanUpdate() {
		return canUpdate;
	}

	public void setCanUpdate(Integer canUpdate) {
		this.canUpdate = canUpdate;
	}

	public Integer getCanReview() {
		return canReview;
	}

	public void setCanReview(Integer canReview) {
		this.canReview = canReview;
	}

	public Integer getCanTrial() {
		return canTrial;
	}

	public void setCanTrial(Integer canTrial) {
		this.canTrial = canTrial;
	}

	public Integer getCanJudgment() {
		return canJudgment;
	}

	public void setCanJudgment(Integer canJudgment) {
		this.canJudgment = canJudgment;
	}

	public String getStrategyList() {
		return strategyList;
	}

	public void setStrategyList(String strategyList) {
		this.strategyList = strategyList;
	}
	
}
