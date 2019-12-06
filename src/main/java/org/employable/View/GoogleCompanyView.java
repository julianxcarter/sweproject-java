package org.employable.View;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

/*from   w w w. j a  v a  2 s  .c om*/
import javax.swing.*;

public class GoogleCompanyView extends javax.swing.JFrame {
    /**
    *
    */
    private static final long serialVersionUID = 1L;

    // ** components to be shown on the new listings panel **//
    public GoogleCompanyView() {
        // create a new jframe object for the home page
        JFrame googlePage = new JFrame("Google Inc.");
        // make sure the page exits when the red x is pressed
        googlePage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the dimmensions of the home page
        googlePage.setSize(800, 800);

        // create a main jpanel to hold all the home page widgets
        JPanel googlePageHeader = new JPanel();
        //set box layout so that elements are added one on top of the other
        googlePageHeader.setLayout(new BoxLayout(googlePageHeader, BoxLayout.X_AXIS));
        googlePageHeader.setVisible(true);
        

        // create a panel for the company's name
        JPanel googleTitle = new JPanel();
        JLabel googleTitleLbl = new JLabel("Google Inc.");
        googleTitle.add(googleTitleLbl);

        // create a button panel for the company star rating and the policy button
        JPanel companyButtons = new JPanel();

        //add company policy button
        JButton policyButton = new JButton("view company policy");
        policyButton.addActionListener(new ActionListener() {
            @Override
            // this button should direct a user to the company's accessibility policy page
            public void actionPerformed(ActionEvent event) {
                try {
                    openWebpage(new URL("https://www.google.com/accessibility/initiatives-research/").toURI());
                } catch (MalformedURLException | URISyntaxException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            
        }
    });  
    
    //add 5 star buttons
    JPanel ratings = new JPanel();
    ratings.setLayout(new GridLayout(0,5,20,20));
    for (int i = 1; i < 6; i++) {
        JButton rating = new JButton(Integer.toString(i));
        ratings.add(rating);
    }

    companyButtons.add(policyButton);
    companyButtons.add(ratings);

     
     // create a jpanel to hold all the campus images
     JPanel googleCampuses = new JPanel();
     
     //set box layout so that elements are added together correctly
     googleCampuses.setVisible(true);

     //add a text box for campus search
     JTextArea campusSearchBar = new JTextArea(1,50);
     googleCampuses.add(campusSearchBar, BorderLayout.NORTH);
     
     //add a button to execute a search
     JButton campusSearchButton = new JButton("Enter");
     googleCampuses.add(campusSearchButton, BorderLayout.NORTH);

     // add a button for the new york campus
     Icon nyOfficePic = new ImageIcon("googleny.jpeg");
     JButton nyOffice = new JButton(nyOfficePic);
     // TODO: add a button listener to open the ny campus page
     googleCampuses.add(nyOffice);

     // add a button for the new york campus
     Icon kirOfficePic = new ImageIcon("googleKir.jpeg");
     JButton kirOffice = new JButton(kirOfficePic);
     kirOffice.addActionListener(new NotAvailable());
     // TODO: add a button listener to open the ny campus page
     googleCampuses.add(kirOffice);

     // add a button for the new york campus
     Icon mtvOfficePic = new ImageIcon("googleMtv.jpeg");
     JButton mtvOffice = new JButton(mtvOfficePic);
     mtvOffice.addActionListener(new NotAvailable());
     // TODO: add a button listener to open the ny campus page
     googleCampuses.add(mtvOffice);

     // add a button for the new york campus
     Icon laxOfficePic = new ImageIcon("googleLax.jpeg");
     JButton laxOffice = new JButton(laxOfficePic);
     laxOffice.addActionListener(new NotAvailable());
     // TODO: add a button listener to open the ny campus page
     googleCampuses.add(laxOffice);


     //add widgets to the google page header
    googlePageHeader.add(companyButtons);

    JPanel googleTopPage = new JPanel();
    googleTopPage.setLayout(new BoxLayout(googleTopPage, BoxLayout.Y_AXIS));
    googleTopPage.add(googleTitle);
    googleTopPage.add(googlePageHeader);

    
    // add components to the google home page
    // googlePage.add(googleTitle, BorderLayout.NORTH);
    // googlePage.add(googlePageHeader, BorderLayout.CENTER);
    googlePage.add(googleTopPage, BorderLayout.NORTH);
    googlePage.add(googleCampuses, BorderLayout.CENTER);
    googlePage.setVisible(true);
   }

   // method to support opening an external webpage
   public static boolean openWebpage(URI uri) {
    Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
        try {
            desktop.browse(uri);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    return false;
}

// method to open an external web page
public static boolean openWebpage(URL url) {
    try {
        return openWebpage(url.toURI());
    } catch (URISyntaxException e) {
        e.printStackTrace();
    }
    return false;
}


private class NotAvailable implements ActionListener {
    public void actionPerformed(ActionEvent e) {
        // show a pop up message to alert user that the campus is not available
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame, "Sorry! This campus is not available for viewing at this time.");
    }
  }

  
   public static void main(String args[]) {
     java.awt.EventQueue.invokeLater(new Runnable() {
           public void run() {
               new GoogleCompanyView().setVisible(true);
           }
       });
   }
}
 
 

