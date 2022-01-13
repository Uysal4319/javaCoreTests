package dataTypesOperations.stringOperations;

public class StringInitialize {

    public static void main(String[] args) {
       StringObject sinit= getObject();
        System.out.println(sinit.getDataString());
    }

    public  static StringObject getObject() {
        return new StringObject();
    }
}
