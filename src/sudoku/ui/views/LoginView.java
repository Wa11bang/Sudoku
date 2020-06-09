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
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.MatteBorder;
import sudoku.LoginText;
import sudoku.MenuButton;

/**
 *
 * @author Waldo
 */
public class LoginView extends JPanel {
    
    public LoginView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));
        setLayout(new GridBagLayout());
        
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        
        GridBagConstraints gbc2 = new GridBagConstraints();
        gbc2.anchor = GridBagConstraints.NORTH;
        gbc2.weightx = 1.0;
        gbc2.weighty = 1.0;
        
        JPanel loginForm = new JPanel();
        //loginForm.setLayout(new GridLayout(0,1));
        loginForm.setLayout(new GridBagLayout());
        loginForm.setOpaque(false);
        LoginText tU = new LoginText();
        LoginText tP = new LoginText();
        
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
        loginForm.add(new MenuButton("Back"), gbc2);
        loginForm.add(new MenuButton("Login"), gbc2);

        setOpaque(false);
        add(loginForm, gbc);
    }
}
