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
        this.setChanged();
        boolean status = false;
        Users tempUser = uh.login(username, password);
        if(null != tempUser)
        {
            System.out.println("Correct Baby!");
            user = tempUser;
            status = true;
            this.notifyObservers(user);
        }       
        
        this.notifyObservers(status);
        
        return status;
    }
    
    public void logout()
    {
        this.user = null;
    }
    
    public Users getUser()
    {
        return this.user;
    }
    
    public boolean createUser(String username, String password)
    {
        boolean status = false;
        Users tempUser = new Users(username, password);
        this.setChanged();
        
        System.out.println(username + " " + password);
        
        if(uh.addUser(tempUser))
        {
            user = uh.login(username, password);  
            System.out.println(tempUser + "  " + user);
            this.notifyObservers(user);
            status = true;
        }       
        
        this.notifyObservers(status);
        
        return status;
    }

}
