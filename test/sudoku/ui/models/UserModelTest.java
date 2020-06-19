package sudoku.ui.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.handlers.UserDao;
import sudoku.handlers.UserDaoImpl;
import sudoku.misc.HibernateUtils;
import sudoku.models.Users;

/**
 * Tests unique important UserModel functionality
 * @author Waldo Theron 18033655
 */
public class UserModelTest {
    private UserDao uh = new UserDaoImpl();
    
    public UserModelTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
        HibernateUtils.shutdown();
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of checkIsValid method, of class UserModel. TRUE = Invalid, FALSE = VALID
     */
    @Test
    public void testCheckIsValidNoInput() {
        System.out.println("checkIsValid");
        String username = "";
        String password = "";
        UserModel instance = new UserModel();
        boolean expResult = true;
        boolean result = instance.checkIsValid(username, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkIsValid method, of class UserModel. TRUE = Invalid, FALSE = VALID
     */
    @Test
    public void testCheckIsValidUsernameUpperBoundary() {
        System.out.println("checkIsValid");
        String username = "JohnDoe12";
        String password = "test";
        UserModel instance = new UserModel();
        boolean expResult = true;
        boolean result = instance.checkIsValid(username, password);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkIsValid method, of class UserModel. TRUE = Invalid, FALSE = VALID
     */
    @Test
    public void testCheckIsValidUsernameLowerBoundary() {
        System.out.println("checkIsValid");
        String username = "JohnDoe1";
        String password = "test";
        UserModel instance = new UserModel();
        boolean expResult = false;
        boolean result = instance.checkIsValid(username, password);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkIfExists method, of class UserModel.
     */
    @Test
    public void testCheckIfExists() {
        Users user = new Users("system-test", "system-test");
        uh.addUser(user);
        
        System.out.println("checkIfExists");
        String username = "system-test";
        UserModel instance = new UserModel();
        boolean expResult = false;
        boolean result = instance.checkIfExists(username);
        
        uh.deleteUser(user);
        
        assertEquals(expResult, result);
    }    
}
