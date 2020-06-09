/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.models;

import java.util.List;
import java.util.Observable;
import sudoku.Block;
import sudoku.Game;
import sudoku.handlers.GameHandler;
import sudoku.handlers.GameHandlerExec;

/**
 *
 * @author Waldo
 */
public class GameModel extends Observable {
    private Game game;
    private final GameHandler gh = new GameHandlerExec(); //Business Layer
    
    public GameModel()
    {
        System.out.println("GameModel()");
    }
    
    public void saveGame()
    {
        if(null != this.game)
        {
        
        this.setChanged();
        this.notifyObservers(gh.modifyGame(game));
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
        this.notifyObservers(check());
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
        
        return true;
    }
    
    /*public boolean check()
    {
        for(int i = 0; i < 9; ++i)
        {
            for(int j = 0; j < 9; ++j)
            {
                if(blocks[i][j].getValue() == 0)
                {
                    //System.out.println("Row: " + i + " Col: " + j + " ZERO VALUE");
                    return false;
                }
                
                if(!(checkRow(i, blocks[i][j].getValue(), j) && checkColumn(j, blocks[i][j].getValue(), i)))
                {
                    if(i != j)
                    {
                    //System.out.println("Row: " + i + " Col: " + j + " FAIL CHECK");
                    return false;
                    }
                }
            }
        }
        
        return true;
    }*/
}
