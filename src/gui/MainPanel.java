/*

Container for all panels in program which do not form part of the sidePanel
Contains methods for switching between panels

By Daniel Vella

*/

package gui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JScrollPane;

public class MainPanel extends javax.swing.JPanel 
   {

   private CardLayout cardLayout_;
   private ImageIcon bgImage_;
   private JLabel imagePlaceHolder_;
   private ViewAvailableDoctorPanel availabilityPanel_;
   private RegisterDoctorPanel registerPanel_;  
   private ViewAllDoctorsPanel viewsPanel_;
   private JScrollPane scrollableAvailabilityPanel_;
   private JScrollPane scrollableViewDoctorsPanel_;
   private JScrollPane scrollableRegisterPanel_;
   
   // Card layout adds a string to panels which needs to be referenced
   private final String BACKGROUND_MAIN_PANEL = "card0";
   private final String VIEW_AVAILABILITIES_PANEL = "card1";
   private final String REGISTER_DOCTOR_PANEL = "card2";
   private final String VIEW_DOCTORS_PANEL = "card3";
 
   // Create new Main Panel
   public MainPanel() 
      {
         
      // GUI Builder automatically generated components
      initComponents();
            
      // Custom created code
      initialiseMainPanel();

      } 
   // end MainPanel constructor
   
   // Components code which are not automatically generated by the GUI Builder
   private void initialiseMainPanel()
      {
      
      // Makes panels attached to so as to fill the whole panel
      fillPanel_.setLayout(new GridLayout());
             
      // Cardlayout for switching between panels functionality
      mainPanel_.setLayout(new CardLayout());
      
      backgroundMainPanel_.setLayout(new BorderLayout());
      
      // Initialise Panels
      availabilityPanel_ = new ViewAvailableDoctorPanel();
      registerPanel_ = new RegisterDoctorPanel();
      viewsPanel_ = new ViewAllDoctorsPanel();     

      // If user resizes screen, scroll bar will be available to navigate
      scrollableAvailabilityPanel_ = new JScrollPane(availabilityPanel_);
      scrollableRegisterPanel_ = new JScrollPane(registerPanel_);
      scrollableViewDoctorsPanel_ = new JScrollPane(viewsPanel_);
      
      // Makes scroll bar more visible
      scrollableAvailabilityPanel_.getHorizontalScrollBar().setPreferredSize(new Dimension(0, 15));
     
      // Add cards to the Card Layout
      cardLayout_ = new CardLayout();
      mainPanel_.setLayout(cardLayout_);
      mainPanel_.add(backgroundMainPanel_, BACKGROUND_MAIN_PANEL);
      mainPanel_.add(scrollableRegisterPanel_, REGISTER_DOCTOR_PANEL);
      mainPanel_.add(scrollableViewDoctorsPanel_, VIEW_DOCTORS_PANEL);
      mainPanel_.add(scrollableAvailabilityPanel_, VIEW_AVAILABILITIES_PANEL);
            
      // Shows backgroundMainPanel at first
      cardLayout_.show(mainPanel_, BACKGROUND_MAIN_PANEL);
      
      // Adds icon to backgroundMainPanel
      bgImage_ = new ImageIcon(getClass().getResource("/images/DoctorBgImage.png"));
      imagePlaceHolder_ = new JLabel(bgImage_); 
      backgroundMainPanel_.add(imagePlaceHolder_, BorderLayout.CENTER );
      
      }
   // end initialiseRestOfComponents method
   
   // Methods for switching between panels
   public void setViewAvailabilitiesPanel()
      {
         
      cardLayout_.show(mainPanel_, VIEW_AVAILABILITIES_PANEL);
      
      }
   
   public void setRegisterDoctorPanel()
      {
         
      cardLayout_.show(mainPanel_, REGISTER_DOCTOR_PANEL);
      
      }
  
   public void setViewDoctorsPanel()
      {
         
      cardLayout_.show(mainPanel_, VIEW_DOCTORS_PANEL);
      
      }
   
   /**
    * This method is called from within the constructor to initialize the form.
    * WARNING: Do NOT modify this code. The content of this method is always
    * regenerated by the Form Editor.
    */
   @SuppressWarnings("unchecked")
   // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
   private void initComponents()
   {

      fillPanel_ = new javax.swing.JPanel();
      mainPanel_ = new javax.swing.JPanel();
      backgroundMainPanel_ = new javax.swing.JPanel();

      fillPanel_.setBackground(new java.awt.Color(255, 255, 255));

      mainPanel_.setBackground(new java.awt.Color(255, 255, 255));

      backgroundMainPanel_.setBackground(new java.awt.Color(255, 255, 255));

      javax.swing.GroupLayout backgroundMainPanel_Layout = new javax.swing.GroupLayout(backgroundMainPanel_);
      backgroundMainPanel_.setLayout(backgroundMainPanel_Layout);
      backgroundMainPanel_Layout.setHorizontalGroup(
         backgroundMainPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 809, Short.MAX_VALUE)
      );
      backgroundMainPanel_Layout.setVerticalGroup(
         backgroundMainPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 538, Short.MAX_VALUE)
      );

      javax.swing.GroupLayout mainPanel_Layout = new javax.swing.GroupLayout(mainPanel_);
      mainPanel_.setLayout(mainPanel_Layout);
      mainPanel_Layout.setHorizontalGroup(
         mainPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(backgroundMainPanel_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      mainPanel_Layout.setVerticalGroup(
         mainPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(backgroundMainPanel_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );

      javax.swing.GroupLayout fillPanel_Layout = new javax.swing.GroupLayout(fillPanel_);
      fillPanel_.setLayout(fillPanel_Layout);
      fillPanel_Layout.setHorizontalGroup(
         fillPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 809, Short.MAX_VALUE)
         .addGroup(fillPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, fillPanel_Layout.createSequentialGroup()
               .addGap(0, 0, Short.MAX_VALUE)
               .addComponent(mainPanel_, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
      );
      fillPanel_Layout.setVerticalGroup(
         fillPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addGap(0, 523, Short.MAX_VALUE)
         .addGroup(fillPanel_Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(mainPanel_, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
      );

      javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
      this.setLayout(layout);
      layout.setHorizontalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(fillPanel_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
      layout.setVerticalGroup(
         layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
         .addComponent(fillPanel_, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
      );
   }// </editor-fold>//GEN-END:initComponents


   // Variables declaration - do not modify//GEN-BEGIN:variables
   private javax.swing.JPanel backgroundMainPanel_;
   private javax.swing.JPanel fillPanel_;
   private javax.swing.JPanel mainPanel_;
   // End of variables declaration//GEN-END:variables
} // end Main Panel Class
