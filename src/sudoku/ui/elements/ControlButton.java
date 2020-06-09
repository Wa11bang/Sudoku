/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;

/**
 *
 * @author Waldo
 */
public class ControlButton extends JButton {
    private Color hoverBackgroundColor;
    private Color pressedBackgroundColor;
    
    public ControlButton() {
        this(null);
    }

    public ControlButton(String buttonText) {
        super(buttonText);
        super.setContentAreaFilled(false);
        setHoverBackgroundColor(Color.decode("#e0d5b1"));
        setPressedBackgroundColor(Color.decode("#e0d5b1").darker());
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
