package managers;

import defaultpackage.Doctor;
import defaultpackage.Surgeon;

/**
 * Class to be used to manage the handling of doctors in this project this class
 * will add, sort and delete managers.
 *
 * @author Deaglan Jack
 * @author Daniel Vella
 * @author Francis McDermott
 * @author Stewart Rutledge
 */
public class DoctorManager
   {

   private static final int MAX_DOCTORS = 100;
   private static final int MAX_DOCTORS_PER_DISCIPLINE = 10;
   private static final int NUMBER_OF_DISCIPLINES = 10;

   private static Doctor[] doctors_ = new Doctor[MAX_DOCTORS];

   public static int getMaxDoctor()
      {
      
      return MAX_DOCTORS;
      
      }

   public static int getDoctorsPerDiscipline()
      {
      
      return MAX_DOCTORS_PER_DISCIPLINE;
      
      }

   public static int getNumberOfDisciplines()
      {
      
      return NUMBER_OF_DISCIPLINES;
      
      }

   public static Doctor[] getAllDoctors()
      {
      
      return doctors_;
      
      }

   // Adds doctor to the array if it's not full and there is space
   // available for the discipline of that doctor
   public static void add(Doctor doctor)
      {
      
      int index = findEmpty();
      boolean isReadyToAdd = index != -1
              && hasFreeDisciplineSpace(doctor.getDiscipline());
      if (isReadyToAdd)
         {
         
         doctors_[index] = doctor;
         
         }
      
      }

   // Finds an empty spot in the array. Returns -1 if full
   public static int findEmpty()
      {
      
      int value = -1;

      for (int i = 0; i < doctors_.length; i++)
         {
         
         if (doctors_[i] == null)
            {
            
            value = i;
            break;
            
            }
         
         }
      
      return value;
      }

   // Finds a doctor in the array by name. Returns null if the doctor does
   // not exist
   public static Doctor find(String name)
      {
      
      int i = getIndex(name);

      if (i != -1)
         {
         
         return doctors_[i];
         
         }

      return null;
      
      }

   // Returns doctors of a particular discipline in an array
   public static Doctor[] getDiscipline(String discipline)
      {
      
      Doctor[] disciplines = new Doctor[MAX_DOCTORS_PER_DISCIPLINE];

      int count = 0;

      for (Doctor doctor : doctors_)
         {
         
         if (doctor != null)
            {

            if (doctor.getDiscipline().equals(discipline))
               {
               
               disciplines[count] = doctor;
               count++;
               
               }
            }
         }
      return disciplines;
      }

   public static boolean hasFreeDisciplineSpace(String discipline)
      {
      
      int count = 0;
      
      for (Doctor doctor : doctors_)
         {
         
         if (doctor != null)
            {
            
            if (doctor.getDiscipline().equals(discipline))
               {
               
               count++;
               
               }
            }
         }
      
      if (count >= MAX_DOCTORS_PER_DISCIPLINE)
         {
         
         return false;
         
         }
      
      return true;
      
      }

   // Returns the index of a doctor, -1 if he doesn't exist
   private static int getIndex(String name)
      {
      
      for (int i = 0; i < doctors_.length; i++)
         {
         
         if (doctors_[i] != null)
            {
            
            if (name.equals(doctors_[i].getName()))
               {
               
               return i;
               
               }
            
            }
         
         }
      
      return -1;
      }

   public static void remove(String name)
      {
      
      System.out.println("Deleting: " + doctors_[getIndex(name)].getName());
      doctors_[getIndex(name)] = null;
      
      }

   public static boolean isEmptyArray()
      {
      
      int count = 0;
      
      for (Doctor doctor : doctors_)
         {
         
         if (doctor != null)
            {
            
            count++;
            
            }
         
         }
      
      return count <= 0;
      
      }

   public static String[] getDisciplinesAsArray()
      {
      
      String disciplineName = "";
      String[] disciplineArray = new String[NUMBER_OF_DISCIPLINES];

      for (int i = 0; i < NUMBER_OF_DISCIPLINES; i++)
         {
         
         switch (i)
            {
            case 0:
               disciplineName = "Cardiology";
               break;
            case 1:
               disciplineName = "Pulmonology";
               break;
            case 2:
               disciplineName = "Infectious Disease";
               break;
            case 3:
               disciplineName = "Hematology";
               break;
            case 4:
               disciplineName = "Intensive Care Medicine";
               break;
            case 5:
               disciplineName = "Neurology";
               break;
            case 6:
               disciplineName = "Ophthalmology";
               break;
            case 7:
               disciplineName = "Orthopedics";
               break;
            case 8:
               disciplineName = "Urology";
               break;
            case 9:
               disciplineName = "Surgery";
               break;
            }
         
         disciplineArray[i] = disciplineName;
         
         }

      return disciplineArray;
      }

   // Returns all doctors and their properties in an array as a string
   // in a format that is suitable to be written to a text file
   public static String allDoctorsToString(Doctor[] doctors)
      {
      
      StringBuilder sb = new StringBuilder();
      
      for (Doctor doctor : doctors)
         {
         
         if (doctor != null)
            {
            
            sb.append(doctor.getName()).append("\r\n");
            sb.append(doctor.getDiscipline()).append("\r\n");
            sb.append(doctor.getContactMethod()).append("\r\n");
            sb.append(doctor.getContactDetails()).append("\r\n");
            sb.append(doctor.getAddress()).append("\r\n");
            if (doctor.getDiscipline().equals("Surgery"))
               {
               
               sb.append(((Surgeon) doctor).getCertificate().getYear());
               sb.append("\r\n");
               sb.append(((Surgeon) doctor).getCertificate().getMonth());
               sb.append("\r\n");
               sb.append(((Surgeon) doctor).getCertificate().getDay());
               sb.append("\r\n");
               
               }
            
            }
         
         }
      
      return sb.toString();
      
      }
   }
