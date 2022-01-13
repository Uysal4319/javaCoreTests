package dataTypesOperations.byteOperations;

import javax.xml.bind.DatatypeConverter;
import java.util.ArrayList;
import java.util.List;

public class ByteOperation {
	
	public static void main(String[] args) {


//    	byte[] array;
//
//    	if (array ==null){
//
//		}
		byte b = 3;
		int in = 2;
		
		in = b;
		if (b == in) {
			System.out.println("equal");
		} else {
			System.out.println("not equal");
		}
		
		System.out.println(toHexString(new byte[]{4, 0, 0, 1, 0, 50, 1}));
		System.out.println(toHexString(new byte[]{42, -122, 58, 0, -119, 97, 51, 1, 1, 1, 0, 1}));
		System.out.println(toHexString(new byte[]{42, -122, 58, 0, -119, 97, 51, 1, 1, 1, 2, 1}));
		
		List<String> test = new ArrayList<>();
		
		System.out.println(test.contains("0"));
		
		byte[] bytes = hexStringToByteArray("496E7465726E6574");
		
		System.out.println("Internet hex = " + toHexString(bytes));
		
		for (int i = 0; i < bytes.length; i++) {
			
			System.out.print(bytes[i]);
		}
	}
	
	public static String toHexString(byte[] array) {
		return DatatypeConverter.printHexBinary(array);
	}
	
	public static byte[] hexStringToByteArray(String s) {
		int len = s.length();
		byte[] data = new byte[len / 2];
		for (int i = 0; i < len; i += 2) {
			data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
					+ Character.digit(s.charAt(i + 1), 16));
		}
		return data;
	}
	
	public static int findPattern(byte[] data, byte[] pattern) {
		
		try {
			int dataLen = data.length;
			int patternLen = pattern.length;
			
			boolean found = false;
			int i = 0;
			for (i = 0; i < dataLen; ++i) {
				found = true;
				if (dataLen - i < patternLen) {
					found = false;
					break;
				}
				for (int j = 0; j < patternLen; ++j) {
					if (data[i + j] != pattern[j]) {
						found = false;
						break;
					}
				}
				if (found) {
					return i;
				}
			}
			return -1;
		} catch (Exception e) {
			
			System.out.println("error : " + e);
			return -1;
		}
		
	}
	
}
