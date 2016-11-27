package interfaces;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by mariusz on 26.11.16.
 */
public interface ChecksumCalculator {

    String calculate(String fileName, String algorithm) throws NoSuchAlgorithmException, IOException;
}
