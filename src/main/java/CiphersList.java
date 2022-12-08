import javax.net.ssl.SSLServerSocketFactory;

public class CiphersList {
	
	public static void main(String[] args) {
		
		SSLServerSocketFactory ssf = (SSLServerSocketFactory)SSLServerSocketFactory.getDefault();
		
		String[] defaultCiphers = ssf.getDefaultCipherSuites();
		String[] availableCiphers = ssf.getSupportedCipherSuites();
		
		System.out.println("Default  Ciphers:");
		for (String s : defaultCiphers){
			System.out.println(s);
		}
		
		System.out.println("Available  Ciphers:");
		for (String s : availableCiphers){
			System.out.println(s);
		}
	}
}
