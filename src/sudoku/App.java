package sudoku;

import sudoku.events.ViewEvent;
import sudoku.misc.HibernateUtils;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sudoku.ui.controllers.*;
import sudoku.ui.models.*;
import sudoku.ui.views.*;

/**
 *
 * @author Waldo
 */
public class App extends JFrame {
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
    
    private GameModel gm = new GameModel();
    private UserModel um = new UserModel();
    private ScoreboardModel sbm = new ScoreboardModel();     

    public App()
    {
        initFrame();
        initModels();
        initViews();
        initControllers();
        initExtControllers();       
        
        cards.add(startView, "start");
        cards.add(loginView, "login");
        cards.add(createUserView, "create_user");
        cards.add(scoreboardView, "scoreboard");
        cards.add(userView, "user");
        cards.add(completedGameView, "completed_games");
        cards.add(uncompletedGameView, "uncompleted_games");      
        cards.add(createGameView, "create_game");
        cards.add(gameView, "game");      
        cards.setOpaque(false);

        add(cards, BorderLayout.CENTER);
                       
        //Handle Shutdown of Application
        handleGUIShutdown();
    }
    
    public void initFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setTitle("Sudoku");   
        getContentPane().validate();
        setResizable(false);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        //etUndecorated(true);
        setVisible(true);
        setBackground(AppColour.APP_BACK);   
        getContentPane().setBackground(AppColour.APP_BACK);
    }
    
    public void initModels()
    {
        sbm.addObserver(scoreboardView);
        sbm.loadScores();
        gm.addObserver(gameView);
        gm.addUserModel(um);
        um.addObserver(userView);
        um.addObserver(loginView);
        um.addObserver(createUserView);
        
        um.addObserver(uncompletedGameView);
        um.addObserver(completedGameView);
    }
    
    public void initViews()
    {        
        startView.addController(sc);          
        gameView.addController(gc);  
        gameView.initComponents();  
        
        userView.addController(uc);   
        loginView.addController(uc);
        createUserView.addController(uc);
        createGameView.addController(gc);
        scoreboardView.addController(sbc);
        
        uncompletedGameView.addController(gc);
        completedGameView.addController(gc);
    }
    
    public void initControllers()
    {
        gc.addModel(gm);
        gc.addView(gameView);    
        sbc.addModel(sbm);
        uc.addModel(um); 
        uc.addLoginView(loginView);
        uc.addCreateUserView(createUserView);
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
        System.out.println("\nPrevious View: " +prevPane);
        System.out.println("Current View: "+currentPane);
        ((CardLayout)cards.getLayout()).show(cards, e.getTargetPane());
    }
    
    public String getPrevPane()
    {
        return this.prevPane;
    }
    
    public void handleGUIShutdown()
    {
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                HibernateUtils.shutdown();
                System.out.println("\"to boldly go where no one has gone before\"");
            }
        }); 
    }
}
