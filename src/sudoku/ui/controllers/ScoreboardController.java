package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sudoku.App;
import sudoku.events.ViewEvent;
import sudoku.ui.models.ScoreboardModel;
import sudoku.ui.views.ScoreboardView;

/**
 *
 * @author Waldo
 */
public class ScoreboardController implements ActionListener {
    private App appView;
    private ScoreboardModel model;
    private ScoreboardView view;
    
    public ScoreboardController()
    {
        System.out.println("ScoreboardController()");
    }
    
    public void addModel(ScoreboardModel m) {
        System.out.println("ScoreboardController: Adding ScoreboardModel");
        this.model = m;
    }
    
    public void addAppView(App v) {
        System.out.println("ScoreboardController: Adding ScoreboardView");
        this.appView = v;
    }

    public void addView(ScoreboardView v) {
        System.out.println("ScoreboardController: Adding ScoreboardView");
        this.view = v;
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("refresh"))
        {
            System.out.println("ScoreboardController(): Acting on ScoreboardModel()");
            model.loadScores();
        }
        if(e.getActionCommand().equals("back")) {
            System.out.println("ScoreboardController(): Acting on AppView()");
            appView.changePane(new ViewEvent("scoreboard", appView.getPrevPane()));
        }
    }
}
