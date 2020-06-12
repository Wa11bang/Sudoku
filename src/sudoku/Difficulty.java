package sudoku;

/**
 * Enumerator Object that stores 3 levels of difficulty as an integer
 * @author Waldo Theron 18033655
 */
public enum Difficulty {
    Easy(24),
    Medium(35),
    Hard(50);

    private final int num;
    
    /**
     * Constructor for the Difficulty object
     * @param num
     */
    private Difficulty(int num)
    {
        this.num = num;
    }
    
    /**
     * Gets the value of the enumerator
     * @return value
     */
    public int getValue()
    {
        return this.num;
    }
}
