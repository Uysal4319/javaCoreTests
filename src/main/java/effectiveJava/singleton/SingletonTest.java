package effectiveJava.singleton;

public class SingletonTest {
	public static void main(String[] args) {
//		LazyCache.getInstance().put("sdef","1231");
//		System.out.println(LazyCache.getInstance().get("sdef"));
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				try {
					Thread.sleep(1);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
				System.out.println("Lazy Object : "+LazyCache.getInstance().hashCode());
				System.out.println("Eager Object : "+EagerCache.getInstance().hashCode());
				System.out.println("Enum Object : "+EnumCache.INSTANCE.hashCode());
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("Lazy Object : "+LazyCache.getInstance().hashCode());
				System.out.println("Eager Object : "+EagerCache.getInstance().hashCode());
				System.out.println("Enum Object : "+EnumCache.INSTANCE.hashCode());
			}
		}).start();
	}
}
