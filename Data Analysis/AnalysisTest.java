import java.util.Scanner;

/**
 * Tests my methods in analysis
 * 
 * @author Alex Komar
 * @version 5/4/16
 */
public class AnalysisTest
{
    /**
     * Test the isExponential method in the analysis class with data that grows exactly exponential
     */
    public static void exactExponentialTest()
    {
        Point[] randPoints = ArrayMethods.randomArray(100,0,100,0,100);
        Point[] exponentialPoints = new Point[50];
        int count = 1;
        for (int i = 0; i<50;i++)
        {
            exponentialPoints[i] = new Point(i,Math.pow(2,count));
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

    /**
     * Test the isExponential method in the analysis class with data that grows in groups exponentialy
     */
    public static void nearExponentialTest()
    {
        Point[] randPoints = ArrayMethods.randomArray(100,0,100,0,100);
        Point[] exponentialPoints = new Point[51];
        int count = 1;
        for (int i = 1; i<51;i+=3)
        {
            exponentialPoints[i-1] = new Point(i,Math.pow(2,count)*.9);
            exponentialPoints[i] = new Point(i,Math.pow(2,count));
            exponentialPoints[i+1] = new Point(i,Math.pow(2,count)*1.1);
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
    

    /**
     * Tests the isExponential method in analysis based on user specified data
     */
    public static void manualExponentialTest()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("How many values are going to be in the test data List?");
        int length = s.nextInt();
        Point[] data = new Point[length];
        for(int i =1; i<length+1;i++)
        {
            System.out.println("What is the value of the " + i +" data point?");
            data[i-1] = new Point(i,s.nextInt());
        }
        ArrayMethods.sort(data);
        if (Analysis.isExponential(data))
        {
            System.out.println("Yes");
        }
        else
        {
            System.out.println("No");
        }
    }

}
