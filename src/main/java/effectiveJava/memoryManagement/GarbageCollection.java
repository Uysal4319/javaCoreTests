package effectiveJava.memoryManagement;

public class GarbageCollection {
	public void finalize() {
		System.out.println("Çöpler Temizlendi");
	}
	
	public static void main(String[] args) {
		GarbageCollection komur = new GarbageCollection();
		GarbageCollection ali = new GarbageCollection();
		GarbageCollection ertu = new GarbageCollection();
		
		komur = null;
		ali = ertu;
		
		System.gc();
	}
}
