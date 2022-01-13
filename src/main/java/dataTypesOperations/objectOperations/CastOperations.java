package dataTypesOperations.objectOperations;

import oopBasics.classes.Human;

public class CastOperations {

    public static void main(String[] args) {

    	Human human = new Human();
	
//		formaters.jsonOperations.Student student = (formaters.jsonOperations.Student) human;
    	
        int uysal = 128;
        byte ertu = (byte) uysal;
        System.out.println(ertu);


        long imsi = 286032154;
        String test = String.valueOf(imsi);
        System.out.println(test);
    }
}
