

/**
 * Tests my methods in analysis
 * 
 * @author Alex Komar
 * @version 5/4/16
 */
public class AnalysisTest
{
    public static void exponentialTest()
    {
        Point[] randPoints = ArrayMethods.randomArray(100,0,100,0,100);
        Point[] exponentialPoints = new Point[51];
        int count = 1;
        for (int i = 1; i<50;i+=3)
        {
            exponentialPoints[i] = new Point(i,Math.pow(2,count));
            exponentialPoints[i-1] = new Point(i,Math.pow(2,count)-15);
            exponentialPoints[i-1] = new Point(i,Math.pow(2,count)+15);
        }
        ArrayMethods.sort(randPoints);
        if (Analysis.isExponential(exponentialPoints))
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }
}
