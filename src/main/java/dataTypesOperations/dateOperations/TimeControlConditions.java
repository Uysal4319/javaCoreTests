package dataTypesOperations.dateOperations;

import java.util.Calendar;

public class TimeControlConditions {
	
	public static void main(String[] args) {
		Calendar now = Calendar.getInstance();
		int hour = now.get(Calendar.HOUR_OF_DAY);
		int minute = now.get(Calendar.MINUTE);
		int hourToCheck = 13;
		int minuteToCheck = 18;
		if (hour == hourToCheck && minute == minuteToCheck) {
			System.out.println("In Time :" + hourToCheck + ":" + minuteToCheck);
		} else {
			System.out.println("Out Time :" + hourToCheck + ":" + minuteToCheck);
		}
	}
}
