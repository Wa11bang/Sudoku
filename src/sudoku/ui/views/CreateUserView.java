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
 *
 * @author Waldo
 */
public class CreateUserView extends IView implements Observer {
    private MenuField createUsername = new MenuField();
    private MenuPasswordField createPassword = new MenuPasswordField();
    private MenuButton backBtn = new MenuButton("Back");
    private MenuButton createBtn = new MenuButton("Create");    
    
    public CreateUserView()
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
        return createUsername.getText();
    }
    
    public String getLoginPassword()
    {
        return createPassword.getText();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("CreateUserView():  Update received from UserModel()");
        if(arg instanceof UserEvent)
        {
            System.out.println("CreateUserView():  Checking User Details from UserModel()");
            if(((UserEvent) arg).isInvalidDetails())
            {
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
    
    public void addController(UserController controller) {
        System.out.println("CreateUserView: Adding UserController");
        backBtn.addActionListener(controller);
        createBtn.addActionListener(controller);
    } 
    
    public void resetText()
    {
        createUsername.setText("");
        createPassword.setText("");
    }
    
    private void initComponents()
    {
        createBtn.setActionCommand("user_create");
        backBtn.setActionCommand("start");
        createUsername.setPlaceholder("Username (Max "+Sudoku.MAX_USERNAME_LEN+" Character)");
        createPassword.setPlaceholder("Password");
    }
    
    private void addComponents()
    {
        contentPanel.add(createUsername, gbConstraints);
        contentPanel.add(createPassword, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(25), gbConstraints);
        contentPanel.add(backBtn, gbConstraints2);
        contentPanel.add(createBtn, gbConstraints2);
    }
}