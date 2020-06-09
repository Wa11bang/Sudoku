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
    private final GameHandler gh = new GameHandlerExec();
    
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
        this.notifyObservers(false);
    }
    
    /**
     * Checks to see if a number re-occurs in the same row
     * @param row
     * @param randVal
     * @param origCol
     * @return
     */
    /*public boolean checkRow(int row, int randVal, int origCol)
    {
        for(int i = 0; i < 9; ++i)
        {
            if(blocks[row][i].getValue() == randVal && (i != origCol))
            {
                //System.out.println("FAIL ROW same value at row: " + row + " col: " + i);
                return false;
            }
        }
        
        return true;
    }*/
    
    /**
     * Checks to see if a number re-occurs in the same column
     * @param col
     * @param randVal
     * @param origRow
     * @return
     */
    /*public boolean checkColumn(int col, int randVal, int origRow)
    {
        for(int i = 0; i < 9; ++i)
        {
            if(blocks[i][col].getValue() == randVal && (i != origRow))
            {
                //System.out.println("FAIL COL");
                return false;
            }
        }
        
        return true;
    }*/
    
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
