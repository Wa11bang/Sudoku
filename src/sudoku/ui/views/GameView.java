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
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import sudoku.Block;
import sudoku.ControlButton;
import sudoku.Game;
import sudoku.GameBlockText;
import sudoku.RoundedPanel;
import sudoku.ui.controllers.GameController;

/**
 *
 * @author Waldo
 */
public class GameView extends JPanel implements Observer {
    private List<JTextField> grid;
    private JPanel gamePanel = new JPanel();
    private ControlButton check = new ControlButton();
    private JButton save = new JButton();
    private JButton back = new JButton();  
    private Color statusCol;
    
    public GameView()
    {
        GridLayout experimentLayout = new GridLayout(3,3);
        experimentLayout.setHgap(15);
        experimentLayout.setVgap(15);
        
        gamePanel.setLayout(experimentLayout);
        gamePanel.setBorder(new EmptyBorder(30,30,15,30));
        
        JPanel controls = new JPanel();
        controls.setBorder(new EmptyBorder(15,30,15,30));
        
        check = new ControlButton("Check Solution");
        check.setActionCommand("check");
        
        save = new ControlButton("Save Progress");
        save.setActionCommand("save");
        
        back = new ControlButton("Back");
        back.setActionCommand("back");

        controls.add(back);
        controls.add(check);
        controls.add(save);        
        
        //this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.setLayout(new BorderLayout());
        
        add(gamePanel, BorderLayout.CENTER);
        add(controls, BorderLayout.PAGE_END);               
    }
    
    public void initComponents()
    {
        grid = new ArrayList();
        for(int i = 0; i < 81; ++i)
        {
            grid.add(new GameBlockText());
            //gamePanel.add(grid.get(i));
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
        
        this.getSections();
    }
    
    /**
     * Group a 3x3 section and draw a really nice background
     * @param game 
     */
    public void getSections()
    {
        int secColStart = 0;
        int secColEnd = 3;
        int secRowStart = 0;
        int secRowEnd = 3;
        
        for(int a = 0; a < 3; ++a)
        {
            secRowStart = 0;
            secRowEnd = 3;
        for(int k = 0; k < 3; ++k)
        {
            GridLayout experimentLayout = new GridLayout(3,3);
            JPanel p = new RoundedPanel();
            experimentLayout.setHgap(5);
            experimentLayout.setVgap(5);
            p.setOpaque(false);
            p.setLayout(experimentLayout);
            p.setBackground(Color.decode("#e0d5b1"));
            p.setBorder(new EmptyBorder(10,10,10,10));
            
            for(int i = secColStart; i < secColEnd; ++i)
            {
                for(int j = secRowStart; j < secRowEnd; ++j)
                {
                    p.add(grid.get((i * 9)+j));
                }
            }
            gamePanel.add(p);
            secRowStart += 3;
            secRowEnd += 3;
        }
            secColStart += 3;
            secColEnd += 3;
        }
    }
    
    public void gameStatus(boolean status)
    {        
        new SwingWorker<Void, String>(){
            @Override
            protected Void doInBackground() throws Exception {
                
                for(int i = 0; i < 81; ++i)
                {
                    if(status)
                    {
                        grid.get(i).setEditable(false);
                    }
                    grid.get(i).setBackground(statusCol);                    
                    Thread.sleep(2);
                }
                
                for(int i = 0; i < 81; ++i)
                {
                    grid.get(i).setBackground(Color.decode("#F6F0ED"));
                    Thread.sleep(2);
                }                
                return null;
            }
        }.execute();
    }
    
    public List<Block> getBlocks()
    {
        ListIterator li = grid.listIterator();
        List<Block> blocks = new ArrayList();
        
        while(li.hasNext())
        {
            try
            {
            blocks.add(new Block(Integer.parseInt(((GameBlockText) li.next()).getText())));
            } catch (NumberFormatException ex)
            {
                statusCol = Color.red;
                this.gameStatus(false);
            }
        }
        
        return blocks;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        
        if(arg instanceof Game)
        {
            loadGame(arg);
        }
        else {
        if((boolean) arg)
        {
            statusCol = Color.green;
        }
        else
        {
            statusCol = Color.red;
        }
        System.out.println("GOT THAT UPDATE BOISSSS");
        this.gameStatus((boolean)arg);
        }
    }  
    
    public void addController(GameController controller) {
        System.out.println("GameView: Adding GameController");
        check.addActionListener(controller);
        save.addActionListener(controller);
        back.addActionListener(controller);
    } 
}
