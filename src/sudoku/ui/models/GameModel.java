package sudoku.ui.models;

import java.util.List;
import java.util.Observable;
import sudoku.models.Block;
import sudoku.Difficulty;
import sudoku.models.Game;
import sudoku.events.GameEvent;
import sudoku.models.GameFactory;
import sudoku.handlers.GameDaoImpl;
import sudoku.handlers.ScoreDaoImpl;
import sudoku.models.Score;
import sudoku.handlers.GameDao;

/**
 * Data Model for Game Related Views
 * @author Waldo Theron 18033655
 */
public class GameModel extends Observable {
    private Game game;
    private UserModel userModel;
    private final GameDao gh = new GameDaoImpl();
    private double timer;
    
    /**
     * Constructor for a GameModel Object
     */
    public GameModel()
    {
        System.out.println("GameModel()");
    }
    
    /**
     * Adds a reference to the UserModel
     * @param m 
     */
    public void addUserModel(UserModel m)
    {
        this.userModel = m;
    }
    
    /**
     * Prepares a Game for the User with a specific difficulty
     * @param type (difficulty)
     */
    public void createGame(String type)
    {
        type = type.substring(0, 1).toUpperCase() + type.substring(1);               
        game = makeGame(type);
        
        gh.addGame(game);
        initGame();
    }
    
    /**
     * Generates a Game with a specific difficulty
     * @param type (difficulty)
     * @return Game Object
     */
    public Game makeGame(String type)
    {
        return GameFactory.create(Difficulty.valueOf(type), userModel.getUser());        
    }   
       
    /**
     * Saves a Game for the User, has the option to notify that the game saved
     * @param notify 
     */
    public void saveGame(boolean notify)
    {
        if(null != game)
        {
            calculateGameTime();
            if(notify)
            {   
                this.setChanged();
                this.notifyObservers(new GameEvent(gh.modifyGame(game), false));
            }
            else
            {
                gh.modifyGame(game);
            }
        }
    }
    
    /**
     * Deletes a Game with a specific game_id
     * @param game_id 
     */
    public void deleteGame(int game_id)
    {
        gh.deleteGame(game_id);
        userModel.getUserGames(false);
    }
    
    /**
     * Calculates and saves a new game time. Updates database only via saveGame
     */
    public void calculateGameTime()
    {
        double newTime = game.getTime() + ((System.currentTimeMillis() - timer)/1000);
        game.setTime(newTime);
    }
    
    /**
     * Notifies observing Views that a Game Object has been initialized.
     */
    public void initGame()
    {
        if(null != game)
        {
            setChanged();
            notifyObservers(game);
            timer = System.currentTimeMillis();
        }
    }
    
    /**
     * Returns all of the Block Objects in the current Game instance
     * @return List of Blocks
     */
    public List<Block> getBlocks()
    {
        return this.game.getBlocks();
    }
    
    /**
     * Sets the List of Blocks for the current Game instance
     * @param blocks 
     */
    public void setBlocks(List<Block> blocks)
    {
        this.game.setBlocks(blocks);
    }
    
    /**
     * Sets the current Game instance
     * @param game 
     */
    public void setGame(Game game)
    {
        this.game = game;        
    }
    
    /**
     * Handles Checking of a Game solution
     */
    public void checkGame()
    {             
        boolean status = checkIfSolved();
        this.setChanged();
        this.notifyObservers(new GameEvent(false, status));
        if(status){
            createGame(game.getDifficulty().toString());
        }
    }
    
    /**
     * Loads a Game instance from a specific Game ID
     * @param id 
     */
    public void playGame(String id) {  
        this.game = gh.getGameByID(Integer.parseInt(id));
        initGame();
    }
    
    /**
     * Adds a Score to the database of the current Game instance
     * Called when a Game has been solved.
     */
    public void addScore()
    {
        Score score = new Score(game);        
        new ScoreDaoImpl().addScore(score);
    }
    
    /**
     * Checks if a Game has been solved
     * @return true if Game solved, else false
     */
    public boolean checkIfSolved()
    {
        for(int i = 1; i < 10; ++i) // Check Value (1 to 9)
        {
            for(int j = 0; j < 9; ++j) // Row and Column (0 to 8)
            {
                if(!gh.checkColumn(game, j, i) || !gh.checkRow(game, j, i))
                {
                    return false; // Game not Solved
                }
            }
        }
        
        game.setComplete(true);
        saveGame(false); 
        addScore();    
        
        return true; // Game Solved
    }    
}
