package interfaces;

import java.io.IOException;
import java.security.GeneralSecurityException;

/**
 * Created by mariusz on 22.11.16.
 */
public interface AesLibrary {

    void encrypt(String fileName, String fileOutputName, String key) throws GeneralSecurityException, IOException;

    void decrypt(String fileName, String fileOutputName, String key) throws GeneralSecurityException, IOException;
}
