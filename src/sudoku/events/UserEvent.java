package sudoku.events;

import sudoku.models.Users;

/**
 * Wrapper Object that holds details about a Users Object
 * @author Waldo Theron 18033655
 */
public class UserEvent {
    private final boolean userExists;
    private final boolean invalidDetails;
    private final Users user;
    
    /**
     * Constructor for a UserEvent Object
     * @param userExists
     * @param invalidDetails
     * @param user 
     */
    public UserEvent(boolean userExists, boolean invalidDetails, Users user)
    {
        this.userExists = userExists;
        this.invalidDetails = invalidDetails;
        this.user = user;
    }
    
    /**
     * Constructor for a UserEvent Object
     * @param userExists
     * @param invalidDetails 
     */
    public UserEvent(boolean userExists, boolean invalidDetails)
    {
        this(userExists, invalidDetails, null);
    }
    
    /**
     * Constructor for a UserEvent Object
     * @param user 
     */
    public UserEvent(Users user)
    {
        this(false, false, user);
    }

    /**
     * Returns the value of boolean userExists
     * @return isUserExists
     */
    public boolean isUserExists() {
        return userExists;
    }

    /**
     * Returns the value of boolean invalidDetails
     * @return invalidDetails
     */
    public boolean isInvalidDetails() {
        return invalidDetails;
    }

    /**
     * Returns the Users Object
     * @return user
     */
    public Users getUser() {
        return user;
    }
}
