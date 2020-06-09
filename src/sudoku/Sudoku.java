/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.util.ArrayList;
import java.util.List;
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;
import sudoku.handlers.UserHandler;
import sudoku.handlers.UserHandlerExec;

/**
 *
 * @author Waldo
 */
public class Sudoku {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       
        //exportDatabase();
        
        MVCTest();
        
        UserHandler uh = new UserHandlerExec();
        //Users usr = new Users("Waldie", "password123");
        
        //uh.addUser(usr);

        
        //Users user = uh.login("Waldie", "password123");
        
        List<Block> blocks = new ArrayList();
        
        int preDoku[] = { 8,3,7,1,9,5,6,4,2,9,6,5,8,4,2,1,7,3,1,4,2,7,3,6,5,9,8,3,5,6,4,1,8,9,2,7,7,1,4,6,2,9,8,3,5,2,9,8,3,5,7,4,1,6,4,2,9,5,6,3,7,8,1,6,7,1,2,8,4,3,5,9,5,8,3,9,7,1,2,6,4 }; 
        
        int counter = 0;        
        
        for(int i = 0; i < 9; ++i)
        {
            //System.out.print((i + 1) + "| ");
            for(int j = 0; j < 9; ++j)
            {
                blocks.add(new Block(preDoku[counter]));
                counter++;
            }
            
            //System.out.print("\n");
        }
        
        //Game game = GameFactory.create(Difficulty.Medium);
        //game.setBlocks(blocks);
        //game.setUser(user);
        
        //Game game = new Hard(user, blocks);
        
        //DBOperations.addGame(game);
        
        //List<Users> users = DBOperations.getUser();      
        
        //for(Users u : uh.retrieveAllUsers())
        //{
        //    System.out.println(u.toString());
        //}
        
        /*for(Users user : users)
        {
            Set<Block> blocks = new HashSet();
            blocks.add(new Block(10));
            blocks.add(new Block(12));
            blocks.add(new Block(15));
            user.setBlocks(blocks);
            DBOperations.updateUser(user);
            System.out.println(user.toString());
        }*/     
        
        //UserHandler uh = new UserHandlerExec();
        //Users u = uh.login("Waldo1", "password123");
        
        /*if(null != u)
        {
            System.out.println(u.toString());
        }
        else
        {
            System.out.println("Incorrect!");
        }*/
        
        //GameHandler gh = new GameHandlerExec();
        
        //List<Game> games = gh.retrieveAllUserGames(user);
        //System.out.println(games.size());
        
        //for(Game g : games)
        //{
        //    g.displayGame();
        //}
        
        //HibernateUtils.shutdown();
        
        //System.exit(0);
    }
    
    public static void MVCTest() {
        Model myModel = new Model();
        View myView = new View();
        myModel.addObserver(myView);
        
        Controller myController = new Controller();
        //pass the reference of model and view to the controllor
        myController.addModel(myModel);
        myController.addView(myView);
        myView.addController(myController);
    }
    
    public static void exportDatabase() {
        /**
         * Read Hibernate XML File Initialize Database
         */
        Configuration cfg = new Configuration().configure();
        SchemaExport export = new SchemaExport(cfg);
        export.create(true, true);

        try {
            //Users user = new Users("Waldo", "password123");
            //DBOperations.addUser(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
               
        HibernateUtils.shutdown();
    }
    
}