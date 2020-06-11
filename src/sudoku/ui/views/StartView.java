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
 *
 * @author Waldo
 */
public class StartView extends JPanel {
    private JPanel startButtons = new JPanel();
    private MenuButton login = new MenuButton("Login");
    private MenuButton cnu = new MenuButton("Create New User");
    private MenuButton vsb = new MenuButton("View Scoreboard");
    private MenuButton exit = new MenuButton("Exit");
    
    public StartView()
    {
        setBorder(new EmptyBorder(45, 10, 10, 10));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setOpaque(false);
        
        loadLogo(Sudoku.LOGO_PATH);
 
        cnu.setActionCommand("create_user");    
        login.setActionCommand("login");      
        vsb.setActionCommand("scoreboard");        
        exit.setActionCommand("exit");               
                
        startButtons.setLayout(new GridLayout(0,1));
        startButtons.setOpaque(false);
        startButtons.add(cnu);
        startButtons.add(Box.createVerticalStrut(15));
        startButtons.add(login);
        startButtons.add(Box.createVerticalStrut(15));
        startButtons.add(vsb);
        startButtons.add(Box.createVerticalStrut(15));
        startButtons.add(exit);        
        
        add(startButtons);
    }
    
    public void addController(StartController controller)
    {
        this.login.addActionListener(controller);
        this.cnu.addActionListener(controller);
        this.vsb.addActionListener(controller);
        this.exit.addActionListener(controller);
    }
    
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
}
