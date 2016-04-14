

/**
 * A data point used for calculations.
 * 
 * @author Alex Komar 
 * @version 4/13/16
 */
public class Point
{
    /** description of instance variable x (add comment for each instance variable) */
    private double x;
    private double y;

    /**
     * Creates a point with value of x,y
     */
    public Point(double x,double y)
    {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Returns the x value of the point
     *
     * @return  The x value of the point as a double
     */
    public double getX()
    {
        // put your code here
        return x;
    }


    /**
     * Returns the y value of the point
     *  
     * @return  The y value of the point as a double
     */
    public double getY()
    {
        // put your code here
        return y;
    }

    
}
