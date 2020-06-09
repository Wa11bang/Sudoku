/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sudoku.ui.models.GameModel;
import sudoku.ui.views.GameView;

/**
 *
 * @author Waldo
 */
public class GameController implements ActionListener {
    private GameModel model;
    private GameView view;
    private boolean val;
    
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
        System.out.println("Clicked");
        System.out.println("GameController(): Acting on GameModel()");
        if (e.getActionCommand().equals("check")) {
            model.checkGame(val);
        } else
        {
            if(val){
                val = false;
            } else {
                val = true;
            }
        }
    }
    
}
