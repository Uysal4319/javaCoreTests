package dataTypesOperations.bigDecimalOperations;

import java.math.BigDecimal;
import java.math.MathContext;

public class BigDecimalTest {
	
	public static void main(String[] args) {
		double a = 1.15;
		double b = 0.25;
		System.out.println("kalan: " + (a - b));
		
		double a1 = 1.15;
		double b1 = 0.25;
		System.out.println("toplam: " + (a1 + b1));
		
		MathContext format = new MathContext(4);
		BigDecimal bigDecimal = new BigDecimal("1.15");
		BigDecimal bigDecimal2 = new BigDecimal("0.25");
		System.out.println("Kalan: " +bigDecimal.subtract(bigDecimal2));
		
		System.out.println("Bolum: "+ bigDecimal.divide(bigDecimal2,format) );
	}
}
