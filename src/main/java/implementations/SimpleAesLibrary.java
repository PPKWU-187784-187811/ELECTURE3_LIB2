package implementations;

import interfaces.AesLibrary;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * Created by mariusz on 26.11.16.
 */
public class SimpleAesLibrary implements AesLibrary {

    public static final String AES = "AES";
    public static final String UTF_8 = "UTF-8";

    @Override
    public boolean encrypt(String fileName, String fileOutputName, String key) {
        try {
            Cipher cipher = Cipher.getInstance(AES);
            SecretKeySpec secretKeySpec = getSecretKeySpec(key);
            cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(readFile(fileName));
            writeToFile(fileOutputName, encryptedBytes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean decrypt(String fileName, String fileOutputName, String key) {
        try {
            Cipher cipher = Cipher.getInstance(AES);
            SecretKeySpec secretKeySpec = getSecretKeySpec(key);
            cipher.init(Cipher.DECRYPT_MODE, secretKeySpec);
            byte[] encryptedBytes = cipher.doFinal(readFile(fileName));
            writeToFile(fileOutputName, encryptedBytes);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    private SecretKeySpec getSecretKeySpec(String key) throws UnsupportedEncodingException {
        return new SecretKeySpec(key.getBytes(UTF_8), AES);
    }

    private byte[] readFile(String fileName) throws IOException {
        return Files.readAllBytes(Paths.get(fileName));
    }

    private void writeToFile(String fileName, byte[] bytes) throws IOException {
        Files.write(Paths.get(fileName), bytes, StandardOpenOption.CREATE);
    }
}
