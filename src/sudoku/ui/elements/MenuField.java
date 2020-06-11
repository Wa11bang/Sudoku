package sudoku.ui.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.JTextField;

/**
 *
 * @author Waldo
 */
public class MenuField extends JTextField {
    
    private String placeholder;
    
    public MenuField() {
        this(null);
    }

    public MenuField(String inputText) {
        super(inputText);
    }
    
    public MenuField(String inputText, String placeholder) {
        super(inputText);
        this.placeholder = placeholder;
    }
    
    public void setPlaceholder(String placeholder)
    {
        this.placeholder = placeholder;
    }
    
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
        g.setColor(new Color(33, 33, 33, 100));
        g.setFont(new Font("Sans Serif", Font.PLAIN, 12));
        g.drawString(placeholder, getInsets().left, this.getHeight() - 7);
    }
}
