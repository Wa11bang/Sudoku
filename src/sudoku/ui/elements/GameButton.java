package sudoku.ui.elements;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JButton;
import sudoku.AppColour;

/**
 *
 * @author Waldo
 */
public class GameButton extends JButton {
    private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;
    
    public GameButton() {
        this(null);
    }

    public GameButton(String buttonText) {
        super(buttonText);
        super.setContentAreaFilled(false);
        setHoverBackgroundColor(AppColour.CONTROL_HOVER);
        setPressedBackgroundColor(AppColour.CONTROL_PRESS);
        setBorderPainted(false);
        setFocusPainted(false);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        if (getModel().isPressed()) {
            g.setColor(pressedBackgroundColor);
        } else if (getModel().isRollover()) {
            g.setColor(hoverBackgroundColor);
        } else {
            g.setColor(getBackground());
        }
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }
    
    public Color getHoverBackgroundColor() {
        return hoverBackgroundColor;
    }

    public void setHoverBackgroundColor(Color hoverBackgroundColor) {
        this.hoverBackgroundColor = hoverBackgroundColor;
    }

    public Color getPressedBackgroundColor() {
        return pressedBackgroundColor;
    }

    public void setPressedBackgroundColor(Color pressedBackgroundColor) {
        this.pressedBackgroundColor = pressedBackgroundColor;
    }    
}
