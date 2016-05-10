

/**
 * Analyzes data to see if there is any relation between the points
 * 
 * @author Alex Komar 
 * @version 4/15/16
 */
public class Analysis
{
    /**
     * Checks to see if the data grows exponentialy
     *
     * @param   a   An array of Points to check for exponentail relation. The data must be sorted by both x and y values
     * @return  returns true if the data grows exponentialy, false if it does not grow exponentially
     */
    public static boolean isExponential(Point[] a)
    {
        int totalCount = 0;//The total times the data grows exponentially
        int[] breaksY = new int[a.length]; //An array that represents each position where a group of data is, and ends
        int yBreaks = 0; // The amount of groups of data there are
        for (int i = 0;i<breaksY.length;i++)
        {
            //Sets all of the base values in the breaksY array
            breaksY[i] = 1;
        }
        for(int i = 0;i<a.length-1;i++)
        {
            //Checks to see if the data in the Y values is grouped in anyway
            if((a[i+1].getY()-a[i].getY())/(((a[i].getY()*a[i].getY())-a[i].getY())*.1) > .1)
            {
                breaksY[i] = 0;
                yBreaks++;
            }
        }
        
        if (yBreaks == 0)
        {
            yBreaks = a.length-1;
        }
        else
        {
            breaksY[breaksY.length-1] = 1;
        }
        
        //Checks to see how many times the data grows exponentially
        if(yBreaks>0 && (yBreaks != a.length-1))
        {
            int i = 0;
            int runCounter = 0;
            while (i<a.length && runCounter != yBreaks-1)
            {
                int average = 0;
                int average2 = 0;
                int count = 0;
                while(i<breaksY.length&&breaksY[i]== 1)
                {
                    average += a[i].getY();
                    i++;
                    count++;
                }
                if (count != 0)
                {
                    average /= count;
                }
                i++;
                count = 0;
                while(i<breaksY.length&&breaksY[i]== 1)
                {
                    average2 += a[i].getY();
                    i++;
                    count++;
                }
                if (count != 0)
                {
                    average2 /= count;
                }
                if(average2-(average*average) <= average2*.01)
                {
                    totalCount+=1;
                }
                runCounter++;
                totalCount = breaksY.length-totalCount;
            }
        }
        else
        {
            for (int i = 0;i<a.length-1;i++)
            {
                if(a[i+1].getY()-(a[i].getY()*a[i].getY())<a[i+1].getY()*.1)
                {
                    totalCount++;
                }
            }
        }
        
        //Checks to see if the number of times it grew exponential is equal to the number of groups of data there are
        if(Math.abs(yBreaks - totalCount) < 3)
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
}
