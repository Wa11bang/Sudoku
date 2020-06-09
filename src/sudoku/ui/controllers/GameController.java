package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import sudoku.Block;
import sudoku.ui.models.GameModel;
import sudoku.ui.views.GameView;

/**
 *
 * @author Waldo
 */
public class GameController implements ActionListener {
    private GameModel model;
    private GameView view;
    private boolean val;
    
    public GameController()
    {
        System.out.println("GameController()");
    }
    
    public void addModel(GameModel m) {
        System.out.println("GameController: Adding GameModel");
        this.model = m;
    }

    public void addView(GameView v) {
        System.out.println("GameController: Adding GameView");
        this.view = v;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Clicked");
        System.out.println("GameController(): Acting on GameModel()");
        if (e.getActionCommand().equals("check")) {
            model.checkGame();
        } else if(e.getActionCommand().equals("save"))
        {
            model.setBlocks(replaceBlockValue(model.getBlocks(), view.getBlocks()));
            model.saveGame();
        } else {
            if(val){
                val = false;
            } else {
                val = true;
            }
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
