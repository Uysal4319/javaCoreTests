package security;

import sun.misc.BASE64Encoder;

import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.spec.AlgorithmParameterSpec;

public class Encrypter {
	
	private static final Encrypter instance = new Encrypter();
	
	public static Encrypter getInstance() {
		return instance;
	}
	
	public static void main(String[] args) {
		System.out.println(getInstance().doEncrypt("user", "user_pass"));
	}
	
	public String doEncrypt(String userName, String pwd) {
		byte[] hashCode = null;
		try {
			StringBuffer buffer = new StringBuffer();
			buffer.append(userName);
			buffer.append(pwd);
			MessageDigest md = MessageDigest.getInstance("SHA");
			md.update(buffer.toString().getBytes(StandardCharsets.UTF_8));
			hashCode = md.digest();
		} catch (Exception e) {
			e.printStackTrace();
		}
		byte[] securedData = encryptData(hashCode);
		BASE64Encoder base64Encoder = new BASE64Encoder();
		String base64Encoded = base64Encoder.encode(securedData);
		return base64Encoded;
	}
	
	private byte[] encryptData(byte[] data) {
		Cipher cipher = getCipher(true);
		try {
			return cipher.doFinal(data);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}
	
	private Cipher getCipher(boolean encryptMode) {
		try {
			SecretKeySpec keySpec = new SecretKeySpec("Pass_321Pass_321".getBytes(StandardCharsets.UTF_8), "AES");
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5PADDING");
			AlgorithmParameterSpec paramSpec = new IvParameterSpec(new byte[cipher.getBlockSize()]);
//			SecretKeySpec keySpec = new SecretKeySpec(Pass_321.getBytes(ENCODING), "DES");
//			Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
//		
//			byte[] iv = new byte[]{
//					(byte) 0x8E, 0x12, 0x39, (byte) 0x9C,
//					0x07, 0x72, 0x6F, 0x5A
//			};
//			AlgorithmParameterSpec paramSpec = new IvParameterSpec(iv);
			
			if (encryptMode) {
				cipher.init(Cipher.ENCRYPT_MODE, keySpec, paramSpec);
			} else {
				cipher.init(Cipher.DECRYPT_MODE, keySpec, paramSpec);
			}
			return cipher;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
}	
