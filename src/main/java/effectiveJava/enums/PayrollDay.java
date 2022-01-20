package effectiveJava.enums;

public enum PayrollDay {
	MONDAY(PayType.WEEKDAY), TUESDAY(PayType.WEEKDAY), WEDNESDAY(PayType.WEEKDAY), THURSDAY(PayType.WEEKDAY), FRIDAY(PayType.WEEKDAY),
	SATURDAY(PayType.WEEKEND), SUNDAY(PayType.WEEKEND);
	
	private final PayType payType;
	
	PayrollDay(PayType payType) {
		this.payType = payType;
	}
	
	int pay(int minutesWork, int payRate) {
		return payType.pay(minutesWork, payRate);
	}
	
	enum PayType {
		WEEKDAY {
			@Override
			int overTimePay(int mins, int payRate) {
				return mins <= MINS_PER_SHIFT ? 0 : (mins - MINS_PER_SHIFT) * payRate / 2;
			}
		},
		WEEKEND {
			@Override
			int overTimePay(int mins, int payRate) {
				return mins * payRate / 2;
			}
		};
		
		abstract int overTimePay(int mins, int payRate);
		
		public static final int MINS_PER_SHIFT = 8 * 60;
		
		int pay(int minutesWork, int payRate) {
			int basePay = minutesWork * payRate;
			return basePay + overTimePay(minutesWork, payRate);
		}
	}
	
	public static void main(String[] args) {
		for (PayrollDay payrollDay : values()) {
			System.out.println(payrollDay + " -> " + payrollDay.pay(8 * 60, 1));
		}
	}
}
