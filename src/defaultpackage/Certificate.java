package defaultpackage;

import java.time.LocalDate;

/**
 * This is an abstract certificate class made to hold information about a
 * doctor's certificate
 *
 * @author Deaglan Jack
 */
public abstract class Certificate
   {

   private int year_;
   private int month_;
   private int day_;

   public Certificate(int year, int month, int day)
      {
      
      year_ = year;
      month_ = month;
      day_ = day;
      
      }

   public LocalDate getIssueDate()
      {
      
      return LocalDate.of(year_, month_, day_);
      
      }

   @Override
   public String toString()
      {
      
      return "Issue Date: " + getIssueDate();
      
      }

   public int getYear()
      {
      
      return year_;
      
      }

   public int getMonth()
      {
      
      return month_;
      
      }

   public int getDay()
      {
      
      return day_;
      
      }
   }
