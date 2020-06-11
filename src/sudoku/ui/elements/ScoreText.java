/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.elements;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import javax.swing.JLabel;
import javax.swing.border.EmptyBorder;

/**
 *
 * @author Waldo
 */
public class ScoreText extends JLabel {   
    public ScoreText() {
        this(null);
    }

    public ScoreText(String inputText) {
        super(inputText);
        setBorder(null);
        this.setOpaque(false);
        setBackground(Color.decode("#685F74").darker().darker());
        setForeground(Color.decode("#F2BEFC"));
        setBorder(new EmptyBorder(5,10,5,10));
        //setEditable(false);
        setFont(new Font("Sans Serif", Font.BOLD, 15));
    }
        
    @Override
    protected void paintComponent(final Graphics g) {
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        super.paintComponent(g);
    }
}