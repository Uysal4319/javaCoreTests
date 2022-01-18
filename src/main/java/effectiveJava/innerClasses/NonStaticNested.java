package effectiveJava.innerClasses;

public class NonStaticNested {
	private String name = "Name";
	
	public  class NonStaticNestedClass{
		public void writeName(){
			System.out.println(name);
		}
	}
}
