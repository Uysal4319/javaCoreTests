package dataTypesOperations.dateOperations;

import java.util.Date;
import java.util.Locale;

public class DateFormat {
	private final static java.text.DateFormat DATE_FORMATTER =
			java.text.DateFormat.getDateInstance(java.text.DateFormat.SHORT, new Locale("tr", "TR"));
	
	public static void main(String[] args) {
		Date date = new Date();
		System.out.println(date);
		System.out.println(formatDate(date));
	}
	
	public static  String formatDate(Date date) {
		if ( date == null )
			return "";
		return DATE_FORMATTER.format(date);
	}
}
