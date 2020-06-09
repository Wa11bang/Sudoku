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
    UserHandler uh = new UserHandlerExec();
    Users user;
    Game game;
    
    public Model() {
        System.out.println("Model()");
    }
    
    public void createNewGame(Difficulty d)
    {
        this.setChanged();
        this.notifyObservers(GameFactory.create(d));
    }
    
    public void login(String username, String password)
    {
        this.user = uh.login(username, password);
        this.setChanged();
        this.notifyObservers(this.user);
    }
}