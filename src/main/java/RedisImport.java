import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

public class RedisImport {
	public static void main(String[] args) {
		Set<String> sentinels = new HashSet<>();
		sentinels.add("localhost:26400");
		
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		int timeout = 1 * 1000; // 1 Seconds
		jedisPoolConfig.setMaxWaitMillis(timeout);
		jedisPoolConfig.setMaxTotal(100);
		jedisPoolConfig.setTestOnBorrow(false);
		
		JedisSentinelPool master = new JedisSentinelPool("masterredis", sentinels, jedisPoolConfig, timeout);
		try {
			Jedis jedis = master.getResource();
			jedis.connect();
			System.out.println(jedis.append("test", "testt"));
			jedis.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
