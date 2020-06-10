package sudoku;

import java.util.List;
import javax.persistence.Entity;

/**
 * Hard object that extends Game, uses Difficulty.Hard enumerator
 * @author Waldo Theron 18033655
 */
@Entity
public class Hard extends Game {

    /**
     * Constructor for Hard object
     * @param user
     */
    public Hard(Users user, List<Block> blocks)
    {
        super(user, blocks, Difficulty.Hard);
    }
    
    public Hard()
    {
        this.setDifficulty(Difficulty.Hard);
    }
}
