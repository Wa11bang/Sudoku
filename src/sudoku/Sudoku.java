package sudoku;

import javax.swing.SwingUtilities;
import sudoku.misc.HibernateUtils;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

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
        
        //HibernateUtils.shutdown();        
        //System.exit(0);
    }
    
    public static void MVCTest() {
        //Model myModel = new Model();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new View();
            }
        });
        HibernateUtils.getSession();
        //myModel.addObserver(myView);
        
        //Controller myController = new Controller();
        //pass the reference of model and view to the controllor
        //myController.addModel(myModel);
        //myController.addView(myView);
        //myView.addController(myController);
    }
    
    public static void exportDatabase() {
        /**
         * Read Hibernate XML File Initialize Database
         */
        Configuration cfg = new Configuration().configure();
        SchemaExport export = new SchemaExport(cfg);
        export.create(true, true);              
        HibernateUtils.shutdown();
    }
    
}