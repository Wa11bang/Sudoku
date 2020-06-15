package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Waldo
 */
public class StartController extends IController implements ActionListener {
    
    public StartController()
    {
        System.out.println("StartController()");
    }    

    @Override
    public void actionPerformed(ActionEvent e) 
    {
        if (e.getActionCommand().equals("exit")) {
            System.exit(0);
        } else {
            changeView("start", e.getActionCommand());
        }             
    }
}
