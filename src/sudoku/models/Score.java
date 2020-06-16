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
 *
 * @author Waldo
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

    public Score(Game game)
    {
        super();
        this.game = game;
        this.user = game.getUser();
        this.score_time = game.getTime();
    }
    
    public Score()
    {
        
    }

    /**
     * @return the moves
     */
    public double getScoreTime() {
        return score_time;
    }   
    
    /**
     * @return the game
     */
    public Game getGame() {
        return game;
    }

    /**
     * @return the user
     */
    public Users getUser() {
        return user;
    }
    
    public String getFormattedScoreTime()
    {
        DecimalFormat df = new DecimalFormat("0.00");
        TimeConverter tC = new TimeConverter(score_time);
        
        return ("Time: " + tC.getMins() + "min "+ df.format(tC.getSecs()) + "s");
    }
    
    public String getFormattedDifficulty()
    {
        return (getGame().getDifficulty().name());
    }
    
    public String getFormattedUsername()
    {
        return("User: " + getUser().getUsername());
    }
}
