/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.handlers;

import java.util.List;
import sudoku.Game;
import sudoku.Users;

/**
 *
 * @author Waldo
 */
public interface GameHandler {
        /**
     * Add a new Game
     */
    public boolean addGame(Game game);
    
    /**
     * Modify an existing user
     */
    public boolean modifyGame(Game game);
    
    /**
     * Delete an existing user
     */
    public boolean deleteGame(Game game);
    
    /**
     * Retrieve user by user_id
     */
    public Game getGameByID(int game_id);
    
    /**
     * Retrieve all existing Users
     */
    public List<Game> retrieveAllUserGames(Users user);
}
