package sudoku.ui.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import sudoku.AppColour;

/**
 * Custom JButton element for all main/menu buttons in Views
 * @author Waldo Theron 18033655
 */
public class MenuButton extends JButton {
    
    private Color hoverBackgroundColour;
    private Color pressedBackgroundColour;

    /**
     * Constructor for a MenuButton Object
     */
    public MenuButton() {
        this(null);
    }

    /**
     * Constructor for a MenuButton Object
     * @param buttonText 
     */
    public MenuButton(String buttonText) {
        super(buttonText);
        super.setContentAreaFilled(false);
        
        setBackground(AppColour.MENU_BACK);        
        setForeground(AppColour.MENU_FORE);
        setHoverBackgroundColour(AppColour.MENU_HOVER);
        setPressedBackgroundColour(AppColour.MENU_PRESS);
        
        setBorderPainted(false);
        setFocusPainted(false);
        
        setFont(new Font("Helvetica", Font.PLAIN, 20));
    }

    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColour);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColour);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
        super.paintComponent(g);
    }

    /**
     * Returns the background color set for the when the user presses the button
     * @return pressedBackgroundColour;
     */
    public Color getPressedBackgroundColour() {
        return pressedBackgroundColour;
    }

    /**
     * Sets the pressedBackgroundColour
     * @param pressedBackgroundColour 
     */
    public void setPressedBackgroundColour(Color pressedBackgroundColour) {
        this.pressedBackgroundColour = pressedBackgroundColour;
    }   
        
    /**
     * Returns the background color set for the when the user hovers over the button
     * @return hoverBackgroundColour;
     */
    public Color getHoverBackgroundColour() {
        return hoverBackgroundColour;
    }

    /**
     * Sets the hoverBackgroundColour
     * @param hoverBackgroundColour 
     */
    public void setHoverBackgroundColour(Color hoverBackgroundColour) {
        this.hoverBackgroundColour = hoverBackgroundColour;
    }     
}
