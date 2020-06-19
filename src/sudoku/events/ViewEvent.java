package sudoku.events;

/**
 * Wrapper Object that holds details about a Game Object
 * @author Waldo Theron 18033655
 */
public class ViewEvent {
    private String currentPane;
    private String targetPane;

    /**
     * Constructor for a ViewEvent Object
     * @param currentPane
     * @param targetPane 
     */
    public ViewEvent(String currentPane, String targetPane)
    {
        this.currentPane = currentPane;
        this.targetPane = targetPane;
    }
    
    /**
     * Constructor for a ViewEvent Object
     */
    public ViewEvent()
    {
        this("", "");
    }
    
    /**
     * Returns the currentPane of the application
     * @return currentPane
     */
    public String getCurrentPane() {
        return currentPane;
    }

    /**
     * Returns the targetPane, requested by the application
     * @return targetPane
     */
    public String getTargetPane() {
        return targetPane;
    }
}
