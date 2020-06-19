package sudoku.ui.elements;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;
import javax.swing.border.MatteBorder;
import sudoku.AppColour;

/**
 * Custom JTextField element for User Inputs
 * @author Waldo Theron 18033655
 */
public class MenuField extends JTextField {
    
    private String placeholder;
    
    /**
     * Constructor for a MenuField Object
     */
    public MenuField() {
        this(null);
    }

    /**
     * Constructor for a MenuField Object
     * @param inputText 
     */
    public MenuField(String inputText) {
        this(inputText, null);
    }
    
    /**
     * Constructor for a MenuField Object
     * @param inputText
     * @param placeholder 
     */
    public MenuField(String inputText, String placeholder) {
        super(inputText);
        this.placeholder = placeholder;
        
        setBorder(new MatteBorder(0, 0, 2, 0, AppColour.MENU_F_BORDER));
        setOpaque(false);
        setPreferredSize(new Dimension(200, 75));
        setFont(new Font("Sans Serif", Font.PLAIN, 24));        
    }
    
    /**
     * Sets the placeholder value
     * @param placeholder 
     */
    public void setPlaceholder(String placeholder)
    {
        this.placeholder = placeholder;
    }
    
    /**
     * Gets the placeholder value
     * @return 
     */
    public String getPlaceholder()
    {
        return this.placeholder;
    }
    
    @Override
    protected void paintComponent(final Graphics pG) {
        super.paintComponent(pG);

        if (placeholder == null || placeholder.length() == 0 || getText().length() > 0) {
            return;
        }

        final Graphics2D g = (Graphics2D) pG;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING,RenderingHints.VALUE_ANTIALIAS_ON);
        g.setColor(AppColour.MENU_F_PLACE);
        g.setFont(new Font("Sans Serif", Font.PLAIN, 12));
        g.drawString(placeholder, getInsets().left, this.getHeight() - 7);
    }
}
