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
    protected GridBagConstraints gbConstraints = new GridBagConstraints();
    protected GridBagConstraints gbConstraints2 = new GridBagConstraints();
    
    public IView()
    {
        setLayout(new GridBagLayout());     
        setOpaque(false);
        
        gbConstraints.gridwidth = GridBagConstraints.REMAINDER;
        gbConstraints.fill = GridBagConstraints.HORIZONTAL;        
        
        gbConstraints2.anchor = GridBagConstraints.NORTH;
        gbConstraints2.weightx = 1.0;
        gbConstraints2.weighty = 1.0;       
    }
}
