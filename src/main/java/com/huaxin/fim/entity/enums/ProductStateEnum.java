package com.huaxin.fim.entity.enums;

/**
 * 是否  
 * <br>创建日期：2015年8月3日 下午5:15:33 <br>
 * <b>Copyright 2015 上海量投网络科技有限公司 All Rights Reserved</b>
 * 
 * @author 李辉
 * @since 1.0
 * @version 1.0
 */
public enum ProductStateEnum {
	
	Placement(){
		@Override
		public String getText() {
			return "募集";
		}
		
		@Override
		public String getValue() {
			return "0";
		}
	}, // 是
	Operation(){
		@Override
		public String getText() {
			return "运行";
		}
		
		@Override
		public String getValue() {
			return "1";
		}
	},
	ExposeAndCriticize(){
		@Override
		public String getText() {
			return "清算";
		}
		
		@Override
		public String getValue() {
			return "2";
		}
	};
	
	public abstract String getText();

	public abstract String getValue();
}
