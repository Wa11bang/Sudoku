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
 *
 * @author Waldo
 */
public class UserView extends IView implements Observer {
    private MenuButton createGameBtn = new MenuButton("Create a new Game");
    private MenuButton uncompletedGamesBtn = new MenuButton("View Uncompleted Games");
    private MenuButton completedGamesBtn = new MenuButton("View Completed Games");
    private MenuButton viewScoreboardBtn = new MenuButton("View Scoreboard");
    private MenuButton logoutBtn = new MenuButton("Logout");
    private MenuLabel userWelcome = new MenuLabel();
    
    public UserView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));
        
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setOpaque(false);                  
          
        initComponents();          
        addComponents();
        add(contentPanel, gbc);       
    }
    
    public void setUserWelcome(Users user)
    {
        userWelcome.setText("Welcome "+user.getUsername());
    }
    
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
    
    public void addController(UserController controller) {
        System.out.println(getClass().getSimpleName()+": Adding "+controller.getClass().getSimpleName());
        createGameBtn.addActionListener(controller);
        uncompletedGamesBtn.addActionListener(controller);
        completedGamesBtn.addActionListener(controller);
        viewScoreboardBtn.addActionListener(controller);
        logoutBtn.addActionListener(controller);
    } 

    protected void initComponents()
    {
        createGameBtn.setActionCommand("create_game");
        uncompletedGamesBtn.setActionCommand("uncompleted_games");
        completedGamesBtn.setActionCommand("completed_games");
        viewScoreboardBtn.setActionCommand("scoreboard");
        logoutBtn.setActionCommand("start");     
    }
    
    private void addComponents() {
        contentPanel.add(userWelcome, gbc);
        contentPanel.add(Box.createVerticalStrut(50), gbc);
        contentPanel.add(createGameBtn, gbc);
        contentPanel.add(Box.createVerticalStrut(25), gbc);
        contentPanel.add(uncompletedGamesBtn, gbc);
        contentPanel.add(Box.createVerticalStrut(25), gbc);
        contentPanel.add(completedGamesBtn, gbc);
        contentPanel.add(Box.createVerticalStrut(25), gbc);
        contentPanel.add(viewScoreboardBtn, gbc);
        contentPanel.add(Box.createVerticalStrut(25), gbc);
        contentPanel.add(logoutBtn, gbc);   
    }
}
