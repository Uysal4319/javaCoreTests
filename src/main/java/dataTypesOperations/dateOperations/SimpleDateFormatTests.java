package dataTypesOperations.dateOperations;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatTests {
	
	public static void main(String[] args) {
		String strCurrentDate = SimpleDateFormat.getInstance().format(new Date());
		System.out.println(strCurrentDate);
		
		DateFormat format = SimpleDateFormat.getInstance();
		
		try {
			Date date = format.parse(strCurrentDate);
			System.out.println("reparse date : " + date);
			SimpleDateFormat newFormat = new SimpleDateFormat("yyyyMMddHHmmss");
			String dateText = newFormat.format(date);
			System.out.println("newFormated date: " + dateText);
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
