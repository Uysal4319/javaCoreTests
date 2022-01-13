package dataTypesOperations.internalizationOperations;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

public class NumberFormatTest {

    public static void main(String[] args) throws ParseException {

        Locale locale = new Locale("tr","tr");
        Locale locale1 = new Locale("us","us");

        NumberFormat numberFormat = NumberFormat.getInstance(locale);
        System.out.println(numberFormat.format(100.76));

        numberFormat = NumberFormat.getInstance(locale1);
        System.out.println(numberFormat.format(100.76));

        // Currency Format
        System.out.println("-------------------------------");

        numberFormat = NumberFormat.getCurrencyInstance(locale);
        System.out.println(numberFormat.format(100.76));

        numberFormat= NumberFormat.getCurrencyInstance(locale1);
        System.out.println(numberFormat.format(100.76));

        // Percentages
        System.out.println("-------------------------------");

        numberFormat = NumberFormat.getPercentInstance(locale);
        System.out.println(numberFormat.format(0.76));

        numberFormat = NumberFormat.getPercentInstance(locale1);
        System.out.println(numberFormat.format(0.76));

        // Min/Max Precision
        System.out.println("-------------------------------");

        numberFormat = NumberFormat.getInstance(locale);

        numberFormat.setMinimumIntegerDigits(2);
        numberFormat.setMaximumIntegerDigits(3);

        numberFormat.setMinimumFractionDigits(2);
        numberFormat.setMaximumFractionDigits(3);

        System.out.println(numberFormat.format(12234.763443));

        // Rounding Mode
        System.out.println("-------------------------------");

        numberFormat.setMinimumFractionDigits(0);
        numberFormat.setMaximumFractionDigits(0);

        System.out.println(numberFormat.format(99.50));

        numberFormat.setRoundingMode(RoundingMode.HALF_DOWN);

        System.out.println(numberFormat.format(99.50));

        //Parsing Number

        System.out.println("-------------------------------");

        numberFormat = NumberFormat.getInstance(locale);

        System.out.println(numberFormat.parse("100,76"));

        numberFormat = NumberFormat.getInstance(locale1);

        System.out.println(numberFormat.parse("100,76"));


        // Decimal Formating
        System.out.println("-------------------------------");

        String pattern = "####,####.##";
        double number = 123456789.123;

        DecimalFormat decimalFormat = new DecimalFormat(pattern);

        System.out.println(number);

        System.out.println(decimalFormat.format(number));

         pattern = "###.##";
         number = 123.45;
        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale);
        decimalFormat.applyPattern(pattern);

        System.out.println(decimalFormat.format(number));


        decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(locale1);
        decimalFormat.applyPattern(pattern);

        System.out.println(decimalFormat.format(number));


    }
}
