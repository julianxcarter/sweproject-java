package View;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
 
/*from   w w w. j a  v a  2 s  .c om*/
import javax.swing.*;
 
public class RecruiterView extends  javax.swing.JFrame{
   /**
    *
    */
   private static final long serialVersionUID = 1L;
   //** components to be shown on the new listings panel **// 

   // lists of strings for location options
   public static String[] locationOptions = {"New York", "Los Angeles", "San Francisco"
   ,"Atlanta", "D.C", "New Jersey", "Seattle", "Houston", "Austin"};
   // list of strings for position options
   public static String[] positionOptions = {"Software Engineer", "Accountant", "Data Analyst"
   ,"Consultant", "Account Manager", "Human Resources Personnel", "Receptionist", "Assistant", "Project Manager"};
   // text box
   public static javax.swing.JTextField text;

   // create a panel for the bottom of the page containing interaction notifications
   public static final JPanel notificationsPanel = new JPanel();
   // create a label for the notifications column
   JLabel notificationsLbl = new JLabel("New Notifications For You:");
   
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
           // add button should add a new listing, including the ui components below:
           public void actionPerformed(ActionEvent event) {
               // create new listing panel and set layout
               JPanel newListing = new JPanel();
               newListing.setLayout(new GridLayout(0,5,20,20));
               // initialize locations combo box
               JComboBox<String> locations = new JComboBox<>(locationOptions);
               // initialize positions combo box
               JComboBox<String> positions = new JComboBox<>(positionOptions);
               // initialize job app link text field
               javax.swing.JTextField textBox = new javax.swing.JTextField();
 
               // create a remove button
               JButton removeButton = new JButton("remove");  
               removeButton.addActionListener(new ActionListener() {
                //remove button should remove the listing from the listings panel
               @Override
               public void actionPerformed(ActionEvent event) {
                   newListing.getParent().remove(newListing);
                   listingsPanel.revalidate();
                   listingsPanel.repaint();
               }
           });        
           
            // create an update button
            JButton updateButton = new JButton("update");  
               updateButton.addActionListener(new ActionListener() {
               @Override
               // update button should add listing to the database
               public void actionPerformed(ActionEvent event) {
                   //collect text containing job application link
                   String appLink = textBox.getText();

                   // pop up message to alert user that the listing has been added
                   JFrame frame = new JFrame();
                   JOptionPane.showMessageDialog(frame, "Listing Updated!");
               }
           });  
                // add all relevant components to the new listing panel
               newListing.add(locations);
               newListing.add(positions);
               newListing.add(textBox);
               newListing.add(removeButton);
               newListing.add(updateButton);
 
               // add the new listing to the listing panel, and revalidate/repaint the UI
               listingsPanel.add(newListing);
               listingsPanel.revalidate();
               listingsPanel.repaint();
           }
       });

      // add Add button to listings panel
       listingsPanel.add(addButton);
 
       //add listings panel to the top of the page
       homePage.add(listingsPanel, BorderLayout.NORTH);

       notificationsPanel.add(notificationsLbl, BorderLayout.NORTH);
       homePage.add(notificationsPanel);

       homePage.setVisible(true);
   }

   public static void addNotification() {
       // create string for notification label
       String name = "jobSeeker";
       JLabel notificationLbl = new JLabel(name);

       // create a notification box
       final JPanel newNotification = new JPanel();
       newNotification.add(notificationLbl);

       //add the new notification to the notification panel
       notificationsPanel.add(newNotification);
   }
   
 
   public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new RecruiterView().setVisible(true);
           }
       });
   }
}
 
 

