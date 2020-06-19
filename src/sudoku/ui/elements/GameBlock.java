package sudoku.ui.elements;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;
import sudoku.AppColour;

/**
 * Custom JTextField element to represent a single block in the Sudoku Grid
 * @author Waldo Theron 18033655
 */
public class GameBlock extends JTextField {
          
    /**
     * Constructor for a GameBlock Object
     */
    public GameBlock()
    {
        this(null);
    }
    
    /**
     * Constructor for a GameBlock Object
     * @param inputText 
     */
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
    
    /**
     * Initializes the listeners that detect when the focus changes
     */
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