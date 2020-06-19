package sudoku.events;

import java.util.List;
import sudoku.models.Score;

/**
 * Wrapper Object that holds multiple Score Objects
 * @author Waldo Theron 18033655
 */
public class ScoreEvent {
    private List<Score> scores;
    
    /**
     * Constructor for ScoreEvent Object
     * @param scores 
     */
    public ScoreEvent(List<Score> scores)
    {
        this.scores = scores;
    }
    
    /**
     * Constructor for ScoreEvent Object
     */
    public ScoreEvent()
    {
        this(null);
    }
    
    /**
     * Returns a list of Score objects
     * @return 
     */
    public List<Score> getScores()
    {
        return scores;
    }
}
