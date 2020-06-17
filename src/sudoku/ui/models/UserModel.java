package sudoku.ui.models;

import java.util.Observable;
import sudoku.Sudoku;
import sudoku.events.GameEvent;
import sudoku.events.UserEvent;
import sudoku.handlers.GameDaoImpl;
import sudoku.models.Users;
import sudoku.handlers.UserDaoImpl;
import sudoku.handlers.GameDao;
import sudoku.handlers.UserDao;
import sudoku.misc.Hash;

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
        if(checkIsValid(username, password))
        {
            notifyObservers(new UserEvent(false, true));
            return false;
        }        
        
        Hash hash = new Hash("SHA-256");
        Users tempUserI = new Users(username, hash.encode(password));        
        
        if(checkIfExists(username)){            
            if(uh.addUser(tempUserI))
            {
                user = uh.login(username, password);           
                notifyObservers(new UserEvent(user));
                return true;
            }               
        }      
        
        notifyObservers(new UserEvent(true,false));
        return false;
    }
    
    public boolean checkIsValid(String username, String password)
    {
        return (username.isEmpty() || password.isEmpty() || username.length() > Sudoku.MAX_USERNAME_LEN);
    }
    
    public boolean checkIfExists(String username)
    {
        return (null == (uh.getUserByID(username)));
    }
    
    public void getUserGames(boolean completed)
    {      
        this.setChanged();
        this.notifyObservers(new GameEvent(gh.retrieveAllUserGames(user, completed)));
    }
}
