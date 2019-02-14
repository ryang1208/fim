package com.huaxin.fim.entity.sy.entity.basicInfo;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * 投顾新增修改日志信息
 * <br>
 * 创建日期：2016年12月1日 下午2:55:11<br>
 * <b>Copyright 2015 上海量投网络科技有限公司 All Rights Reserved</b>
 *
 * @author 周胜兵
 * @since 1.0
 * @version 1.0
 */

@Entity
@Table(name = "t_investment_log")
public class InvestmentLog implements Serializable{
    
    	private static final long serialVersionUID = 1L;
    
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;
    
    	//操作功能名称 
 	@Column(name = "func_name", nullable = false, length = 200)
 	@NotNull
 	@NotBlank
 	@Length(min = 1, max = 200)
 	private String funcName;
 	
 	//操作类型
 	@Column(name = "oper_type", nullable = false, length = 30)
 	@NotNull
 	@NotBlank
 	@Length(min = 1, max = 30)
 	private String operType;
 	
 	
 	//操作ip地址
 	@Column(name = "ip_address", length = 20)
 	@Length(min = 0, max = 20)
 	private String ipAdress;
 	
 	//操作内容
 	@Column(name = "oper_content", length = 200)
 	@Length(min = 0, max = 200)
 	private String operContent;
 	
 	
 	//日志类型  InvestmentTypeEnums
 	@Column(name = "log_type", nullable = false, length = 1)
 	@NotNull
 	@NotBlank
 	@Length(min = 1, max = 1)
 	private String logType;
 		
 	
 	//操作人
 	@Column(name = "oper_user", nullable = false, length = 30)
 	@NotNull
 	@NotBlank
 	@Length(min = 1, max = 30)
 	private String operUser;
 		
 	//操作日期
 	@Column(name = "oper_date", nullable = false, length = 8)
 	@NotNull
 	@NotBlank
 	@Length(min = 1, max = 8)
 	private String operDate;
 		
 		
 	//操作时间
 	@Column(name = "oper_time", nullable = false, length = 8)
 	@NotNull
 	@NotBlank
 	@Length(min = 1, max = 8)
 	private String operTime;

 	@Transient
 	private String stratDate;
 	
 	@Transient
 	private String endDate;
 	
	public InvestmentLog() {
	    super();
	    // TODO Auto-generated constructor stub
	}
	
	


	public InvestmentLog(String funcName, String operType,
		String operContent, String logType, String operUser,
		String operDate, String operTime) {
	    super();
	    this.funcName = funcName;
	    this.operType = operType;
	    this.operContent = operContent;
	    this.logType = logType;
	    this.operUser = operUser;
	    this.operDate = operDate;
	    this.operTime = operTime;
	}




	public long getId() {
	    return id;
	}


	public void setId(long id) {
	    this.id = id;
	}


	public String getFuncName() {
	    return funcName;
	}


	public void setFuncName(String funcName) {
	    this.funcName = funcName;
	}


	public String getOperType() {
	    return operType;
	}


	public void setOperType(String operType) {
	    this.operType = operType;
	}


	public String getIpAdress() {
	    return ipAdress;
	}


	public void setIpAdress(String ipAdress) {
	    this.ipAdress = ipAdress;
	}


	public String getOperContent() {
	    return operContent;
	}


	public void setOperContent(String operContent) {
	    this.operContent = operContent;
	}


	public String getOperUser() {
	    return operUser;
	}


	public void setOperUser(String operUser) {
	    this.operUser = operUser;
	}


	public String getOperDate() {
	    return operDate;
	}


	public void setOperDate(String operDate) {
	    this.operDate = operDate;
	}


	public String getOperTime() {
	    return operTime;
	}


	public void setOperTime(String operTime) {
	    this.operTime = operTime;
	}




	public String getLogType() {
	    return logType;
	}




	public void setLogType(String logType) {
	    this.logType = logType;
	}




	public String getStratDate() {
	    return stratDate;
	}




	public void setStratDate(String stratDate) {
	    this.stratDate = stratDate;
	}




	public String getEndDate() {
	    return endDate;
	}




	public void setEndDate(String endDate) {
	    this.endDate = endDate;
	}
 	
 	
 	
}
