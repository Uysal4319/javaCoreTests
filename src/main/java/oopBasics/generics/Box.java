package oopBasics.generics;

import java.util.ArrayList;
import java.util.List;

public class Box<E, S> {
	
	private List<E> list = new ArrayList<>();
	private S s;
	
	
	public void add(E e) {
		this.list.add(e);
	}
	
	public void add(E e, S s) {
		this.list.add(e);
		this.s = s;
	}
	
	public int size() {
		return this.list.size();
	}
	
	public E get(int i) {
		return this.list.get(i);
	}
	
	public E getFirst() {
		return this.list.get(0);
	}
	
	public S getSecond() {
		return s;
	}
	
}
