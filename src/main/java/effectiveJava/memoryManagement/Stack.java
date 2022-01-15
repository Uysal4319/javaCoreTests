package effectiveJava.memoryManagement;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class Stack implements Cloneable {
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
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Stack stack = (Stack) o;
		return size == stack.size && Arrays.equals(elements, stack.elements);
	}
	
	@Override
	public int hashCode() {
		int result = Objects.hash(size);
		result = 31 * result + Arrays.hashCode(elements);
		return result;
	}
	
	@Override
	public String toString() {
		return "Stack{" +
				"elements=" + Arrays.toString(elements) +
				", size=" + size +
				'}';
	}
	
//	@Override
//	public Object clone() throws CloneNotSupportedException {
//		return super.clone();
//	}
	//very imported for Deep Copy
	@Override
	public Stack clone(){
		try {
			Stack newStack = (Stack) super.clone();
			newStack.elements = elements.clone();
			return newStack;
		}catch (CloneNotSupportedException e ){
			throw new AssertionError();
		}
	}
	public boolean isEmpty(){
		return size == 0;
	}
}
