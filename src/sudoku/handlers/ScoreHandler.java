/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.handlers;

import java.util.List;
import sudoku.models.Score;
import sudoku.models.Users;

/**
 *
 * @author Waldo
 */
public interface ScoreHandler {
        /**
     * Add a new Game
     */
    public boolean addScore(Score score);
    
    /**
     * Retrieve user by user_id
     */
    public List<Score> getScoresByUser(Users user);
    
    /**
     * Retrieve all existing Users
     */
    public List<Score> retrieveAllScores();
    
}
