/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.CardLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Waldo
 */
public class Controller implements ActionListener {
    Model model;
    View view;

    Controller() {
        System.out.println("AppController()");
    }

    //invoked when a button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("AppController(): Acting on AppModel()");
        //model.login("Waldo", "password123");
    }

    public void addModel(Model m) {
        System.out.println("AppController: Adding AppModel");
        this.model = m;
    }

    public void addView(View v) {
        System.out.println("AppController: Adding AppView");
        this.view = v;
    }
}