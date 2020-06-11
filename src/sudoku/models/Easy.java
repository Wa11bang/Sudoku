package sudoku.models;

import sudoku.models.Block;
import sudoku.models.Game;
import sudoku.models.Users;
import java.util.List;
import javax.persistence.Entity;
import sudoku.Difficulty;

/**
 * Easy object that extends Game, uses Difficulty.Easy enumerator
 * @author Waldo Theron 18033655
 */
@Entity
public class Easy extends Game {

    /**
     * Constructor for Easy object
     * @param user
     */
    public Easy(Users user, List<Block> blocks)
    {
        super(user, blocks, Difficulty.Easy);
    }
    
    public Easy()
    {
        this.setDifficulty(Difficulty.Easy);
    }
    
    /**
     * Initialize the game object by permuting the grid
     */
}