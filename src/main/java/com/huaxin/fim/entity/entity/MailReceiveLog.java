package com.huaxin.fim.entity.entity;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/*
 * 接收及下载附件文件解析日志数据实体类
 * 
 */
@Entity
@Table(name = "t_mail_receive_log")
public class MailReceiveLog implements Serializable {

	private static final long serialVersionUID = 1L;
	// 序号（自动编号）
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "sequence")
	@SequenceGenerator(name = "sequence", sequenceName = "seq_t_mail_receive_log") // 适配oracle等没有主键自增长的数据库，改用sequence
	@Column(name = "id")
	private Long id;
	
	// 日期
	@Column(name = "date", length = 8)
	@Length(min = 1, max = 8)
	@NotNull
	@NotBlank
	private String date;
	
	// 导入方式
	@Column(name = "import_type", length = 2)
	@Length(min = 0, max = 2)
	@NotNull
	@NotBlank
	private String importType;
	
	// 接收邮件总数
	@Column(name = "mail_account")
	private int mailAccount;
	
	// 下载附件总数
	@Column(name = "uploadFile_account")
	private int uploadFileAccount;
	
	// 解析文件成功总数
	@Column(name = "file_success_account")
	private int fileSuccessAccount;
	
	// 解析文件失败总数
	@Column(name = "file_fail_account")
	private int fileFailAccount;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getImportType() {
		return importType;
	}

	public void setImportType(String importType) {
		this.importType = importType;
	}

	public int getMailAccount() {
		return mailAccount;
	}

	public void setMailAccount(int mailAccount) {
		this.mailAccount = mailAccount;
	}

	public int getUploadFileAccount() {
		return uploadFileAccount;
	}

	public void setUploadFileAccount(int uploadFileAccount) {
		this.uploadFileAccount = uploadFileAccount;
	}

	public int getFileSuccessAccount() {
		return fileSuccessAccount;
	}

	public void setFileSuccessAccount(int fileSuccessAccount) {
		this.fileSuccessAccount = fileSuccessAccount;
	}

	public int getFileFailAccount() {
		return fileFailAccount;
	}

	public void setFileFailAccount(int fileFailAccount) {
		this.fileFailAccount = fileFailAccount;
	}
}