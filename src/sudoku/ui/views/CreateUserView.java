package sudoku.ui.views;

import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import sudoku.AppColour;
import sudoku.Sudoku;
import sudoku.events.UserEvent;
import sudoku.ui.controllers.UserController;
import sudoku.ui.elements.MenuField;
import sudoku.ui.elements.MenuButton;
import sudoku.ui.elements.MenuPasswordField;

/**
 * A menu for creating a new User
 * @author Waldo Theron 18033655
 */
public class CreateUserView extends IView implements Observer {
    private MenuField createUsername = new MenuField();
    private MenuPasswordField createPassword = new MenuPasswordField();
    private MenuButton backBtn = new MenuButton("Back");
    private MenuButton createBtn = new MenuButton("Create");    
    
    /**
     * Constructor for a CreateUserView Object
     */
    public CreateUserView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));

        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setOpaque(false);
        
        initComponents();
        addComponents();       
                
        add(contentPanel, gbConstraints);          
    }
    
    /**
     * Returns the login username from the JComponent
     * @return username
     */
    public String getLoginUsername()
    {
        return createUsername.getText();
    }
    
    /**
     * Returns the login password from the JComponent
     * @return password
     */
    public String getLoginPassword()
    {
        return createPassword.getText();
    }
    
    /**
     * Listens for Updates from the Observable. Informs the User of invalid inputs
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("CreateUserView():  Update received from UserModel()");
        if(arg instanceof UserEvent)
        {
            System.out.println("CreateUserView():  Checking User Details from UserModel()");
            if(((UserEvent) arg).isInvalidDetails())
            {
                createUsername.setPlaceholder("Invalid Input");
                createBtn.setBackground(AppColour.ERROR);
            }
            else if (((UserEvent) arg).isUserExists()) {
                createUsername.setPlaceholder("User exists");
                createUsername.updateUI();
            }
            else
            {
                createUsername.setPlaceholder("Username (Max "+Sudoku.MAX_USERNAME_LEN+" Character)");
                createBtn.setBackground(AppColour.MENU_BACK);
            }
        }
        resetText();
    }
    
    /**
     * Adds the relevant controller to handle user interactions with this view
     * @param controller 
     */
    public void addController(UserController controller) {
        System.out.println("CreateUserView: Adding UserController");
        backBtn.addActionListener(controller);
        createBtn.addActionListener(controller);
    } 
    
    /**
     * Removes all content from the username and password TextFields
     */
    public void resetText()
    {
        createUsername.setText("");
        createPassword.setText("");
    }
    
    /**
     * Initializes all JComponents before being added to the main panel
     */
    private void initComponents()
    {
        createBtn.setActionCommand("user_create");
        backBtn.setActionCommand("start");
        createUsername.setPlaceholder("Username (Max "+Sudoku.MAX_USERNAME_LEN+" Character)");
        createPassword.setPlaceholder("Password");
    }
    
    /**
     * Adds JComponents to main panel
     */
    private void addComponents()
    {
        contentPanel.add(createUsername, gbConstraints);
        contentPanel.add(createPassword, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(25), gbConstraints);
        contentPanel.add(backBtn, gbConstraints2);
        contentPanel.add(createBtn, gbConstraints2);
    }
}