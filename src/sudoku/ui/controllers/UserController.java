/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sudoku.View;
import sudoku.ui.models.UserModel;
import sudoku.ui.views.UserView;

/**
 *
 * @author Waldo
 */
public class UserController implements ActionListener {   
    private View appView;
    private UserModel model;
    private UserView view;
    
    public UserController()
    {
        System.out.println("UserController()");
    }
    
    public void addModel(UserModel m) {
        System.out.println("UserController: Adding UserModel");
        this.model = m;
    }
    
    public void addAppView(View v) {
        System.out.println("GameController: Adding AppView");
        this.appView = v;
    }

    public void addView(UserView v) {
        System.out.println("UserController: Adding UserView");
        this.view = v;
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("user_login")) {
            System.out.println("UserController(): Acting on UserModel()");
            if(model.login(view.getLoginUsername(), view.getLoginPassword()))
            {
                System.out.println("UserController(): Acting on AppView()");
                appView.setCurrentPane("start");
            }
        } else if(e.getActionCommand().equals("start"))
        {
            System.out.println("UserController(): Acting on AppView()");
            appView.setCurrentPane("start");
        }
    }
}
