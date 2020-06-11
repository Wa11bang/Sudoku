/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
        this.userExists = userExists;
        this.invalidDetails = invalidDetails;
        this.user = null;
    }
    
    public UserEvent(Users user)
    {
        this.userExists = false;
        this.invalidDetails = false;
        this.user = user;
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
