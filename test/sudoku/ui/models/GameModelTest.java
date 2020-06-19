package sudoku.ui.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.Difficulty;
import sudoku.misc.HibernateUtils;
import sudoku.models.Game;
import sudoku.models.GameFactory;

/**
 * Tests unique important GameModel functionality
 * @author Waldo Theron 18033655
 */
public class GameModelTest {
    private Game game = GameFactory.create(Difficulty.Hard);
    private double game_time = 50;
    
    public GameModelTest() {
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
        game.setTime(game_time);
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of calculateGameTime method, of class GameModel.
     */
    @Test
    public void testCalculateGameTime() throws InterruptedException {
        System.out.println("calculateGameTime");
        System.out.println("Game time: "+game.getTime());
        GameModel instance = new GameModel();
        instance.setGame(game);
        instance.initGame();
        Thread.sleep(2000);
        instance.calculateGameTime();  
        
        double expResult = 52;
        double result = game.getTime();
        System.out.println("Game time: "+result);
        
        assertEquals(expResult, result, 0.01);
    }  
    
    /**
     * Test of calculateGameTime method, of class GameModel. New Values
     */
    @Test
    public void testCalculateGameTime_2() throws InterruptedException {
        System.out.println("calculateGameTime");
        System.out.println("Game time: "+game.getTime());
        GameModel instance = new GameModel();
        instance.setGame(game);
        instance.initGame();
        Thread.sleep(500);
        instance.calculateGameTime();  
        
        double expResult = 50.5;
        double result = game.getTime();
        System.out.println("Game time: "+result);
        
        assertEquals(expResult, result, 0.01);
    }  
}
