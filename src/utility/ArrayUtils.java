package utility;

import defaultpackage.Doctor;
import managers.DoctorManager;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Class for utilities and arrays
 * @author Deaglan Jack
 * @author Daniel Vella
 */
public class ArrayUtils
   {

   public static boolean isSameSizeArray(String[] array1, String[] array2)
      {
      return array1.length == array2.length;
      }
   
   public static void sortArray() throws NullPointerException
      {
      Arrays.sort(DoctorManager.getAllDoctors(), new Comparator<Doctor>()
         {
         @Override
         public int compare(Doctor d1, Doctor d2)
            {
            if (d1.getName() == null && d2.getName() == null)
               {
               return 0;
               }
            if (d1.getName() == null)
               {
               return 1;
               }
            if (d2.getName() == null)
               {
               return -1;
               }
            return (d1.getName()).compareTo(d2.getName());
            }
         }
      );
      }
   }
