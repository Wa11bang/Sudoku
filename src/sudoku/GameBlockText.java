/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.BorderFactory;
import javax.swing.JTextField;
import javax.swing.border.AbstractBorder;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 *
 * @author Waldo
 */
public class GameBlockText extends JTextField implements FocusListener {
    
    public GameBlockText(String inputText)
    {
        super(inputText);    
        this.setOpaque(false);
        this.setFont(new Font("Sans Serif", Font.BOLD, 25));
        setBackground(Color.decode("#F6F0ED"));
        //this.setBorder(new RoundedCornerBorder());
        //Border roundedBorder = new LineBorder(Color.WHITE, 15, true);
        this.setBorder(null);
        this.setHorizontalAlignment(JTextField.CENTER);
        this.addFocusListener(this);
        //this.setBorder(BorderFactory.createLineBorder(Color.black));
    }
    
    public void focusGained(java.awt.event.FocusEvent focusEvent) {
        try {
            JTextField src = (JTextField)focusEvent.getSource();
            src.setBackground(Color.decode("#BBB193"));
        } catch (ClassCastException ignored) {
            /* I only listen to JTextFields */
        }
    }
    
    @Override
    protected void paintComponent(Graphics g)
    {
        
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
        super.paintComponent(g);
    }
    
    public GameBlockText()
    {
        this(null);
    }

    @Override
    public void focusLost(FocusEvent e) {
        try {
            JTextField src = (JTextField)e.getSource();
            src.setBackground(Color.decode("#F6F0ED"));
        } catch (ClassCastException ignored) {
            /* I only listen to JTextFields */
        }
    }
}