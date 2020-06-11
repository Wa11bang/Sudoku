package sudoku.ui.elements;

import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 * @author Waldo
 */
public class MenuLabel extends JLabel {
    public MenuLabel(String labelText)
    {
        super(labelText);
        setOpaque(false);
        setBorder(null);
        setHorizontalAlignment(JLabel.CENTER);
        setFont(new Font("Helvetica", Font.PLAIN, 25));
    }
    
    public MenuLabel()
    {
        this("");
    }
}
