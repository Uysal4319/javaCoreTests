package generators.fileEncoding;

public class PriceType {
	private String priceName;
	
	public String getPriceName() {
		return priceName;
	}
	
	public void setPriceName(String priceName) {
		this.priceName = priceName;
	}
	
	@Override
	public String toString() {
		return "PriceType{" +
				"priceName='" + priceName + '\'' +
				'}';
	}
}
