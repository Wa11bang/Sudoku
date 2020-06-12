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

import java.util.Collections;
import java.util.List;
import java.util.Random;
import javax.swing.SwingUtilities;
import sudoku.misc.BlockGenerator;
import sudoku.misc.HibernateUtils;
import sudoku.models.Block;

/**
 *
 * @author Waldo
 */
public class Sudoku {  
    public final static String LOGO_PATH = "/sudoku/res/logo_c.png";
    public final static int PERMUTE_COUNT = 100;
    
    public static void main(String[] args) {    
        Random rand = new Random();
        int row_a = rand.nextInt(9);
        int row_b = ((row_a / 3) * 3) + rand.nextInt(3);
        
        System.out.println(row_a + " " + row_b);
        
        List<Block> blocks = BlockGenerator.generate(Difficulty.Hard);
        for(int i = 0; i < 81; ++i)
        {            
            if(i % 9 == 0)
            {
                System.out.print("\n");
            }
            System.out.print("["+blocks.get(i).getValue()+"]");
        }
        
        for(int i = 0; i < 9; ++i)
        {
            Collections.swap(blocks, ((row_a * 9) + i), ((row_b * 9) + i)); // COLUMNS
            Collections.swap(blocks, ((row_a + (i*9))), ((row_b + (i*9)))); // ROWS
        }     
        
        System.out.println("\n\n");
        
        for(int i = 0; i < 81; ++i)
        {            
            if(i % 9 == 0)
            {
                System.out.print("\n");
            }
            System.out.print("["+blocks.get(i).getValue()+"]");
        }
        
        //RunGUI();
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