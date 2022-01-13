package effectiveJava.memoryManagement.springApp;

import effectiveJava.memoryManagement.Stack;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StackPopService {
	@GetMapping("/stackPop")
	public static void stackPop() {
		Stack stack = new Stack();
		
		for (int i = 1; i < 1000000; i++) {
			stack.push(i);
		}
		
		for (int i = 1; i < 1000000; i++) {
			stack.pop();
		}
		System.out.println("pop process completed...");
	}
	
	@GetMapping("/stackPopWell")
	public static void stackPopWell() {
		Stack stack = new Stack();
		
		for (int i = 1; i < 1000000; i++) {
			stack.push(i);
		}
		
		for (int i = 1; i < 1000000; i++) {
			stack.popWell();
		}
		System.out.println("pop well process completed...");
	}
}
