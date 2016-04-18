

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
        double growthX = a[a.length-1].getX()-a[0].getX();
        int[] breaksX = new int[a.length];
        int xBreaks = 0;
        int yBreaks = 0;
        for(int i = 0;i<a.length-1;i++)
        {
            //Y Break checker
            if((a[i+1].getY()-a[i].getY())/growthY > .1)
            {
                breaksY[i] = 1;
                yBreaks++;
            }
        }
        if (yBreaks == 0)
        {
            yBreaks = a.length;
        }
        /**
        for(int i = 0;i<a.length-1;i++)
        {
            //X Break checker, will most likely not be used if x grow linearly
            if((a[i+1].getX()-a[i].getX())/growthX > .1)
            {
                breaksX[i] = 1;
                xBreaks++;
            }
        }
        */
        if(yBreaks>0 && (yBreaks != a.length))
        {
            int i = 0;
            
            while (i<a.length)
            {
                int average = 0;
                int average2 = 0;
                int count = 0;
                while(breaksY[i]!= 1)
                {
                    average += a[i].getY();
                    i++;
                }
                average /= count;
                i++;
                count = 0;
                while(breaksY[i]!= 1)
                {
                    average2 += a[i].getY();
                    i++;
                }
                average2 /= count;
                if(average*average == average2)
                {
                    totalCount+=1;
                }
            }
        }
        else
        {
            for (int i = 0;i<a.length-1;i++)
            {
                if((a[i].getY()*a[i].getY())==a[i+1].getY())
                {
                    totalCount++;
                }
            }
        }
        
        if(yBreaks == totalCount)
        {
            return true;
        }
        else
        {
            return false;
        }
    }

}
