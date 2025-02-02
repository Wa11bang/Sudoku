package sudoku.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import sudoku.models.Block;
import sudoku.Difficulty;
import static sudoku.Sudoku.PERMUTE_COUNT;

/**
 * Generates a Random Sudoku Block list from pre-defined "solved" grids.
 * @author Waldo Theron 18033655
 */
public class BlockGenerator {   
    private static Random rand = new Random(); 
    
    /**
     * Returns a List of Blocks for a Sudoku game with a given difficulty
     * @param d
     * @return List of Block
     */
    public static List<Block> generate(Difficulty d)
    {
        List<Block> blocks = new ArrayList();        
        int[] selected = getRandomElement(getPreDokus());
        
        int counter = 0;      
        for(int i = 0; i < selected.length; ++i)
        {
            blocks.add(new Block(selected[counter]));
            counter++;
        }
        
        removeNBlocks(blocks, d.getValue());
        permute(blocks);
        
        return blocks;
    }
    
    /**
     * Handles the permutation functions, and ensures a specific level of
     * randomness is achieved.
     * @param blocks 
     */
    public static void permute(List<Block> blocks)
    {
        for(int i = 0; i < PERMUTE_COUNT; ++i)
        {
            permuteRow(blocks);
            permuteColumn(blocks);
        }
    }
    
    /**
     * Returns a random list of Sudoku numbers from pre-defined lists.
     * @param list
     * @return int[]
     */
    public static int[] getRandomElement(List<int[]> list) 
    {         
        return list.get(rand.nextInt(list.size())); 
    } 
    
    /**
     * Removes a specific number of blocks from a given Block List.
     * @param blocks
     * @param n 
     */
    public static void removeNBlocks(List<Block> blocks, int n)
    {
        int counter = 0;
        while(counter < n)
        {
            int block = (rand.nextInt(81));
            
            if(blocks.get(block).getValue() != 0)
            {
                blocks.get(block).setValue(0);                     
                counter++;
            }
        }
    }
    
    /**
     * Randomly swaps two rows within a 3 by 9 section while still maintaining
     * solvability
     * @param blocks 
     */
    public static void permuteRow(List<Block> blocks)
    {
        int row_a = rand.nextInt(9);
        int row_b = ((row_a / 3) * 3) + rand.nextInt(3);
       
        for(int i = 0; i < 9; ++i)
        {
            Collections.swap(blocks, ((row_a + (i*9))), ((row_b + (i*9)))); // ROWS
        } 
    }
    
    /**
     * Randomly swaps two columns within a 9 by 3 section while still maintaining
     * solvability
     * @param blocks 
     */
    public static void permuteColumn(List<Block> blocks)
    {
        int col_a = rand.nextInt(9);
        int col_b = ((col_a / 3) * 3) + rand.nextInt(3);
       
        for(int i = 0; i < 9; ++i)
        {
            Collections.swap(blocks, ((col_a * 9) + i), ((col_b * 9) + i)); // COLUMNS
        } 
    }
    
    /**
     * Returns a List of Integer one-dimensional arrays
     * @return 
     */
    public static List<int[]> getPreDokus()
    {
        List<int[]> preDokus = new ArrayList();
        
        preDokus.add(new int[]{ 8,3,7,1,9,5,6,4,2,9,6,5,8,4,2,1,7,3,1,4,2,7,3,6,5,9,8,3,5,6,4,1,8,9,2,7,7,1,4,6,2,9,8,3,5,2,9,8,3,5,7,4,1,6,4,2,9,5,6,3,7,8,1,6,7,1,2,8,4,3,5,9,5,8,3,9,7,1,2,6,4 });
        preDokus.add(new int[]{ 3,9,1,4,5,7,8,6,2,8,6,4,2,9,1,7,5,3,5,2,7,8,6,3,1,4,9,4,1,8,7,3,9,5,2,6,9,5,6,1,2,4,3,8,7,7,3,2,5,8,6,4,9,1,6,4,9,3,7,8,2,1,5,2,8,3,6,1,5,9,7,4,1,7,5,9,4,2,6,3,8 });
        preDokus.add(new int[]{ 2,3,5,9,4,6,8,1,7,4,1,8,7,5,3,2,9,6,7,6,9,8,2,1,3,4,5,6,5,2,3,9,4,1,7,8,1,9,4,5,8,7,6,2,3,3,8,7,6,1,2,4,5,9,9,2,6,4,7,8,5,3,1,5,4,3,1,6,9,7,8,2,8,7,1,2,3,5,9,6,4 });
        preDokus.add(new int[]{ 7,2,1,3,4,8,9,6,5,6,5,9,2,7,1,3,4,8,3,4,8,9,5,6,2,7,1,4,8,6,1,2,7,5,9,3,9,7,5,8,3,4,1,2,6,1,3,2,5,6,9,4,8,7,2,6,4,7,1,5,8,3,9,8,1,3,6,9,2,7,5,4,5,9,7,4,8,3,6,1,2 });
        preDokus.add(new int[]{ 6,1,3,7,5,8,2,9,4,4,8,2,3,6,9,5,1,7,5,9,7,2,1,4,6,8,3,1,6,9,8,7,5,3,4,2,2,3,5,4,9,6,8,7,1,7,4,8,1,3,2,9,6,5,8,7,4,6,2,3,1,5,9,9,2,6,5,4,1,7,3,8,3,5,1,9,8,7,4,2,6 });
        
        return preDokus;
    }
}
