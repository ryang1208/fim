package com.huaxin.fim.entity.sy.entity.financial;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 财务核算-估值文件导入
 * @author JIHB
 *
 */
@Entity
@Table(name = "t_evaluate_file_import")
public class EvaluateFileImport implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;
	
	// 基金代码
	@Column(name = "fund_product_id", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 1, max = 10)
	private String fundProductID;
	
	//估值日
	@Column(name = "evaluate_date", nullable = false, length = 10)
	@Length(min = 0, max = 10)
	private String evaluateDate;
	
	//单位净值/当前净值
	@Column(name = "iopv", nullable = true, length = 10)
	@Length(min = 0, max = 10)
	private String iopv;
	
	//累计净值
	@Column(name = "accumulation_iopv", nullable = false, length = 10)
	@Length(min = 0, max = 10)
	private String accumulationIopv;
	
	//托管方净资产
	@Column(name = "net_asset", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String netAsset;
	
	//活期存款
	@Column(name = "current_deposit", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String currentDeposit;
	
	//产品份额
	@Column(name = "share", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String share;
	
	//优先级份额单位净值
	@Column(name = "y_iopv", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String yIopv;
	
	//优先级份额累计净值
	@Column(name = "y_accumulation_iopv", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String yAccumulationIopv;
	
	//进取级份额单位净值
	@Column(name = "j_iopv", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String jIopv;
	
	//进取级份额累计净值
	@Column(name = "j_accumulation_iopv", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String jAccumulationIopv;
	
	//中间级级份额单位净值
	@Column(name = "z_iopv", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String zIopv;
	
	//中间级级份额累计净值
	@Column(name = "z_accumulation_iopv", nullable = true, length = 15)
	@Length(min = 0, max = 15)
	private String zAccumulationIopv;
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFundProductID() {
		return fundProductID;
	}

	public void setFundProductID(String fundProductID) {
		this.fundProductID = fundProductID;
	}

	public String getEvaluateDate() {
		return evaluateDate;
	}

	public void setEvaluateDate(String evaluateDate) {
		this.evaluateDate = evaluateDate;
	}

	public String getIopv() {
		return iopv;
	}

	public void setIopv(String iopv) {
		this.iopv = iopv;
	}

	public String getCurrentDeposit() {
		return currentDeposit;
	}

	public void setCurrentDeposit(String currentDeposit) {
		this.currentDeposit = currentDeposit;
	}
	
	public String getAccumulationIopv() {
		return accumulationIopv;
	}

	public void setAccumulationIopv(String accumulationIopv) {
		this.accumulationIopv = accumulationIopv;
	}

	public String getNetAsset() {
		return netAsset;
	}

	public void setNetAsset(String netAsset) {
		this.netAsset = netAsset;
	}

	public String getShare() {
		return share;
	}

	public void setShare(String share) {
		this.share = share;
	}

	public String getyIopv() {
		return yIopv;
	}

	public void setyIopv(String yIopv) {
		this.yIopv = yIopv;
	}

	public String getyAccumulationIopv() {
		return yAccumulationIopv;
	}

	public void setyAccumulationIopv(String yAccumulationIopv) {
		this.yAccumulationIopv = yAccumulationIopv;
	}

	public String getjIopv() {
		return jIopv;
	}

	public void setjIopv(String jIopv) {
		this.jIopv = jIopv;
	}

	public String getjAccumulationIopv() {
		return jAccumulationIopv;
	}

	public void setjAccumulationIopv(String jAccumulationIopv) {
		this.jAccumulationIopv = jAccumulationIopv;
	}

	public String getzIopv() {
		return zIopv;
	}

	public void setzIopv(String zIopv) {
		this.zIopv = zIopv;
	}

	public String getzAccumulationIopv() {
		return zAccumulationIopv;
	}

	public void setzAccumulationIopv(String zAccumulationIopv) {
		this.zAccumulationIopv = zAccumulationIopv;
	}
	
}
