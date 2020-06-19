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
 * Data Model for User Related Views
 * @author Waldo Theron 18033655
 */
public class UserModel extends Observable {
    private Users user;
    private final UserDao uh = new UserDaoImpl();
    private final GameDao gh = new GameDaoImpl();
    
    /**
     * Constructor for a UserModel Object
     */
    public UserModel()
    {
        System.out.println("UserModel()");
    }
    
    /**
     * Requests for a user to login using a username and password.
     * The password gets hashed before being used to login.
     * @param username
     * @param password
     * @return successful = TRUE, unsuccessful = FALSE
     */
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
    
    /**
     * Dereferences the current Users instance
     */
    public void logout()
    {
        user = null;
        System.out.println("UserModel(): Logged Out of User");
    }       
    
    /**
     * Creates a new user using a username and password
     * @param username
     * @param password
     * @return successful = TRUE, unsuccessful = FALSE
     */
    public boolean createUser(String username, String password)
    {
        setChanged();
        if(checkIsValid(username, password))
        {
            notifyObservers(new UserEvent(false, true));
            return false;
        }        
        
        Hash hash = new Hash("SHA-256");
        Users tempUser = new Users(username, hash.encode(password));        
        
        if(checkIfExists(username)){            
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
    
    /**
     * Checks to see if a username meets criteria and both the username/password
     * are not left empty.
     * @param username
     * @param password
     * @return successful = FALSE, unsuccessful = TRUE
     */
    public boolean checkIsValid(String username, String password)
    {
        return (username.isEmpty() || password.isEmpty() || username.length() > Sudoku.MAX_USERNAME_LEN);
    }
    
    /**
     * Checks to see if a User exists with a given username
     * @param username
     * @return successful = FALSE, unsuccessful = TRUE
     */
    public boolean checkIfExists(String username)
    {
        return (null == (uh.getUserByUsername(username)));
    }
    
    /**
     * Returns the current Users instance
     * @return 
     */
    public Users getUser()
    {
        return user;
    }
    
    /**
     * Notifies Observing Views with a List of a Users Games. Option to select
     * from completed or uncompleted Game Objects.
     * @param completed = TRUE, uncompleted = FALSE
     */
    public void getUserGames(boolean completed)
    {      
        this.setChanged();
        this.notifyObservers(new GameEvent(gh.retrieveAllUserGames(user, completed)));
    }
}
