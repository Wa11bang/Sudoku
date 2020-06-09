/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sudoku;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

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
    
    @Column(name="moves")
    private int moves;
    
    @Column(name="isComplete")
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
        this.moves = 0;
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
     * @return the moves
     */
    public int getMoves() {
        return moves;
    }

    /**
     * @param moves the moves to set
     */
    public void setMoves(int moves) {
        this.moves = moves;
    }

    /**
     * @return the complete
     */
    public boolean isComplete() {
        return complete;
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
    
    public void displayGame()
    {
        System.out.println("\nGame: " + this.game_id + " " + this.diff.toString() + "\n");
        System.out.print("  ");
        for(int i = 0; i < 9; ++i)
        {
            int c = (65 + i);
            System.out.print("  " + (char)(c));
        }
        
        System.out.print("\n");

        int counter = 0;        
        
        Object[] bb = this.blocks.toArray();
        
        for(int i = 0; i < 9; ++i)
        {
            System.out.print((i + 1) + "| ");
            for(int j = 0; j < 9; ++j)
            {
                System.out.print("[" + ((Block) bb[counter]).getValue() + "]");
                counter++;
            }
            
            System.out.print("\n");
        }
        
        System.out.println("\n");
    }
}
