package utilidades;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class Cifrar {

	
	public static String cifrar (String s) throws NoSuchAlgorithmException {
		
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
	    byte[] byteParaCifrar = s.getBytes(StandardCharsets.UTF_8);
	    byte[] byteArrayCifrado = digest.digest(byteParaCifrar);
	    String cifrado = Base64.getEncoder().encodeToString(byteArrayCifrado);
	    return cifrado;
		
	}
	
	
	public static void main(String []args) throws NoSuchAlgorithmException {
		
		System.out.println(cifrar("Ivan"));
	}
}
