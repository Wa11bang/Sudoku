package sudoku.ui.models;

import java.util.List;
import java.util.Observable;
import sudoku.models.Block;
import sudoku.Difficulty;
import sudoku.models.Game;
import sudoku.events.GameEvent;
import sudoku.models.GameFactory;
import sudoku.handlers.GameHandler;
import sudoku.handlers.GameHandlerExec;
import sudoku.handlers.ScoreHandlerExec;
import sudoku.misc.BlockGenerator;
import sudoku.models.Score;

/**
 *
 * @author Waldo
 */
public class GameModel extends Observable {
    private Game game;
    private UserModel userModel;
    private final GameHandler gh = new GameHandlerExec(); //Business Layer
    private double timer;
    
    public GameModel()
    {
        System.out.println("GameModel()");
    }
    
    public void create(String type)
    {
        type = type.substring(0, 1).toUpperCase() + type.substring(1);
        
        Game tempGame = GameFactory.create(Difficulty.valueOf(type));
        tempGame.setBlocks(BlockGenerator.generate(tempGame.getDifficulty()));
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
            double newTime = game.getTime() + ((System.currentTimeMillis() - timer)/1000);
            game.setTime(newTime);
            if(notify)
            {   
                this.setChanged();
                this.notifyObservers(new GameEvent(gh.modifyGame(game), false));
            }
            else
            {
                gh.modifyGame(game);
            }
        }
    }
    
    public void initGame()
    {
        if(null != this.game)
        {
            this.setChanged();
            this.notifyObservers(game);
            timer = System.currentTimeMillis();
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
            for(int c = 0; c < 9; ++c)
            {
            if(!this.gh.checkSolution1(this.game, c, i) || !this.gh.checkSolution(this.game, c, i))
            {
                return false;
            }
            }
        }
        
        this.game.setComplete(true);
        this.saveGame(false);
        Score score = new Score(game);
        new ScoreHandlerExec().addScore(score);
        
        return true;
    }
}
