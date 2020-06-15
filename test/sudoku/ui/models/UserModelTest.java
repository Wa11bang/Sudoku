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
     * Test of checkIsValid method, of class UserModel. True test case
     */
    @Test
    public void testCheckIsValidValid() {
        System.out.println("checkIsValid - username not empty, username less than 12 and password set");
        String username = "JohnDoe10";
        String password = "IamJoHnDoE01";
        
        UserModel instance = new UserModel();
        boolean expResult = false;
        boolean result = instance.checkIsValid(username, password);
        
        assertEquals(expResult, result);
    }    
    
    /**
     * Test of checkIsValid method, of class UserModel. False test case
     */
    @Test
    public void testCheckIsValidInvalid() {
        System.out.println("checkIsValid - password empty");
        String username = "JohnDoe10";
        String password = "";
        
        UserModel instance = new UserModel();
        boolean expResult = true;
        boolean result = instance.checkIsValid(username, password);
        
        assertEquals(expResult, result);
    }  
    
    /**
     * Test of checkIsValid method, of class UserModel. Maximum boundary test case
     */
    @Test
    public void testCheckIsValidMax() {
        System.out.println("checkIsValid - username has 12 characters (boundary)");
        String username = "MyNameHas12C";
        String password = "WhatAPassword";
        UserModel instance = new UserModel();
        boolean expResult = false;
        boolean result = instance.checkIsValid(username, password);
        
        assertEquals(expResult, result);
    }  
}
