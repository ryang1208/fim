package com.huaxin.fim.entity.enums;

/**
 * 成立年限枚举对象
 * @author liumd
 *
 */
public enum CreateYearEnum {

	MORE_THAN_THREE_YEAR() {
		@Override
		public String getText() {
			return "3年以上";
		}
		
		@Override
		public String getValue() {
			return "36-";
		}
		
	},
	UNDER_SIX_MONTH() {
		@Override
		public String getText() {
			return "6个月以下";
		}

		@Override
		public String getValue() {
			return "0-6";
		}

	},
	ONE_YEAR_TO_THREE_YEAR() {

		@Override
		public String getText() {
			return "1-3年";
		}

		@Override
		public String getValue() {
			return "12-36";
		}
	},
	SIX_MONTH_TO_ONE_YEAR() {

		@Override
		public String getText() {
			return "6个月-1年";
		}

		@Override
		public String getValue() {
			return "6-12";
		}
	};

	public abstract String getText();

	public abstract String getValue();

}
