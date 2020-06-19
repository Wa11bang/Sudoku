package sudoku.ui.elements;

import java.awt.FlowLayout;
import java.awt.Font;
import sudoku.AppColour;

/**
 * Custom JPanel element used as a wrapper panel for other components
 * @author Waldo Theron 18033655
 */
public class MenuPanel extends RoundedPanel {   
    
    /**
     * Constructor for a MenuPanel Object
     */
    public MenuPanel() {
        super(30);        
        setLayout(new FlowLayout(FlowLayout.LEFT));
        setBorder(null);
        setOpaque(false);
        setBackground(AppColour.MENU_BACK);
        setFont(new Font("Sans Serif", Font.BOLD, 15));      
    }
}