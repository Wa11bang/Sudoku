package sudoku.ui.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JPanel;
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
public class CreateUserView extends JPanel  implements Observer {
    private JPanel createForm = new JPanel();
    private MenuField createUsername = new MenuField();
    private MenuPasswordField createPassword = new MenuPasswordField();
    private MenuButton backBtn = new MenuButton("Back");
    private MenuButton createBtn = new MenuButton("Create");    
    
    public CreateUserView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));
        setLayout(new GridBagLayout());      
        setOpaque(false);      
        
        GridBagConstraints gbc = new GridBagConstraints();
        GridBagConstraints gbc2 = new GridBagConstraints();
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
                
        gbc2.anchor = GridBagConstraints.NORTH;
        gbc2.weightx = 1.0;
        gbc2.weighty = 1.0;      
                     
        createForm.setLayout(new GridBagLayout());
        createForm.setOpaque(false);
        
        createBtn.setActionCommand("user_create");
        backBtn.setActionCommand("start");

        createUsername.setPlaceholder("Username (Max "+Sudoku.MAX_USERNAME_LEN+" Character)");
        createPassword.setPlaceholder("Password");
        
        createForm.add(createUsername, gbc);
        createForm.add(createPassword, gbc);
        createForm.add(Box.createVerticalStrut(25), gbc);
        createForm.add(backBtn, gbc2);
        createForm.add(createBtn, gbc2);
        
        add(createForm, gbc);          
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
                createUsername.setPlaceholder("Username (Max 12 Character)");
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
}