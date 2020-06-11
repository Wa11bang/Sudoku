package sudoku.ui.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import sudoku.AppColour;
import sudoku.events.UserEvent;
import sudoku.ui.controllers.UserController;
import sudoku.ui.elements.MenuField;
import sudoku.ui.elements.MenuButton;

/**
 *
 * @author Waldo
 */
public class CreateUserView extends JPanel  implements Observer {
    private JPanel createForm = new JPanel();
    private MenuField createUsername = new MenuField();
    private MenuField createPassword = new MenuField(); //CHANGE to JPasswordField 
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
        backBtn.setActionCommand("back");

        createUsername.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0, 100)));
        createUsername.setPlaceholder("Username (Max 12 Character)");
        createUsername.setOpaque(false);
        createUsername.setPreferredSize(new Dimension(200, 75));
        createUsername.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        
        createPassword.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0, 100)));
        createPassword.setPlaceholder("Password");
        createPassword.setOpaque(false);
        createPassword.setPreferredSize(new Dimension(200, 75));
        createPassword.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        
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