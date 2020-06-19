package sudoku.models;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import sudoku.Difficulty;
import sudoku.misc.TimeConverter;

/**
 * Game Class, stores information such as game_time, user and the list of blocks
 * @author Waldo Theron 18033655
 */
@Entity(name="game")
@Table(name = "game")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
abstract public class Game implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="game_id")
    private int game_id;
    
    @Column(name="game_time")
    private double game_time;
    
    @Column(name="is_complete")
    private boolean complete;
    
    @Column(name="difficulty")
    private Difficulty diff;
    
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users user;
    
    @OneToMany(cascade = { CascadeType.ALL }, fetch = FetchType.EAGER)
    @JoinTable(joinColumns = @JoinColumn(name = "game_id"), inverseJoinColumns = @JoinColumn(name = "block_id"))
    private List<Block> blocks = new ArrayList();

    /**
     * Constructor for Game Object
     * @param user
     * @param blocks
     * @param diff 
     */
    public Game(Users user, List<Block> blocks, Difficulty diff)
    {
        super();
        this.user = user;
        this.blocks = blocks;
        this.game_time = 0;
        this.complete = false;
        this.diff = diff;
    }
    
    /**
     * Constructor for Game Object
     */
    public Game()
    {
        
    }
    
    /**
     * Returns the value of the game_id (only after retrieved from database)
     * @return game_id
     */
    public int getGame_id() {
        return game_id;
    }

    /**
     * Retrieves the time the game has been played
     * @return game_time
     */
    public double getTime() {
        return game_time;
    }

    /**
     * Sets the current game time
     * @param time
     */
    public void setTime(double time) {
        this.game_time = time;
    }

    /**
     * Returns the value of boolean complete (is the game complete)
     * @return complete
     */
    public boolean isComplete() {
        return this.complete;
    }
    
    /**
     * Sets the value of the complete boolean
     * @param complete
     */
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    /**
     * Returns the User which created the Game
     * @return user
     */
    public Users getUser() {
        return user;
    }

    /**
     * Sets the creator of this game
     * @param user
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * Returns the List of Blocks for this Game
     * @return blocks
     */
    public List<Block> getBlocks() {
        return blocks;
    }

    /**
     * Sets the List of Blocks for this Game
     * @param blocks
     */
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
    
    /**
     * Returns the Game difficulty enumerator
     * @return difficulty
     */
    public Difficulty getDifficulty() {
        return diff;
    }

    /**
     * Sets the Game difficulty enumerator
     * @param diff
     */
    public void setDifficulty(Difficulty diff) {
        this.diff = diff;
    }
    
    /**
     * Returns a formatted String representation of the Game time
     * @return String
     */
    public String getFormattedTime()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        TimeConverter tC = new TimeConverter(game_time);
        
        return ("Time: " + tC.getMins() + "min "+ df.format(tC.getSecs()) + "s");
    }
    
    /**
     * Returns a formatted String representation of the Game difficulty
     * @return String
     */
    public String getFormattedDifficulty()
    {
        return (getDifficulty().name());
    }
    
    /**
     * Returns a  String representation of the Game Object
     * @return String
     */
    @Override
    public String toString()
    {
        return (getFormattedDifficulty() + " -> " + getFormattedTime());
    }
}
