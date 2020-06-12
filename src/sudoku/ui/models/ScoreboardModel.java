package sudoku.ui.models;

import java.util.List;
import java.util.Observable;
import sudoku.events.ScoreEvent;
import sudoku.handlers.ScoreDaoImpl;
import sudoku.models.Score;
import sudoku.handlers.ScoreDao;

/**
 *
 * @author Waldo
 */
public class ScoreboardModel extends Observable {
    private List<Score> scores;
    private final ScoreDao sh = new ScoreDaoImpl();
    
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
