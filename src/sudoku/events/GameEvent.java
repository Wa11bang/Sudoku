package sudoku.events;

import java.util.List;
import sudoku.models.Game;

/**
 *
 * @author Waldo
 */
public class GameEvent {
    private boolean saved;
    private boolean solved;
    private List<Game> games;
    
    public GameEvent(boolean saved, boolean solved)
    {
        this.saved = saved;
        this.solved = solved;
    }
    
    public GameEvent(List<Game> games)
    {
        this(false, false);
        this.games = games;        
    }
    
    public GameEvent()
    {
        this(false, false);
    }
    
    public boolean getSaved()
    {
        return this.saved;
    }
    
    public boolean getSolved()
    {
        return this.solved;
    }
    
    public List<Game> getGames()
    {
        return this.games;
    }
}
