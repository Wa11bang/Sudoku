package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import sudoku.Block;
import sudoku.View;
import sudoku.ViewEvent;
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
    
    @Override
    public void actionPerformed(ActionEvent e) {   
        System.out.println("GameController(): Acting on GameModel()");
        if (e.getActionCommand().equals("check")) {
            if(null != view.parseBlocks())
            {
                model.setBlocks(replaceBlockValue(model.getBlocks(), view.parseBlocks()));
                model.checkGame();
            }
            
        } else if(e.getActionCommand().equals("save"))
        {            
            if(null != view.parseBlocks())
            {
            model.setBlocks(replaceBlockValue(model.getBlocks(), view.parseBlocks()));
            model.saveGame(true);
            }
        } else if(e.getActionCommand().equals("back"))
        {
            System.out.println("GameController(): Acting on AppView()");
            //appView.setCurrentPane("start");
            appView.changePane(new ViewEvent("game", "user"));
        }
    }    
}
