package sudoku.ui.views;

import java.awt.GridBagConstraints;
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
public class CompletedGameView extends JPanel implements Observer {
    private JPanel scoreboardPanel = new JPanel();
    private JPanel board = new JPanel();
    private List<JPanel> gameList = new ArrayList();    
    private MenuButton backBtn = new MenuButton("Back");
    private GridBagConstraints gbc = new GridBagConstraints();
    private MenuLabel completedGameBanner = new MenuLabel("Completed Games");
    
    public CompletedGameView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));
        setLayout(new GridBagLayout());        
        setOpaque(false);     
        
        GridBagConstraints gbc2 = new GridBagConstraints();
        
        gbc.gridwidth = GridBagConstraints.REMAINDER;
        gbc.fill = GridBagConstraints.HORIZONTAL;        
        
        gbc2.anchor = GridBagConstraints.NORTH;
        gbc2.weightx = 1.0;
        gbc2.weighty = 1.0;        
        
        scoreboardPanel.setLayout(new GridBagLayout());
        scoreboardPanel.setOpaque(false);             
        backBtn.setActionCommand("back");

        scoreboardPanel.add(completedGameBanner, gbc);
        scoreboardPanel.add(Box.createVerticalStrut(50), gbc);
        
        scoreboardPanel.add(board, gbc);
        scoreboardPanel.add(Box.createVerticalStrut(25), gbc);
        scoreboardPanel.add(backBtn, gbc2);
        
        board.setLayout(new GridBagLayout());
        board.setOpaque(false);        

        add(scoreboardPanel, gbc);    
    }
    
    public void populate(List<Game> games)
    {
        System.out.println("CompletedGameView():  Populating GameBoard"); 
        board.removeAll();
        gameList.clear();
        for(Game game : games)
        {
            JPanel panel = new MenuPanel();
            panel.add(new ScoreLabel(game.toString()));
            gameList.add(panel);
        }
        
        initComponents();
    }
    
    public void initComponents()
    {
        for(JPanel gL : gameList)
        {
            board.add(gL, gbc);
            board.add(Box.createVerticalStrut(5), gbc);
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
    
    public void addController(GameController controller) {
        System.out.println("CompletedGameView: Adding GameController");
        backBtn.addActionListener(controller);
    }  
}