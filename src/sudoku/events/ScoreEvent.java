/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.events;

import java.util.List;
import sudoku.models.Score;

/**
 *
 * @author Waldo
 */
public class ScoreEvent {
    private List<Score> scores;
    
    public ScoreEvent(List<Score> scores)
    {
        this.scores = scores;
    }
    
    public ScoreEvent()
    {
        this(null);
    }
    
    public List<Score> getScores()
    {
        return scores;
    }
}
