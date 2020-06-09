/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JButton;

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
        setBackground(new Color(232, 240, 255).darker());
        setFont(new Font("Sans Serif", Font.PLAIN, 20));
        setForeground(new Color(232, 240, 255));
        setHoverBackgroundColor(new Color(104, 116, 232).darker());
        setPressedBackgroundColor(new Color(247, 172, 207).darker());
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
        g.fillRect(0, 0, getWidth(), getHeight());
        super.paintComponent(g);
    }

    @Override
    public void setContentAreaFilled(boolean b) {
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
