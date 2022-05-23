package dataTypesOperations.dateOperations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderTest {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
        	
            Date date = sdf.parse("2020-03-01");
            Calendar today = Calendar.getInstance();
            System.out.println(getLastMonthEndTime(today).getTime());
	
			long val = today.getTimeInMillis();
			Date dates=new Date(val);
			SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
			String dateText = df2.format(dates);
			System.out.println("formatted: " + dateText);
	
			System.out.println("formatted date : " + getFormattedDate("dd.MM.yyyy HH:mm:ss"));
			
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    
    public static Calendar getLastMonthEndTime(Calendar today) {
        // set yesterday's date...
        Calendar calendar = Calendar.getInstance();
        if (today != null) {
            calendar.setTimeInMillis(today.getTimeInMillis());
        }
        calendar.add(Calendar.MONTH, -1);
        calendar.set(Calendar.DAY_OF_MONTH, 31);
        calendar.set(Calendar.HOUR_OF_DAY, 0);
        calendar.set(Calendar.MINUTE, 0);
        calendar.set(Calendar.SECOND, 0);
        calendar.set(Calendar.MILLISECOND, 0);

        return calendar;
    }
	
	public static String getFormattedDate(String pattern){
		Date date = new Date();
		try {
			SimpleDateFormat sdt = new SimpleDateFormat("dd.MM.yyyy HH:mm:ss");
			return sdt.format(date);
		}catch (Exception e){
			System.out.println("Date Format Error..." + e);
		}
		return date.toString();
	}
}

