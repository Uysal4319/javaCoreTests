package effectiveJava.annotations;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class BigRam {
	public String first;
	
	public BigRam(String first) {
		this.first = first;
	}
	
	public String getFirst() {
		return first;
	}
	
	public void setFirst(String first) {
		this.first = first;
	}
	
	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		BigRam bigRam = (BigRam) o;
		return Objects.equals(getFirst(), bigRam.getFirst());
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(getFirst());
	}
	
	public static void main(String[] args) {
		Set<BigRam> bigRams = new HashSet<>();
		bigRams.add(new BigRam("a"));
		bigRams.add(new BigRam("b"));
		bigRams.add(new BigRam("a"));
		bigRams.add(new BigRam("b"));
		
		System.out.println(bigRams.size());
	}
}
