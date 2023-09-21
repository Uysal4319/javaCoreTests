package effectiveJava.memoryManagement.springApp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

@RestController
public class ResponseCheckService {
	public Map<Integer,Boolean> map = new HashMap<>();
	@GetMapping("/availableKafkaPartitions")
	public String availableKafkaPartitions() {
		IntStream.range(0,10).forEach(i -> {
		map.put(i,true);		
		});
		return map.toString();
	}
	
}
