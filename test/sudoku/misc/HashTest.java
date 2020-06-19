package sudoku.misc;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Tests full functionality of a Hash Object
 * @author Waldo Theron 18033655
 */
public class HashTest {
    
    public HashTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of bytesToHex method, of class Hash.
     */
    @Test
    public void testComparison() {
        System.out.println("bytesToHex");
        Hash instance = new Hash("SHA-256");
        String expResult = "345837a29e408cf69771db1188157664da5d9e6c1182b467f0100864761019b7";
        String result = instance.encode("Hello_World");        
        
        assertEquals(expResult, result);
    }

    /**
     * Test of encode method, of class Hash.
     */
    @Test
    public void testEncode() {
        System.out.println("encode");
        String password = "HELLO_WORLD";
        Hash instance = new Hash("SHA-256");
        String result = instance.encode(password);
        
        System.out.println("Original: "+password);
        System.out.println("Encoded: "+result);
        
        assertNotSame(password, result);
    }
    
}
