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
 *
 * @author Waldo
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

    public Game(Users user, List<Block> blocks, Difficulty diff)
    {
        super();
        this.user = user;
        this.blocks = blocks;
        this.game_time = 0;
        this.complete = false;
        this.diff = diff;
    }
    
    public Game()
    {
        
    }
    
    /**
     * @return the game_id
     */
    public int getGame_id() {
        return game_id;
    }

    /**
     * @return the time
     */
    public double getTime() {
        return game_time;
    }

    /**
     * @param time the moves to set
     */
    public void setTime(double time) {
        this.game_time = time;
    }

    /**
     * @param complete the complete to set
     */
    public boolean isComplete() {
        return this.complete;
    }
    
    /**
     * @param complete the complete to set
     */
    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    /**
     * @return the user
     */
    public Users getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Users user) {
        this.user = user;
    }

    /**
     * @return the blocks
     */
    public List<Block> getBlocks() {
        return blocks;
    }

    /**
     * @param blocks the blocks to set
     */
    public void setBlocks(List<Block> blocks) {
        this.blocks = blocks;
    }
    
    /**
     * @return the difficulty
     */
    public Difficulty getDifficulty() {
        return diff;
    }

    /**
     * @param diff the difficulty to set
     */
    public void setDifficulty(Difficulty diff) {
        this.diff = diff;
    }
    
    public String getFormattedTime()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        TimeConverter tC = new TimeConverter(game_time);
        
        return ("Time: " + tC.getMins() + "min "+ df.format(tC.getSecs()) + "s");
    }
    
    public String getFormattedDifficulty()
    {
        return (getDifficulty().name());
    }
    
    @Override
    public String toString()
    {
        return (getFormattedDifficulty() + " -> " + getFormattedTime());
    }
}
