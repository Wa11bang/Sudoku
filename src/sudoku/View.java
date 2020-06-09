/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;
import sudoku.handlers.GameHandler;
import sudoku.handlers.GameHandlerExec;
import sudoku.handlers.UserHandler;
import sudoku.handlers.UserHandlerExec;
import sudoku.ui.controllers.GameController;
import sudoku.ui.controllers.StartController;
import sudoku.ui.models.GameModel;
import sudoku.ui.models.StartModel;
import sudoku.ui.views.GameView;
import sudoku.ui.views.StartView;

/**
 *
 * @author Waldo
 */
public class View extends JFrame implements Observer {
    private JPanel cards = new JPanel(new CardLayout());
    private StartView startView = new StartView();
    private GameView gameView = new GameView();

    
    public View()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        
        //NOT PRODUCTION       
        
        UserHandler uh = new UserHandlerExec();
        GameHandler gh = new GameHandlerExec();
        
        Users u = uh.login("Waldo", "password123");
        Game g = gh.getGameByID(1);      
        
        GameModel gm = new GameModel();
        gameView.initComponents();        
        
        gm.addObserver(gameView);
        
        GameController gc = new GameController();                  
        gc.addModel(gm);
        gc.addView(gameView);
        
        gameView.addController(gc);   
        
        gm.setGame(g);
        gm.initGame();
        
        //NOT PRODUCTION      
        
        
        //VIEW INIT
        
        
        //MODELS
        StartModel sm = new StartModel();
        
        //CONTROLLERS
        StartController sc = new StartController(cards);
        
        sc.addModel(sm);
        sc.addView(startView);        
        startView.addController(sc);  
        //VIEW INIT
        
        

        
        cards.add(startView, "start");
        cards.add(gameView, "login");
        //cards.add(startView, "login"); //Gets user to login
        
        cards.setBackground(new Color(232, 240, 255));
        cards.setOpaque(false);

        
        
        //Where the GUI is assembled:
        //Put the JComboBox in a JPanel to get a nicer look.

        add(cards, BorderLayout.CENTER);
        getContentPane().validate();
        setResizable(false);

        //Display Window
        setAlwaysOnTop(true);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
        setBackground(new Color(232, 240, 255, 220));       
        
        Runtime.getRuntime().addShutdownHook(new Thread()
        {
            @Override
            public void run()
            {
                HibernateUtils.shutdown();
            }

            });
    }

    @Override
    public void update(Observable obs, Object obj) {
       ((CardLayout)cards.getLayout()).show(cards, (String)obj);
    }
}
