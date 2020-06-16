package sudoku.ui.elements;

import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JPanel;
import sudoku.AppColour;

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
        setBackground(AppColour.MENU_BACK);
        setFont(new Font("Sans Serif", Font.BOLD, 15));      
    }
        
    @Override
    protected void paintComponent(final Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g);
    }
}