import io.lettuce.core.RedisClient;
import io.lettuce.core.api.StatefulRedisConnection;

public class RedisSourceInfo {
	public static void main(String[] args) {
		
		RedisClient redisClient = RedisClient.create("redis://localhost:26400"); 
		StatefulRedisConnection<String, String> connection = redisClient.connect(); 
		String info = connection.sync().info();
		System.out.println(info); 	
		connection.close();
		redisClient.shutdown();
	}
}
