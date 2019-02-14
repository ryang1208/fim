package com.huaxin.fim.entity.enums;

/**
 * 统计维度类型枚举
 * 
 * @author liumd
 *
 */
public enum DimensionsTypeEnum {

	INVEST_PERIOD() {
		@Override
		public String getText() {
			return "投资账户周期";
		}

		@Override
		public String getValue() {
			return "102";
		}

	},
	INVEST_VARIETY() {
		@Override
		public String getText() {
			return "投资账户品种";
		}

		@Override
		public String getValue() {
			return "103";
		}

	},
	INVEST_DAILY_CONTRACT_TRADE() {
		@Override
		public String getText() {
			return "投资账户每日合约交易";
		}

		@Override
		public String getValue() {
			return "104";
		}
	},
	PRODUCT_DAILY() {

		@Override
		public String getText() {
			return "产品每日统计";
		}

		@Override
		public String getValue() {
			return "201";
		}
	},
	PRODUCT_PERIOD() {

		@Override
		public String getText() {
			return "产品周期";
		}

		@Override
		public String getValue() {
			return "202";
		}
	},
	PRODUCT_VARIETY() {

		@Override
		public String getText() {
			return "产品品种";
		}

		@Override
		public String getValue() {
			return "203";
		}
	},
	PRODUCT_DAILY_CONTRACT_TRADE() {

		@Override
		public String getText() {
			return "产品每日合约交易";
		}

		@Override
		public String getValue() {
			return "204";
		}
	},
	INDUSTRY_PERIOD() {

		@Override
		public String getText() {
			return "行业周期";
		}

		@Override
		public String getValue() {
			return "205";
		}
	},
	PRODUCT_RATING() {

		@Override
		public String getText() {
			return "产品评级";
		}

		@Override
		public String getValue() {
			return "206";
		}
	},
	PRODUCT_FACTOR_PERIOD() {

		@Override
		public String getText() {
			return "产品个股因子周期";
		}

		@Override
		public String getValue() {
			return "301";
		}
	},
	PRODUCT_INDUSTRY_FACTOR_PERIOD() {

		@Override
		public String getText() {
			return "产品行业因子周期";
		}

		@Override
		public String getValue() {
			return "302";
		}
	},
	PRODUCT_INDEX_PERIOD() {

		@Override
		public String getText() {
			return "产品指数周期";
		}

		@Override
		public String getValue() {
			return "401";
		}
	};

	public abstract String getText();

	public abstract String getValue();

}
