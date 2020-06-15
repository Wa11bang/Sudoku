/*

    TODO
    Comments   

    Add Logger to important classes

    JUNIT TESTING

    Store PREDOKUs in Database
    Make Score print out neater
    
    Make so that you cannot save game after completed

    Create AppView abstract and then use a ViewFactory

    add MenuLabels to each view

    EMPTY CLASSES:
    - StartModel
*/

package sudoku;

import javax.swing.SwingUtilities;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import sudoku.misc.HibernateUtils;

/**
 *
 * @author Waldo
 */
public class Sudoku {  
    public final static String LOGO_PATH = "/sudoku/res/logo.png";
    public static final double VERSION = 1.5;
    private static final Logger LOGGER = LogManager.getLogger(Sudoku.class);
    public final static int PERMUTE_COUNT = 100;
    
    public static void main(String[] args) {  
        LOGGER.info("Starting Sudoku");
        RunGUI();        
    }
    
    public static void RunGUI() {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new App();
            }
        });
        
        HibernateUtils.getSession();
    }
}