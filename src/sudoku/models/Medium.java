package sudoku.models;

import sudoku.models.Block;
import sudoku.models.Game;
import sudoku.models.Users;
import java.util.List;
import javax.persistence.Entity;
import sudoku.Difficulty;

/**
 * Medium object that extends Game, uses Difficulty.Medium enumerator
 * @author Waldo Theron 18033655
 */
@Entity
public class Medium extends Game {

    /**
     * Constructor for Medium object
     * @param user
     */
    public Medium(Users user, List<Block> blocks)
    {
        super(user, blocks, Difficulty.Medium);
    }
    
    public Medium()
    {
        this.setDifficulty(Difficulty.Medium);
    }
}
