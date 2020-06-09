/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.controllers;

import sudoku.Model;
import sudoku.ui.models.UserModel;
import sudoku.ui.views.UserView;

/**
 *
 * @author Waldo
 */
public class UserController {   
    private Model appModel;
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
    
    public void addAppModel(Model m) {
        System.out.println("UserController: Adding AppModel");
        this.appModel = m;
    }

    public void addView(UserView v) {
        System.out.println("UserController: Adding UserView");
        this.view = v;
    }
}
