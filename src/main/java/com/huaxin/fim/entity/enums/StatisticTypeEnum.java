package com.huaxin.fim.entity.enums;

/**
 * 统计类型枚举
 * 
 * @author sust
 *
 */
public enum StatisticTypeEnum {

	ALL() {
		@Override
		public String getText() {
			return "全部";
		}

		@Override
		public String getValue() {
			return "0";
		}

	},
	LastDay() {
		@Override
		public String getText() {
			return "前一日";
		}

		@Override
		public String getValue() {
			return "1";
		}

	},
	FiveDays() {
		@Override
		public String getText() {
			return "近五日";
		}

		@Override
		public String getValue() {
			return "2";
		}
	},
	DefinedDate() {

		@Override
		public String getText() {
			return "自定义日期";
		}

		@Override
		public String getValue() {
			return "3";
		}
	};

	public abstract String getText();

	public abstract String getValue();

}
