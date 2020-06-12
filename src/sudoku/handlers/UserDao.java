package sudoku.handlers;

import java.util.List;
import sudoku.models.Users;

/**
 *
 * @author Waldo
 */
public interface UserDao {
    /**
     * Add a new User
     */
    public boolean addUser(Users user);
    
    /**
     * Modify an existing user
     */
    public boolean modifyUser(Users user);
    
    /**
     * Delete an existing user
     */
    public boolean deleteUser(Users user);
    
    /**
     * Retrieve user by user_id
     */
    public Users getUserByID(String username);
    
    /**
     * Retrieve all existing Users
     */
    public List<Users> retrieveAllUsers();
    
    /**
     * Retrieves a User with given credentials
     */
    public Users login(String username, String password);
}
