package defaultpackage;

import java.time.LocalTime;

/**
 * Holds information about a surgeon. Inherits from doctor. Surgeon required a
 * valid certificate to be able to practice.
 *
 * @author Deaglan Jack
 */
public class Surgeon extends Doctor
   {

   private SurgeonCertificate certificate_;

   public Surgeon(String name,
           String contactMethod,
           String contactDetails,
           String address,
           SurgeonCertificate certificate)
      {
      
      super(name, "Surgery", contactMethod, contactDetails, address);
      certificate_ = certificate;
      
      }

   // A surgeon's availability time relies on his schedule and whether his
   // certificate is valid or not
   @Override
   public boolean isAvailable(LocalTime time, int day)
      {
      
      return super.isAvailable(time, day) && !certificate_.isExpired();
      
      }

   public SurgeonCertificate getCertificate()
      {
      
      return certificate_;
      
      }

   @Override
   public String toString()
      {
      
      return super.toString() + "\n" 
              + certificate_.toString();
      
      }
   }
