package sudoku.ui.models;

import java.util.Observable;
import sudoku.events.UserEvent;
import sudoku.models.Users;
import sudoku.handlers.UserHandler;
import sudoku.handlers.UserHandlerExec;

/**
 *
 * @author Waldo
 */
public class UserModel extends Observable {
    private Users user;
    private final UserHandler uh = new UserHandlerExec();
    
    public UserModel()
    {
        System.out.println("UserModel()");
    }
    
    public String getUsername()
    {
        return user.getUsername();
    }
    
    public boolean login(String username, String password)
    {
        setChanged();
        Users tempUser = uh.login(username, password);
        if(null != tempUser)
        {
            user = tempUser;
            this.notifyObservers(new UserEvent(user));
            return true;
        }       
        
        notifyObservers(new UserEvent(false,true));        
        return false;
    }
    
    public void logout()
    {
        user = null;
        System.out.println("UserModel(): Logged Out of User");
    }
    
    public Users getUser()
    {
        return user;
    }
    
    public boolean createUser(String username, String password)
    {
        setChanged();
        if(username.isEmpty() || password.isEmpty() || username.length() > 12)
        {
            notifyObservers(new UserEvent(false, true));
            return false;
        }
        
        Users tempUser = new Users(username, password);        
        
        if(null == (uh.getUserByID(username))){
            
            if(uh.addUser(tempUser))
            {
                user = uh.login(username, password);           
                notifyObservers(new UserEvent(user));
                return true;
            }               
        }
        
        notifyObservers(new UserEvent(true,false));
        return false;
    }

}
