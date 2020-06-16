package sudoku.events;

import sudoku.models.Users;

/**
 *
 * @author Waldo
 */
public class UserEvent {
    private final boolean userExists;
    private final boolean invalidDetails;
    private final Users user;
    
    public UserEvent(boolean userExists, boolean invalidDetails, Users user)
    {
        this.userExists = userExists;
        this.invalidDetails = invalidDetails;
        this.user = user;
    }
    
    public UserEvent(boolean userExists, boolean invalidDetails)
    {
        this(userExists, invalidDetails, null);
    }
    
    public UserEvent(Users user)
    {
        this(false, false, user);
    }

    /**
     * @return the userExists
     */
    public boolean isUserExists() {
        return userExists;
    }

    /**
     * @return the invalidUsername
     */
    public boolean isInvalidDetails() {
        return invalidDetails;
    }

    /**
     * @return the user
     */
    public Users getUser() {
        return user;
    }
}
