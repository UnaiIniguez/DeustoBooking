package utilidades;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Cifrar {

	
//	public static String cifrar (String s) {
//		
//		try {
//			MessageDigest digest = MessageDigest.getInstance("SHA-256");
//			byte[] byteParaCifrar = s.getBytes(StandardCharsets.UTF_8);
//			byte[] byteArrayCifrado = digest.digest(byteParaCifrar);
//			String cifrado = Base64.getEncoder().encodeToString(byteArrayCifrado);
//			return cifrado;
//		} catch (NoSuchAlgorithmException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		return null;
//	}
//	
//	
//	public static void main(String []args) {
//		
//		System.out.println(cifrar("Ivan"));
//	}
}
