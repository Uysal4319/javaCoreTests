package effectiveJava.innerClasses;

public class InnerClassTests {
	
	public static void main(String[] args) {
		StaticNested.StaticNestedClass staticNested = new StaticNested.StaticNestedClass();
		
		//NonStatic Nested
		NonStaticNested nonStatic =new NonStaticNested();
		NonStaticNested.NonStaticNestedClass nonStaticNestedClass = nonStatic.new NonStaticNestedClass();
		nonStaticNestedClass.writeName();
		
		AnonymousClass anonymousClass = new AnonymousClass(){
			public void helloWorld(){
				System.out.println("hello");		
			}
		};
		
		anonymousClass.helloWorld();
	}
}
