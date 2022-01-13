package dataTypesOperations.byteOperations;

public class ArrayCopy {
	public static void main(String[] args) {
		byte[] a = new byte[2657];
		for (int i = 0; i < a.length; i++) {
			a[i] = (byte) i;
		}
		byte[] b = new byte[2615];
		
		System.arraycopy(a, 42, b, 0, 2615);
		
		for (int i = 0; i < b.length; i++) {
			System.out.println(b[i]);
		}
	}
}

