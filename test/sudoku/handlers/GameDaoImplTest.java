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
import sudoku.Difficulty;
import sudoku.misc.BlockGenerator;
import sudoku.misc.HibernateUtils;
import sudoku.models.Game;
import sudoku.models.GameFactory;
import sudoku.models.Users;

/**
 *
 * @author Waldo
 */
public class GameDaoImplTest {
    private GameDao gh = new GameDaoImpl();
    private UserDao uh = new UserDaoImpl();
    private Users user;
    
    public GameDaoImplTest() {
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
        Users user = new Users("system", "system");
        uh.addUser(user);
        this.user = user;
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addGame method, of class GameDaoImpl.
     */
    @Test
    public void testAddGame() {
        
        System.out.println("addGame");

        Game game = GameFactory.create(Difficulty.Hard);
        game.setBlocks(BlockGenerator.generate(Difficulty.Hard));
        game.setUser(user);

        boolean expResult = true;
        boolean result = gh.addGame(game);
        
        assertEquals(expResult, result);
    }

    /**
     * Test of getGameByID method, of class GameDaoImpl.
     */
    @Test
    public void testGetGameByID() {
        System.out.println("getGameByID");
        
        
        Game game = GameFactory.create(Difficulty.Hard);
        game.setBlocks(BlockGenerator.generate(Difficulty.Hard));
        game.setUser(user);
        gh.addGame(game);
        
        int expResult = uh.getUserByUsername("system").getUserID();


        Game result = gh.getGameByID(1);        
        assertSame(expResult, result.getUser().getUserID());
    }


    /**
     * Test of retrieveAllUserGames method, of class GameDaoImpl.
     */
    @Test
    public void testRetrieveAllUserGames() {
        System.out.println("retrieveAllUserGames");
        int expResult = 3;
        
        for (int i = 0; i < expResult; ++i)
        {
            Game game = GameFactory.create(Difficulty.Hard);
            game.setBlocks(BlockGenerator.generate(Difficulty.Hard));
            game.setUser(user);
            gh.addGame(game);    
        }
        
        
        int result = gh.retrieveAllUserGames(user, false).size();     
        
        assertEquals(expResult, result);

    }
    
}
