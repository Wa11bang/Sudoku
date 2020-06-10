package sudoku;

import java.util.Observable;

/**
 *
 * @author Waldo
 */
public class ModelOld extends Observable {    
    public ModelOld() {
        System.out.println("AppModel()");
    }    
    
    public void changePane(String panel)
    {
        this.setChanged();
        this.notifyObservers(panel);
    }
}