/*

COM373 Programming II 

TEAM MEMBERS
Daniel Vella B00746979
Deaglan Jack B00615778
Francis McDermott B00705888
Stewart Rutledge B00720532

ASSUMPTIONS
1) Availabilities File will update all the days of the week.
2) If surgeon certificate is expired, the surgeon will always be marked as 
unavailable even if schedule indicates that surgeon is available.

*/

package defaultpackage;

import gui.SystemFrame;
import java.io.IOException;
import java.io.FileNotFoundException;
import managers.DoctorIO;

/**
 *
 * @author Deaglan Jack & Daniel Vella
 */
public class Main
   {
   
   public static void main(String[] args)
      {

      // Reads doctor data from Doctor Records File
      try

         {

         DoctorIO.readDoctorsData();

         } catch (FileNotFoundException fe)

         {

         System.out.println("Doctor records file does not exist");

         }

      SystemFrame systemFrame = new SystemFrame();

      // Writes Doctors Data to Doctor Records File before closing 
      Runtime.getRuntime().addShutdownHook(new Thread(new Runnable()
         {

         @Override
         public void run()
            {
            try
               {
               DoctorIO.writeDoctorsData();
               } catch (IOException ie)
               {
               System.out.println("Error: could not save all registered customers");
               }

            }
         }
      )); // end RunTime

      } // end public method main

   } // end main class
