package sudoku.models;

import java.io.Serializable;
import java.text.DecimalFormat;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import sudoku.misc.TimeConverter;

/**
 * Score Object, contains score_time, user and game
 * @author Waldo Theron 18033655
 */
@Entity(name="score")
@Table(name = "score")
public class Score implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="score_id")
    private int score_id;
    
    @Column(name="score_time")
    private double score_time;

    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Users user;
    
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "game_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private Game game;

    /**
     * Constructor for Score Object
     * @param game
     */
    public Score(Game game)
    {
        super();
        this.game = game;
        this.user = game.getUser();
        this.score_time = game.getTime();
    }
    
    /**
     * Constructor for Score Object
     */
    public Score()
    {
        
    }

    /**
     * Returns the time of the Score
     * @return score_time
     */
    public double getScoreTime() {
        return score_time;
    }   
    
    /**
     * Returns the Game Object that set the score
     * @return game
     */
    public Game getGame() {
        return game;
    }

    /**
     * Returns the User that set the score
     * @return  user
     */
    public Users getUser() {
        return user;
    }
    
    /**
     * Returns a formatted String representation of the score time
     * @return String
     */
    public String getFormattedScoreTime()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        TimeConverter tC = new TimeConverter(score_time); //Important to Note: The difference is the score_time (between Game's Method)
        
        return ("Time: " + tC.getMins() + "min "+ df.format(tC.getSecs()) + "s");
    }
    
    /**
     * Returns a formatted String representation of the Game difficulty
     * @return String
     */
    public String getFormattedDifficulty()
    {
        return (getGame().getDifficulty().name());
    }
    
    /**
     * Returns a formatted String representation of the User
     * @return String
     */
    public String getFormattedUsername()
    {
        return("User: " + getUser().getUsername());
    }
}
