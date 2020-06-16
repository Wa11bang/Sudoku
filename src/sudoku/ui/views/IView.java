package sudoku.ui.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import javax.swing.JPanel;

/**
 *
 * @author Waldo
 */
abstract public class IView extends JPanel {
    protected JPanel contentPanel = new JPanel();    
    protected GridBagConstraints gbc = new GridBagConstraints();
    protected GridBagConstraints gbc2 = new GridBagConstraints();
    
    public IView()
    {
        setLayout(new GridBagLayout());     
        setOpaque(false);
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;        
        
        gbc2.anchor = GridBagConstraints.NORTH;
        gbc2.weightx = 1.0;
        gbc2.weighty = 1.0;       
    }
}
