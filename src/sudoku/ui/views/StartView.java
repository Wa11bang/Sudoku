package sudoku.ui.views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import sudoku.Sudoku;
import sudoku.ui.elements.MenuButton;
import sudoku.ui.controllers.StartController;

/**
 * StartView: Shows the initial main menu view
 * @author Waldo Theron 18033655
 */
public class StartView extends JPanel {
    private JPanel startButtons = new JPanel();
    private MenuButton login = new MenuButton("Login");
    private MenuButton cnu = new MenuButton("Create New User");
    private MenuButton vsb = new MenuButton("View Scoreboard");
    private MenuButton exit = new MenuButton("Exit");
    
    /**
     * Constructor for a StartView Object
     */
    public StartView()
    {
        setBorder(new EmptyBorder(45, 10, 10, 10));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(false);
        
        loadLogo(Sudoku.LOGO_PATH);
 
        initComponents();
        addComponents();              
                             
        add(startButtons);                
    }
    
    /**
     * Adds the relevant controller to handle user interactions with this view
     * @param controller 
     */
    public void addController(StartController controller)
    {
        this.login.addActionListener(controller);
        this.cnu.addActionListener(controller);
        this.vsb.addActionListener(controller);
        this.exit.addActionListener(controller);
    }
    
    /**
     * Adds a Logo element to the main panel from a given path 
     * @param path 
     */
    public void loadLogo(String path)
    {       
        try {
            BufferedImage logo = ImageIO.read(getClass().getResource(path));
            JLabel logoLbl = new JLabel(new ImageIcon(logo));
            add(logoLbl);
        } catch (IOException ex) {
            System.out.println("File not found!");
        }   
    }
    
    /**
     * Initializes all JComponents before being added to the main panel
     */
    private void initComponents()
    {
        startButtons.setLayout(new GridLayout(0,1));
        startButtons.setOpaque(false);
        cnu.setActionCommand("create_user");    
        login.setActionCommand("login");      
        vsb.setActionCommand("scoreboard");        
        exit.setActionCommand("exit");   
    }
    
    /**
     * Adds JComponents to main panel
     */
    private void addComponents()
    {
        startButtons.add(cnu);
        startButtons.add(Box.createVerticalStrut(15));
        startButtons.add(login);
        startButtons.add(Box.createVerticalStrut(15));
        startButtons.add(vsb);
        startButtons.add(Box.createVerticalStrut(15));
        startButtons.add(exit);   
    }        
}
