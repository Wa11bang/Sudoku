package sudoku.ui.views;

import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import sudoku.AppColour;
import sudoku.events.UserEvent;
import sudoku.ui.controllers.UserController;
import sudoku.ui.elements.MenuField;
import sudoku.ui.elements.MenuButton;
import sudoku.ui.elements.MenuPasswordField;

/**
 *
 * @author Waldo
 */
public class LoginView extends IView implements Observer {
    private MenuField loginUsername = new MenuField();
    private MenuPasswordField loginPassword = new MenuPasswordField();
    private MenuButton backBtn = new MenuButton("Back");
    private MenuButton loginBtn = new MenuButton("Login");
    
    public LoginView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));   

        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setOpaque(false);       
        
        initComponents();       
        addComponents();
        
        add(contentPanel, gbConstraints);
    }
    
    public String getLoginUsername()
    {
        return loginUsername.getText();
    }
    
    public String getLoginPassword()
    {
        return loginPassword.getText();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("LoginView():  Update received from UserModel()");
        if(arg instanceof UserEvent)
        {
            System.out.println("LoginView():  Checking Login Details from UserModel()");
            if(((UserEvent) arg).isInvalidDetails())
            {
                loginBtn.setBackground(AppColour.ERROR);
            }
            else
            {
                loginBtn.setBackground(AppColour.MENU_BACK);
            }
        }
        
        resetText();
    }
    
    /**
     * Adds the relevant controller to handle user interactions with this view
     * @param controller 
     */
    public void addController(UserController controller) {
        System.out.println("LoginView: Adding UserController");
        backBtn.addActionListener(controller);
        loginBtn.addActionListener(controller);
    } 
    
    public void resetText()
    {
        loginUsername.setText("");
        loginPassword.setText("");
    }
    
    /**
     * Initializes all JComponents before being added to the main panel
     */
    private void initComponents()
    {
        loginBtn.setActionCommand("user_login");
        backBtn.setActionCommand("start");        
        loginUsername.setPlaceholder("Username");        
        loginPassword.setPlaceholder("Password");
    }
    
    /**
     * Adds JComponents to main panel
     */
    private void addComponents()
    {
        contentPanel.add(loginUsername, gbConstraints);
        contentPanel.add(loginPassword, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(25), gbConstraints);
        contentPanel.add(backBtn, gbConstraints2);
        contentPanel.add(loginBtn, gbConstraints2);
    }
}