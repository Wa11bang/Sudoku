package sudoku.ui.elements;

import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author Waldo
 */
public class RoundedPanel extends JPanel { 
    private int roundingRadius;
    
    public RoundedPanel(int radius)
    {
        super();
        this.roundingRadius = radius;
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {        
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, roundingRadius, roundingRadius);
        super.paintComponent(g);
    }
}
