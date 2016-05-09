

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
     * @param   a   An array of Points to check for exponentail relation
     * @return  returns true if the data grows exponentialy, false if it does not grow exponentially
     */
    public static boolean isExponential(Point[] a)
    {
        int totalCount = 0;
        double growthY = a[a.length-1].getY()-a[0].getY();
        int[] breaksY = new int[a.length];
        int yBreaks = 0;
        for (int i = 0;i<breaksY.length;i++)
        {
            breaksY[i] = 1;
        }
        for(int i = 0;i<a.length-1;i++)
        {
            //Y Break checker
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
        
        System.out.println(yBreaks);
        
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
        
        System.out.println(totalCount);
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
