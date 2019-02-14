package com.huaxin.fim.entity.enums;

/**
 * 数据来源枚举
 * @author liumd
 *
 */
public enum DataLevelEnum {

	LEVEL1() {
		@Override
		public String getText() {
			return "二级数据指标依投资账户";
		}
		
		@Override
		public String getValue() {
			return "1";
		}
		
	},
	LEVEL2() {
		@Override
		public String getText() {
			return "二级数据指标依产品";
		}

		@Override
		public String getValue() {
			return "2";
		}

	},
	LEVEL3() {

		@Override
		public String getText() {
			return "三级数据指标";
		}

		@Override
		public String getValue() {
			return "3";
		}
	},
	LEVEL4() {

		@Override
		public String getText() {
			return "四级数据指标";
		}

		@Override
		public String getValue() {
			return "4";
		}
	},
	LEVEL5() {

		@Override
		public String getText() {
			return "五级数据指标";
		}

		@Override
		public String getValue() {
			return "5";
		}
	},
	LEVEL6() {

		@Override
		public String getText() {
			return "六级数据指标";
		}

		@Override
		public String getValue() {
			return "6";
		}
	},
	LEVEL7() {

		@Override
		public String getText() {
			return "七级数据指标";
		}

		@Override
		public String getValue() {
			return "7";
		}
	};

	public abstract String getText();

	public abstract String getValue();

}
