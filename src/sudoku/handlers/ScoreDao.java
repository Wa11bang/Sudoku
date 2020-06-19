package sudoku.handlers;

import java.util.List;
import sudoku.models.Score;
import sudoku.models.Users;

/**
 * Score Direct-Access-Object Interface Class
 * @author Waldo Theron 18033655
 */
public interface ScoreDao {
    /**
     * Add a new Score
     */
    public boolean addScore(Score score);
    
    /**
     * Retrieve all scores from a specific User
     */
    public List<Score> getScoresByUser(Users user);
    
    /**
     * Retrieve all existing Scores
     */
    public List<Score> retrieveAllScores();
    
}
