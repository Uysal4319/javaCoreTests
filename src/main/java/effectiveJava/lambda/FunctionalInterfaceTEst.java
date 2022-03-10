package effectiveJava.lambda;

import java.util.function.BinaryOperator;

public class FunctionalInterfaceTEst {
	public static void main(String[] args) {
		BinaryOperator<Integer> op =
				BinaryOperator.maxBy((a,b)-> (a>b) ? 1 :(a==b) ? 0 : -1 );
		// apply bifunctional interface inden geliyor.
		System.out.println(op.apply(15,89));
		 
	}
}
