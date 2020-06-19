package sudoku.models;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.Difficulty;

/**
 * Tests full functionality of the GameFactory
 * @author Waldo Theron 18033655
 */
public class GameFactoryTest {
    
    public GameFactoryTest() {
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
     * Test of create method, of class GameFactory. EASY
     */
    @Test
    public void testCreateEasyGame() {
        System.out.println("Create Easy Game");
        Difficulty d = Difficulty.Easy;
        Game result = GameFactory.create(d);
        assertTrue(result instanceof Easy);
    }
    
    /**
     * Test of create method, of class GameFactory. MEDIUM
     */
    @Test
    public void testCreateMediumGame() {
        System.out.println("Create Medium Game");
        Difficulty d = Difficulty.Medium;
        Game result = GameFactory.create(d);
        assertTrue(result instanceof Medium);
    }
    
    /**
     * Test of create method, of class GameFactory. HARD
     */
    @Test
    public void testCreateHardGame() {
        System.out.println("Create Hard Game");
        Difficulty d = Difficulty.Hard;
        Game result = GameFactory.create(d);
        assertTrue(result instanceof Hard);
    }
    
}
