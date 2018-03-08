package utility;

/**
 * Utility class for Time
 * @author dj
 */
public class TimeUtils
  {
    // Returns seconds as a formatted string
    public static String secondsToTime(int seconds)
      {
        final int SECONDS_IN_HOUR = 3600;
        final int SECONDS_IN_MINUTE = 60;
        int hour = 0;
        int minute = 0;
        while (seconds >= SECONDS_IN_HOUR)
          {
            hour++;
            seconds -= SECONDS_IN_HOUR;
          }
        while (seconds >= SECONDS_IN_MINUTE)
          {
            minute++;
            seconds -= SECONDS_IN_MINUTE;
          }

        String formatHour = formatTime(hour);
        String formatMinute = formatTime(minute);

        return formatHour + ":" + formatMinute;
      }
    
    // Formats a "time" integer i.e. 8 becomes 08 on a clock
    public static String formatTime(int i)
      {
        String formatTime = Integer.toString(i);

        if (formatTime.length() == 1)
          {
            char c = formatTime.charAt(0);
            formatTime = "0" + c;
          }

        return formatTime;
      }
    
    
  }
