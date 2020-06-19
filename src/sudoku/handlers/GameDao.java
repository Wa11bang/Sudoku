package sudoku.handlers;

import java.util.List;
import sudoku.models.Game;
import sudoku.models.Users;

/**
 * Game Direct-Access-Object Interface Class
 * @author Waldo Theron 18033655
 */
public interface GameDao {
    /**
     * Add a new Game
     */
    public boolean addGame(Game game);
    
    /**
     * Modify an existing Game
     */
    public boolean modifyGame(Game game);
    
    /**
     * Delete an existing Game
     */
    public boolean deleteGame(int game_id);
    
    /**
     * Retrieve user by game_id
     */
    public Game getGameByID(int game_id);
    
    /**
     * Retrieve all existing Game Objects from a User
     */
    public List<Game> retrieveAllUserGames(Users user, boolean completed);
    
    /**
     * Check the row solution of existing Game
     */
    public boolean checkRow(Game game, int row, int checkVal);
    
    /**
     * Check the column solution of existing Game
     */
    public boolean checkColumn(Game game, int col, int checkVal);
}
