/*

    TODO
    Comments   

*/

package sudoku;

import javax.swing.SwingUtilities;
import sudoku.misc.Log;
import sudoku.misc.HibernateUtils;

/**
 *
 * @author Waldo
 */
public class Sudoku extends Log {  
    public final static String LOGO_PATH = "/sudoku/res/logo.png";
    public static final double VERSION = 1.5;    
    public final static int PERMUTE_COUNT = 1;
    public final static int MAX_USERNAME_LEN = 8;
    
    public static void main(String[] args) {  
        log.info("Starting Sudoku");
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