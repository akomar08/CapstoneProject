

/**
 * Write a description of class AnalysisTest here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class AnalysisTest
{
    public static void exponentialTest()
    {
        Point[] randPoints = ArrayMethods.randomArray(100,0,100,0,100);
        Point[] exponentialPoints = new Point[100];
        for (int i = 0; i<100;i++)
        {
            exponentialPoints[i] = new Point(i,Math.pow(3,i));
        }
        ArrayMethods.sort(randPoints);
        
        if (Analysis.isExponential(exponentialPoints))
        {
            System.out.println("Yes");
        }
    }
}
