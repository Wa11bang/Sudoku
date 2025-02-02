package sudoku.ui.views;

import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import sudoku.events.GameEvent;
import sudoku.models.Game;
import sudoku.ui.controllers.GameController;
import sudoku.ui.elements.MenuButton;
import sudoku.ui.elements.MenuLabel;
import sudoku.ui.elements.MenuPanel;
import sudoku.ui.elements.ScoreLabel;

/**
 * Shows a List of the Users Uncompleted Games
 * @author Waldo Theron 18033655
 */
public class UncompletedGameView extends IView implements Observer {
    private JPanel gamesPanel = new JPanel();
    private List<JPanel> gameList = new ArrayList();    
    private MenuButton backBtn = new MenuButton("Back");    
    private MenuLabel uncompletedGameBanner = new MenuLabel("Uncompleted Games");
    private GameController controller;

    /**
     * Constructor for an UncompletedGameView Object
     */
    public UncompletedGameView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));   
        
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setOpaque(false);          
        
        initComponents();        
        addComponents();                

        add(contentPanel, gbConstraints);    
    }
    
    /**
     * Creates a JComponent for each element in the given List of Games
     * @param games 
     */
    public void populate(List<Game> games)
    {
        System.out.println(getClass().getSimpleName()+":  Populating GameBoard"); 
        gamesPanel.removeAll();
        gameList.clear();
        for(Game game : games)
        {
            JPanel panel = new MenuPanel();
            MenuButton gBtn = new MenuButton("Play");
            MenuButton dBtn = new MenuButton(	"\u2421");
            gBtn.addActionListener(controller);
            gBtn.setActionCommand("play_"+game.getGame_id());
            dBtn.addActionListener(controller);
            dBtn.setActionCommand("del_"+game.getGame_id());
            panel.add(new ScoreLabel(game.toString()));
            panel.add(gBtn);
            panel.add(dBtn);
            gameList.add(panel);
        }        
                
        initListComponents();
    }
    
    /**
     * Initializes a JComponent for each element in the gameList
     */
    public void initListComponents()
    {
        for(JPanel game : gameList)
        {
            gamesPanel.add(game, gbConstraints);
            gamesPanel.add(Box.createVerticalStrut(5), gbConstraints);
        }
        updateUI();
    }
    
    /**
     * Listens for Updates from the Observable. Re-populates the View with new
     * uncompleted user games
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(getClass().getSimpleName()+":  Update received from UserModel()"); 
        if(arg instanceof GameEvent)
        {
            populate(((GameEvent) arg).getGames());
        }
    }
    
    /**
     * Adds the relevant controller to handle user interactions with this view
     * @param controller 
     */
    public void addController(GameController controller) {
        System.out.println(getClass().getSimpleName()+": Adding "+controller.getClass().getSimpleName());
        backBtn.addActionListener(controller);
        this.controller = controller;
    } 
    
    /**
     * Initializes all JComponents before being added to the main panel
     */
    private void initComponents() {
        backBtn.setActionCommand("back");
        gamesPanel.setLayout(new GridBagLayout());
        gamesPanel.setOpaque(false); 
    }
    
    /**
     * Adds JComponents to main panel
     */
    private void addComponents() {
        contentPanel.add(uncompletedGameBanner, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(50), gbConstraints);        
        contentPanel.add(gamesPanel, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(50), gbConstraints);
        contentPanel.add(backBtn, gbConstraints2);  
    }
}