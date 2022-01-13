package dataTypesOperations.stringOperations;

import java.util.ArrayList;
import java.util.List;

public class StringOperation {


    public static void main(String[] args) {
        
        String test = "1,4,9,15,16,17,18,19,22,24,25,26,27,28,29,30,31,32,33,34,35,36,37,38,39,40,41,42,43,44,45,46,47,48,49,50,51,52,53,54,55,56,57,58,59,60,61,62,63,64,65,66,67,68,69,70,71,72,73,74,75,76,77,78,79,80,81,82,83,84,85,86,87,88,89,90,91,92,93,94,95,96,97,98,99,100,101,102,103,104,105,106,107,108,109,110,111,112,113,114,115,116,117,118,119,120,121,122,123,124,125,126,127,128,129,130,131,132,133,134,135,136,137,138,139,140,141,142,143,144,145,146,147,148,149,150,151,152,153,154,155,156,157,158,159,160,161,162,163,164,165,166,167,168,169,170,171,172,173,174,175,176,177,178,179,180,181,182,183,184,185,186,187,188,189,190,191,192,193,194,195,196,197,198,199,200,201,202,203,204,205,206,207,208,209,210,211,212,213,214,215,216,217,218,220,221,223,224,225,226,227,228,229,230,231,232,233,234,235,236,237,238,239,240,241,242,243,244,245,246,247,248,249,250,251,252,253,254";
	
        String nullCheck = "";
	
		System.out.println(nullCheck.equalsIgnoreCase("nullCheck"));
//		System.out.println(test.trim());
//		System.out.println("63/64 : " + (63/64));
//        System.out.println(msisdnFormater("00994501234567"));
//
//        startWithMethodTest();
//		replaceMethodTest();
		subStringMethodTest();
//		
//		trimMethodTest();
//		soutNullTest();
		
		String xmlString = "<tag> <OMSYSTEM>OCS</tag><tag1>01020310230</tag1>";
	
		subStringBetweenTwoWord(xmlString);
		
//        Integer nullInteger = null;
//        String nullString =    Integer.toString(nullInteger);
//
//        if (nullString != null){
//
//            System.out.println("null dan geçti");
//        }

        Integer buyukInt = 1;

        int kucukInt =1;

        if (buyukInt == kucukInt) {
            System.out.println("eşitler");
        }



    }

    public static String msisdnFormatter(String msisdn) {
        List<String> ownGtPrefixList = new ArrayList<>();
        ownGtPrefixList.add("99450");
        ownGtPrefixList.add("99451");

        String ownCountryCode = "994";

        for (String item : ownGtPrefixList) {

            if (msisdn.startsWith(item)) {

                return msisdn;
            } else if (msisdn.startsWith(item.substring(ownCountryCode.length()))) {

                return ownCountryCode + msisdn;
            } else if (msisdn.startsWith("00" + ownCountryCode)) {

                return msisdn.substring(2);
            }
        }
        return "";
    }


    private String msisdnConverter(String msisdn) {
        return msisdn;
    }

    private static void startWithMethodTest() {
        String text = "sdfsadf";
        String startWith = "";

        List<String> list = new ArrayList<>();
        list.add(startWith);

        for (String prefix : list) {

            if (text.startsWith(startWith)) {
                System.out.println("prefix : " + prefix);
            }
        }

    }
	
	private static void replaceMethodTest() {
		String text = "sdfsa#HELLO#df";
		String replaced = text.replace("#HELLO#","");
		
		System.out.println("replaced : " + replaced );
		
	}
	private static void trimMethodTest() {
		String text = "  sdf sa#H ELLO #df  ";
		String empty = "  5";
		System.out.println("trim li : " + text.trim() );
		
		if(empty == null || empty.trim().isEmpty()){
			System.out.println("empty : "+ empty);
		}
		
	}
	
	private static void subStringMethodTest() {	
		String s = "01234562";
		
		System.out.println("substring remove first element :" + s.substring(1));
		String ss = s.substring(2);
			
		int index = s.indexOf('2', 0);
		int indexlast = s.lastIndexOf('2');
		System.out.println(ss);
		System.out.println("s size : "+s.length());
		System.out.println(Integer.parseInt(s.substring(5, 7), 16));
		
	}
	
	public static void subStringBetweenTwoWord(String s){
    	
    	int firstIndex = s.indexOf("<tag>");
    	int lastIndex = s.indexOf("</tag>");
		
		System.out.println(s.substring(firstIndex + 10 ,lastIndex));
    	
	}
	
	private static void soutNullTest() {
		String s = null;
		
		System.out.println("lfdsjgdf "+ s +" sdfgsdf");
	}
}
