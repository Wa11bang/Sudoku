/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.models.Users;

/**
 *
 * @author Waldo
 */
public class UserModelTest {
    
    public UserModelTest() {
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
     * Test of login method, of class UserModel.
     */
    @Test
    public void testLogin() {
        System.out.println("login");
        String username = "";
        String password = "";
        UserModel instance = new UserModel();
        boolean expResult = false;
        boolean result = instance.login(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of logout method, of class UserModel.
     */
    @Test
    public void testLogout() {
        System.out.println("logout");
        UserModel instance = new UserModel();
        instance.logout();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUser method, of class UserModel.
     */
    @Test
    public void testGetUser() {
        System.out.println("getUser");
        UserModel instance = new UserModel();
        Users expResult = null;
        Users result = instance.getUser();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of createUser method, of class UserModel.
     */
    @Test
    public void testCreateUser() {
        System.out.println("createUser");
        String username = "";
        String password = "";
        UserModel instance = new UserModel();
        boolean expResult = false;
        boolean result = instance.createUser(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIsValid method, of class UserModel.
     */
    @Test
    public void testCheckIsValid() {
        System.out.println("checkIsValid");
        String username = "";
        String password = "";
        UserModel instance = new UserModel();
        boolean expResult = false;
        boolean result = instance.checkIsValid(username, password);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfExists method, of class UserModel.
     */
    @Test
    public void testCheckIfExists() {
        System.out.println("checkIfExists");
        String username = "";
        UserModel instance = new UserModel();
        boolean expResult = false;
        boolean result = instance.checkIfExists(username);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getUserGames method, of class UserModel.
     */
    @Test
    public void testGetUserGames() {
        System.out.println("getUserGames");
        boolean completed = false;
        UserModel instance = new UserModel();
        instance.getUserGames(completed);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
