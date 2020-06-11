package sudoku.ui.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import sudoku.View;
import sudoku.events.ViewEvent;
import sudoku.ui.models.UserModel;
import sudoku.ui.views.CreateUserView;
import sudoku.ui.views.LoginView;
import sudoku.ui.views.UserView;

/**
 *
 * @author Waldo
 */
public class UserController implements ActionListener {   
    private View appView;
    private UserModel model;
    private UserView view;
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
    
    public void addAppView(View v) {
        System.out.println("GameController: Adding AppView");
        this.appView = v;
    }

    public void addLoginView(LoginView v)
    {
        this.loginView = v;
    }
    
    public void addCreateUserView(CreateUserView v)
    {
        this.createUserView = v;
    }
    
    public void addView(UserView v) {
        System.out.println("UserController: Adding UserView");
        this.view = v;
    }    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("user_login")) {
            
            System.out.println("UserController(): Acting on UserModel()");
            if(model.login(loginView.getLoginUsername(), loginView.getLoginPassword()))
            {
                System.out.println("UserController(): Acting on AppView()");
                appView.changePane(new ViewEvent("start", "user"));
            }
        } else if (e.getActionCommand().equals("user_create")) {            
            System.out.println("UserController(): Acting on UserModel()");            
            if(model.createUser(createUserView.getLoginUsername(), createUserView.getLoginPassword()))
            {
                System.out.println("UserController(): Acting on AppView()");
                appView.changePane(new ViewEvent("start", "user"));
            }
        } else if(e.getActionCommand().equals("back")) {
            System.out.println("UserController(): Acting on UserView()");
            model.logout();
            System.out.println("UserController(): Acting on AppView()");
            appView.changePane(new ViewEvent(e.getActionCommand(), "start"));
        } else {
            System.out.println("UserController(): Acting on AppView()");
            appView.changePane(new ViewEvent("user", e.getActionCommand()));
        }
    }
}
