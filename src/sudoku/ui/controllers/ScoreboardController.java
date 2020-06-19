package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sudoku.ui.models.ScoreboardModel;

/**
 * Handles User Interactions for a Score Object
 * @author Waldo Theron 18033655
 */
public class ScoreboardController extends IController implements ActionListener {
    private ScoreboardModel model;
    
    /**
     * Constructor for a ScoreboardController Object
     */
    public ScoreboardController()
    {
        System.out.println("ScoreboardController()");
    }
    
    /**
     * Adds a reference to the ScoreboardModel
     * @param m 
     */
    public void addModel(ScoreboardModel m) {
        System.out.println("ScoreboardController: Adding ScoreboardModel");
        this.model = m;
    }
    
    /**
     * Handles User Actions
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("refresh")) {                            // Repopulates the Scoreboard
            System.out.println("ScoreboardController(): Acting on ScoreboardModel()");
            model.loadScores();
        } else if(e.getActionCommand().equals("back")) {                        // Exit Scoreboard
            changeView("scoreboard", super.getAppView().getPrevPane());
        }
    }
}
