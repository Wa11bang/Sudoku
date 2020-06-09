/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.models;

import java.util.Observable;
import sudoku.Game;
import sudoku.handlers.GameHandler;
import sudoku.handlers.GameHandlerExec;

/**
 *
 * @author Waldo
 */
public class GameModel extends Observable {
    private Game game;
    private final GameHandler gh = new GameHandlerExec();
    
    public GameModel()
    {
        System.out.println("GameModel()");
    }
    
    public void saveGame()
    {
        if(null != this.game)
        {
            gh.modifyGame(game);
        }
        
        this.setChanged();
        this.notifyObservers();
    }
    
    public void initGame()
    {
        if(null != this.game)
        {
            this.setChanged();
            this.notifyObservers(game);
        }
    }
    
    public void setGame(Game game)
    {
        this.game = game;        
    }
    
    public void checkGame()
    {
        this.setChanged();
        this.notifyObservers(true);
    }
}
