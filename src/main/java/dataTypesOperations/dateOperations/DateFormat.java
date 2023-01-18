package dataTypesOperations.dateOperations;

import java.util.Date;
import java.util.Locale;

public class DateFormat {
	private final static java.text.DateFormat DATE_FORMATTER =
			java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT, new Locale("tr", "TR"));
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		System.out.println(getSecondChanged(date,"+0"));
		System.out.println(date);
		System.out.println(formatDate(date));
	}
	
	public static  String formatDate(Date date) {
		if ( date == null )
			return "";
		return DATE_FORMATTER.format(date);
	}
	
	public static Date getSecondChanged(Date date, String elapsedTime) {
		try {
			if(elapsedTime.startsWith("-")){
				int value = Integer.parseInt(elapsedTime.substring(1));
				date.setSeconds(date.getSeconds() - value);
			} else if(elapsedTime.startsWith("+")){
				int value = Integer.parseInt(elapsedTime.substring(1));
				date.setSeconds(date.getSeconds() + value);
			}else {
				date.setSeconds(date.getSeconds() - 8);
			}
		} catch (Throwable t) {
			date.setSeconds(date.getSeconds() - 8);
		}
		return date;
	}
}
