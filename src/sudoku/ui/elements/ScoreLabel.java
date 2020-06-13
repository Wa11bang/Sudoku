package sudoku.ui.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Waldo
 */
public class ScoreLabel extends JLabel {   
    
    public ScoreLabel(String inputText) {
        super(inputText);
        
        setBorder(null);
        setOpaque(false);
        setBackground(Color.decode("#E0DFD5"));
        setForeground(Color.decode("#685F74").darker().darker());
        setBorder(new EmptyBorder(10,10,10,10));
        setFont(new Font("Sans Serif", Font.BOLD, 15));
    }
    
    public ScoreLabel() {
        this(null);
    }
        
    @Override
    protected void paintComponent(final Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g);
    }
}