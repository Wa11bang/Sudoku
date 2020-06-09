/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

/**
 *
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
