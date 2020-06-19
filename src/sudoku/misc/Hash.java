package sudoku.misc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Hashing Implementation of the Java MessageDigest Package. Allows for messages
 * to be encoded in any compatible algorithm.
 * @author Waldo Theron 18033655
 */
public class Hash extends Log {
    private MessageDigest md;
    
    /**
     * Constructor for a Hash Object, sets the required algorithm.
     * @param algo 
     */
    public Hash(String algo)
    {
        try {
            md = MessageDigest.getInstance(algo);
        } catch (NoSuchAlgorithmException ex) {
            log.warn(ex);
        }
    }
    
    /**
     * Converts a byte[] array to Hexadecimal
     * @param result
     * @return hexadecimal representation
     */
    public String bytesToHex(byte[] result) {
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    /**
     * Encodes a given string with the set algorithm.
     * @param password
     * @return encoded hexadecimal
     */
    public String encode(String password)
    {
        byte[] result = md.digest(password.getBytes());
        return bytesToHex(result);
    }
}
