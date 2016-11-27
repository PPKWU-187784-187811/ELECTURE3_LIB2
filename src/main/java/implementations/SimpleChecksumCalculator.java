package implementations;

import interfaces.ChecksumCalculator;

import javax.xml.bind.DatatypeConverter;
import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by mariusz on 26.11.16.
 */
public class SimpleChecksumCalculator implements ChecksumCalculator {

    @Override
    public String calculate(String fileName, String algorithm) throws NoSuchAlgorithmException, IOException {
        MessageDigest messageDigest = MessageDigest.getInstance(algorithm);
        byte[] block = new byte[4096];
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int length;
        while ((length = fileInputStream.read(block)) > 0) {
            messageDigest.update(block, 0, length);
        }
        return DatatypeConverter.printHexBinary(messageDigest.digest());
    }
}
