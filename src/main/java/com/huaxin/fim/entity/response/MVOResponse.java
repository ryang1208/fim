package com.huaxin.fim.entity.response;

import java.math.BigDecimal;

/**
 * MVO模型计算返回记过对象
 * 
 * @author liumd
 *
 */
public class MVOResponse {

	private double[] weight; // 权重
	 
	private double[][] stdAndCov; // 方差及协方差二维数组
	
	private BigDecimal expectYeild; // 预期收益率
	
	private BigDecimal simulationStd; // 模拟组合产品的方差
	
	 
	private BigDecimal marketYeild; // 资本市场线y轴值
	
	private BigDecimal bestYeild; // 最优收益率



	public BigDecimal getBestYeild() {
		return bestYeild;
	}

	public void setBestYeild(BigDecimal bestYeild) {
		this.bestYeild = bestYeild;
	}

	public BigDecimal getMarketYeild() {
		return marketYeild;
	}

	public void setMarketYeild(BigDecimal marketYeild) {
		this.marketYeild = marketYeild;
	}

	public BigDecimal getSimulationStd() {
		return simulationStd;
	}

	public void setSimulationStd(BigDecimal simulationStd) {
		this.simulationStd = simulationStd;
	}

	public double[] getWeight() {
		return weight;
	}

	public void setWeight(double[] weight) {
		this.weight = weight;
	}

	public double[][] getStdAndCov() {
		return stdAndCov;
	}

	public void setStdAndCov(double[][] stdAndCov) {
		this.stdAndCov = stdAndCov;
	}

	public BigDecimal getExpectYeild() {
		return expectYeild;
	}

	public void setExpectYeild(BigDecimal expectYeild) {
		this.expectYeild = expectYeild;
	}
	
	
}
