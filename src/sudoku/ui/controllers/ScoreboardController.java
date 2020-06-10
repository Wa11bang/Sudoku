/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sudoku.View;
import sudoku.ViewEvent;
import sudoku.ui.models.ScoreboardModel;
import sudoku.ui.views.ScoreboardView;

/**
 *
 * @author Waldo
 */
public class ScoreboardController implements ActionListener {
    private View appView;
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
    
    public void addAppView(View v) {
        System.out.println("ScoreboardController: Adding ScoreboardView");
        this.appView = v;
    }

    public void addView(ScoreboardView v) {
        System.out.println("ScoreboardController: Adding ScoreboardView");
        this.view = v;
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("back"))
        {
            System.out.println("ScoreboardController(): Acting on AppView()");
            appView.changePane(new ViewEvent("scoreboard", "start"));
        }
    }
}
