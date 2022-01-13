package effectiveJava.memoryManagement;

import java.util.Arrays;
import java.util.EmptyStackException;

public class Stack {
	public Object[] elements;
	public int size = 0;
	public static final int INITIAL_CAPACITY = 16;
	
	public void finalize() {
		System.out.println("Çöpler silindi.");
	}
	
	public Stack() {
		elements = new Object[INITIAL_CAPACITY];
	}
	
	public void push(Object e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public Object pop() {
		if (size == 0)
			throw new EmptyStackException();
		
		return elements[--size];
	}
	
	public Object popWell() {
		if (size == 0)
			throw new EmptyStackException();
		
		Object result = elements[--size];
		elements[size] = null;
		
		return result;
	}
	
	private void ensureCapacity() {
		if (elements.length == size) {
			elements = Arrays.copyOf(elements, 2 * size + 1);
		}
	}
}
