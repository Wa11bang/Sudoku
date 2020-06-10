/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.views;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import sudoku.AppColour;
import sudoku.Users;
import sudoku.ui.controllers.UserController;
import sudoku.ui.elements.LoginText;
import sudoku.ui.elements.MenuButton;

/**
 *
 * @author Waldo
 */
public class UserView extends JPanel implements Observer {
    private JPanel userMenu = new JPanel();
    private GridBagConstraints gbc = new GridBagConstraints();
    private MenuButton createGameBtn = new MenuButton("Create a new Game");
    private MenuButton uncompletedGamesBtn = new MenuButton("View Uncompleted Games");
    private MenuButton completedGamesBtn = new MenuButton("View Completed Games");
    private MenuButton viewScoreboardBtn = new MenuButton("View Scoreboard");
    private MenuButton logoutBtn = new MenuButton("Logout");
    private JTextField userWelcome = new JTextField();
    
    public UserView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));
        setLayout(new GridBagLayout());        
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.anchor = GridBagConstraints.NORTH;
        gbc2.weightx = 1.0;
        gbc2.weighty = 1.0;        
        
        //userMenu.setLayout(new GridLayout(0, 1));
        userMenu.setLayout(new GridBagLayout());
        userMenu.setOpaque(false);  
        userWelcome.setOpaque(false);
        userWelcome.setBorder(null);
        userWelcome.setEditable(false);
        userWelcome.setHorizontalAlignment(JTextField.CENTER);
        userWelcome.setFont(new Font("Helvetica", Font.PLAIN, 25));
        
        createGameBtn.setActionCommand("create_game");
        uncompletedGamesBtn.setActionCommand("uncompleted_games");
        completedGamesBtn.setActionCommand("completed_games");
        viewScoreboardBtn.setActionCommand("scoreboard");
        logoutBtn.setActionCommand("user");//Current Panel (Used for Back-tracking)

        
        userMenu.add(userWelcome, gbc);
        userMenu.add(Box.createVerticalStrut(50), gbc);
        userMenu.add(createGameBtn, gbc);
        userMenu.add(Box.createVerticalStrut(25), gbc);
        userMenu.add(uncompletedGamesBtn, gbc);
        userMenu.add(Box.createVerticalStrut(25), gbc);
        userMenu.add(completedGamesBtn, gbc);
        userMenu.add(Box.createVerticalStrut(25), gbc);
        userMenu.add(viewScoreboardBtn, gbc);
        userMenu.add(Box.createVerticalStrut(25), gbc);
        userMenu.add(logoutBtn, gbc);      
        

        
        add(userMenu, gbc);
        
        setOpaque(false);
        
    }
    
    public void loadUser(Users user)
    {
        userWelcome.setText("Welcome "+user.getUsername());
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("UserView():  Update received from UserModel()");
        if(arg instanceof Users)
        {
            loadUser((Users)arg);
        }
    }
    
    public void addController(UserController controller) {
        System.out.println("UserView: Adding UserController");
        createGameBtn.addActionListener(controller);
        uncompletedGamesBtn.addActionListener(controller);
        completedGamesBtn.addActionListener(controller);
        viewScoreboardBtn.addActionListener(controller);
        logoutBtn.addActionListener(controller);
    } 
}
