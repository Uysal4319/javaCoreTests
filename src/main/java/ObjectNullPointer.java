import java.util.ArrayList;
import java.util.List;

public class ObjectNullPointer {
	
	public static void main(String[] args) {
		
		TestClass testClass = new TestClass();
		
		testClass.getId();
		
		for (String s : testClass.getList()){
			System.out.println("helllloooo");
		}
	}
	
	
	public static class TestClass{
		 private int id;
		 private int name;
		 private List<String>  list = new ArrayList<>();
		
		public int getId() {
			return id;
		}
		
		public void setId(int id) {
			this.id = id;
		}
		
		public int getName() {
			return name;
		}
		
		public void setName(int name) {
			this.name = name;
		}
		
		public List<String> getList() {
			return list;
		}
		
		public void setList(List<String> list) {
			this.list = list;
		}
	}
}
