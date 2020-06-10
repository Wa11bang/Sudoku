/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
 * @author Waldo
 */
public class ViewEvent {
    //private String prevPane;
    private String currentPane;
    private String targetPane;

    public ViewEvent(String currentPane, String targetPane)
    {
        this.currentPane = currentPane;
        this.targetPane = targetPane;
    }
    
    public ViewEvent()
    {
        this("", "");
    }
    
    /**
     * @return the currentPane
     */
    public String getCurrentPane() {
        return currentPane;
    }

    /**
     * @param currentPane the currentPane to set
     */
    public void setCurrentPane(String currentPane) {
        this.currentPane = currentPane;
    }

    /**
     * @return the targetPane
     */
    public String getTargetPane() {
        return targetPane;
    }

    /**
     * @param targetPane the targetPane to set
     */
    public void setTargetPane(String targetPane) {
        this.targetPane = targetPane;
    }
}
