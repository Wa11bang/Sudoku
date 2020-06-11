/*

    TODO
    JPassword for Login and Create
    View Completed Game
    View Uncompleted Games
    Comments
    
    Rename View Class and reduce Main Method

    GameHandlerExec/GameHandler - CheckSolution

    Add Logger

    PERMUTATION ALGORITHM
    Store PREDOKUs in Database
    Make Score print out neater
    
    Make so that you cannot save game after completed

    Make classes as direct access objects for all Handlers

    Create AppView abstract and then use a ViewFactory

    replace userWelcome in userView with MenuLabel
    add MenuLabels to each view

    Add styles from CreateUserView and LoginView to MenuField and Add MenuPasswordField

    EMPTY CLASSES:
    - StartModel
    - CompletedGameView
    - UncompletedGameView
*/

package sudoku;

import javax.swing.SwingUtilities;
import sudoku.misc.HibernateUtils;

/**
 *
 * @author Waldo
 */
public class Sudoku {  
    public final static String LOGO_PATH = "/sudoku/res/logo_c.png";
    public static void main(String[] args) {      
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