/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.views;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import sudoku.Controller;
import sudoku.MenuButton;

/**
 *
 * @author Waldo
 */
public class StartView extends JPanel {
    private MenuButton login;
    private MenuButton cnu;
    private MenuButton vsb;
    private MenuButton exit;
    
    public StartView()
    {
        try {
            BufferedImage myPicture = ImageIO.read(new File("./src/sudoku/res/logo.png"));
            JLabel picLabel = new JLabel(new ImageIcon(myPicture));
            add(picLabel);
        } catch (IOException ex) {
            System.out.println("File not found!");
        }   
        
        cnu = new MenuButton("Create New User");
        //cnu.setBackground(new Color(104, 116, 232).brighter());
        cnu.setFont(new Font("Segoe UI", Font.PLAIN, 20));
        cnu.setForeground(new Color(232, 240, 255));
        cnu.setHoverBackgroundColor(new Color(104, 116, 232).darker());
        cnu.setPressedBackgroundColor(new Color(247, 172, 207).darker());
        cnu.setBorderPainted(false);
        cnu.setFocusPainted(false);
        cnu.setActionCommand("create_user");
        cnu.setHorizontalAlignment(JLabel.CENTER);
        
        login = new MenuButton("Login");
        login.setActionCommand("login");
        
        vsb = new MenuButton("View Scoreboard");
        vsb.setActionCommand("view_scoreboard");
        
        exit = new MenuButton("Exit");
        exit.setActionCommand("exit");
        
        setBorder(new EmptyBorder(45, 10, 10, 10));
        //startMenu.setLayout(new BoxLayout(startMenu, BoxLayout.Y_AXIS));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel startButtons = new JPanel();
        //startButtons.setLayout(new BoxLayout(startButtons, BoxLayout.Y_AXIS));
        startButtons.setLayout(new GridLayout(0,1));
        startButtons.setOpaque(false);
        startButtons.add(cnu);
        startButtons.add(Box.createVerticalStrut(15));
        startButtons.add(login);
        startButtons.add(Box.createVerticalStrut(15));
        startButtons.add(vsb);
        startButtons.add(Box.createVerticalStrut(15));
        startButtons.add(exit);
        
        //startMenu.setBackground(new Color(232, 240, 255));
        setOpaque(false);
        add(startButtons);
    }
    
    public void addController(Controller controller)
    {
        this.login.addActionListener(controller);
        this.cnu.addActionListener(controller);
        this.vsb.addActionListener(controller);
        this.exit.addActionListener(controller);
    }
}
