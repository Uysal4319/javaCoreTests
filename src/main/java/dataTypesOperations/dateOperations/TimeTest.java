package dataTypesOperations.dateOperations;

import java.util.Calendar;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        Date callDuration ;
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.clear(Calendar.ZONE_OFFSET);
        cal.add(Calendar.MILLISECOND, (int) 999);

        callDuration = cal.getTime();
        System.out.println(callDuration);

    }
}
