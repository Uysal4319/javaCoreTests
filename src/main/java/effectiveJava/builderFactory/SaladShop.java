package effectiveJava.builderFactory;

public class SaladShop {
	// Mandatory
	private int orderID;
	private String size;
	
	// Optional 
	private String oilType;
	private boolean tomato;
	private boolean paper;
	
	public static class Builder{
		// Mandatory
		private int orderID;
		private String size;
		
		// Optional 
		private String oilType;
		private boolean tomato;
		private boolean paper;
		
		public Builder(int orderID, String size) {
			this.orderID = orderID;
			this.size = size;
		}
		
		public Builder oilType(String type){
			oilType = type;
			return this;
		}
		
		public Builder tomato(boolean isTomato){
			tomato = isTomato;
			return this;
		}
		
		public Builder paper(boolean isPaper){
			paper = isPaper;
			return this;
		}
		
		public SaladShop build(){
			return new SaladShop(this);
		}
	}
	
	public SaladShop(Builder builder) {
		oilType = builder.oilType;
		tomato = builder.tomato;
		paper = builder.paper;
	}
	
	public int getOrderID() {
		return orderID;
	}
	
	public String getSize() {
		return size;
	}
	
	public String getOilType() {
		return oilType;
	}
	
	public boolean isTomato() {
		return tomato;
	}
	
	public boolean isPaper() {
		return paper;
	}
	
	// Telescope Pattern
	public SaladShop(int orderID, String size) {
		this.orderID = orderID;
		this.size = size;
	}
	// Telescope Pattern end
	
	// JavaBeans Pattern
	public SaladShop() {
	}
	
	public void setOilType(String oilType) {
		this.oilType = oilType;
	}
	
	public void setTomato(boolean tomato) {
		this.tomato = tomato;
	}
	
	public void setPaper(boolean paper) {
		this.paper = paper;
	}
	// JavaBeans Pattern End
	
}
