package sudoku.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Block Object Class, stores an Integer value
 * @author Waldo Theron 18033655
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

    /**
     * Constructor for a Block Object
     * @param value 
     */
    public Block(int value)
    {
        super();
        this.value = value;
    }
    
    /**
     * Constructor for a Block Object
     */
    public Block()
    {
        
    }

    /**
     * Returns the Block's value
     * @return value
     */
    public int getValue() {
        return value;
    }

    /**
     * Sets the Blocks value
     * @param value
     */
    public void setValue(int value) {
        this.value = value;
    }
    
    
}
