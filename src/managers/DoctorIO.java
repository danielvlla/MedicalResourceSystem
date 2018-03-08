package managers;

import defaultpackage.Doctor;
import defaultpackage.Schedule;
import defaultpackage.Surgeon;
import defaultpackage.SurgeonCertificate;
import exceptions.ArrayLengthMismatchException;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Scanner;
import java.io.FileWriter;
import utility.TimeUtils;
import utility.WeekUtils;

/**
 * Class that handles input and output to the program 
 * 
 * @author Deaglan Jack
 * @author Francis McDermott
 * @author Daniel Vella
 * @author Stewart Rutledge
 */

public class DoctorIO
   {

   // Writes doctors to a text file
   public static void writeDoctorsData() throws IOException
      {
      
      String data = DoctorManager.allDoctorsToString(DoctorManager.getAllDoctors());
      File file = new File("Doctor Records File.txt");
      
      FileWriter fw = new FileWriter(file);
      fw.write(data);
      fw.flush();
      
      }

   // Reads doctors in from a text file and adds them to the doctor array
   public static void readDoctorsData() throws FileNotFoundException
      {
      
      File file = new File("Doctor Records File.txt");
      Scanner scanner = new Scanner(file);

      while (scanner.hasNextLine())
         {
         
         Doctor newDoctor;

         String name = scanner.nextLine();
         String discipline = scanner.nextLine();
         String contactMethod = scanner.nextLine();
         String contactDetails = scanner.nextLine();
         String address = scanner.nextLine();
         
         // Doctor can become a surgeon at runtime
         if (discipline.equals("Surgery"))
            {
            
            int year = Integer.parseInt(scanner.nextLine());
            int month = Integer.parseInt(scanner.nextLine());
            int day = Integer.parseInt(scanner.nextLine());

            newDoctor = new Surgeon(name, contactMethod, contactDetails, address, new SurgeonCertificate(year, month, day));
            
            } 
         else
            {
            
            newDoctor = new Doctor(name, discipline, contactMethod, contactDetails, address);
            
            }
         
         DoctorManager.add(newDoctor);
         
         }
      }

   // Updates all registered doctor's availabilities provided they are
   // in the text file
   public static void availabilityUpdate(File file)
           throws FileNotFoundException,
           NullPointerException,
           ArrayLengthMismatchException
      {
      
      String doctorName;
      Scanner myScanner = new Scanner(file);

      while (myScanner.hasNextLine())
         {
         
         doctorName = myScanner.nextLine();
         System.out.println(doctorName);
         String[] startTimes = new String[WeekUtils.DAYS_IN_WEEK];
         String[] endTimes = new String[WeekUtils.DAYS_IN_WEEK];
         for (int i = 0; i < WeekUtils.DAYS_IN_WEEK; i++)
            {
            
            String[] times = myScanner.nextLine().split(" ");
            startTimes[i] = times[1];
            endTimes[i] = times[2];
            
            }
         // Creating new schedule for doctor
         Schedule newSchedule = new Schedule(startTimes, endTimes);
         DoctorManager.find(doctorName).setSchedule(newSchedule);
         }
      }

   // Generates a formatted report for an array of doctors that provides
   // a list of times that none of them will be available
   private static String getDisciplineReport(Doctor[] doctors)
      {
      
      int secondsInDay = LocalTime.of(23, 59).toSecondOfDay();
      int startTime = 0;
      int endTime = 0;
      
      boolean isAPeriodOfUnavailability = false;
      String[] daysOfWeek = WeekUtils.getDaysOfWeekAsArray();
      StringBuilder sb = new StringBuilder();
      
      // Looping through days of the week
      for (int k = 0; k < WeekUtils.DAYS_IN_WEEK; k++)
         {
         
         sb.append(daysOfWeek[k]).append("\r\n");
         for (int i = 0; i <= secondsInDay; i++)
            {
            
            boolean isEndOfDay = i == secondsInDay;
            if ((isEndOfDay) || hasDoctorAvailable(doctors, i, k))
               {
               
               if (isAPeriodOfUnavailability)
                  {
                  
                  endTime = i;
                  isAPeriodOfUnavailability = false;
                  sb.append(TimeUtils.secondsToTime(startTime)).append("-");
                  sb.append(TimeUtils.secondsToTime(endTime));
                  sb.append("\r\n");
                  }
               } 
            else
               {
               
               if (!isAPeriodOfUnavailability)
                  {
                  
                  startTime = i;
                  isAPeriodOfUnavailability = true;
                  
                  }
               }
            }
         }// End of days of week loop
      return sb.toString();
      }

   // Returns a formatted string containing a report of all periods of
   // unavailabilties for all disciplines
   public static String getFullReport()
      {
      String[] disciplineList = DoctorManager.getDisciplinesAsArray();

      StringBuilder sb = new StringBuilder();

      for (String disciplineName : disciplineList)
         {
         
         sb.append(disciplineName).append("\r\n").append("=========").append("\r\n");
         sb.append(getDisciplineReport(DoctorManager.getDiscipline(disciplineName)));
         sb.append("\r\n");
         
         }
      
      return sb.toString();
      
      }
   
   // Checks a specific second on a specific day to see if any doctor from an
   // array of doctors is available at that time
   private static boolean hasDoctorAvailable(Doctor[] doctors, int secondInDay, int day)
      {
      boolean hasDoctorAvailable = false;

      for (Doctor doctor : doctors)
         {
         
         if (doctor != null)
            {
            
            LocalTime time = LocalTime.ofSecondOfDay(secondInDay);
            if (doctor.isAvailable(time, day))
               {
               
               hasDoctorAvailable = true;
               break;
               
               }
            }
         }

      return hasDoctorAvailable;
      
      }
   }
