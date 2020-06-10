package sudoku.ui.views;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingWorker;
import javax.swing.border.EmptyBorder;
import sudoku.AppColour;
import sudoku.Block;
import sudoku.ui.elements.ControlButton;
import sudoku.Game;
import sudoku.GameEvent;
import sudoku.ui.elements.GameBlock;
import sudoku.ui.elements.RoundedPanel;
import sudoku.ui.controllers.GameController;

/**
 *
 * @author Waldo
 */
public class GameView extends JPanel implements Observer {
    private List<GameBlock> grid;
    private JPanel gamePanel = new JPanel();
    private ControlButton check = new ControlButton();
    private JButton save = new JButton();
    private JButton back = new JButton();  
    
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
        
        setLayout(new BorderLayout());
        
        add(gamePanel, BorderLayout.CENTER);
        add(controls, BorderLayout.PAGE_END);               
    }
    
    public void initComponents()
    {
        grid = new ArrayList();
        for(int i = 0; i < 81; ++i)
        {
            grid.add(new GameBlock());
        }     
        this.drawSections();
    }
    
    public void loadGame(Object game)
    {
        ListIterator li = grid.listIterator();
        List<Block> blocks = ((Game) game).getBlocks();
        
        System.out.println(blocks.size());
        
        while(li.hasNext())
        {
            int block_val = blocks.get((li.nextIndex())).getValue();
            System.out.print(block_val);
            if(block_val != 0)
            {
                ((GameBlock) li.next()).setText(block_val + "");
                //grid.get(li.nextIndex()).setEditable(true);
            }
            else
            {
                ((GameBlock) li.next()).setText("");
            }
        }       
    }
    
    /**
     * Group a 3x3 section and draw a really nice background
     * @param game 
     */
    public void drawSections()
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
            p.setBackground(AppColour.GAME_SECTION);
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
    
    public void gameStatus(GameEvent e)
    {        
        new SwingWorker<Void, String>(){
            @Override
            protected Void doInBackground() throws Exception {
                
                for(int i = 0; i < 81; ++i)
                {
                    if(e.getSaved())
                    {
                        grid.get(i).setBackground(AppColour.SAVED);      
                    } 
                    else if(e.getSolved())
                    {
                        //grid.get(i).setEditable(false);
                        grid.get(i).setBackground(AppColour.CORRECT);   
                    }
                    else
                    {
                        grid.get(i).setBackground(AppColour.ERROR);      
                    }
                                  
                    Thread.sleep(2);
                }
                
                for(int i = 0; i < 81; ++i)
                {
                    grid.get(i).setBackground(AppColour.GAME_B_BACK);
                    Thread.sleep(2);
                }                
                return null;
            }
        }.execute();
    }
    
    public List<Block> parseBlocks()
    {
        ListIterator li = grid.listIterator();
        List<Block> blocks = new ArrayList();
        
        while(li.hasNext())
        {
            GameBlock gb = ((GameBlock) li.next());
                
            if(isInteger(gb.getText()))
                blocks.add(new Block(Integer.parseInt(gb.getText())));
            else
            {
                blocks.add(new Block(0));
            }
        }
        
        return blocks;
    }    
       
    public void addController(GameController controller) {
        System.out.println("GameView: Adding GameController");
        check.addActionListener(controller);
        save.addActionListener(controller);
        back.addActionListener(controller);
    } 
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("GameView():  Update received from GameModel()");
        if(arg instanceof Game)
        {
            loadGame(arg);
        }
        else {
        
        this.gameStatus((GameEvent)arg);
        }
    }  
    
    public static boolean isInteger(String str) {
               
        for(char c : str.toCharArray())
        {
            if(!Character.isDigit(c))
            {
                return false;
            }
        }
        
        return true && !str.isEmpty();
    }
}
