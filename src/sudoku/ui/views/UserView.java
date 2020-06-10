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
public class UserView extends JPanel implements Observer {
    private JPanel loginForm = new JPanel();
    private JPanel createForm = new JPanel();
    private GridBagConstraints gbc = new GridBagConstraints();
    private LoginText tU = new LoginText();
    private LoginText tP = new LoginText(); //CHANGE to JPasswordField 
    private MenuButton backBtn = new MenuButton("Back");
    private MenuButton loginBtn = new MenuButton("Login");
    
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
        
        //loginForm.setLayout(new GridLayout(0,1));
        loginForm.setLayout(new GridBagLayout());
        loginForm.setOpaque(false);       
        
        loginBtn.setActionCommand("user_login");
        backBtn.setActionCommand("start");
        
        tU.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0, 100)));
        tU.setPlaceholder("Username");
        tU.setOpaque(false);
        tU.setPreferredSize(new Dimension(200, 75));
        tU.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        
        tP.setBorder(new MatteBorder(0, 0, 2, 0, new Color(0, 0, 0, 100)));
        tP.setPlaceholder("Password");
        tP.setOpaque(false);
        tP.setPreferredSize(new Dimension(200, 75));
        tP.setFont(new Font("Sans Serif", Font.PLAIN, 24));
        
        loginForm.add(tU, gbc);
        loginForm.add(tP, gbc);
        loginForm.add(Box.createVerticalStrut(25), gbc);
        loginForm.add(backBtn, gbc2);
        loginForm.add(loginBtn, gbc2);
        
        //CREATE
        
        createForm.setLayout(new GridBagLayout());
        createForm.setOpaque(false);
        LoginText cU = new LoginText();
        LoginText cP = new LoginText();
        
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
        createForm.add(new MenuButton("Back"), gbc2);
        createForm.add(new MenuButton("Create"), gbc2);

        setOpaque(false);
        
    }
    
    public UserView create()
    {
        removeAll();
        add(createForm, gbc);
        return this;
    }
    
    public UserView login()
    {
        removeAll();
        add(loginForm, gbc);
        return this;
    }
    
    public String getLoginUsername()
    {
        return this.tU.getText();
    }
    
    public String getLoginPassword()
    {
        return this.tP.getText();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("UserView():  Update received from UserModel()");
        if(!(boolean)arg)
        {
            loginBtn.setBackground(AppColour.ERROR);
        }
        else
        {
            loginBtn.setBackground(AppColour.MENU_BACK);
            tU.setText("");
            tP.setText("");
        }
        tU.setText("");
        tP.setText("");
    }
    
    public void addController(UserController controller) {
        System.out.println("UserView: Adding UserController");
        backBtn.addActionListener(controller);
        loginBtn.addActionListener(controller);
    } 
}
