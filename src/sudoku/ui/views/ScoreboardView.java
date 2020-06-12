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
import sudoku.events.ScoreEvent;
import sudoku.models.Score;
import sudoku.ui.controllers.ScoreboardController;
import sudoku.ui.elements.MenuButton;
import sudoku.ui.elements.ScoreLabel;

/**
 *
 * @author Waldo
 */
public class ScoreboardView extends JPanel implements Observer {
    private JPanel scoreboardPanel = new JPanel();
    private JPanel board = new JPanel();
    private List<ScoreLabel> scoreList = new ArrayList();    
    private MenuButton backBtn = new MenuButton("Back");
    private MenuButton refreshBtn = new MenuButton("Refresh "+"\uD83D\uDDD8");
    private GridBagConstraints gbc = new GridBagConstraints();
    
    public ScoreboardView()
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
        refreshBtn.setActionCommand("refresh");

        scoreboardPanel.add(board, gbc);
        scoreboardPanel.add(Box.createVerticalStrut(25), gbc);
        scoreboardPanel.add(backBtn, gbc2);
        scoreboardPanel.add(refreshBtn, gbc2);
        
        board.setLayout(new GridBagLayout());
        board.setOpaque(false);        
        
        add(scoreboardPanel, gbc);                
    }
    
    public void populate(List<Score> scores)
    {
        System.out.println("ScoreboardView():  Populating Scoreboard"); 
        board.removeAll();
        scoreList.clear();
        for(Score score : scores)
        {
            scoreList.add(new ScoreLabel(score.toString()));
            
        }
        
        initComponents();
    }
    
    public void initComponents()
    {
        for(ScoreLabel st : scoreList)
        {
            board.add(st, gbc);
            board.add(Box.createVerticalStrut(5), gbc);
        }
        updateUI();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("ScoreboardView():  Update received from ScoreboardModel()"); 
        if(arg instanceof ScoreEvent)
        {
            populate(((ScoreEvent) arg).getScores());
        }
    }
    
    public void addController(ScoreboardController controller) {
        System.out.println("ScoreboardView: Adding ScoreboardController");
        backBtn.addActionListener(controller);
        refreshBtn.addActionListener(controller);
    } 
}
