package com.huaxin.fim.entity.enums;

/**
 * 统计周期枚举
 * @author liumd
 *
 */
public enum PeriodTypeEnum {

	UNTIL_NOW() {
		@Override
		public String getText() {
			return "成立以来";
		}
		
		@Override
		public String getValue() {
			return "0";
		}

		@Override
		public int getMonth() {
			return 0;
		}
		
	},
	ONE_MONTH() {
		@Override
		public String getText() {
			return "近1月";
		}

		@Override
		public String getValue() {
			return "1";
		}

		@Override
		public int getMonth() {
			return 1;
		}

	},
	THREE_MONTH() {

		@Override
		public String getText() {
			return "近3月";
		}

		@Override
		public String getValue() {
			return "2";
		}

		@Override
		public int getMonth() {
			return 3;
		}
	},
	SIX_MONTH() {

		@Override
		public String getText() {
			return "近6月";
		}

		@Override
		public String getValue() {
			return "3";
		}

		@Override
		public int getMonth() {
			return 6;
		}
	},
	ONE_YEAR() {

		@Override
		public String getText() {
			return "近一年";
		}

		@Override
		public String getValue() {
			return "4";
		}

		@Override
		public int getMonth() {
			return 12;
		}
	},
	TWO_YEAR() {

		@Override
		public String getText() {
			return "近二年";
		}

		@Override
		public String getValue() {
			return "7";
		}

		@Override
		public int getMonth() {
			return 24;
		}
	},
	THREE_YEAR() {

		@Override
		public String getText() {
			return "近三年";
		}

		@Override
		public String getValue() {
			return "8";
		}

		@Override
		public int getMonth() {
			return 36;
		}
	},
	FIVE_YEAR() {

		@Override
		public String getText() {
			return "近五年";
		}

		@Override
		public String getValue() {
			return "9";
		}

		@Override
		public int getMonth() {
			return 60;
		}
	},
	THIS_YEAR() {

		@Override
		public String getText() {
			return "今年以来";
		}

		@Override
		public String getValue() {
			return "5";
		}

		@Override
		public int getMonth() {
			return 99999;
		}
	},
	ONE_DAY() {

		@Override
		public String getText() {
			return "单日";
		}

		@Override
		public String getValue() {
			return "6";
		}

		@Override
		public int getMonth() {
			return -1;
		}
	};

	public abstract String getText();

	public abstract String getValue();
	
	public abstract int getMonth();

}
