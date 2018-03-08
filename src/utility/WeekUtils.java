package utility;

import java.time.LocalDate;

/**
 *
 * Utility class for weeks
 * @author Deaglan Jack
 */
public final class WeekUtils
  {

    public static final int DAYS_IN_WEEK = 7;

    // Returns day of the week as an index starting with sunday at 0 and ending
    // with saturday at 6
    public static int getDayOfWeek()
      {
        int dayOfWeek = LocalDate.now().getDayOfWeek().getValue();

        // If it's sunday set the index to 0 instead of 7
        if (dayOfWeek == 7)
          {
            dayOfWeek = 0;
          }

        return dayOfWeek;
      }

    public static String[] getDaysOfWeekAsArray()
      {
        String[] daysArray = new String [WeekUtils.DAYS_IN_WEEK];
        String dayOfWeek = "";
        for (int i = 0; i < WeekUtils.DAYS_IN_WEEK; i++)
          {
            switch (i)
              {
                case 0:
                    dayOfWeek = "Sunday";
                    break;
                case 1:
                    dayOfWeek = "Monday";
                    break;
                case 2:
                    dayOfWeek = "Tuesday";
                    break;
                case 3:
                    dayOfWeek = "Wednesday";
                    break;
                case 4:
                    dayOfWeek = "Thursday";
                    break;
                case 5:
                    dayOfWeek = "Friday";
                    break;
                case 6:
                    dayOfWeek = "Saturday";
                    break;
              }
            daysArray[i] = dayOfWeek;
          }
        
        return daysArray;
      }
  }
