package dataTypesOperations.stringOperations;

public class Regex {

    public static void main(String[] args) {
        String toAddress = "+90121212112E";
         String tempToAsress = toAddress. replaceAll("[^0-9a-fA-F]","F");
         
        System.out.println(toAddress);
        System.out.println(tempToAsress);

    }
}
