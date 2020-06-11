package sudoku.ui.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;
import sudoku.AppColour;

/**
 *
 * @author Waldo
 */
public class MenuButton extends JButton {
    
    private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;

    public MenuButton() {
        this(null);
    }

    public MenuButton(String buttonText) {
        super(buttonText);
        super.setContentAreaFilled(false);
        
        setBackground(AppColour.MENU_BACK);        
        setForeground(AppColour.MENU_FORE);
        setHoverBackgroundColor(AppColour.MENU_HOVER);
        setPressedBackgroundColor(AppColour.MENU_PRESS);
        
        setBorderPainted(false);
        setFocusPainted(false);
        
        setFont(new Font("Helvetica", Font.PLAIN, 20));
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
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 30, 30);
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
