package sudoku.ui.views;

import java.awt.GridBagLayout;
import java.util.Observable;
import java.util.Observer;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import sudoku.events.UserEvent;
import sudoku.models.Users;
import sudoku.ui.controllers.UserController;
import sudoku.ui.elements.MenuButton;
import sudoku.ui.elements.MenuLabel;

/**
 * User Menu View
 * @author Waldo Theron 18033655
 */
public class UserView extends IView implements Observer {
    private MenuButton createGameBtn = new MenuButton("New Game");
    private MenuButton uncompletedGamesBtn = new MenuButton("View Uncompleted Games");
    private MenuButton completedGamesBtn = new MenuButton("View Completed Games");
    private MenuButton viewScoreboardBtn = new MenuButton("View Scoreboard");
    private MenuButton logoutBtn = new MenuButton("Logout");
    private MenuLabel userWelcome = new MenuLabel();
    
    /**
     * Constructor for a UserView Object
     */
    public UserView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));
        
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setOpaque(false);                  
          
        initComponents();          
        addComponents();
        add(contentPanel, gbConstraints);       
    }
    
    /**
     * Updates the user welcome label with a username
     * @param user 
     */
    public void setUserWelcome(Users user)
    {
        userWelcome.setText("Welcome "+user.getUsername());
    }
    
    /**
     * Listens for Updates from the Observable. Sets the username to the Welcome
     * banner
     * @param o
     * @param arg 
     */
    @Override
    public void update(Observable o, Object arg) {
        System.out.println(getClass().getSimpleName()+":  Update received from UserModel()");
        if(arg instanceof UserEvent)
        {           
            if(null != ((UserEvent) arg).getUser())
            {
                System.out.println(getClass().getSimpleName()+":  Loading User from UserModel()");
                setUserWelcome(((UserEvent) arg).getUser());
            }
        }
    }
    
    /**
     * Adds the relevant controller to handle user interactions with this view
     * @param controller 
     */
    public void addController(UserController controller) {
        System.out.println(getClass().getSimpleName()+": Adding "+controller.getClass().getSimpleName());
        createGameBtn.addActionListener(controller);
        uncompletedGamesBtn.addActionListener(controller);
        completedGamesBtn.addActionListener(controller);
        viewScoreboardBtn.addActionListener(controller);
        logoutBtn.addActionListener(controller);
    } 

    /**
     * Initializes all JComponents before being added to the main panel
     */
    protected void initComponents()
    {
        createGameBtn.setActionCommand("create_game");
        uncompletedGamesBtn.setActionCommand("uncompleted_games");
        completedGamesBtn.setActionCommand("completed_games");
        viewScoreboardBtn.setActionCommand("scoreboard");
        logoutBtn.setActionCommand("start");     
    }
    
    /**
     * Adds JComponents to main panel
     */
    private void addComponents() {
        contentPanel.add(userWelcome, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(50), gbConstraints);
        contentPanel.add(createGameBtn, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(25), gbConstraints);
        contentPanel.add(uncompletedGamesBtn, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(25), gbConstraints);
        contentPanel.add(completedGamesBtn, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(25), gbConstraints);
        contentPanel.add(viewScoreboardBtn, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(25), gbConstraints);
        contentPanel.add(logoutBtn, gbConstraints);   
    }
}
