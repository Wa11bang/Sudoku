package sudoku.misc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import sudoku.Difficulty;
import sudoku.models.Block;

/**
 *
 * @author Waldo
 */
public class BlockGeneratorTest {
    
    public BlockGeneratorTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of removeNBlocks method, of class BlockGenerator.
     */
    @Test
    public void testRemoveNBlocksEasy() {
        System.out.println("Testing Removal of Blocks for Grid Generation: Easy");
        Difficulty d = Difficulty.Easy;
        List<Integer> blocks = convertBlockToInt(BlockGenerator.generate(d));
        
        
        int expResult = d.getValue();
        
        int result = Collections.frequency(blocks, 0);
        assertEquals(expResult, result);
    }
 
    /**
     * Test of removeNBlocks method, of class BlockGenerator.
     */
    @Test
    public void testRemoveNBlocksMedium() {
        System.out.println("Testing Removal of Blocks for Grid Generation: Medium");
        Difficulty d = Difficulty.Medium;
        List<Integer> blocks = convertBlockToInt(BlockGenerator.generate(d));
        
        
        int expResult = d.getValue();
        
        int result = Collections.frequency(blocks, 0);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of removeNBlocks method, of class BlockGenerator.
     */
    @Test
    public void testRemoveNBlocksHard() {
        System.out.println("Testing Removal of Blocks for Grid Generation: Hard");
        Difficulty d = Difficulty.Hard;
        List<Integer> blocks = convertBlockToInt(BlockGenerator.generate(d));
        
        
        int expResult = d.getValue();
        
        int result = Collections.frequency(blocks, 0);
        assertEquals(expResult, result);
    }
    
    public List<Integer> convertBlockToInt(List<Block> blocks)
    {
        List<Integer> blockValue = new ArrayList();
        for(Block b : blocks)
        {
            blockValue.add(b.getValue());
        }
        return blockValue;
    }
}
