package org.employable.View;

import org.employable.Controller.RecruiterController;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;
import java.net.URL;

/*from   w w w. j a  v a  2 s  .c om*/
import javax.swing.*;
import javax.swing.border.EtchedBorder;
 
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
   public static final JPanel notificationsPane = new JPanel();
   // create a label for the notifications column
   JLabel notificationsLbl = new JLabel("New Notifications For You:");

   // create an instance of the recruiter controller
   RecruiterController controller = new RecruiterController();
   
   public RecruiterView(String company) {
      
       // create a new jframe object for the home page
       JFrame homePage= new JFrame(company + " Recruiter"); 
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
                    // remove the job listing from the database

                   // remove the job listing from the UI
                   newListing.getParent().remove(newListing);
                   listingsPanel.revalidate();
                   listingsPanel.repaint();
               }
           });        
           
            // create an update button
            JButton updateButton = new JButton("update");  

            // update button sould be diabled by default. will be enabled if text is present in the
            // application link text box
            updateButton.setEnabled(false);

               updateButton.addActionListener(new ActionListener() {
               @Override
               // update button should add listing to the database by calling the controller method
               public void actionPerformed(ActionEvent event) {
                   //collect text containing job application link   
                    String appLink = textBox.getText();

                    // check if the text in the textbox is a valid URL
                    if (!isValid(appLink)) {
                      // show a pop up message to alert user that the listing has been added
                      JFrame frame = new JFrame();
                      JOptionPane.showMessageDialog(frame, "Invalid Link!");
                      return;
                    }
                   
                   // collect listing location
                   String chosenLocation = locations.getSelectedItem().toString();

                   //collect listing position
                   String chosenPosition = positions.getSelectedItem().toString();

                   // call the controller to update the database with the new listing
                   controller.createJobListing(chosenPosition, "company", appLink, chosenLocation);

                   // show a pop up message to alert user that the listing has been added
                   JFrame frame = new JFrame();
                   JOptionPane.showMessageDialog(frame, "Listing Updated!");
               }
           });  

           // include a listener for the application link textbox that will disable the update button
           // if the text is empty
           DocumentListener checkText = new DocumentListener() {
            public void changedUpdate(DocumentEvent e) {
                changed();
              }
              public void removeUpdate(DocumentEvent e) {
                changed();
              }
              public void insertUpdate(DocumentEvent e) {
                changed();
              }
            
              public void changed() {
                 if (textBox.getText().equals("")){
                   updateButton.setEnabled(false);
                 }
                 else {
                   updateButton.setEnabled(true);
                }
            
              }
           };

           // add document listener to text box
           textBox.getDocument().addDocumentListener(checkText);

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

      // add Add Listings button to listings panel
       listingsPanel.add(addButton);
 
       //add listings panel to the top of the page
       homePage.add(listingsPanel, BorderLayout.NORTH);

       // allow notifications to be scrollable; if job listings push notifications panel off of
       // the page, they should still be viewable to the user
       JScrollPane notificationsPanel = new JScrollPane(notificationsPane);
       notificationsPanel.setLayout(new ScrollPaneLayout());
       
       //add dummy notifications for user views
       notificationsPane.add(notificationsLbl);
       notificationsPane.add(new NewNotification("Cameron Womack"));
       notificationsPane.add(new NewNotification("Julian Carter"));
       notificationsPane.add(new NewNotification("Ariel Turnley"));
       notificationsPane.add(new NewNotification("Thulani Vereen"));
       notificationsPane.add(new NewNotification("Cameryn Boyd"));
    
       homePage.getContentPane().add(notificationsPanel);

       homePage.setVisible(true);
   }
   
    // function to check if the text box text is a valid URL
    public static boolean isValid(String url) 
    { 
        // try creating a valid URL 
        try { 
            new URL(url).toURI(); 
            return true; 
        } 
          
        // If there was an Exception 
        // while creating URL object 
        catch (Exception e) { 
            return false; 
        }
    }

    // create a notification class that will create boxes to show 
    // user interactions with job listing in the notifications panel
    public class NewNotification extends JPanel {
      /**
     *
     */
    private static final long serialVersionUID = 1L;

    public NewNotification(String n) {
          setLayout(new BorderLayout());
          setBorder(BorderFactory.createEtchedBorder(EtchedBorder.RAISED));
          String label = "<html>A new user, " + n + " viewed a job listing posted by this company.</html>";
          add(new JLabel(label, JLabel.CENTER));
      }

      @Override
      public Dimension getMinimumSize() {
          return getPreferredSize();
      }

      @Override
      public Dimension getMaximumSize() {
          return getPreferredSize();
      }

      @Override
      public Dimension getPreferredSize() {
          return new Dimension(150, 150);
      }
  }
  
   public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new RecruiterView("Google").setVisible(true);
           }
       });
   }
}
 
 

