package sudoku.ui.elements;

import java.awt.Font;
import javax.swing.JLabel;

/**
 * Custom JLabel element for displaying important text in menus
 * @author Waldo Theron 18033655
 */
public class MenuLabel extends JLabel {
    /**
     * Constructor for a MenuLabel Object
     * @param labelText 
     */
    public MenuLabel(String labelText)
    {
        super(labelText);
        setOpaque(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("Helvetica", Font.PLAIN, 25));
    }
    
    /**
     * Constructor for a MenuLabel Object
     */
    public MenuLabel()
    {
        this("");
    }
}
