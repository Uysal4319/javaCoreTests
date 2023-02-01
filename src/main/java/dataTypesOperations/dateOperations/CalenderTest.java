package dataTypesOperations.dateOperations;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CalenderTest {

    public static void main(String[] args) {
		createCustomCalendar();
//      parseSDF();
//      calendarToDate();
//		compareCalendar();
//		iterateCalendar();
    }
    public  static void iterateCalendar(){
		Calendar today = Calendar.getInstance();
		System.out.println("today: " + today.getTime());
	
		today.add(Calendar.DAY_OF_MONTH, 4);
		today.add(Calendar.MINUTE, 2500);
		System.out.println("tomorrow: " + today.getTime());
	}
    
    public static void compareCalendar(){
		Calendar today = Calendar.getInstance();
		System.out.println("today: " + today.getTime());
	
		Calendar tomorrow = Calendar.getInstance();
		tomorrow.set(Calendar.MONTH, 2);
		System.out.println("tomorrow: "+ tomorrow.getTime());
	
		System.out.println("today.after(tomorrow): "+today.after(tomorrow));
		System.out.println("today.before(tomorrow): "+today.before(tomorrow));
		System.out.println("today.after(today) : "+today.after(today));
		System.out.println("today.equals(today): "+today.equals(today));
		
	}

    public static void parseSDF(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse("2020-03-01");
			Calendar today = Calendar.getInstance();
			System.out.println(getLastMonthEndTime(today).getTime());
		
			long val = today.getTimeInMillis();
			Date dates=new Date(val);
//			SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
			SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String dateText = df2.format(dates);
			System.out.println("formatted: " + dateText);
			System.out.println("formatted date : " + getFormattedDate("dd.MM.yyyy HH:mm:ss"));
		
		} catch (Exception e) {
			System.out.println(e);
		}
	}
    public static void calendarToDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			Date date = sdf.parse("2020-03-01");
			Calendar today = Calendar.getInstance();
			System.out.println(getLastMonthEndTime(today).getTime());
		
			long val = today.getTimeInMillis();
			Date dates=new Date(val);
//			SimpleDateFormat df2 = new SimpleDateFormat("MM/dd/yy hh:mm:ss");
			SimpleDateFormat df2 = new SimpleDateFormat("yyyyMMddHHmmssSSS");
			String dateText = df2.format(dates);
			System.out.println("formatted: " + dateText);
			System.out.println("formatted date : " + getFormattedDate("dd.MM.yyyy HH:mm:ss"));
		
		} catch (Exception e) {
			System.out.println(e);
		}
    	
	}
	public static void createCustomCalendar(){
		Calendar calendar = Calendar.getInstance();
		calendar.set(Calendar.YEAR, 2023);
		calendar.set(Calendar.MONTH, Calendar.JANUARY);
		calendar.set(Calendar.DATE, 31);
		calendar.set(Calendar.HOUR_OF_DAY, 23);
		calendar.set(Calendar.MINUTE, 31);
		
		Date date = calendar.getTime();
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm");
		String formattedDate = sdf.format(date);
		System.out.println(formattedDate);
		
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

