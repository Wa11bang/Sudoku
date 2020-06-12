package sudoku.ui.models;

import java.util.List;
import java.util.Observable;
import sudoku.events.GameEvent;
import sudoku.events.UserEvent;
import sudoku.handlers.GameDaoImpl;
import sudoku.models.Users;
import sudoku.handlers.UserDaoImpl;
import sudoku.models.Game;
import sudoku.handlers.GameDao;
import sudoku.handlers.UserDao;

/**
 *
 * @author Waldo
 */
public class UserModel extends Observable {
    private Users user;
    private final UserDao uh = new UserDaoImpl();
    private final GameDao gh = new GameDaoImpl();
    
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
    
    public void getUserGames(boolean completed)
    {      
        this.setChanged();
        this.notifyObservers(new GameEvent(gh.retrieveAllUserGames(user, completed)));
    }

}
