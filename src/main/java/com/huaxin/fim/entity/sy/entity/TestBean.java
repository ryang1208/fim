package com.huaxin.fim.entity.sy.entity;

import com.dev.framework.core.annotation.SessionAttribute;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.io.Serializable;

/**
 * 业务实体类 一定要实现Serializable接口 主要的配置如下： 校验相关的配置 jpa 相关的配置
 * 
 * @author fan
 *
 */
// @Entity
public class TestBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Size(min = 1, max = 10)
	private String a = "test";

	private boolean b = false;

	private double c = 1.0d;

	private float d = 1.0f;

	private int e = 1;

	@SessionAttribute("user")
	private int user;

	private long f = 1l;

	// 关联TestBean2的校验
	@Valid
	private TestBean2 bean = null;

	public String getA() {
		return a;
	}

	public void setA(String a) {
		this.a = a;
	}

	public boolean isB() {
		return b;
	}

	public void setB(boolean b) {
		this.b = b;
	}

	public double getC() {
		return c;
	}

	public void setC(double c) {
		this.c = c;
	}

	public float getD() {
		return d;
	}

	public void setD(float d) {
		this.d = d;
	}

	public int getE() {
		return e;
	}

	public void setE(int e) {
		this.e = e;
	}

	public long getF() {
		return f;
	}

	public void setF(long f) {
		this.f = f;
	}

}
