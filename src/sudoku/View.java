package sudoku;

import sudoku.misc.HibernateUtils;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sudoku.handlers.GameHandler;
import sudoku.handlers.GameHandlerExec;
import sudoku.handlers.UserHandler;
import sudoku.handlers.UserHandlerExec;
import sudoku.ui.controllers.*;
import sudoku.ui.models.*;
import sudoku.ui.views.*;

/**
 *
 * @author Waldo
 */
public class View extends JFrame implements Observer {
    private String currentPane;
    private String prevPane;
    private JPanel cards = new JPanel(new CardLayout());
    
    private StartView startView = new StartView();
    private GameView gameView = new GameView();
    private UserView userView = new UserView();
    private LoginView loginView = new LoginView();
    private CreateUserView createUserView = new CreateUserView();
    private CreateGameView createGameView = new CreateGameView();
    private CompletedGameView completedGameView = new CompletedGameView();
    private UncompletedGameView uncompletedGameView = new UncompletedGameView();
    private ScoreboardView scoreboardView = new ScoreboardView();
    
    private StartController sc = new StartController();
    private GameController gc = new GameController();
    private UserController uc = new UserController();
    private ScoreboardController sbc = new ScoreboardController();

    
    public View()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setTitle("Sudoku");
        
        //NOT PRODUCTION       
        
        UserHandler uh = new UserHandlerExec();
        GameHandler gh = new GameHandlerExec();
        
        Users u = uh.login("Waldo", "password123");
        Game g = gh.getGameByID(1);              
        
        gameView.initComponents();            
         
        //NOT PRODUCTION           
             
        //MODELS
        StartModel sm = new StartModel();
        GameModel gm = new GameModel();
        UserModel um = new UserModel();
        ScoreboardModel sbm = new ScoreboardModel();
        
        //CONTROLLERS
        sc = new StartController();
        gc = new GameController();
        uc = new UserController();
        sbc = new ScoreboardController();
        
        
        sc.addModel(sm);        
        sc.addView(startView); 
        startView.addController(sc);  
        
        gc.addModel(gm);
        gc.addView(gameView);        
        gm.addObserver(gameView);
        gameView.addController(gc);   
        
        uc.addModel(um);
        uc.addView(userView);        
        uc.addLoginView(loginView);
        uc.addCreateUserView(createUserView);
        um.addObserver(userView);
        um.addObserver(loginView);
        um.addObserver(createUserView);
        userView.addController(uc);   
        loginView.addController(uc);
        createUserView.addController(uc);
        
        initExtControllers();
        
        //VIEW INIT
        
        //TESTING CODE
        gm.setGame(g);
        gm.initGame();
        //TESTING CODE
        
        cards.add(startView, "start");
        cards.add(loginView, "login");
        cards.add(createUserView, "create_user");
        cards.add(gameView, "scoreboard");   //scoreboardView    
        cards.add(userView, "user");
        cards.add(completedGameView, "completed_games");
        cards.add(uncompletedGameView, "uncompleted_games");      
        cards.add(createGameView, "create_game");
        //cards.add(gameView, "game"); 
       
        cards.setBackground(new Color(232, 240, 255));
        cards.setOpaque(false);

        add(cards, BorderLayout.CENTER);
        getContentPane().validate();
        setResizable(false);

        //Display Window
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
        setBackground(new Color(232, 240, 255, 220));       
        
        //Handle Shutdown of Application
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                HibernateUtils.shutdown();
            }
        });
    }
    
    public void initExtControllers()
    {
        sc.addAppView(this);
        gc.addAppView(this);
        uc.addAppView(this);
        sbc.addAppView(this);
    }
    
    public void setCurrentPane(String pane)
    {
        ((CardLayout)cards.getLayout()).show(cards, pane);
    }

    public void changePane(ViewEvent e)
    {        
        prevPane = e.getCurrentPane();
        currentPane = e.getTargetPane();
        System.out.println(prevPane);
        System.out.println(currentPane);
        ((CardLayout)cards.getLayout()).show(cards, e.getTargetPane());
    }
    
    public String getPrevPane()
    {
        return this.prevPane;
    }
    
    @Override
    public void update(Observable obs, Object obj) {
        System.out.println("Update received!");
        setCurrentPane((String) obj);
    }
}
