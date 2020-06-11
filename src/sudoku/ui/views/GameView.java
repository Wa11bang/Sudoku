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
import sudoku.models.Block;
import sudoku.ui.elements.GameButton;
import sudoku.models.Game;
import sudoku.events.GameEvent;
import sudoku.ui.elements.GameBlock;
import sudoku.ui.elements.RoundedPanel;
import sudoku.ui.controllers.GameController;

/**
 *
 * @author Waldo
 */
public class GameView extends JPanel implements Observer {    
    private JPanel gamePanel = new JPanel();
    private JPanel controls = new JPanel();
    private List<GameBlock> grid = new ArrayList();;
    private GameButton check = new GameButton();
    private JButton save = new JButton();
    private JButton back = new JButton();  
        
    public GameView()
    {
        setLayout(new BorderLayout());
        
        GridLayout gamePanelLayout = new GridLayout(3,3);
        gamePanelLayout.setHgap(15);
        gamePanelLayout.setVgap(15);
        
        
        gamePanel.setLayout(gamePanelLayout);
        gamePanel.setBorder(new EmptyBorder(30,30,15,30));             
        controls.setBorder(new EmptyBorder(15,30,15,30));
        
        check = new GameButton("Check Solution");
        check.setActionCommand("check");
        
        save = new GameButton("Save Progress");
        save.setActionCommand("save");
        
        back = new GameButton("Back");
        back.setActionCommand("back");

        controls.add(back);
        controls.add(check);
        controls.add(save);                   
        
        add(gamePanel, BorderLayout.CENTER);
        add(controls, BorderLayout.PAGE_END);               
    }
    
    public void initComponents()
    {
        for(int i = 0; i < 81; ++i)
        {
            grid.add(new GameBlock());
        }     
        drawSections();
    }
    
    /**
     * Group a 3x3 section and draw a really nice background
     */
    public void drawSections()
    {
        int sectionColumnStart = 0;
        int sectionColumnEnd = 3;
        int gridSize = 3;
        
        int sectionRowStart,sectionRowEnd;
        
        for(int x = 0; x < gridSize; ++x)
        {
            sectionRowStart = 0;
            sectionRowEnd = 3;
            for(int y = 0; y < gridSize; ++y)
            {
                GridLayout gameSectionLayout = new GridLayout(3,3);
                gameSectionLayout.setHgap(5);
                gameSectionLayout.setVgap(5);

                JPanel p = new RoundedPanel(30);

                p.setOpaque(false);
                p.setLayout(gameSectionLayout);
                p.setBackground(AppColour.GAME_SECTION);
                p.setBorder(new EmptyBorder(10,10,10,10));

                for(int i = sectionColumnStart; i < sectionColumnEnd; ++i)
                {
                    for(int j = sectionRowStart; j < sectionRowEnd; ++j)
                    {
                        p.add(grid.get((i * 9)+j));
                    }
                }

                gamePanel.add(p);
                sectionRowStart += 3;
                sectionRowEnd += 3;
            }
            sectionColumnStart += 3;
            sectionColumnEnd += 3;
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
    
    public void loadGame(Object game)
    {
        ListIterator<GameBlock> li = grid.listIterator();
        List<Block> blocks = ((Game) game).getBlocks();        
        
        while(li.hasNext())
        {
            int block_val = blocks.get((li.nextIndex())).getValue();
            if(block_val != 0)
            {
                (li.next()).setText(Integer.toString(block_val));
            }
            else
            {
                (li.next()).setText("");
            }
        }       
    }
    
    public List<Block> parseBlocks()
    {
        ListIterator<GameBlock> li = grid.listIterator();
        List<Block> blocks = new ArrayList();
        
        while(li.hasNext())
        {
            GameBlock gb = li.next();
                
            if(isInteger(gb.getText())){
                blocks.add(new Block(Integer.parseInt(gb.getText())));
            } 
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
        if(arg instanceof Game) {
            loadGame(arg);
        } else {        
            gameStatus((GameEvent)arg);
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
        return (true && !str.isEmpty());
    }
}
