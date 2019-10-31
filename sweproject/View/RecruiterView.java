package View;
import Controller;
import Model;

import java.awt.*;
// import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
/*from   w w w. j a  v a  2 s  .c om*/
import javax.swing.*;
// import javax.swing.JCheckBox;
// import javax.swing.JFrame;
// import javax.swing.JList;
// import javax.swing.JPanel;
// import javax.swing.JLabel;
// import javax.swing.JButton;
// import javax.swing.JComboBox;
// import javax.swing.JScrollPane;
// import java.awt.BorderLayout;
// import javax.swing.ListCellRenderer;g
// import javax.swing.ListSelectionModel;
 
public class RecruiterView extends  javax.swing.JFrame{
   /**
    *
    */
   private static final long serialVersionUID = 1L;
   // //Options for the JComboBox
   public static String[] locationOptions = {"New York", "Los Angeles", "San Francisco"
   ,"Atlanta", "D.C", "New Jersey", "Seattle", "Houston", "Austin"};
   public static String[] positionOptions = {"Software Engineer", "Accountant", "Data Analyst"
   ,"Consultant", "Account Manager", "Human Resources Personnel", "Receptionist", "Assistant", "Project Manager"};
   public static javax.swing.JTextField text; //array of JTextFields
 
   public RecruiterView() {
      
       // create a new jframe object for the home page
       JFrame homePage= new JFrame("Home Page View"); 
       // make sure the page exits when the red x is pressed
       homePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       //set the dimmensions of the home page
       homePage.setSize(800,800);
 
       // create a panel for the top of the page containing job listings
       final JPanel listingsPanel = new JPanel();
       // create a label for the open positions column
       JLabel listingsLbl = new JLabel("Locations Available:");
       listingsPanel.setLayout(new BoxLayout(listingsPanel, BoxLayout.Y_AXIS));
       // place label at the top of the panel
       listingsPanel.add(listingsLbl, BorderLayout.NORTH);
       listingsPanel.setVisible(true);
 
       //add a button to add job listings
       JButton addButton = new JButton( "Add Listings");
       addButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent event) {
               JPanel newListing = new JPanel();
               newListing.setLayout(new GridLayout(0,5,20,20));
               JComboBox<String> locations = new JComboBox<>(locationOptions);
               JComboBox<String> positions = new JComboBox<>(positionOptions);
               javax.swing.JTextField textBox = new javax.swing.JTextField();
 
               JButton removeButton = new JButton("remove");  
               removeButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent event) {
                   newListing.getParent().remove(newListing);
                   listingsPanel.revalidate();
                   listingsPanel.repaint();
               }
           });        
           
            //add update button to update database. include a notification
            JButton updateButton = new JButton("update");  
               updateButton.addActionListener(new ActionListener() {
               @Override
               public void actionPerformed(ActionEvent event) {
                   // update listings database
                   JFrame frame = new JFrame();
                   JOptionPane.showMessageDialog(frame, "Listing added!");
               }
           });  
 
               newListing.add(locations);
               newListing.add(positions);
               newListing.add(textBox);
               newListing.add(removeButton);
               newListing.add(updateButton);
 
               listingsPanel.add(newListing);
               listingsPanel.revalidate();
               listingsPanel.repaint();
           }
       });

      // add Add button to listings panel
       listingsPanel.add(addButton);
 
       //add listings panel to the top of the page
       homePage.add(listingsPanel, BorderLayout.NORTH);

       // create a panel for the bottom of the page containing interaction notifications
       final JPanel notificationsPanel = new JPanel();
       // create a label for the notifications column
       JLabel notificationsLbl = new JLabel("New Notifications For You:");
       notificationsPanel.add(notificationsLbl, BorderLayout.NORTH);


       homePage.add(notificationsPanel);

       homePage.setVisible(true);
   }

   public static void addNotification() {

   }
 
   public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new RecruiterView().setVisible(true);
           }
       });
   }
}
 
 

