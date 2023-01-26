package ec.gob.cj.pesnot.notaria.config;

import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class EncryptionUtils {
	
	private static final String ALGORITHM = "AES";
    private static final String TRANSFORMATION = "AES";
    private static final String key = "PESNOT2022";

    public static String encrypt(String key, String value) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);
        byte[] encryptedBytes = cipher.doFinal(value.getBytes());
        return new String(encryptedBytes, StandardCharsets.UTF_8);
    }

    public static String decrypt(String key, String encryptedValue) throws Exception {
        SecretKeySpec secretKey = new SecretKeySpec(key.getBytes(StandardCharsets.UTF_8), ALGORITHM);
        Cipher cipher = Cipher.getInstance(TRANSFORMATION);
        cipher.init(Cipher.DECRYPT_MODE, secretKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedValue.getBytes());
        return new String(decryptedBytes, StandardCharsets.UTF_8);
    }

	public static String getKey() {
		return key;
	}
    
    

}
