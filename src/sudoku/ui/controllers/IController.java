package sudoku.ui.controllers;

import sudoku.App;
import sudoku.events.ViewEvent;

/**
 * Abstract Class for Controllers, adds reference to App() Class
 * @author Waldo Theron 18033655
 */
abstract public class IController {
    private App appView;
    
    /**
     * Adds a reference to AppView
     * @param v 
     */
    public void addAppView(App v) {
        System.out.println(getClass().getSimpleName()+": Adding AppView");
        this.appView = v;
    }
    
    /**
     * Returns the AppView
     * @return appView
     */
    public App getAppView()
    {
        return this.appView;
    }
    
    /**
     * Requests a change of the main view using a ViewEvent
     * @param dest
     * @param src 
     */
    public void changeView(String dest, String src)
    {
        System.out.println(getClass().getSimpleName()+": Acting on AppView()");
        appView.changePane(new ViewEvent(dest,src));
    }
}
