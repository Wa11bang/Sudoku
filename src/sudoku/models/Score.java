package sudoku.models;

import java.io.Serializable;
import java.time.Duration;
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
     * @return the game_id
     */
    public int getScore_id() {
        return score_id;
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
    
    @Override
    public String toString()
    {
        Duration d = Duration.ofMillis((long) this.score_time) ;
        int minutes = (int) d.toMinutes();
        int seconds = (int) d.toMillis();
        
        return ("Game ID: "+this.game.getGame_id() + " Time: " + minutes + "Min "+ seconds + "s  Settings: " + this.game.getDifficulty() +" ("+ this.game.getDifficulty().getValue() + ") User: "+this.user.getUsername());
    }
}
