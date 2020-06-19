package sudoku.ui.elements;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 * A document that limits the maximum length of content
 * @author Waldo Theron 18033655
 */
public class TextLimitDocument extends PlainDocument {
    private int maxLength = 0;
    
    /**
     * Constructor for TextLimitDocument
     * @param maxLength 
     */
    public TextLimitDocument(int maxLength)
    {
        this.maxLength = maxLength;
    }
    
    @Override
    public void insertString(int offset, String string, AttributeSet as) throws BadLocationException
    {
        if((string != null) && ((string.length() + this.getLength()) <= this.maxLength))
        {
            super.insertString(offset, string, as);
        }
    }
}
