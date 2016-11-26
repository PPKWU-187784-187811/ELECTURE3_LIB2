package interfaces;

/**
 * Created by mariusz on 22.11.16.
 */
public interface AesLibrary {

    boolean encrypt(String fileName, String fileOutputName, String key);

    boolean decrypt(String fileName, String fileOutputName, String key);
}
