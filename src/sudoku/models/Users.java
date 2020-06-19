package sudoku.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Users Object, contains username and password
 * @author Waldo Theron 18033655
 */
@Entity(name="users")
@Table(name = "users")
public class Users implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="user_id")
    private int user_id;
    
    @Column(name="username", nullable = false, unique=true)
    private String username;
    
    @Column(name="password", nullable = false)
    private String password;
    
    /**
     * Constructor for Users Object
     * @param username
     * @param password 
     */
    public Users(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    /**
     * Constructor for Users Object
     */
    public Users() {

    }   

    /**
     * Returns the username of the User
     * @return username
     */
    public String getUsername() {
        return username;
    }
    
    /**
     * Returns the user ID of the User (only after existing in database)
     * @return 
     */
    public int getUserID()
    {
        return user_id;
    }
    
    /**
     * Returns a String representation of a Users Object
     * @return 
     */
    @Override
    public String toString()
    {
        return "User: " + this.user_id + " - " + this.username;
    }
}

