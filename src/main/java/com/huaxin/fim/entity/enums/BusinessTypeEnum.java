package com.huaxin.fim.entity.enums;

/**
 * 份额文件导入业务类型枚举
 * @author liumd
 *
 */
public enum BusinessTypeEnum {

	Subscription() {
		@Override
		public String getText() {
			return "认购";
		}
		
		@Override
		public String getValue() {
			return "1";
		}

		@Override
		public String getOperation() {
			return "";
		}
	},
	Purchasing() {
		@Override
		public String getText() {
			return "申购";
		}
		
		@Override
		public String getValue() {
			return "2";
		}

		@Override
		public String getOperation() {
			return "+";
		}
	},
	Redeeming() {
		@Override
		public String getText() {
			return "赎回";
		}
		
		@Override
		public String getValue() {
			return "3";
		}

		@Override
		public String getOperation() {
			return "1";
		}
	},
	Transfer() {
		@Override
		public String getText() {
			return "转托管";
		}
		
		@Override
		public String getValue() {
			return "4";
		}

		@Override
		public String getOperation() {
			return "";
		}
	},
	TransferInCustody() {
		@Override
		public String getText() {
			return "托管转入";
		}
		
		@Override
		public String getValue() {
			return "5";
		}

		@Override
		public String getOperation() {
			return "";
		}
	},
	TransferOutCustody() {
		@Override
		public String getText() {
			return "托管转出";
		}
		
		@Override
		public String getValue() {
			return "6";
		}

		@Override
		public String getOperation() {
			return "";
		}
	},
	ChangeDividendMethod() {
		@Override
		public String getText() {
			return "修改分红方式";
		}
		
		@Override
		public String getValue() {
			return "7";
		}

		@Override
		public String getOperation() {
			return "";
		}
	},
	ShareFreeze() {
		@Override
		public String getText() {
			return "份额冻结";
		}
		
		@Override
		public String getValue() {
			return "8";
		}

		@Override
		public String getOperation() {
			return "";
		}
	},
	ShareUnfreeze() {
		@Override
		public String getText() {
			return "份额解冻";
		}
		
		@Override
		public String getValue() {
			return "9";
		}

		@Override
		public String getOperation() {
			return "";
		}
	},
	NonTransactionAssigned() {
		@Override
		public String getText() {
			return "非交易过户";
		}
		
		@Override
		public String getValue() {
			return "10";
		}

		@Override
		public String getOperation() {
			return "+";
		}
	},
	FundTransferOut() {
		@Override
		public String getText() {
			return "基金转换出";
		}
		
		@Override
		public String getValue() {
			return "11";
		}

		@Override
		public String getOperation() {
			return "-";
		}
	},
	NonTransactionAssignedOut() {
		@Override
		public String getText() {
			return "非交易过户出";
		}
		
		@Override
		public String getValue() {
			return "12";
		}

		@Override
		public String getOperation() {
			return "-";
		}
	},
	NonTransactionAssignedIn() {
		@Override
		public String getText() {
			return "非交易过户入";
		}
		
		@Override
		public String getValue() {
			return "13";
		}

		@Override
		public String getOperation() {
			return "+";
		}
	},
	FundTransferIn() {
		@Override
		public String getText() {
			return "基金转换入";
		}
		
		@Override
		public String getValue() {
			return "14";
		}

		@Override
		public String getOperation() {
			return "+";
		}
	},
	FundEstablished() {
		@Override
		public String getText() {
			return "基金成立";
		}
		
		@Override
		public String getValue() {
			return "15";
		}

		@Override
		public String getOperation() {
			return "+";
		}
	},
	FundTermination() {
		@Override
		public String getText() {
			return "基金终止";
		}
		
		@Override
		public String getValue() {
			return "16";
		}

		@Override
		public String getOperation() {
			return "";
		}
	},
	FundClearing() {
		@Override
		public String getText() {
			return "基金清盘";
		}
		
		@Override
		public String getValue() {
			return "17";
		}

		@Override
		public String getOperation() {
			return "";
		}
	},
	IssuingFailing() {
		@Override
		public String getText() {
			return "发行失败";
		}
		
		@Override
		public String getValue() {
			return "18";
		}

		@Override
		public String getOperation() {
			return "";
		}
	},
	ForcedIncrease() {
		@Override
		public String getText() {
			return "强制调增";
		}
		
		@Override
		public String getValue() {
			return "19";
		}

		@Override
		public String getOperation() {
			return "+";
		}
	},
	ForcedLess() {
		@Override
		public String getText() {
			return "强制调减";
		}
		
		@Override
		public String getValue() {
			return "20";
		}

		@Override
		public String getOperation() {
			return "-";
		}
	},
	DividendPayment() {
		@Override
		public String getText() {
			return "红利发放";
		}
		
		@Override
		public String getValue() {
			return "21";
		}

		@Override
		public String getOperation() {
			return "";
		}
	};
	

	public abstract String getText();

	public abstract String getValue();
	
	public abstract String getOperation();

}
