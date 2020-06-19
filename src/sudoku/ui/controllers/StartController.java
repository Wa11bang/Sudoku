package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Handles User Interactions for the Start Menu
 * @author Waldo Theron 18033655
 */
public class StartController extends IController implements ActionListener {
    
    /**
     * Constructor for a StartController Object
     */
    public StartController()
    {
        System.out.println("StartController()");
    }    

    /**
     * Handles User Actions
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("exit")) {                              // Exits the Program
            System.exit(0);
        } else {
            changeView("start", e.getActionCommand());                          // Transition away from the Start Menu
        }             
    }
}
