package sudoku.ui.views;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import sudoku.ui.elements.MenuButton;
import sudoku.ui.controllers.StartController;

/**
 *
 * @author Waldo
 */
public class StartView extends JPanel {
    private MenuButton login;
    private MenuButton cnu;
    private MenuButton vsb;
    private MenuButton exit;
    
    public StartView()
    {
        loadLogo("/sudoku/res/logo.png");
        
        cnu = new MenuButton("Create New User");
        cnu.setActionCommand("create_user");
        
        login = new MenuButton("Login");
        login.setActionCommand("login");
        
        vsb = new MenuButton("View Scoreboard");
        vsb.setActionCommand("scoreboard");
        
        exit = new MenuButton("Exit");
        exit.setActionCommand("exit");
        
        setBorder(new EmptyBorder(45, 10, 10, 10));
        setLayout(new FlowLayout(FlowLayout.CENTER));
        
        JPanel startButtons = new JPanel();
        startButtons.setLayout(new GridLayout(0,1));
        startButtons.setOpaque(false);
        startButtons.add(cnu);
        startButtons.add(Box.createVerticalStrut(15));
        startButtons.add(login);
        startButtons.add(Box.createVerticalStrut(15));
        startButtons.add(vsb);
        startButtons.add(Box.createVerticalStrut(15));
        startButtons.add(exit);
        
        setOpaque(false);
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
        URI logoPath = null;
        try {
            logoPath = getClass().getResource(path).toURI();
        } catch (URISyntaxException ex) {
            Logger.getLogger(StartView.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            BufferedImage logo = ImageIO.read(new File(logoPath));
            JLabel logoLbl = new JLabel(new ImageIcon(logo));
            add(logoLbl);
        } catch (IOException ex) {
            System.out.println("File not found!");
        }   
    }
}
