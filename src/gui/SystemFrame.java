/*

JFrame for Medical Resource Management System

By Daniel Vella

*/

package gui;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import managers.DoctorIO;

public class SystemFrame extends JFrame
        implements WindowListener
   {
   
   private JMenuBar menuBar_;
   private JMenu systemMenuBarItem_;
   private SidePanel sidePanel_;
   private MainPanel mainPanel_;
   private JMenuItem exitMenuItem_;
   
   public SystemFrame()
      {
         
      initialise();
      this.addWindowListener(this);
      
      }
   
   private void initialise()
      {
         
      // Create Menu
      menuBar_ = new JMenuBar();
      
      // Create Menu Buttons
      systemMenuBarItem_ = new JMenu("System");
      
      // Create Menu Item Exit
      exitMenuItem_ = new JMenuItem("Exit");
      exitMenuItem_.addActionListener(new ActionListener() 
         {
        
         public void actionPerformed(ActionEvent actionEvent) 
            {
            
            System.exit(0);
        
            }
      });
      
      // Add Menu Items to Menu Bar Items
      systemMenuBarItem_.add(exitMenuItem_);
      
      // Add menu items to Menu
      menuBar_.add(systemMenuBarItem_);
      this.setJMenuBar(menuBar_);
      
      // Set Custom Icon of Frame Window
      setIconImage(Toolkit.getDefaultToolkit().getImage(getClass().getResource("/images/DoctorIcon.png")));
            
      // Instantiate panels
      mainPanel_ = new MainPanel();
      mainPanel_.setLayout(new BoxLayout(mainPanel_, BoxLayout.Y_AXIS));
      mainPanel_.setAlignmentX(Component.CENTER_ALIGNMENT);
      
      // Pass in mainPanel to sidePanel to allow change of panels
      sidePanel_ = new SidePanel(mainPanel_);
      
      // Adds to side and main panel to a border layout
      this.add(sidePanel_, BorderLayout.WEST);
      this.add(mainPanel_, BorderLayout.CENTER);
      
      this.setTitle("Medical Resource Management System");
      // Closes program on closing
      this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      // Sets window to full screen on any device
      this.setExtendedState(JFrame.MAXIMIZED_BOTH); 
      // Center window
      this.setLocationRelativeTo(null);
      this.pack();
      this.setVisible(true);

      } // end initialise()

    @Override
    public void windowOpened(WindowEvent e)
      {
        
      }

    @Override
    public void windowClosing(WindowEvent e)
      {
      try{
        DoctorIO.writeDoctorsData();
      } catch (IOException io)
         {
            System.out.println("Error: could not create doctor records");
         }
      }

    @Override
    public void windowClosed(WindowEvent e)
      {
        
      }

    @Override
    public void windowIconified(WindowEvent e)
      {
        
      }

    @Override
    public void windowDeiconified(WindowEvent e)
      {
        
      }

    @Override
    public void windowActivated(WindowEvent e)
      {
       
      }

    @Override
    public void windowDeactivated(WindowEvent e)
      {
       
      }


} // end class SystemFrame
