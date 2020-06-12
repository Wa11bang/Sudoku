package sudoku.models;

import sudoku.Difficulty;

/**
 * Static Factory Method for Generating an instance of a game.
 * @author Waldo
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
}
