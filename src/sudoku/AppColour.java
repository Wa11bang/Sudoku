package sudoku;

import java.awt.Color;

/**
 *
 * @author Waldo
 */
public class AppColour {
    public static final Color ERROR = Color.decode("#DD1C1A");//Color.RED;
    public static final Color INCORRECT = Color.RED;
    public static final Color CORRECT = Color.GREEN;
    public static final Color SAVED = Color.ORANGE;
    public static final Color MENU_FORE = Color.decode("#313638");//new Color(232, 240, 255);
    public static final Color MENU_BACK = Color.decode("#E0DFD5");//new Color(232, 240, 255).darker();
    public static final Color MENU_HOVER = Color.decode("#F09D51");//new Color(104, 116, 232).darker();
    public static final Color MENU_PRESS = Color.decode("#313638").brighter();//new Color(247, 172, 207).darker();
    public static final Color MENU_F_BORDER = new Color(0, 0, 0, 100);
    public static final Color MENU_F_PLACE = new Color(33, 33, 33, 100);
    public static final Color GAME_SECTION = Color.decode("#e0d5b1");//Color.decode("#e0d5b1");
    public static final Color GAME_B_BACK = Color.decode("#F6F0ED");
    public static final Color GAME_B_FOCUS = Color.decode("#BBB193");
    public static final Color CONTROL_PRESS = Color.decode("#e0d5b1").darker();
    public static final Color CONTROL_HOVER = Color.decode("#e0d5b1");  
    public static final Color SCORE_L_FORE = Color.decode("#685F74").darker().darker();
    public static final Color APP_BACK = Color.decode("#E8E9EB");//new Color(255,255,255,180);  
}