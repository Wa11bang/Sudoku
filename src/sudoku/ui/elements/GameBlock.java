package sudoku.ui.elements;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import sudoku.AppColour;

/**
 *
 * @author Waldo
 */
public class GameBlock extends JTextField {
    
    public GameBlock(String inputText)
    {
        super(inputText);    
        setOpaque(false);
        setFont(new Font("Sans Serif", Font.BOLD, 25));
        setBackground(AppColour.GAME_B_BACK);
        setBorder(null);
        setHorizontalAlignment(JTextField.CENTER);
        setDocument(new TextLimitDocument(1));
        
        initFocusListener();
    }
    
    public GameBlock()
    {
        this(null);
    }
    
    public void initFocusListener()
    {
        addFocusListener(new FocusListener() {
            @Override
            public void focusGained(FocusEvent e) {
                try {
                    JTextField src = (JTextField)e.getSource();
                    src.setBackground(AppColour.GAME_B_FOCUS);
                } catch (ClassCastException ignored) {
                    /* oofies, I only care about dem sweet JTextTitties */
                }
            }

            @Override
            public void focusLost(FocusEvent e) {
                try {
                    JTextField src = (JTextField)e.getSource();
                    src.setBackground(AppColour.GAME_B_BACK);
                } catch (ClassCastException ignored) {
                    /* oofies, I only care about dem sweet JTextTitties */
                }
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        
        g.setColor(getBackground());
        g.fillRoundRect(0, 0, getWidth()-1, getHeight()-1, 30, 30);
        super.paintComponent(g);
    }   
}