package effectiveJava.generics;

import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Objects;

public class StackWithGenerics<E> implements Cloneable {
	public E[] elements;
	public int size = 0;
	public static final int INITIAL_CAPACITY = 16;
	
	public void finalize() {
		System.out.println("Çöpler silindi.");
	}
	
	@SuppressWarnings("unckecked")
	public StackWithGenerics() {
		elements = (E[]) new Object[INITIAL_CAPACITY];
	}
	
	public void push(E e) {
		ensureCapacity();
		elements[size++] = e;
	}
	
	public E pop() {
		if (size == 0)
			throw new EmptyStackException();
		
		return elements[--size];
	}
	
	public E popWell() {
		if (size == 0)
			throw new EmptyStackException();
		
		E result = elements[--size];
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
		StackWithGenerics stackWithGenerics = (StackWithGenerics) o;
		return size == stackWithGenerics.size && Arrays.equals(elements, stackWithGenerics.elements);
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
	public StackWithGenerics clone(){
		try {
			StackWithGenerics newStackWithGenerics = (StackWithGenerics) super.clone();
			newStackWithGenerics.elements = elements.clone();
			return newStackWithGenerics;
		}catch (CloneNotSupportedException e ){
			throw new AssertionError();
		}
	}
	public boolean isEmpty(){
		return size == 0;
	}
}
