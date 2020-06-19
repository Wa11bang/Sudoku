package sudoku.events;

import java.util.List;
import sudoku.models.Game;

/**
 * Wrapper Object that holds details about a Game Object
 * @author Waldo Theron 18033655
 */
public class GameEvent {
    private boolean saved;
    private boolean solved;
    private List<Game> games;
    
    /**
     * Constructor for GameEvent Object
     * @param saved
     * @param solved 
     */
    public GameEvent(boolean saved, boolean solved)
    {
        this.saved = saved;
        this.solved = solved;
    }
    /**
     * Constructor for GameEvent Object
     * @param games
     */
    public GameEvent(List<Game> games)
    {
        this(false, false);
        this.games = games;        
    }
    
    /**
     * Constructor for GameEvent Object
     */
    public GameEvent()
    {
        this(false, false);
    }
    
    /**
     * Returns the value of the saved boolean
     * @return 
     */
    public boolean getSaved()
    {
        return this.saved;
    }
    
    /**
     * Returns the value of the solved boolean
     * @return 
     */
    public boolean getSolved()
    {
        return this.solved;
    }
    
    /**
     * Returns the list of Game Objects
     * @return 
     */
    public List<Game> getGames()
    {
        return this.games;
    }
}
