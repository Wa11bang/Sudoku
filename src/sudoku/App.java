package sudoku;

import sudoku.events.ViewEvent;
import sudoku.misc.HibernateUtils;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sudoku.ui.controllers.*;
import sudoku.ui.models.*;
import sudoku.ui.views.*;

/**
 * Main GUI Application
 * @author Waldo Theron 18033655
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

    /**
     * Constructor for Application Object
     */
    public App()
    {        
        initModels();
        initViews();
        initControllers();
        initExtControllers();       
        addComponents();            
        
        cards.setOpaque(false);
        add(cards, BorderLayout.CENTER);    
        
        // Load Frame after Components Loaded
        initFrame();
                       
        //Handle Shutdown of Application
        handleGUIShutdown();
    }
    
    /**
     * Initializes the Frame of the Java Swing Application
     */
    public void initFrame()
    {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(600, 600);
        setTitle("Sudoku");   
        setResizable(false);
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        //setUndecorated(true);
        setVisible(true);
        setBackground(AppColour.APP_BACK);   
        getContentPane().setBackground(AppColour.APP_BACK);
        
        playMenuTrack();
    }
    
    /**
     * Initializes the Models used in the GUI Application (M- VC)
     */
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
    
    /**
     * Initializes the Views used in the GUI Application (M -V- C)
     */
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
    
    /**
     * Initializes the Controllers used in the GUI Application (MV -C)
     */
    public void initControllers()
    {
        gc.addModel(gm);
        gc.addView(gameView);    
        sbc.addModel(sbm);
        uc.addModel(um); 
        uc.addLoginView(loginView);
        uc.addCreateUserView(createUserView);
    }
    
    /**
     * Passes the Application Frame to the Controllers
     */
    public void initExtControllers()
    {
        sc.addAppView(this);
        gc.addAppView(this);
        uc.addAppView(this);
        sbc.addAppView(this);
    }
    
    /**
     * Adds JComponents to main panel
     */
    public void addComponents()
    {
        cards.add(startView, "start");
        cards.add(loginView, "login");
        cards.add(createUserView, "create_user");
        cards.add(scoreboardView, "scoreboard");
        cards.add(userView, "user");
        cards.add(completedGameView, "completed_games");
        cards.add(uncompletedGameView, "uncompleted_games");      
        cards.add(createGameView, "create_game");
        cards.add(gameView, "game");  
    }
    
    /**
     * Transitions current view to a target view panel
     * @param pane 
     */
    public void setCurrentPane(String pane)
    {
        ((CardLayout)cards.getLayout()).show(cards, pane);
    }

    /**
     * Handles ViewEvents to modify current view panel
     * @param e
     */
    public void changePane(ViewEvent e)
    {        
        prevPane = e.getCurrentPane();
        currentPane = e.getTargetPane();
        System.out.println("\nPrevious View: " +prevPane);
        System.out.println("Current View: "+currentPane);
        setCurrentPane(currentPane);
    }
    
    /**
     * Returns the previous view panel from a previous user interaction
     * @return prevPane
     */
    public String getPrevPane()
    {
        return this.prevPane;
    }
    
    public void playMenuTrack()
    {
        new Runnable(){
            @Override
            public void run() {
                sound();
            }
            
        }.run();
    }
    
    public void sound() {
        try {
            AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(getClass().getResource("/sudoku/res/menu.wav"));
            Clip clip = AudioSystem.getClip();
            clip.open(audioInputStream);
            clip.start();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    /**
     * Self-explanatory, makes sure the database is properly shutdown
     */
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
