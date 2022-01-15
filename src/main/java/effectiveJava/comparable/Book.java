package effectiveJava.comparable;

import java.util.Objects;

public class Book implements Comparable<Book> {
	
	private  String name;
	private  int pageCount;
	
	public Book(String name, int pageCount) {
		this.name = name;
		this.pageCount = pageCount;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getPageCount() {
		return pageCount;
	}
	
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Book book = (Book) o;
		return getPageCount() == book.getPageCount() && getName().equals(book.getName());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getName(), getPageCount());
	}
	
	@Override
	public String toString() {
		return "Book{" +
				"name='" + name + '\'' +
				", pageCount=" + pageCount +
				'}';
	}
	
	@Override
	public int compareTo(Book o) {
		return this.pageCount - o.pageCount;
	}
}
