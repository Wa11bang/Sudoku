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
 * Represents a Sudoku Game using JComponents
 * @author Waldo Theron 18033655
 */
public class GameView extends JPanel implements Observer {    
    private JPanel gamePanel = new JPanel();
    private JPanel controls = new JPanel();
    private List<GameBlock> grid = new ArrayList();;
    private JButton check = new GameButton("Check Solution");
    private JButton save = new GameButton("Save Progress");
    private JButton back = new GameButton("Back");
        
    /**
     * Constructor for a GameView Object
     */
    public GameView()
    {
        setLayout(new BorderLayout());        
        GridLayout gamePanelLayout = new GridLayout(3,3);
        gamePanelLayout.setHgap(15);
        gamePanelLayout.setVgap(15);               
        gamePanel.setLayout(gamePanelLayout);
        gamePanel.setBorder(new EmptyBorder(30,30,15,30));             
        controls.setBorder(new EmptyBorder(15,30,15,30));
        
        initComponents();
        addComponents();
        
        add(gamePanel, BorderLayout.CENTER);
        add(controls, BorderLayout.PAGE_END);               
    }
    
    /**
     * Initializes all GameBlock components before being
     * added to the main panel
     */
    public void initGBlockComponents()
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
        int sectionRowStart,sectionRowEnd;
        int gridSize = 3;
        
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
    
    /**
     * Displays a Thread-safe status on the Game Grid.
     * Shows for Saving Games and Checking the solution of a Game
     * @param e 
     */
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
    
    /**
     * Replace GameBlock text contents with the given Block Values of the Game
     * Object
     * @param game 
     */
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
    
    /**
     * Retrieves Block Objects from the View by converting each GameBlock.
     * @return List of Blocks
     */
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
    
    /**
     * Initializes all JComponents before being added to the main panel
     */
    public void initComponents(){
        check.setActionCommand("check");        
        save.setActionCommand("save");        
        back.setActionCommand("back");
    }
    
    /**
     * Adds JComponents to main panel
     */
    public void addComponents()
    {
        controls.add(back);
        controls.add(check);
        controls.add(save);     
    }
       
    /**
     * Adds the relevant controller to handle user interactions with this view
     * @param controller 
     */
    public void addController(GameController controller) {
        System.out.println("GameView: Adding GameController");
        check.addActionListener(controller);
        save.addActionListener(controller);
        back.addActionListener(controller);
    } 
    
    /**
     * Listens for Updates from the Observable. Initializes a Game object or 
     * displays the status of a current Game.
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("GameView():  Update received from GameModel()");
        if(arg instanceof Game) {
            loadGame(arg);
        } else {        
            gameStatus((GameEvent)arg);
        }
    }  
    
    /**
     * Checks if the input string can be represented as an Integer
     * @param str
     * @return 
     */
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
