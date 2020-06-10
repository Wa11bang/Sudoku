/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.models;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import sudoku.Block;
import sudoku.Difficulty;
import sudoku.Game;
import sudoku.GameEvent;
import sudoku.GameFactory;
import sudoku.handlers.GameHandler;
import sudoku.handlers.GameHandlerExec;
import sudoku.misc.BlockGenerator;

/**
 *
 * @author Waldo
 */
public class GameModel extends Observable {
    private Game game;
    private UserModel userModel;
    private final GameHandler gh = new GameHandlerExec(); //Business Layer
    
    public GameModel()
    {
        System.out.println("GameModel()");
    }
    
    public void create(String type)
    {
        type = type.substring(0, 1).toUpperCase() + type.substring(1);
        
        Game tempGame = GameFactory.create(Difficulty.valueOf(type));
        tempGame.setBlocks(BlockGenerator.generate());
        tempGame.setUser(userModel.getUser());
        gh.addGame(tempGame);
        
        this.game = tempGame;
        initGame();
    }
    
    public void addUserModel(UserModel m)
    {
        this.userModel = m;
    }
    
    public void saveGame(boolean notify)
    {
        if(null != this.game)
        {
            if(notify)
            {   
                this.setChanged();
                this.notifyObservers(new GameEvent(gh.modifyGame(game), false));
            }
        }
    }
    
    public void initGame()
    {
        if(null != this.game)
        {
            this.setChanged();
            this.notifyObservers(game);
        }
    }
    
    public List<Block> getBlocks()
    {
        return this.game.getBlocks();
    }
    
    public void setBlocks(List<Block> blocks)
    {
        this.game.setBlocks(blocks);
    }
    
    public void setGame(Game game)
    {
        this.game = game;        
    }
    
    public void checkGame()
    {              
        this.setChanged();
        this.notifyObservers(new GameEvent(false, check()));
    }
    
    public boolean check()
    {
        for(int i = 1; i < 10; ++i)
        {
            if(!this.gh.checkSolution1(this.game, 5, i))
            {
                return false;
            }
        }
        
        this.saveGame(false);
        
        return true;
    }
}
