package sudoku.handlers;

import java.util.List;
import sudoku.models.Users;

/**
 * User Direct-Access-Object Interface Class
 * @author Waldo Theron 18033655
 */
public interface UserDao {
    /**
     * Add a new User
     */
    public boolean addUser(Users user);
    
    /**
     * Modify an existing User
     */
    public boolean modifyUser(Users user);
    
    /**
     * Delete an existing User
     */
    public boolean deleteUser(Users user);
    
    /**
     * Retrieve User by user_id
     */
    public Users getUserByUsername(String username);
    
    /**
     * Retrieve all existing Users
     */
    public List<Users> retrieveAllUsers();
    
    /**
     * Retrieves a User with given credentials
     */
    public Users login(String username, String password);
}
