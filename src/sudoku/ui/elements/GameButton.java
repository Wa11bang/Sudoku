package sudoku.ui.elements;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import sudoku.AppColour;

/**
 * Custom JButton element to represent the GameView control buttons
 * @author Waldo Theron 18033655
 */
public class GameButton extends JButton {
    private Color hoverBackgroundColour;
    private Color pressedBackgroundColour;
    
    /**
     * Constructor for a GameButton Object
     */
    public GameButton(String buttonText) {
        super(buttonText);
        super.setContentAreaFilled(false);
        setHoverBackgroundColour(AppColour.CONTROL_HOVER);
        setPressedBackgroundColour(AppColour.CONTROL_PRESS);
        setBorderPainted(false);
        setFocusPainted(false);
    }
    
    /**
     * Constructor for a GameButton Object
     */
    public GameButton() {
        this(null);
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
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
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
