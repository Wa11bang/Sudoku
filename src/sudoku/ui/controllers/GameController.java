package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import sudoku.Block;
import sudoku.Model;
import sudoku.View;
import sudoku.ui.models.GameModel;
import sudoku.ui.views.GameView;

/**
 *
 * @author Waldo
 */
public class GameController implements ActionListener {
    private View appView;
    private GameModel model;
    private GameView view;
    
    public GameController()
    {
        System.out.println("GameController()");
    }
    
    public void addModel(GameModel m) {
        System.out.println("GameController: Adding GameModel");
        this.model = m;
    }
    
    public void addAppView(View v) {
        System.out.println("GameController: Adding AppView");
        this.appView = v;
    }

    public void addView(GameView v) {
        System.out.println("GameController: Adding GameView");
        this.view = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {        
        if (e.getActionCommand().equals("check")) {
            System.out.println("GameController(): Acting on GameModel()");
            model.checkGame();
        } else if(e.getActionCommand().equals("save"))
        {
            System.out.println("GameController(): Acting on GameModel()");
            model.setBlocks(replaceBlockValue(model.getBlocks(), view.parseBlocks()));
            model.saveGame();
        } else if(e.getActionCommand().equals("back_users"))
        {
            System.out.println("GameController(): Acting on AppView()");
            appView.setCurrentPane("start");
        }
    }
    
    public List<Block> replaceBlockValue(List<Block> source, List<Block> newSet)
    {
        ListIterator li = newSet.listIterator();
        List<Block> blocks = new ArrayList();
        
        int count = 0;
        
        while(li.hasNext())
        {
            source.get(count).setValue(((Block)li.next()).getValue());
            count++;
        }
        
        return source;
    }
    
}
