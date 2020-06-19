package sudoku.ui.views;

import java.awt.GridBagLayout;
import javax.swing.Box;
import javax.swing.border.EmptyBorder;
import sudoku.ui.controllers.GameController;
import sudoku.ui.elements.MenuButton;
import sudoku.ui.elements.MenuLabel;

/**
 * Create Game View 
 * @author Waldo
 */
public class CreateGameView extends IView {  
    private MenuButton easyBtn = new MenuButton("Easy");
    private MenuButton mediumBtn = new MenuButton("Medium");
    private MenuButton hardBtn = new MenuButton("Hard");
    private MenuButton backBtn = new MenuButton("Back");
    private MenuLabel gameSelect = new MenuLabel("Please select a Game Difficulty");
    
    public CreateGameView()
    {
        setBorder(new EmptyBorder(30, 30, 30, 30));
        
        contentPanel.setLayout(new GridBagLayout());
        contentPanel.setOpaque(false);     
           
        initComponents();
        addComponents();

        add(gameSelect, gbConstraints);
        add(contentPanel, gbConstraints); 
    }
    
    /**
     * Adds the relevant controller to handle user interactions with this view
     * @param controller 
     */
    public void addController(GameController controller) {
        System.out.println("CreateGameView: Adding GameController");
        easyBtn.addActionListener(controller);
        mediumBtn.addActionListener(controller);
        hardBtn.addActionListener(controller);
        backBtn.addActionListener(controller);
    } 
    
    /**
     * Initializes all JComponents before being added to the main panel
     */
    private void initComponents()
    {
        easyBtn.setActionCommand("easy_create");
        mediumBtn.setActionCommand("medium_create");
        hardBtn.setActionCommand("hard_create");
        backBtn.setActionCommand("back");
    }
    
    /**
     * Adds JComponents to main panel
     */
    private void addComponents()
    {
        contentPanel.add(Box.createVerticalStrut(25), gbConstraints);
        contentPanel.add(easyBtn, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(10), gbConstraints);
        contentPanel.add(mediumBtn, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(10), gbConstraints);
        contentPanel.add(hardBtn, gbConstraints);
        contentPanel.add(Box.createVerticalStrut(50), gbConstraints);
        contentPanel.add(backBtn);   
    }
}
