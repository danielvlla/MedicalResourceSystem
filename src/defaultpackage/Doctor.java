package defaultpackage;

import java.time.LocalTime;

/**
 * Class for holding information about a Doctor
 *
 * @author Deaglan Jack
 */
public class Doctor
   {

   private String name_;
   private String discipline_;
   private String contactMethod_;
   private String contactDetails_;
   private String address_;
   private Schedule schedule_;

   public Doctor(String name,
           String discipline,
           String contactMethod,
           String contactDetails,
           String address)
      {
      
      name_ = name;
      discipline_ = discipline;
      contactMethod_ = contactMethod;
      contactDetails_ = contactDetails;
      address_ = address;
      
      }

   public String getDiscipline()
      {
      
      return discipline_;
      
      }

   public void setSchedule(Schedule schedule)
      {
      
      schedule_ = schedule;
      
      }

   public Schedule getSchedule()
      {
      
      return schedule_;
      
      }

   public void setName(String name)
      {
      
      name_ = name;
      
      }

   public String getName()
      {
      
      return name_;
      
      }

   public void setContactMethod(String contactMethod)
      {
      
      contactMethod_ = contactMethod;
      
      }

   public String getContactMethod()
      {
      
      return contactMethod_;
      
      }

   public void setContactDetails(String contactDetails)
      {
      
      contactDetails_ = contactDetails;
      
      }

   public String getContactDetails()
      {
      
      return contactDetails_;
      
      }

   public void setAddress(String address)
      {
      
      address_ = address;
      
      }

   public String getAddress()
      {
      
      return address_;
      
      }

   public void setDiscipline(String discipline)
      {

      discipline_ = discipline;

      }

   // Checks a moment of time on a day of the week to check if a doctor is
   // available according to his schedule
   public boolean isAvailable(LocalTime time, int day)
      {
      
      if (schedule_ == null)
         {
         
         return false;
         
         }

      LocalTime startTime = LocalTime.parse(schedule_.getStartTimes()[day]);
      LocalTime endTime = LocalTime.parse(schedule_.getEndTimes()[day]);

      return (startTime.isBefore(time))
              && (endTime.isAfter(time));
      }

   @Override
   public String toString()
      {
      
      return "Name: " + name_ + "\n"
              + "Discipline" + discipline_ + "\n"
              + "Contact Method: " + contactMethod_ + "\n"
              + "Contact Details: " + contactDetails_ + "\n"
              + "Address :" + address_;
      
      }
   }
