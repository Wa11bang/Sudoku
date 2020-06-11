package sudoku.ui.models;

import java.util.List;
import java.util.Observable;
import sudoku.events.ScoreEvent;
import sudoku.handlers.ScoreHandler;
import sudoku.handlers.ScoreHandlerExec;
import sudoku.models.Score;

/**
 *
 * @author Waldo
 */
public class ScoreboardModel extends Observable {
    private List<Score> scores;
    private final ScoreHandler sh = new ScoreHandlerExec();
    
    public ScoreboardModel()
    {
        System.out.println("ScoreboardModel()");
        loadScores();
    }
    
    public void loadScores()
    {
        scores = sh.retrieveAllScores();
        setChanged();
        notifyObservers(new ScoreEvent(scores));
    }
}
