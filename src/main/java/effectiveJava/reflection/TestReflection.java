package effectiveJava.reflection;

import java.lang.reflect.*;

public class TestReflection {
	
	public static void main(String[] args) {
		try {
			Class<?> employee = Class.forName("oopBasics.abstractions.Employee");
			
			Constructor<?> constructor = employee.getDeclaredConstructor(String.class, Integer.TYPE, String.class);
			
			for (Field field : employee.getDeclaredFields()) {
				System.out.println("Field: " + field.getName() );
			}
			
			System.out.println("Modifiers : " + constructor.getModifiers());
			System.out.println("Modifier : " + Modifier.toString(constructor.getModifiers()));
			
			System.out.println("Name : " +constructor.getName() );
			System.out.println("IsAccessible : " +constructor.isAccessible() );
			System.out.println("IsSynthetic: " +constructor.isSynthetic() );
			System.out.println("IsVarArgs: " +constructor.isVarArgs() );
			
			Method ageSet = employee.getMethod("setAge", int.class);
			ageSet.invoke(constructor,13);
			
			Method ageGet = employee.getMethod("getAge");
			System.out.println(ageGet.invoke(employee));
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
	}
}
