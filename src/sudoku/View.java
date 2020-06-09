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
import sudoku.ui.controllers.GameController;
import sudoku.ui.controllers.StartController;
import sudoku.ui.controllers.UserController;
import sudoku.ui.models.GameModel;
import sudoku.ui.models.StartModel;
import sudoku.ui.views.GameView;
import sudoku.ui.views.StartView;
import sudoku.ui.views.UserView;

/**
 *
 * @author Waldo
 */
public class View extends JFrame implements Observer {
    private JPanel cards = new JPanel(new CardLayout());
    private StartView startView = new StartView();
    private GameView gameView = new GameView();
    private UserView userView = new UserView();
    private StartController sc = new StartController();
    private GameController gc = new GameController();
    private UserController uc = new UserController();

    
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
        
        
        //VIEW INIT
        
        
        //MODELS
        StartModel sm = new StartModel();
        GameModel gm = new GameModel();
        
        //CONTROLLERS
        sc = new StartController();
        gc = new GameController();
        uc = new UserController();
        
        sc.addModel(sm);        
        sc.addView(startView); 
        startView.addController(sc);  
        
        gc.addModel(gm);
        gc.addView(gameView);        
        gm.addObserver(gameView);
        gameView.addController(gc);   
        
        initExtControllers();
        
        //VIEW INIT
        
        gm.setGame(g);
        gm.initGame();

        
        cards.add(startView, "start");
        cards.add(userView.create(), "create_user");
        cards.add(userView.login(), "login");
        cards.add(gameView, "view_scoreboard");       
        
        cards.setBackground(new Color(232, 240, 255));
        cards.setOpaque(false);

        add(cards, BorderLayout.CENTER);
        getContentPane().validate();
        setResizable(false);

        //Display Window
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        //setUndecorated(true);
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
    }
    
    public void setCurrentPane(String pane)
    {
        ((CardLayout)cards.getLayout()).show(cards, pane);
    }

    @Override
    public void update(Observable obs, Object obj) {
        System.out.println("Update received!");
        setCurrentPane((String) obj);
    }
}
