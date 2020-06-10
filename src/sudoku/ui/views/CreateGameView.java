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
import sudoku.Difficulty;
import sudoku.Users;
import sudoku.ui.controllers.GameController;
import sudoku.ui.controllers.UserController;
import sudoku.ui.elements.MenuButton;

/**
 *
 * @author Waldo
 */
public class CreateGameView extends JPanel implements Observer {
    private JPanel gameSelection = new JPanel();
    private JPanel btnPanel = new JPanel();
    private GridBagConstraints gbc = new GridBagConstraints();
    private MenuButton easyBtn = new MenuButton("Easy ("+Difficulty.Easy.getValue()+")");
    private MenuButton mediumBtn = new MenuButton("Medium ("+Difficulty.Medium.getValue()+")");
    private MenuButton hardBtn = new MenuButton("Hard ("+Difficulty.Hard.getValue()+")");
    private MenuButton backBtn = new MenuButton("Back");
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
        gameSelection.setLayout(new GridBagLayout());
        gameSelection.setOpaque(false);        
              
        
        gameSelect.setOpaque(false);
        gameSelect.setBorder(null);
        gameSelect.setEditable(false);
        gameSelect.setHorizontalAlignment(JTextField.CENTER);
        gameSelect.setFont(new Font("Helvetica", Font.PLAIN, 25));
        gameSelect.setText("Please select a Game Difficulty");
        
        easyBtn.setActionCommand("easy_create");
        mediumBtn.setActionCommand("medium_create");
        hardBtn.setActionCommand("hard_create");
        backBtn.setActionCommand("back");//Current Panel (Used for Back-tracking) user

        gameSelection.add(Box.createVerticalStrut(25), gbc);
        gameSelection.add(easyBtn, gbc);
        gameSelection.add(Box.createVerticalStrut(10), gbc);
        gameSelection.add(mediumBtn, gbc);
        gameSelection.add(Box.createVerticalStrut(10), gbc);
        gameSelection.add(hardBtn, gbc);
        gameSelection.add(Box.createVerticalStrut(50), gbc);
        gameSelection.add(backBtn);   

        add(gameSelect, gbc);
        add(gameSelection, gbc);
        
        setOpaque(false);
        
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("CreateGameView():  Update received from UserModel()");
        if(arg instanceof Users)
        {
        }
    }
    
    public void addController(GameController controller) {
        System.out.println("CreateGameView: Adding GameController");
        easyBtn.addActionListener(controller);
        mediumBtn.addActionListener(controller);
        hardBtn.addActionListener(controller);
        backBtn.addActionListener(controller);
    } 
}
