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
import sudoku.ui.controllers.UserController;
import sudoku.ui.elements.LoginText;
import sudoku.ui.elements.MenuButton;

/**
 *
 * @author Waldo
 */
public class CreateUserView extends JPanel  implements Observer {
    private JPanel createForm = new JPanel();
    private GridBagConstraints gbc = new GridBagConstraints();
    private LoginText cU = new LoginText();
    private LoginText cP = new LoginText(); //CHANGE to JPasswordField 
    private MenuButton backBtn = new MenuButton("Back");
    private MenuButton createBtn = new MenuButton("Create");
    
    public CreateUserView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));
        setLayout(new GridBagLayout());        
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.anchor = GridBagConstraints.NORTH;
        gbc2.weightx = 1.0;
        gbc2.weighty = 1.0;      
                     
        createForm.setLayout(new GridBagLayout());
        createForm.setOpaque(false);
        
        createBtn.setActionCommand("user_create");
        backBtn.setActionCommand("create_user"); //Current Panel (Used for Back-tracking)
        
        cU = new LoginText();
        cP = new LoginText();
        
        cU.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0, 100)));
        cU.setPlaceholder("Username");
        cU.setOpaque(false);
        cU.setPreferredSize(new Dimension(200, 75));
        cU.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        
        cP.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0, 100)));
        cP.setPlaceholder("Password");
        cP.setOpaque(false);
        cP.setPreferredSize(new Dimension(200, 75));
        cP.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        
        createForm.add(cU, gbc);
        createForm.add(cP, gbc);
        createForm.add(Box.createVerticalStrut(25), gbc);
        createForm.add(backBtn, gbc2);
        createForm.add(createBtn, gbc2);
        
        add(createForm, gbc);

        setOpaque(false);        
    }
    
    public String getLoginUsername()
    {
        return this.cU.getText();
    }
    
    public String getLoginPassword()
    {
        return this.cP.getText();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("CreateUserView():  Update received from UserModel()");
        if(arg instanceof Boolean && !(boolean)arg)
        {
            createBtn.setBackground(AppColour.ERROR);
        }
        else
        {
            createBtn.setBackground(AppColour.MENU_BACK);
            cU.setText("");
            cP.setText("");
        }
        cU.setText("");
        cP.setText("");
    }
    
    public void addController(UserController controller) {
        System.out.println("CreateUserView: Adding UserController");
        backBtn.addActionListener(controller);
        createBtn.addActionListener(controller);
    } 
}