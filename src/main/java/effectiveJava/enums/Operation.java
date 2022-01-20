package effectiveJava.enums;

public enum Operation {
	PLUS("+") {
		@Override
		public double apply(double x, double y) {
			return x + y;
		}
	}, MINUS("-") {
		@Override
		public double apply(double x, double y) {
			return x - y;
		}
	}, CROSS("*") {
		@Override
		public double apply(double x, double y) {
			return x * y;
		}
	}, DIVIDE("/") {
		@Override
		public double apply(double x, double y) {
			return x / y;
		}
	};
	private String symbol;
	
	Operation(String symbol) {
		this.symbol = symbol;
	}
	
	public abstract double apply(double x, double y);
	
	@Override
	public String toString() {
		return symbol;
		
	}
	
	public static void main(String[] args) {
		double x = 3.1;
		double y = 2.6;
		for (Operation operation : values()) {
			System.out.println(x + operation.toString() + y + " = " + operation.apply(x, y));
		}
	}
}
