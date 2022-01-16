package effectiveJava.mutable;

import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class MutableAndImmutableTests {
	public static void main(String[] args) {
		// immutable
		String string = new String("Hello");
		string.toUpperCase(Locale.ROOT);
		System.out.println(string);
		
		//mutable
		Date date = new Date();
		System.out.println(date);
		date.setDate(1);
		System.out.println(date);
		
		// immutable
		LocalDate localDate = LocalDate.now();
		System.out.println(localDate);
		localDate.plusDays(2);
		System.out.println(localDate);
		
//		Mutable mutable = new Mutable(2);
//		Immutable immutable = (Immutable) mutable;
//		System.out.println(immutable.getValue());
//		mutable.setValue(4);
//		System.out.println(immutable.getValue());
	}
}
