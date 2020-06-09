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
import javax.swing.JFrame;
import javax.swing.JPanel;
import sudoku.handlers.GameHandler;
import sudoku.handlers.GameHandlerExec;
import sudoku.handlers.UserHandler;
import sudoku.handlers.UserHandlerExec;
import sudoku.ui.views.GameView;
import sudoku.ui.views.StartView;

/**
 *
 * @author Waldo
 */
public class View extends JFrame implements Observer {
    private JPanel cards;
    private JPanel startView = new StartView();
    private JPanel gameView = new GameView();

    
    public View()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        
        //NOT PRODUCTION
        
        UserHandler uh = new UserHandlerExec();
        GameHandler gh = new GameHandlerExec();
        
        Users u = uh.login("Waldo", "password123");
        Game g = gh.getGameByID(1);      
        ((GameView) gameView).initComponents();
        ((GameView) gameView).loadGame(g);   
        
        //NOT PRODUCTION      

        cards = new JPanel(new CardLayout());
        //cards.add(startMenu, "start");
        cards.add(gameView, "start");
        cards.add(startView, "login"); //Gets user to login
        
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
        if(obj instanceof Users && obj != null)
        {
            //login.setText(obj.toString());
        }
        else
        {
            //login.setText("Invalid");
        }
        if(obj instanceof Game && obj != null)
        {
            
        }
        else
        {
            
        }
    }
    
    public class panelButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            CardLayout cl = (CardLayout)(cards.getLayout());
        
            System.out.println(e.getActionCommand());

            if (e.getActionCommand().equals("exit")) {
                System.exit(0);
            }
            else
            {
                cl.show(cards, (String)e.getActionCommand());
            }
            }        
    }

    //What is the reason for NOT registering controllor in the constructor? 
    public void addController(Controller controller) {
        System.out.println("View      : adding controller");
        //need a controller before adding it as a listener 
        ((StartView) startView).addController(controller);
    }
    
    public JPanel getCardLayout(){
        return this.cards;
    }

}
