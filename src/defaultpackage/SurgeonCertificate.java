package defaultpackage;

import java.time.LocalDate;

/**
 * A surgeon must have a valid certificate which is a certificate that has been
 * issued within any time in the last year.
 *
 * Leap year edge case: 29th Feb (+ or -) 1 year is equal to 28th Feb This is
 * sufficient for the purposes of this class.
 *
 * @author Deaglan Jack
 */
public class SurgeonCertificate extends Certificate
        implements Expireable

   {

   private int YEARS_BEFORE_EXPIRY = 1;

   public SurgeonCertificate(int year, int month, int day)
      {
      
      super(year, month, day);
      
      }

   @Override
   public LocalDate getExpiryDate()
      {
      
      return getIssueDate().plusYears(YEARS_BEFORE_EXPIRY);
      
      }

   @Override
   public boolean isExpired()
      {
      
      LocalDate todayDate = LocalDate.now();

      return todayDate.isAfter(getExpiryDate());
      
      }

   @Override
   public String toString()
      {
      
      return super.toString() + "\n"
              + "Expiry Date: " + getExpiryDate();
      
      }

   }
