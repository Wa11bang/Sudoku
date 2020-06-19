package sudoku.ui.models;

import java.util.List;
import java.util.Observable;
import sudoku.events.ScoreEvent;
import sudoku.handlers.ScoreDaoImpl;
import sudoku.models.Score;
import sudoku.handlers.ScoreDao;

/**
 * Data Model for the Scoreboard
 * @author Waldo Theron 18033655
 */
public class ScoreboardModel extends Observable {
    private List<Score> scores;
    private final ScoreDao sh = new ScoreDaoImpl();
    
    /**
     * Constructor for ScoreboardModel
     */
    public ScoreboardModel()
    {
        System.out.println("ScoreboardModel()");
        loadScores();
    }
    
    /**
     * Updates Scoreboard View
     */
    public void loadScores()
    {
        scores = sh.retrieveAllScores();
        setChanged();
        notifyObservers(new ScoreEvent(scores));
    }
}
