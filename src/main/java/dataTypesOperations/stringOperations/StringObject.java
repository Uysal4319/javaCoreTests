package dataTypesOperations.stringOperations;

public class StringObject {

    public byte[]  data ;

    public String getDataString() {
        if(data != null){
            return new String(data);
        }
        return "data is null";
    }
}
