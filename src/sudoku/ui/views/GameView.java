/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku.ui.views;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import sudoku.Block;
import sudoku.Game;
import sudoku.GameBlockText;
import sudoku.ui.controllers.GameController;

/**
 *
 * @author Waldo
 */
public class GameView extends JPanel implements Observer {
    private List<JTextField> grid;
    private JPanel gamePanel = new JPanel();
    private JButton check = new JButton();
    private JButton save = new JButton();
    private JButton back = new JButton();  
    private SwingWorker<Void, String> worker;
    private Color statusCol;
    
    public GameView()
    {
        GridLayout experimentLayout = new GridLayout(9,9);
        experimentLayout.setHgap(15);
        experimentLayout.setVgap(15);
        
        gamePanel.setLayout(experimentLayout);
        gamePanel.setBorder(new EmptyBorder(30,30,15,30));
        
        /*
        this.setLayout(experimentLayout);
        this.setBorder(new EmptyBorder(15,15,15,15));
        */      
        
        JPanel controls = new JPanel();
        controls.setBorder(new EmptyBorder(15,30,15,30));
        
        check = new JButton("Check Solution");
        check.setActionCommand("check");
        
        save = new JButton("Save Progress");
        save.setActionCommand("save");
        
        back = new JButton("Back");
        back.setActionCommand("back");

        controls.add(back);
        controls.add(check);
        controls.add(save);        
        
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
        
        add(gamePanel, BorderLayout.CENTER);
        add(controls, BorderLayout.PAGE_END);
        
        
        worker = new SwingWorker<Void, String>(){

            @Override
            protected Void doInBackground() throws Exception {
                for(int i = 0; i < 81; ++i)
                {
                    grid.get(i).setBackground(statusCol);
                    Thread.sleep(5);
                }   
                
                this.cancel(true);
                
                return null;
            }

            @Override
            protected void process(List<String> res){
                for(String text : res){
                }
            }

        };
    }
    
    public void initComponents()
    {
        grid = new ArrayList();
        for(int i = 0; i < 81; ++i)
        {
            grid.add(new GameBlockText());
            gamePanel.add(grid.get(i));
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
        /*if((boolean) arg)
        {
            statusCol = Color.green;
        }
        else
        {
            statusCol = Color.red;
        }
        System.out.println("GOT THAT UPDATE BOISSSS");
        worker.execute();*/
    }  
    
    public void addController(GameController controller) {
        System.out.println("GameView: Adding GameController");
        check.addActionListener(controller);
        save.addActionListener(controller);
        back.addActionListener(controller);
    } 
}
