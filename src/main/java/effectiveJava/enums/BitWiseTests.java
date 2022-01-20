package effectiveJava.enums;

public class BitWiseTests {
	// 0000
	// 0001 
	// 0011
	// 0111
	public static void main(String[] args) {
		int x = -4;
		System.out.println(x + ">>1 = " + (x >> 1));
		
		int y = 4;
		System.out.println(y + ">>1 = " + (y >> 1));
		
		int z = -1;
		System.out.println(z + ">>>31 = " + (z >>> 31));
		
		int t = 2;
		System.out.println(t + "<<1 = " + (t << 1));
		
		System.out.println(1 << 2);
	}
}
