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
 *
 * @author Waldo
 */
public class CompletedGameView extends IView implements Observer {
    private JPanel gamesPanel = new JPanel();
    private List<JPanel> gameList = new ArrayList();    
    private MenuButton backBtn = new MenuButton("Back");
    private MenuLabel completedGameBanner = new MenuLabel("Completed Games");
    
    public CompletedGameView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));
        
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setOpaque(false);     
        
        initComponents();
        addComponents();
        
        add(contentPanel, gbConstraints);    
    }
    
    public void populate(List<Game> games)
    {
        System.out.println("CompletedGameView():  Populating GameBoard"); 
        gamesPanel.removeAll();
        gameList.clear();
        for(Game game : games)
        {
            JPanel panel = new MenuPanel();
            panel.add(new ScoreLabel(game.toString()));
            gameList.add(panel);
        }
        
        initListComponents();
    }
    
    public void initListComponents()
    {
        for(JPanel gL : gameList)
        {
            gamesPanel.add(gL, gbConstraints);
            gamesPanel.add(Box.createVerticalStrut(5), gbConstraints);
        }
        updateUI();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("CompletedGameView():  Update received from UserModel()"); 
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
        System.out.println("CompletedGameView: Adding GameController");
        backBtn.addActionListener(controller);
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
        contentPanel.add(completedGameBanner, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(50), gbConstraints);
        
        contentPanel.add(gamesPanel, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(25), gbConstraints);
        contentPanel.add(backBtn, gbConstraints2);
    }
}