package sudoku.misc;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Waldo
 */
public class Hash {
    private MessageDigest md;
    
    public Hash(String algo)
    {
        try {
            md = MessageDigest.getInstance(algo);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(Hash.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public String bytesToHex(byte[] result) {
        StringBuilder sb = new StringBuilder();
        for (byte b : result) {
            sb.append(String.format("%02x", b));
        }
        return sb.toString();
    }
    
    public String encode(String password)
    {
        byte[] result = md.digest(password.getBytes());
        return bytesToHex(result);
    }
}
