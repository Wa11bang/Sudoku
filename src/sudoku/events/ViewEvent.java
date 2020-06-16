package sudoku.events;

/**
 *
 * @author Waldo
 */
public class ViewEvent {
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
     * @return the targetPane
     */
    public String getTargetPane() {
        return targetPane;
    }
}
