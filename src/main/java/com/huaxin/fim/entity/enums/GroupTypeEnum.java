package com.huaxin.fim.entity.enums;

/**
 * 产品分组枚举
 * @author liumd
 *
 */
public enum GroupTypeEnum {

	HIT() {
		@Override
		public String getText() {
			return "投中";
		}
		
		@Override
		public String getValue() {
			return "1";
		}
		
	},
	MIDTERMCONTEST() {
		@Override
		public String getText() {
			return "中期大赛";
		}

		@Override
		public String getValue() {
			return "2";
		}

	};

	public abstract String getText();

	public abstract String getValue();

}
