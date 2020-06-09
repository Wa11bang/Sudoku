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
        System.out.println("Controller()");
    }

    //invoked when a button is pressed
    @Override
    public void actionPerformed(ActionEvent e) {
        CardLayout cl = (CardLayout)(view.getCardLayout().getLayout());
        
        System.out.println(e.getActionCommand());

        if (e.getActionCommand().equals("exit")) {
            System.exit(0);
        }
        else
        {
            cl.show(view.getCardLayout(), (String)e.getActionCommand());
        }
        
        System.out.println("Controller: acting on Model");
        //model.login("Waldo", "password123");
    }

    public void addModel(Model m) {
        System.out.println("Controller: adding model");
        this.model = m;
    }

    public void addView(View v) {
        System.out.println("Controller: adding view");
        this.view = v;
    }
}