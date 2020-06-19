package sudoku.misc;

/**
 * Functional Class to retrieve a time from seconds
 * @author Waldo Theron 18033655
 */
public class TimeConverter {
    private double time;
    
    /**
     * Constructor for TimeConverter Object
     * @param time 
     */
    public TimeConverter(double time)
    {
        this.time = time;
    }

    /**
     * Calculates the total amount of minutes from the time
     * @return minutes from total time 
     */
    public double getMins()
    {
        double min = (this.time - (this.time % 60)) / 60;        
        return min;
    }
    
    /**
     * Calculates the total amount of seconds from the time, minus the minutes
     * @return seconds from total time (minus minutes)
     */
    public double getSecs()
    {
        double secs = this.time - (60 * getMins());
        return secs;
    }
}
