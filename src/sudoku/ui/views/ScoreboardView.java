package sudoku.ui.views;

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
import sudoku.ui.elements.MenuLabel;
import sudoku.ui.elements.ScoreLabel;
import sudoku.ui.elements.MenuPanel;

/**
 * Shows a List of all the Game Scores
 * @author Waldo Theron 18033655
 */
public class ScoreboardView extends IView implements Observer {
    private JPanel scoresPanel = new JPanel();
    private List<JPanel> scoreList = new ArrayList();    
    private MenuButton backBtn = new MenuButton("Back");
    private MenuButton refreshBtn = new MenuButton("Refresh "+"\uD83D\uDDD8");
    private MenuLabel scoreboardBanner = new MenuLabel("Scoreboard");
    
    /**
     * Constructor for a ScoreboardView Object
     */
    public ScoreboardView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));      

        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setOpaque(false);       

        initComponents();
        addComponents();
        
        add(contentPanel, gbConstraints);                
    }
    
    /**
     * Creates a JComponent for each element in the given List of Scores
     * @param scores
     */
    public void populate(List<Score> scores)
    {
        System.out.println("ScoreboardView():  Populating Scoreboard"); 
        scoresPanel.removeAll();
        scoreList.clear();
        for(Score score : scores)
        {
            JPanel panel = new MenuPanel();
            panel.add(new ScoreLabel(score.getFormattedDifficulty()));
            panel.add(new ScoreLabel(score.getFormattedScoreTime()));            
            panel.add(new ScoreLabel(score.getFormattedUsername()));
            scoreList.add(panel);            
        }
        
        initListComponents();
    }
    
    /**
     * Initializes a JComponent for each element in the scoreList
     */
    public void initListComponents()
    {
        for(JPanel score : scoreList)
        {
            scoresPanel.add(score, gbConstraints);
            scoresPanel.add(Box.createVerticalStrut(5), gbConstraints);
        }
        updateUI();
    }
    
    /**
     * Listens for Updates from the Observable. Populates the Scoreboard View
     * received Scores
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("ScoreboardView():  Update received from ScoreboardModel()"); 
        if(arg instanceof ScoreEvent)
        {
            populate(((ScoreEvent) arg).getScores());
        }
    }
    
    /**
     * Adds the relevant controller to handle user interactions with this view
     * @param controller 
     */
    public void addController(ScoreboardController controller) {
        System.out.println("ScoreboardView: Adding ScoreboardController");
        backBtn.addActionListener(controller);
        refreshBtn.addActionListener(controller);
    } 
    
    /**
     * Initializes all JComponents before being added to the main panel
     */
    private void initComponents()
    {
        backBtn.setActionCommand("back");
        refreshBtn.setActionCommand("refresh");
        scoresPanel.setLayout(new GridBagLayout());
        scoresPanel.setOpaque(false);        
    }
    
    /**
     * Adds JComponents to main panel
     */
    private void addComponents()
    {
        contentPanel.add(scoreboardBanner, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(50), gbConstraints);
        contentPanel.add(scoresPanel, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(25), gbConstraints);
        contentPanel.add(backBtn, gbConstraints2);
        contentPanel.add(Box.createHorizontalStrut(10), gbConstraints2);
        contentPanel.add(refreshBtn, gbConstraints2);
    }
}
