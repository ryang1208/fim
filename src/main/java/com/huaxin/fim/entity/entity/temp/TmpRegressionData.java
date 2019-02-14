package com.huaxin.fim.entity.entity.temp;

/**
 * 多元回归数据集合
 * @author shenwei
 *
 */
public class TmpRegressionData {

	private String date;
	
	private double y;
	
	private double[] x;

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public double getY() {
		return y;
	}

	public void setY(double y) {
		this.y = y;
	}

	public double[] getX() {
		return x;
	}

	public void setX(double[] x) {
		this.x = x;
	}

}
