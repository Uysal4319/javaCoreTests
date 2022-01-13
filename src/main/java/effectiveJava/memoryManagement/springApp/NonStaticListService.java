package effectiveJava.memoryManagement.springApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class NonStaticListService {
	@GetMapping("/nonStaticList")
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		for (int i = 0; i < 1000000; i++) {
			list.add(i);
		}
	}
}
