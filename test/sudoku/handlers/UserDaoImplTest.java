package sudoku.handlers;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.misc.HibernateUtils;
import sudoku.models.Users;

/**
 *
 * @author Waldo
 */
public class UserDaoImplTest {
    private UserDao uh = new UserDaoImpl();
    private final static String USERNAME = "system_test";
    private final static String PASSWORD = "system_test";
    
    public UserDaoImplTest() {
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
     * Test of addUser method, of class UserDaoImpl.
     */
    @Test
    public void testAddUser() {
        Users user = new Users(USERNAME, PASSWORD);
        if(null != uh.getUserByUsername(USERNAME))
        {
            uh.deleteUser(user);
        }

        Users result = uh.getUserByUsername(USERNAME);
        
        assertEquals(user.getUsername(), result.getUsername());
    }    

    /**
     * Test of getUserByID method, of class UserDaoImpl.
     */
    @Test
    public void testGetUserByID() {
        UserDaoImpl instance = new UserDaoImpl();
        Users result = instance.getUserByUsername(USERNAME);
        assertEquals(USERNAME, result.getUsername());
    }

    /**
     * Test of retrieveAllUsers method, of class UserDaoImpl.
     */
    @Test
    public void testRetrieveAllUsers() {
        System.out.println("retrieveAllUsers");
        UserDaoImpl instance = new UserDaoImpl();
        List<Users> result = instance.retrieveAllUsers();
        assertEquals(USERNAME, result.get(0).getUsername());
    }  
}
