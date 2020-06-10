/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.views;

import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import sudoku.Users;
import sudoku.ui.controllers.UserController;
import sudoku.ui.elements.MenuButton;

/**
 *
 * @author Waldo
 */
public class CreateGameView extends JPanel implements Observer {
    private JPanel userMenu = new JPanel();
    private GridBagConstraints gbc = new GridBagConstraints();
    private MenuButton easyBtn = new MenuButton("Create a new Game");
    private MenuButton mediumBtn = new MenuButton("View Uncompleted Games");
    private MenuButton hardBtn = new MenuButton("View Completed Games");
    private MenuButton createBtn = new MenuButton("View Scoreboard");
    private MenuButton backBtn = new MenuButton("Logout");
    private JTextField gameName = new JTextField();
    private JTextField gameSelect = new JTextField();
    
    public CreateGameView()
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
        gameSelect.setOpaque(false);
        gameSelect.setBorder(null);
        gameSelect.setEditable(false);
        gameSelect.setHorizontalAlignment(JTextField.CENTER);
        gameSelect.setFont(new Font("Helvetica", Font.PLAIN, 25));
        
        easyBtn.setActionCommand("easy_game");
        mediumBtn.setActionCommand("medium_game");
        hardBtn.setActionCommand("hard_game");
        createBtn.setActionCommand("create");
        backBtn.setActionCommand("back");//Current Panel (Used for Back-tracking) user

        
        userMenu.add(gameSelect, gbc);
        userMenu.add(Box.createVerticalStrut(50), gbc);
        userMenu.add(easyBtn, gbc);
        userMenu.add(Box.createVerticalStrut(25), gbc);
        userMenu.add(mediumBtn, gbc);
        userMenu.add(Box.createVerticalStrut(25), gbc);
        userMenu.add(hardBtn, gbc);
        userMenu.add(Box.createVerticalStrut(25), gbc);
        userMenu.add(gameName, gbc);
        userMenu.add(Box.createVerticalStrut(25), gbc);
        userMenu.add(createBtn, gbc);      
        userMenu.add(backBtn, gbc);   

        
        add(userMenu, gbc);
        
        setOpaque(false);
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("CreateGameView():  Update received from UserModel()");
        if(arg instanceof Users)
        {
        }
    }
    
    public void addController(UserController controller) {
        System.out.println("UserView: Adding UserController");
        easyBtn.addActionListener(controller);
        mediumBtn.addActionListener(controller);
        hardBtn.addActionListener(controller);
        createBtn.addActionListener(controller);
        backBtn.addActionListener(controller);
    } 
}
