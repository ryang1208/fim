package com.huaxin.fim.entity.sy.entity;

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
 * 短信返回消息实体类
 * @author konglingqi
 *
 */

@Entity
@Table(name = "t_shortMsg_return")
public class ShortMsgReturn  implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private long id;

	// 返回状态值  成功返回Success 失败返回：Faild
	@Column(name = "return_status", nullable = false, length = 10)
	@NotNull
	@NotBlank
	@Length(min = 0, max = 10)
	private String returnstatus;
	
	// 返回信息
	@Column(name = "message", nullable = false, length = 50)
	@NotNull
	@NotBlank
	@Length(min = 0, max = 50)
	private String message;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getReturnstatus() {
		return returnstatus;
	}

	public void setReturnstatus(String returnstatus) {
		this.returnstatus = returnstatus;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
