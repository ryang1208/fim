package com.huaxin.fim.entity.enums.dictionary;
/*
 * 基准指数ID枚举
 */
public enum IndexIDEnum {
	// 沪深300
	HS300("000300"),
	// 中证500
	ZZ500("000905"),
	// 中债国债总财富指数
	ZZGZ("038.CS"),
	// 大宗商品南华商品指数
	NHFURURE("NH0100.NHF"),
	// 沣泛定制指数
	FF0001("FF0001"),
	// 沣泛FOF指数（母基金）
	FF0002("FF0002"),
	// CTA套利策略指数
	FF0003("FF0003"),
	// CTA量化对冲策略指数
	FF0004("FF0004"),
	// CTA高频策略指数
	FF0005("FF0005"),
	// CTA量化趋势策略指数
	FF0006("FF0006"),
	// 期货期权策略指数
	FF0007("FF0007"),
	// 主观趋势策略指数
	FF0008("FF0008"),
	// 阿尔法策略指数
	FF0009("FF0009"),
	// 量化选股策略指数
	FF0010("FF0010"),
	// 股票多头策略指数
	FF0011("FF0011"),
	// T0套利策略指数
	FF0012("FF0012"),
	// 债券策略指数
	FF0013("FF0013"),	
	// 其他策略指数
	FF0014("FF0014"),
	// M策略指数
	FF0015("FF0015");
	
	private String stringValue;

	private IndexIDEnum(String stringValue) {

		this.stringValue = stringValue;
	}

	public String getStringValue() {
		return stringValue;
	}

}
