/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.controllers;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import sudoku.View;
import sudoku.ui.models.StartModel;
import sudoku.ui.views.StartView;

/**
 *
 * @author Waldo
 */
public class StartController implements ActionListener {
    private StartModel model;
    private StartView view;
    private JPanel mainView;
    
    public StartController(JPanel mainView)
    {
        System.out.println("StartController()");
        this.mainView = mainView;
    }
    
    public void addModel(StartModel m) {
        System.out.println("StartController: Adding StartModel");
        this.model = m;
    }

    public void addView(StartView v) {
        System.out.println("StartController: Adding StartView");
        this.view = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("StartController(): Acting on StartModel()");
        
        CardLayout cl = (CardLayout)(mainView.getLayout());        
        System.out.println(e.getActionCommand());

        if (e.getActionCommand().equals("exit")) {
            System.exit(0);
        }
        else
        {
            cl.show(mainView, (String)e.getActionCommand());
        }                      
    }
}
