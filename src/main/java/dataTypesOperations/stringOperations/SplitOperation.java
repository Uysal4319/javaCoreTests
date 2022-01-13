package dataTypesOperations.stringOperations;

import java.util.Arrays;

public class SplitOperation {

    public static void main(String[] args) {

        Integer[] xdrIndexes = splitXDRFields("1|2|3|3");
        Arrays.stream(xdrIndexes).forEach(System.out::println);

   		String keyValue = "masterName=masterRedis";

        System.out.println(keyValue.split("=")[1]);

    }

    public static Integer[] splitXDRFields(String xdrFields) {

        String fields[] = xdrFields.split("\\|");

        if (fields == null || fields.length <= 0) {

            return null;
        }

        int count = fields.length;
        Integer xdrFieldIndexes[] = new Integer[count];
        try {
            for (int i = 0; i < count; i++) {
                xdrFieldIndexes[i] = new Integer(fields[i]);

            }
            return xdrFieldIndexes;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }
}
