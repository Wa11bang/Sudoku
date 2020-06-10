package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sudoku.View;
import sudoku.ViewEvent;
import sudoku.ui.models.StartModel;
import sudoku.ui.views.StartView;

/**
 *
 * @author Waldo
 */
public class StartController implements ActionListener {
    private View appView;
    private StartModel model;
    private StartView view;
    
    public StartController()
    {
        System.out.println("StartController()");
    }
    
    public void addModel(StartModel m) {
        System.out.println("StartController: Adding StartModel");
        this.model = m;
    }
    
    public void addAppView(View v) {
        System.out.println("StartController: Adding AppView");
        this.appView = v;
    }

    public void addView(StartView v) {
        System.out.println("StartController: Adding StartView");
        this.view = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("StartController(): Acting on AppView()");

        if (e.getActionCommand().equals("exit")) {
            System.exit(0);
        }
        else
        {
            appView.changePane(new ViewEvent("start", e.getActionCommand()));
        }             
    }
}
