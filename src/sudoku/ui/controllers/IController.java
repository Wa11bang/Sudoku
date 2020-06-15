package sudoku.ui.controllers;

import sudoku.App;
import sudoku.events.ViewEvent;

/**
 *
 * @author Waldo
 */
abstract public class IController {
    private App appView;
    
    public void addAppView(App v) {
        System.out.println(getClass().getSimpleName()+": Adding AppView");
        this.appView = v;
    }
    
    public App getAppView()
    {
        return this.appView;
    }
    
    public void changeView(String dest, String src)
    {
        System.out.println(getClass().getSimpleName()+": Acting on AppView()");
        appView.changePane(new ViewEvent(dest,src));
    }
}
