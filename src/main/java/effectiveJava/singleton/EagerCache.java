package effectiveJava.singleton;

import java.util.HashMap;

public class EagerCache implements Cache{
	
	private static final EagerCache instance = new EagerCache();
	private HashMap<Object, Object> map;
	
	public EagerCache() {
		map = new HashMap<Object,Object>();
	}
	
	@Override
	public void put(Object key, Object value) {
		
	}
	
	@Override
	public Object get(Object key) {
		return null;
	}
	
	public static EagerCache getInstance(){
		return instance;
	}
}
