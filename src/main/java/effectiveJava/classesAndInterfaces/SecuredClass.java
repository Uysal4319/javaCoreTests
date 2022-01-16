package effectiveJava.classesAndInterfaces;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SecuredClass {
	
	private static final String[] array = new String[5];
	private static final List<String> array2 = Collections.unmodifiableList(Arrays.asList(array));
	
}
