/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class LoginText extends JTextField {
    
    private String placeholder;
    private String passwordU;
    private boolean mask;
    
    public LoginText() {
        this(null);
    }

    public LoginText(String inputText) {
        super(inputText);
    }
    
    public LoginText(String inputText, String placeholder) {
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
