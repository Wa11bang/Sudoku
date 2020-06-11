package sudoku.ui.elements;

import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.PlainDocument;

/**
 *
 * @author Waldo
 */
public class TextLimitDocument extends PlainDocument {
    private int maxLength = 0;
    
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
