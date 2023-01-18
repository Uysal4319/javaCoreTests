package dataTypesOperations.objectOperations;

import oopBasics.classes.Human;

public class CastOperations {

    public static void main(String[] args) {

    	Human human = new Human();
	
//		formaters.jsonOperations.Student student = (formaters.jsonOperations.Student) human;
    	
        int intValue = 128;
        byte byteValue = (byte) intValue;
        System.out.println(byteValue);
        
        long imsi = 286032154;
        String test = String.valueOf(imsi);
        System.out.println(test);
    }
}
