/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.handlers;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.Difficulty;
import sudoku.models.Block;
import sudoku.models.Game;
import sudoku.models.GameFactory;
import sudoku.models.Users;

/**
 *
 * @author Waldo
 */
public class GameDaoImplTest {
    
    public GameDaoImplTest() {
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
     * Test of checkRow method, of class GameDaoImpl.
     */
    @Test
    public void testCheckRowValid() {
        System.out.println("checkRow - Valid");
        
        List<Block> blocks = new ArrayList();
        
        for(int i = 1; i < 10; ++i)
        {
            blocks.add(new Block(i));
        }
        
        Game game = GameFactory.create(Difficulty.Hard);
        game.setBlocks(blocks);
        
        int row = 0;
        int checkVal = 5;
        GameDao instance = new GameDaoImpl();
        boolean expResult = true;
        boolean result = instance.checkRow(game, row, checkVal);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of checkRow method, of class GameDaoImpl.
     */
    @Test
    public void testCheckRowInvalid() {
        System.out.println("checkRow - Invalid");
        
        List<Block> blocks = new ArrayList();
        
        for(int i = 1; i < 10; ++i)
        {
            if(i == 2)
            {
                blocks.add(new Block(1));
            }
            else
            {
                blocks.add(new Block(i));
            }
        }
        
        Game game = GameFactory.create(Difficulty.Hard);
        game.setBlocks(blocks);
        
        int row = 0;
        int checkVal = 2;
        GameDao instance = new GameDaoImpl();
        boolean expResult = false;
        boolean result = instance.checkRow(game, row, checkVal);
        assertEquals(expResult, result);
    }

    /**
     * Test of checkColumn method, of class GameDaoImpl.
     */
    @Test
    public void testCheckColumn() {
        System.out.println("checkColumn");
        Game game = null;
        int col = 0;
        int checkVal = 0;
        GameDaoImpl instance = new GameDaoImpl();
        boolean expResult = false;
        boolean result = instance.checkColumn(game, col, checkVal);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
