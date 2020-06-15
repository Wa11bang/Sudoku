package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sudoku.ui.models.ScoreboardModel;

/**
 *
 * @author Waldo
 */
public class ScoreboardController extends IController implements ActionListener {
    private ScoreboardModel model;
    
    public ScoreboardController()
    {
        System.out.println("ScoreboardController()");
    }
    
    public void addModel(ScoreboardModel m) {
        System.out.println("ScoreboardController: Adding ScoreboardModel");
        this.model = m;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("refresh"))
        {
            System.out.println("ScoreboardController(): Acting on ScoreboardModel()");
            model.loadScores();
        }
        if(e.getActionCommand().equals("back")) {
            changeView("scoreboard", super.getAppView().getPrevPane());
        }
    }
}
