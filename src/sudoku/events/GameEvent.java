package sudoku.events;

/**
 *
 * @author Waldo
 */
public class GameEvent {
    private boolean saved;
    private boolean solved;
    
    public GameEvent(boolean saved, boolean solved)
    {
        this.saved = saved;
        this.solved = solved;
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
}
