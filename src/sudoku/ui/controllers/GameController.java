package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sudoku.ui.models.GameModel;
import sudoku.ui.views.GameView;

/**
 * Handles User Interactions for a Game Object
 * @author Waldo Theron 18033655
 */
public class GameController extends IController implements ActionListener {
    private GameModel model;
    private GameView view;
    
    /**
     * Constructor for GameController
     */
    public GameController()
    {
        System.out.println("GameController()");
    }
    
    /**
     * Adds a reference to the GameModel
     * @param m 
     */
    public void addModel(GameModel m) {
        System.out.println("GameController: Adding GameModel");
        this.model = m;
    }

    /**
     * Adds a reference to the GameView
     * @param v 
     */
    public void addView(GameView v) {
        System.out.println("GameController: Adding GameView");
        this.view = v;
    }   
    
    /**
     * Handles User Actions
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {   
        System.out.println("GameController(): Acting on GameModel()");
        if (e.getActionCommand().equals("check")) {                             // Check Game
            if(null != view.parseBlocks())
            {
                model.setBlocks(view.parseBlocks());
                model.checkGame();
            }            
        } else if(e.getActionCommand().equals("save"))                          // Save Game
        {            
            if(null != view.parseBlocks())
            {
                model.setBlocks(view.parseBlocks());
                model.saveGame(true);
            }
        } else if(e.getActionCommand().contains("create"))                      // Create Game
        {            
            model.createGame(e.getActionCommand().replace("_create", ""));            
            changeView("create_game", "game");
            
        } else if(e.getActionCommand().contains("play"))                        // Play Game
        {            
            model.playGame(e.getActionCommand().replace("play_", ""));            
            changeView("play", "game");
            
        } else if(e.getActionCommand().contains("del"))                         // Delete Game
        {    
            int game_id = Integer.parseInt(e.getActionCommand().replace("del_", ""));
            model.deleteGame(game_id);                        
        } else
        {
            changeView("game", "user");                                         // Exit Current View (back)
        }
    }
}
