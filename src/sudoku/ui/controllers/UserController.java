package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sudoku.ui.models.UserModel;
import sudoku.ui.views.CreateUserView;
import sudoku.ui.views.LoginView;

/**
 *
 * @author Waldo
 */
public class UserController extends IController implements ActionListener {   
    private UserModel model;
    private LoginView loginView;
    private CreateUserView createUserView;
    
    public UserController()
    {
        System.out.println("UserController()");
    }
    
    public void addModel(UserModel m) {
        System.out.println("UserController: Adding UserModel");
        this.model = m;
    }

    public void addLoginView(LoginView v)
    {
        this.loginView = v;
    }
    
    public void addCreateUserView(CreateUserView v)
    {
        this.createUserView = v;
    }   
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getActionCommand().equals("user_login")) {            
            System.out.println("UserController(): Acting on UserModel()");
            if(model.login(loginView.getLoginUsername(), loginView.getLoginPassword()))
            {
                changeView("start", "user");
            }
        } else if (e.getActionCommand().equals("user_create")) {            
            System.out.println("UserController(): Acting on UserModel()");            
            if(model.createUser(createUserView.getLoginUsername(), createUserView.getLoginPassword()))
            {
                changeView("start", "user");
            }
        } else if(e.getActionCommand().equals("logout")) {
            System.out.println("UserController(): Acting on UserView()");
            model.logout();
            changeView("start", "user");
        } else if(e.getActionCommand().equals("uncompleted_games")) {
            model.getUserGames(false);
            changeView("user", e.getActionCommand());
        } else if(e.getActionCommand().equals("completed_games")) {
            model.getUserGames(true);
            changeView("user", e.getActionCommand());
        } else {
            changeView("user", e.getActionCommand());
        }
    }
}
