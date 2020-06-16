package sudoku.misc;

/**
 *
 * @author Waldo
 */
public class TimeConverter {
    private double time;
    
    public TimeConverter(double time)
    {
        this.time = time;
    }

    public double getMins()
    {
        double min = (this.time - (this.time % 60)) / 60;        
        return min;
    }
    
    public double getSecs()
    {
        double secs = this.time - (60 * getMins());
        return secs;
    }
}
