package com.huaxin.fim.mapper;

import com.huaxin.fim.entity.sy.entity.investmentManager.InvestmentManager;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrganizationInvestmentDataAuthorityMapper {

	/**
	 * 获取已选投顾
	 * @return
	 */
	public List<InvestmentManager> getCheckedInvestmentList(@Param("investerMangertIds") String[] investerMangertIds);

	/**
	 * 获取可选投顾
	 * @return
	 */
	public List<InvestmentManager> getNotCheckedInvestmentList(@Param("investerMangertIds") String[] investerMangertIds);
}
