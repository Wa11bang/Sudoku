/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.views;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.JTextField;
import sudoku.Block;
import sudoku.Game;
import sudoku.GameBlockText;

/**
 *
 * @author Waldo
 */
public class GameView extends JPanel implements Observer {
    private List<JTextField> grid;
    
    public GameView()
    {
        GridLayout experimentLayout = new GridLayout(9,9);
        experimentLayout.setHgap(15);
        experimentLayout.setVgap(15);
        this.setLayout(experimentLayout);
    }
    
    public void initComponents()
    {
        grid = new ArrayList();
        for(int i = 0; i < 81; ++i)
        {
            grid.add(new GameBlockText());
            this.add(grid.get(i));
        }
        
        
    }
    
    public void loadGame(Object game)
    {
        ListIterator li = grid.listIterator();
        List<Block> blocks = ((Game) game).getBlocks();
        
        while(li.hasNext())
        {
            ((GameBlockText) li.next()).setText(blocks.get((li.nextIndex() - 1)).getValue() + "");
        }
    }
    
    @Override
    public void update(Observable o, Object arg) {
        loadGame(arg);
    }  
}
