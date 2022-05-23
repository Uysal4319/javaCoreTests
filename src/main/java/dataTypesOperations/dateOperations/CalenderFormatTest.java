package dataTypesOperations.dateOperations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderFormatTest {
	
	public static void main(String[] args) {
		Calendar today = Calendar.getInstance();
		System.out.println("today: " + today.getTime());
		long val = today.getTimeInMillis();
		Date dates=new Date(val);
		SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
		String dateText = df2.format(dates);
		System.out.println("formatted: " + dateText);
	}
}
