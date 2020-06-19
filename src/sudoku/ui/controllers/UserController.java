package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sudoku.ui.models.UserModel;
import sudoku.ui.views.CreateUserView;
import sudoku.ui.views.LoginView;

/**
 * Handles User Interactions for a Users Object
 * @author Waldo Theron 18033655
 */
public class UserController extends IController implements ActionListener {   
    private UserModel model;
    private LoginView loginView;
    private CreateUserView createUserView;
    
    /**
     * Constructor for a UserController Object
     */
    public UserController()
    {
        System.out.println("UserController()");
    }
    
    /**
     * Adds a reference to the UserModel
     * @param m 
     */
    public void addModel(UserModel m) {
        System.out.println("UserController: Adding UserModel");
        this.model = m;
    }

    /**
     * Adds a reference to the LoginView
     * @param v 
     */
    public void addLoginView(LoginView v)
    {
        this.loginView = v;
    }
    
    /**
     * Adds a reference to the CreateUserView
     * @param v 
     */
    public void addCreateUserView(CreateUserView v)
    {
        this.createUserView = v;
    }   
    
    /**
     * Handles User Actions
     * @param e 
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("user_login")) {                         // Login
            System.out.println("UserController(): Acting on UserModel()");
            if(model.login(loginView.getLoginUsername(), loginView.getLoginPassword()))
            {
                changeView("start", "user");
            }
        } else if (e.getActionCommand().equals("user_create")) {                // Create a new Usaer
            System.out.println("UserController(): Acting on UserModel()");            
            if(model.createUser(createUserView.getLoginUsername(), createUserView.getLoginPassword()))
            {
                changeView("start", "user");
            }
        } else if(e.getActionCommand().equals("logout")) {                      // Logout
            System.out.println("UserController(): Acting on UserView()");
            model.logout();
            changeView("start", "user");
        } else if(e.getActionCommand().equals("uncompleted_games")) {           // View Uncompleted Games
            model.getUserGames(false);
            changeView("user", e.getActionCommand());
        } else if(e.getActionCommand().equals("completed_games")) {             // View Completed Games
            model.getUserGames(true);
            changeView("user", e.getActionCommand());
        } else {
            changeView("user", e.getActionCommand());                           // Exit Current View (back)
        }
    }
}
