/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.models;

import java.util.Observable;
import sudoku.Users;
import sudoku.handlers.UserHandler;
import sudoku.handlers.UserHandlerExec;

/**
 *
 * @author Waldo
 */
public class UserModel extends Observable {
    private Users user;
    private final UserHandler uh = new UserHandlerExec(); //Business Layer
    
    public UserModel()
    {
        System.out.println("UserModel()");
    }
    
    public String getUsername()
    {
        return this.user.getUsername();
    }
    
    public boolean login(String username, String password)
    {
        boolean status = false;
        Users tempUser = uh.login(username, password);
        if(null != tempUser)
        {
            user = tempUser;
            status = true;
        }        
        
        this.setChanged();
        this.notifyObservers(status);
        
        return status;
    }

}
