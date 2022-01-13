package dataTypesOperations.objectOperations;

import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ObjectValidate {

    private static String      dateFormat           = "yyyy-MM-dd HH:mm:ss";

    public static void main(String[] args) {

        Object a = null;

        Date now =new Date();
        System.out.println(formatCdrData(now));

        if(a == null){
            System.out.println("a null");
        }else {
            System.out.println("a null değil");
        }
    }

    public static String formatCdrData(Date date) {
        if (date == null) {
            return null;
        }

        Format formatter = new SimpleDateFormat(dateFormat);
        return formatter.format(date);
    }
}
