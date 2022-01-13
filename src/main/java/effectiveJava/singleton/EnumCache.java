package effectiveJava.singleton;

import java.util.HashMap;

public enum EnumCache implements Cache {
	INSTANCE;
	
	private static final HashMap<Object,Object> map = new HashMap<Object,Object>();
	
	@Override
	public void put(Object key, Object value) {
		map.put(key, value)
;	}
	
	@Override
	public Object get(Object key) {
		return map.get(key);
	}
}
