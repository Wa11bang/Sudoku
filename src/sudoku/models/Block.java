package sudoku.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Waldo
 */

@Entity(name="block")
@Table(name = "block")
public class Block implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="block_id")
    private int block_id;
    
    @Column(name="block_value")
    private int value;

    public Block(int value)
    {
        super();
        this.value = value;
    }
    
    public Block()
    {
        
    }

    /**
     * @return the value
     */
    public int getValue() {
        return value;
    }

    /**
     * @param value the value to set
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    
}
