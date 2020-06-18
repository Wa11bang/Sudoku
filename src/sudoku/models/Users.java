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
     * @return the username
     */
    public String getUsername() {
        return username;
    }
    
    public int getUserID()
    {
        return user_id;
    }
    
    @Override
    public String toString()
    {
        return "User: " + this.user_id + " - " + this.username;
    }
}

