package dataTypesOperations.integerOperations;

public class Operator {
	private int                     operatorId;
	private String                  operatorName;
	
	public Operator(int operatorId, String operatorName) {
		this.operatorId = operatorId;
		this.operatorName = operatorName;
	}
	
	public int getOperatorId() {
		return operatorId;
	}
	
	public void setOperatorId(int operatorId) {
		this.operatorId = operatorId;
	}
	
	public String getOperatorName() {
		return operatorName;
	}
	
	public void setOperatorName(String operatorName) {
		this.operatorName = operatorName;
	}
}
