package sudoku.ui.views;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import sudoku.events.GameEvent;
import sudoku.models.Game;
import sudoku.ui.controllers.GameController;
import sudoku.ui.elements.MenuButton;

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

        scoreboardPanel.add(board, gbc);
        scoreboardPanel.add(Box.createVerticalStrut(25), gbc);
        scoreboardPanel.add(backBtn, gbc2);
        
        board.setLayout(new GridBagLayout());
        board.setOpaque(false);        
        
        add(scoreboardPanel, gbc);                
    }
    
    public void populate(List<Game> games)
    {
        System.out.println("CompletedGameView():  Populating Game List"); 
        board.removeAll();
        gameList.clear();
        for(Game game : games)
        {
            JPanel p = new JPanel();
            p.add(new JLabel(game.toString()));
            gameList.add(p);
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
        System.out.println("UncompletedGameView():  Update received from UserModel()"); 
        if(arg instanceof GameEvent)
        {
            System.out.println("OK");
            populate(((GameEvent) arg).getGames());
        }
    }
    
    public void addController(GameController controller) {
        System.out.println("UncompletedGameView: Adding GameController");
        backBtn.addActionListener(controller);
    } 
}