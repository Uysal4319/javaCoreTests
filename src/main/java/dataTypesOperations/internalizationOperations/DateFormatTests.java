package dataTypesOperations.internalizationOperations;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class DateFormatTests {
    public static void main(String[] args) throws ParseException {
        Locale locale = new Locale("tr","TR");

        DateFormat dateFormat = DateFormat.getDateInstance();

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT, locale);

        System.out.println(dateFormat.format(new Date()));

        System.out.println("------------------------------------------------");

        dateFormat = DateFormat.getDateInstance(DateFormat.DEFAULT);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateInstance(DateFormat.SHORT);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateInstance(DateFormat.MEDIUM);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateInstance(DateFormat.LONG);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateInstance(DateFormat.FULL);

        System.out.println(dateFormat.format(new Date()));

        System.out.println("-------------------------------------------------");


        dateFormat = DateFormat.getTimeInstance(DateFormat.DEFAULT);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getTimeInstance(DateFormat.MEDIUM);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getTimeInstance(DateFormat.LONG);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getTimeInstance(DateFormat.FULL);

        System.out.println(dateFormat.format(new Date()));

        System.out.println("--------------------------------------------------");

        dateFormat = DateFormat.getDateTimeInstance(DateFormat.DEFAULT, DateFormat.DEFAULT);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateTimeInstance(DateFormat.SHORT, DateFormat.SHORT);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateTimeInstance(DateFormat.MEDIUM, DateFormat.MEDIUM);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG);

        System.out.println(dateFormat.format(new Date()));

        dateFormat = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL);

        System.out.println(dateFormat.format(new Date()));

        //SimpleDate Format
        System.out.println("-----------------------------------------------------");
        String pattern = "dd-MM-yyyy";

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);

        Date date = new Date();

        System.out.println(date);
        System.out.println(simpleDateFormat.format(date));

        String dateText = "29-11-2017";

        date = simpleDateFormat.parse(dateText);

        System.out.println(simpleDateFormat.format(date));

        System.out.println("------------------------------------------------------");

         pattern = "EEEEE MMMMM yyyy";

         simpleDateFormat = new SimpleDateFormat(pattern);

         date = new Date();

        System.out.println(date);
        System.out.println(simpleDateFormat.format(date));

        simpleDateFormat = new SimpleDateFormat(pattern,locale);

        System.out.println(simpleDateFormat.format(date));


        System.out.println("-------------------------------------------------------");

        // Patterns

        pattern = "dd-MM-yy";
        simpleDateFormat = new SimpleDateFormat(pattern);
        date = new Date();
        System.out.println(simpleDateFormat.format(date));

        pattern = "MM-dd-yyyy";
        simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println(simpleDateFormat.format(date));

        pattern = "yyyy-MM-dd HH:mm:ss";
        simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println(simpleDateFormat.format(date));

        pattern = "EEEEE MMMMM yyyy HH:mm:ss.SSSZ";
        simpleDateFormat = new SimpleDateFormat(pattern);
        System.out.println(simpleDateFormat.format(date));

        // UTC

        System.out.println("------------------------------------------------------");

        Calendar calender = new GregorianCalendar();

        calender.setTimeZone(TimeZone.getTimeZone("Etc/UTC"));
        calender.set(Calendar.HOUR_OF_DAY, 12);

        System.out.println("UTC: " + calender.get(Calendar.HOUR_OF_DAY));
        System.out.println("UTC: " + calender.getTimeInMillis());

        calender.setTimeZone(TimeZone.getTimeZone("Europe/Copenhagen"));
        System.out.println("CPH: " + calender.get(Calendar.HOUR_OF_DAY));
        System.out.println("CPH: " + calender.getTimeInMillis());

        calender.setTimeZone(TimeZone.getTimeZone("Turkey/Istanbul"));
        System.out.println("IST: " + calender.get(Calendar.HOUR_OF_DAY));
        System.out.println("IST: " + calender.getTimeInMillis());
    }
}
