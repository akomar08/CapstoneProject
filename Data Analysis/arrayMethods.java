import java.util.Scanner;


/**
 * Creates an array of points.
 * 
 * @author Alex Komar
 * @version 4/13/16
 */
public class ArrayMethods
{
    /**
     * Creates a random array of data points 
     *
     * @param   size    How many data points there will be
     * @param   ymin    The smallest possible value for y 
     * @param   ymax    The largest possible value for y
     * @param   xmin    The smallest possible value for x
     * @param   xmax    The largest possible value for x
     * 
     * @return    An array of Points
     */
    public static Point[] randomArray(int size,double ymin,double ymax, double xmin, double xmax)
    {
        Point[] randArr = new Point[size];
        for(int i = 0;i<size;i++)
        {
            Point pt = new Point((Math.random()*(xmax*xmin))+xmin,(Math.random()*(ymax-ymin))+ymin);
            randArr[i] = pt;            
        }
        return randArr;
    }
    

    /**
     * Creates an array of points based off of data that the user passes in
     *
     * @return  an array of data points
     */
    public static Point[] manualArray()
    {
        Scanner s = new Scanner(System.in);
        System.out.println("How many data points are there?");
        int count = s.nextInt();
        Point[] newArr = new Point[count];
        for (int i = 0; i<count;i++)
        {
            System.out.println("What is the data point's x value?");
            double x = s.nextDouble();
            System.out.println("What is the data point's y value?");
            double y = s.nextDouble();
            Point pnt = new Point(x,y);
            newArr[i] = pnt;
        }
        return newArr;
    }
    
    
    /**
       Sorts an array, using merge sort.
       @param a the array to sort
    */
    public static void sort(Point[] a)
    {  
       if (a.length <= 1) { return; }
       Point[] first = new Point[a.length / 2];
       Point[] second = new Point[a.length - first.length];
       // Copy the first half of a into first, the second half into second
       for (int i = 0; i < first.length; i++) 
       { 
          first[i] = a[i]; 
       }
       for (int i = 0; i < second.length; i++) 
       { 
          second[i] = a[first.length + i]; 
       }
       sort(first);
       sort(second);
       merge(first, second, a);
    }

    /**
       Merges two sorted arrays into an array
       @param first the first sorted array
       @param second the second sorted array
       @param a the array into which to merge first and second
    */
    private static void merge(Point[] first, Point[] second, Point[] a)
    {  
       int iFirst = 0; // Next element to consider in the first array
       int iSecond = 0; // Next element to consider in the second array
       int j = 0; // Next open position in a

       // As long as neither iFirst nor iSecond is past the end, move
       // the smaller element into a
       while (iFirst < first.length && iSecond < second.length)
       {  
          if (first[iFirst].getX() < second[iSecond].getX())
          {  
             a[j] = first[iFirst];
             iFirst++;
          }
          else
          {  
             a[j] = second[iSecond];
             iSecond++;
          }
          j++;
       }

       // Note that only one of the two loops below copies entries
       // Copy any remaining entries of the first array
       while (iFirst < first.length) 
       { 
          a[j] = first[iFirst]; 
          iFirst++; j++;
       }
       // Copy any remaining entries of the second half
       while (iSecond < second.length) 
       { 
          a[j] = second[iSecond]; 
          iSecond++; j++;
       }
    }
    
    /**
     * Removes one point from an aray
     *
     * @post    The specified data point in the array is removed
     * @param   a   The array that you are removing a point from
     * @param   pos Which position will be removed from the array
     * @return  description of the return value
     */
    public static void remove(Point[] a,int pos)
    {
       Point[] b = new Point[a.length - 1];
       for (int i = 0; i<pos; i++)
       {
           b[i] = a[i];
       }
       for (int i = pos; i <a.length;i++)
       {
           b[i] = a[i+1];
       }
       a = b;
    }
    
    /**
     * Removes any duplicates from an array of data points
     *
     * @param   a   The array that is going to be cleaned
     */
    public static void clean(Point[] a)
    {
        for(int i = 0; i<a.length;i++)
        {
            if(a[i].equals(a[i+1]))
            {
                remove(a,i+1);
                i--;
            }
        }
    }


}
