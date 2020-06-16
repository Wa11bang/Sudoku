/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.elements;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Waldo
 */
public class MenuPanel extends JPanel {   
    
    public MenuPanel() {
        super();
        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(null);
        setOpaque(false);
        setBackground(Color.decode("#E0DFD5"));
        setFont(new Font("Sans Serif", Font.BOLD, 15));      
    }
        
    @Override
    protected void paintComponent(final Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g);
    }
}