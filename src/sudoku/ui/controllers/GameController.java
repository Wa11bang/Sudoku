package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sudoku.ui.models.GameModel;
import sudoku.ui.views.GameView;

/**
 *
 * @author Waldo
 */
public class GameController extends IController implements ActionListener {
    private GameModel model;
    private GameView view;
    
    public GameController()
    {
        System.out.println("GameController()");
    }
    
    public void addModel(GameModel m) {
        System.out.println("GameController: Adding GameModel");
        this.model = m;
    }

    public void addView(GameView v) {
        System.out.println("GameController: Adding GameView");
        this.view = v;
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {   
        System.out.println("GameController(): Acting on GameModel()");
        if (e.getActionCommand().equals("check")) {
            if(null != view.parseBlocks())
            {
                model.setBlocks(view.parseBlocks());
                model.checkGame();
            }            
        } else if(e.getActionCommand().equals("save"))
        {            
            if(null != view.parseBlocks())
            {
                model.setBlocks(view.parseBlocks());
                model.saveGame(true);
            }
        } else if(e.getActionCommand().contains("create"))
        {            
            model.createGame(e.getActionCommand().replace("_create", ""));            
            changeView("create_game", "game");
            
        } else if(e.getActionCommand().contains("play"))
        {            
            model.playGame(e.getActionCommand().replace("play_", ""));            
            changeView("play", "game");
            
        } else if(e.getActionCommand().contains("del"))
        {            
            model.deleteGame(Integer.parseInt(e.getActionCommand().replace("del_", "")));                        
        } else
        {
            changeView("game", "user");
        }
    }
}
