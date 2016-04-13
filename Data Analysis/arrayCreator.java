

/**
 * Creates an array of points.
 * 
 * @author Alex Komar
 * @version 4/13/16
 */
public class arrayCreator
{
    /**
     * An example of a method - replace this comment with your own
     *    that describes the operation of the method
     *
     * @pre        preconditions for the method
     *            (what the method assumes about the method's parameters and class's state)
     * @post    postconditions for the method
     *            (what the method guarantees upon completion)
     * @param    y    description of parameter y
     * @return    description of the return value
     */
    public Point[] randomArray(int size,double ymin,double ymax, double xmin, double xmax)
    {
        Point[] randArr = new Point[size];
        for(int i = 0;i<size;i++)
        {
            Point pt = new Point((Math.random()*(xmax*xmin))+xmin,(Math.random()*(ymax-ymin))+ymin);
            randArr[i] = pt;            
        }
        return randArr;
    }

}
