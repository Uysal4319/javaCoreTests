package dataTypesOperations.integerOperations;

import dataTypesOperations.byteOperations.ByteOperation;
import org.apache.commons.lang3.ArrayUtils;

public class ParseInt {
	
	public static void main(String[] args) {
		Operator operator = new Operator((byte)1,"sdfasd");
		System.out.println(operator.getOperatorId());
		hoRelNumToBytes("FF");
	}
	
	public static byte[] hoRelNumToBytes(String hoRelNumStr) {
		byte[] bytes = new byte[8];
		
		bytes  = ByteOperation.hexStringToByteArray(hoRelNumStr);
		
		System.out.println();
		int hoRel = Integer.parseInt(hoRelNumStr);
		byte[] hoRElNumBytes = toByteArray(hoRel);
		ArrayUtils.reverse(hoRElNumBytes);
		byte[] filler = {(byte) 0xFF, (byte) 0xFF, (byte) 0xFF, (byte) 0xFF};
		return ArrayUtils.addAll(hoRElNumBytes, filler);
	}
	private static byte[] toByteArray(int value) {
		return new byte[]{(byte) (value >> 24), (byte) (value >> 16), (byte) (value >> 8), (byte) value};
	}
}

