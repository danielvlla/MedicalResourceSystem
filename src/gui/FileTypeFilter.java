/*

FileFilter to implmenent in Import and Export Windows

By Daniel Vella

*/

package gui;

import java.io.File;
import javax.swing.filechooser.FileFilter;

public class FileTypeFilter extends FileFilter
   {
   
   private final String extension_;
   private final String description_;
   
   public FileTypeFilter(String ext, String desc)
      {
         
      this.extension_ = ext;
      this.description_ = desc;

      }

   @Override
   public boolean accept(File f) 
      {
      
      if (f.isDirectory())
         {
         
         return true;   
            
         }
      
      return f.getName().endsWith(extension_);
         
      }

   @Override
   public String getDescription() 
      {
         
      return description_ + String.format(" (*%s)", extension_);   
         
      }
}
