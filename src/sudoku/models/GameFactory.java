package sudoku.models;

import sudoku.Difficulty;
import sudoku.misc.BlockGenerator;

/**
 * Static Factory Method for Generating an instance of a game.
 * @author Waldo Theron 18033655
 */
public class GameFactory {
    public static Game create(Difficulty d)
    {
        Game g = null;
        if ("easy".equalsIgnoreCase(d.toString())) {
            g = new Easy();
        }
        if ("medium".equalsIgnoreCase(d.toString())) {
            g = new Medium();
        }
        if ("hard".equalsIgnoreCase(d.toString())) {
            g = new Hard();
        }
        return g;
    }
    
    public static Game create(Difficulty d, Users user)
    {
        Game g = null;
        if ("easy".equalsIgnoreCase(d.toString())) {
            g = new Easy(user, BlockGenerator.generate(d));
        }
        if ("medium".equalsIgnoreCase(d.toString())) {
            g = new Medium(user, BlockGenerator.generate(d));
        }
        if ("hard".equalsIgnoreCase(d.toString())) {
            g = new Hard(user, BlockGenerator.generate(d));
        }
        return g;
    }
}
