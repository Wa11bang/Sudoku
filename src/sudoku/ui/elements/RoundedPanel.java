/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.elements;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Waldo
 */
public class RoundedPanel extends JPanel {    
    public RoundedPanel()
    {
        super();
    }
    @Override
    protected void paintComponent(Graphics g)
    {        
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
        super.paintComponent(g);
    }
}
