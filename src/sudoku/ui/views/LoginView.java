package sudoku.ui.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import sudoku.AppColour;
import sudoku.events.UserEvent;
import sudoku.ui.controllers.UserController;
import sudoku.ui.elements.MenuField;
import sudoku.ui.elements.MenuButton;
import sudoku.ui.elements.MenuLabel;
import sudoku.ui.elements.MenuPasswordField;

/**
 *
 * @author Waldo
 */
public class LoginView extends JPanel implements Observer {
    private JPanel loginForm = new JPanel();
    private MenuField loginUsername = new MenuField();
    private MenuPasswordField loginPassword = new MenuPasswordField();
    private MenuButton backBtn = new MenuButton("Back");
    private MenuButton loginBtn = new MenuButton("Login");
    
    public LoginView()
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

        loginForm.setLayout(new GridBagLayout());
        loginForm.setOpaque(false);       
        
        loginBtn.setActionCommand("user_login");
        backBtn.setActionCommand("start");
        
        loginUsername.setPlaceholder("Username");        
        loginPassword.setPlaceholder("Password");
        
        loginForm.add(loginUsername, gbc);
        loginForm.add(loginPassword, gbc);
        loginForm.add(Box.createVerticalStrut(25), gbc);
        loginForm.add(backBtn, gbc2);
        loginForm.add(loginBtn, gbc2);
        
        add(loginForm, gbc);
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
}
