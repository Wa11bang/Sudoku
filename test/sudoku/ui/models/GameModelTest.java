/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.models;

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.models.Block;
import sudoku.models.Game;

/**
 *
 * @author Waldo
 */
public class GameModelTest {
    
    public GameModelTest() {
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
     * Test of createGame method, of class GameModel.
     */
    @Test
    public void testCreateGame() {
        System.out.println("createGame");
        String type = "";
        GameModel instance = new GameModel();
        instance.createGame(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of makeGame method, of class GameModel.
     */
    @Test
    public void testMakeGame() {
        System.out.println("makeGame");
        String type = "";
        GameModel instance = new GameModel();
        Game expResult = null;
        Game result = instance.makeGame(type);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addUserModel method, of class GameModel.
     */
    @Test
    public void testAddUserModel() {
        System.out.println("addUserModel");
        UserModel m = null;
        GameModel instance = new GameModel();
        instance.addUserModel(m);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveGame method, of class GameModel.
     */
    @Test
    public void testSaveGame() {
        System.out.println("saveGame");
        boolean notify = false;
        GameModel instance = new GameModel();
        instance.saveGame(notify);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteGame method, of class GameModel.
     */
    @Test
    public void testDeleteGame() {
        System.out.println("deleteGame");
        int game_id = 0;
        GameModel instance = new GameModel();
        instance.deleteGame(game_id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of calculateGameTime method, of class GameModel.
     */
    @Test
    public void testCalculateGameTime() {
        System.out.println("calculateGameTime");
        GameModel instance = new GameModel();
        instance.calculateGameTime();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of initGame method, of class GameModel.
     */
    @Test
    public void testInitGame() {
        System.out.println("initGame");
        GameModel instance = new GameModel();
        instance.initGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBlocks method, of class GameModel.
     */
    @Test
    public void testGetBlocks() {
        System.out.println("getBlocks");
        GameModel instance = new GameModel();
        List<Block> expResult = null;
        List<Block> result = instance.getBlocks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBlocks method, of class GameModel.
     */
    @Test
    public void testSetBlocks() {
        System.out.println("setBlocks");
        List<Block> blocks = null;
        GameModel instance = new GameModel();
        instance.setBlocks(blocks);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGame method, of class GameModel.
     */
    @Test
    public void testSetGame() {
        System.out.println("setGame");
        Game game = null;
        GameModel instance = new GameModel();
        instance.setGame(game);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkGame method, of class GameModel.
     */
    @Test
    public void testCheckGame() {
        System.out.println("checkGame");
        GameModel instance = new GameModel();
        instance.checkGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addScore method, of class GameModel.
     */
    @Test
    public void testAddScore() {
        System.out.println("addScore");
        GameModel instance = new GameModel();
        instance.addScore();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of checkIfSolved method, of class GameModel.
     */
    @Test
    public void testCheckIfSolved() {
        System.out.println("checkIfSolved");
        GameModel instance = new GameModel();
        boolean expResult = false;
        boolean result = instance.checkIfSolved();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of playGame method, of class GameModel.
     */
    @Test
    public void testPlayGame() {
        System.out.println("playGame");
        String id = "";
        GameModel instance = new GameModel();
        instance.playGame(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
