package effectiveJava.memoryManagement.springApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StaticObjectService {
	public static final List<Integer> list = new ArrayList<>();
	
	@GetMapping("/staticList")
	public static void main(String[] args) {
		for (int i = 0; i < 1000000; i++) {
			list.add(i);
		}
	}
}
