package sudoku.models;

import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Waldo
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
    
    public Users(String username, String password) {
        super();
        this.username = username;
        this.password = password;
    }

    public Users() {

    }
    
    /**
     * @return the id
     */
    public int getId() {
        return user_id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.user_id = id;
    }

    /**
     * @return the username
     */
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }
    
    @Override
    public String toString()
    {
        return "User: " + this.user_id + " - " + this.username;
    }
}

