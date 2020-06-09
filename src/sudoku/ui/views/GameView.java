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
import java.util.logging.Level;
import java.util.logging.Logger;
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
import sudoku.RoundedPanel;
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
        GridLayout experimentLayout = new GridLayout(3,3);
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
        
        this.getSections((Game)game);
    }
    
    public void getSections(Game game)
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
                    System.out.print(" ["+game.getBlocks().get((i * 9)+j).getValue()+"] ");
                    p.add(grid.get((i * 9)+j));
                }
                System.out.println("\n");
            }
            gamePanel.add(p);
            System.out.println("SECTION SEPERATION");
            secRowStart += 3;
            secRowEnd += 3;
        }
            secColStart += 3;
            secColEnd += 3;
        }
    }
    
    public void gameStatus()
    {        
        worker = new SwingWorker<Void, String>(){

            @Override
            protected Void doInBackground() throws Exception {
                
                for(int i = 0; i < 81; ++i)
                {
                    grid.get(i).setBackground(statusCol);
                    Thread.sleep(10);
                }
                
                for(int i = 0; i < 81; ++i)
                {
                    grid.get(i).setBackground(Color.decode("#F6F0ED"));
                    Thread.sleep(10);
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
        worker.execute();
        /*new Runnable(){
            @Override
            public void run() {                
                System.out.println("LOL");
                 
                try {
                    for(int i = 0; i < 81; ++i)
                {
                    grid.get(i).setBackground(statusCol);
                }
                    Thread.sleep(1000);
                    for(int i = 0; i < 81; ++i)
                {
                    grid.get(i).setBackground(Color.decode("#F6F0ED"));
                } 
                } catch (InterruptedException ex) {
                    Logger.getLogger(GameView.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }            
        }.run();*/
        //l.run();
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
        this.gameStatus();
        }
    }  
    
    public void addController(GameController controller) {
        System.out.println("GameView: Adding GameController");
        check.addActionListener(controller);
        save.addActionListener(controller);
        back.addActionListener(controller);
    } 
}
