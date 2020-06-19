/*
    __          __     _____  _   _ _____ _   _  _____ 
    \ \        / /\   |  __ \| \ | |_   _| \ | |/ ____|
     \ \  /\  / /  \  | |__) |  \| | | | |  \| | |  __ 
      \ \/  \/ / /\ \ |  _  /| . ` | | | | . ` | | |_ |
       \  /\  / ____ \| | \ \| |\  |_| |_| |\  | |__| |
        \/  \/_/    \_\_|  \_\_| \_|_____|_| \_|\_____|

DO NOT RUN THIS TEST IF THERE IS IMPORT DATA IN THE DATABASE. 
UPON RUNNING THIS TEST, ALL DATA WILL BE ERASED FROM THE DATABASE.

- Waldo Theron

 */
package sudoku.handlers;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.misc.HibernateUtils;
import sudoku.models.Users;

/**
 * Tests important functionalities of the User Direct-Access-Object Implementation
 * @author Waldo Theron 18033655
 */
public class UserDaoImplTest {
    private UserDao uh = new UserDaoImpl();
    private Users user = new Users();
    
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
        Configuration cfg = new Configuration().configure();
        SchemaExport export = new SchemaExport(cfg);
        export.create(true, true);
        user = new Users("system", "system");
    }
    
    @After
    public void tearDown() {        
    }

    /**
     * Test of addUser method, of class UserDaoImpl.
     */
    @Test
    public void testAddUser() {
        boolean result = uh.addUser(this.user);
        boolean expResult = true;

        assertEquals(expResult, result);
    }    
    
    /**
     * Test of getUserByUsername method, of class UserDaoImpl.
     */
    @Test
    public void testGetUserByUsername() {
        uh.addUser(this.user);

        Users result = uh.getUserByUsername("system");
        if(null != result)
        {        
            assertEquals(user.getUsername(), result.getUsername());
        } else {
            fail();
        }
    }
}
