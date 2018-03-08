package defaultpackage;

import exceptions.ArrayLengthMismatchException;
import utility.ArrayUtils;
import utility.WeekUtils;

/**
 * Class for handling a doctors schedule. Two arrays that holds the start time of
 * each day and end time of each day where the index is the of the week starting
 * at Sunday (0)
 *
 * @author Deaglan Jack
 */
public class Schedule
   {

   private String[] startTimes_ = new String[WeekUtils.DAYS_IN_WEEK];
   private String[] endTimes_ = new String[WeekUtils.DAYS_IN_WEEK];

   public Schedule(String[] startTimes, String[] endTimes)
           throws ArrayLengthMismatchException
      {
      
      setTimes(startTimes, endTimes);
      
      }

   public final void setTimes(String[] startTimes, String[] endTimes)
           throws ArrayLengthMismatchException
      {
      
      if ((ArrayUtils.isSameSizeArray(startTimes_, startTimes))
              && (ArrayUtils.isSameSizeArray(endTimes_, endTimes)))
         {
         
         startTimes_ = startTimes;
         endTimes_ = endTimes;
         
         } 
      else
         {
         
         throw new ArrayLengthMismatchException("Trying to set array greater than size "
                 + "(" + WeekUtils.DAYS_IN_WEEK + ")");
         
         }
      }

   public String[] getStartTimes()
      {
      
      return startTimes_;
      
      }

   public String[] getEndTimes()
      {
      
      return endTimes_;
      
      }

   @Override
   public String toString()
      {
      
      StringBuilder myStringBuilder = new StringBuilder();

      for (int i = 0; i < startTimes_.length; i++)
         {
         
         myStringBuilder.append(i);
         myStringBuilder.append(" ");
         myStringBuilder.append(startTimes_[i]);
         myStringBuilder.append("-");
         myStringBuilder.append(endTimes_[i]);

         // If last line don't bother taking a new line
         if (i < startTimes_.length - 1)
            {
            myStringBuilder.append("\n");
            }
         
         }
      
      return myStringBuilder.toString();
      
      }
   }
