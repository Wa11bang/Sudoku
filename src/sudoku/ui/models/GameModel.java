package sudoku.ui.models;

import java.util.List;
import java.util.Observable;
import sudoku.models.Block;
import sudoku.Difficulty;
import sudoku.models.Game;
import sudoku.events.GameEvent;
import sudoku.models.GameFactory;
import sudoku.handlers.GameDaoImpl;
import sudoku.handlers.ScoreDaoImpl;
import sudoku.misc.BlockGenerator;
import sudoku.models.Score;
import sudoku.handlers.GameDao;

/**
 *
 * @author Waldo
 */
public class GameModel extends Observable {
    private Game game;
    private UserModel userModel;
    private final GameDao gh = new GameDaoImpl();
    private double timer;
    
    public GameModel()
    {
        System.out.println("GameModel()");
    }
    
    public void create(String type)
    {
        type = type.substring(0, 1).toUpperCase() + type.substring(1);               
        game = makeGame(type);
        
        gh.addGame(game);
        initGame();
    }
    
    public Game makeGame(String type)
    {
        Game tempGame = (new GameFactory().create(Difficulty.valueOf(type)));
        tempGame.setBlocks(BlockGenerator.generate(tempGame.getDifficulty()));
        tempGame.setUser(userModel.getUser());
        
        return tempGame;
    }
    
    public void addUserModel(UserModel m)
    {
        this.userModel = m;
    }
    
    public void saveGame(boolean notify)
    {
        if(null != game)
        {
            calculateTime();
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
    
    public void calculateTime()
    {
        double newTime = game.getTime() + ((System.currentTimeMillis() - timer)/1000);
        game.setTime(newTime);
    }
    
    public void initGame()
    {
        if(null != game)
        {
            setChanged();
            notifyObservers(game);
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
    
    public void addScore()
    {
        Score score = new Score(game);        
        new ScoreDaoImpl().addScore(score);
    }
    
    public boolean check()
    {
        for(int i = 1; i < 10; ++i)
        {
            for(int c = 0; c < 9; ++c)
            {
            if(!gh.checkColumn(game, c, i) || !gh.checkRow(game, c, i))
            {
                return false;
            }
            }
        }
        
        game.setComplete(true);
        saveGame(false); 
        addScore();
        
        return true;
    }

    public void play(String id) {  
        this.game = gh.getGameByID(Integer.parseInt(id));
        initGame();
    }
}
