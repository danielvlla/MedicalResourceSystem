package defaultpackage;

import java.time.LocalDate;

/**
 * Interface that implements methods that require something to expire In this
 * project it will be used on certificates
 *
 * @author Deaglan Jack
 */
public interface Expireable
   {

   public boolean isExpired();

   public LocalDate getExpiryDate();
   }
