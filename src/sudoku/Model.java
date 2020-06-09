/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.Observable;
import sudoku.handlers.UserHandler;
import sudoku.handlers.UserHandlerExec;

/**
 *
 * @author Waldo
 */
public class Model extends Observable {    
    public Model() {
        System.out.println("AppModel()");
    }    
    
    public void changePane(String panel)
    {
        this.setChanged();
        this.notifyObservers(panel);
    }
}