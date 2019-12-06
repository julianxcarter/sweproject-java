package org.employable;

import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.*;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// import com.mongodb.ServerAddress;

import org.bson.Document;
import org.employable.Model.JobListingModel;
import org.employable.View.JobSeekerProfileView;
import org.employable.View.RecruiterView;
// import java.util.Arrays;
// import com.mongodb.Block;
// import java.lang.Object;
import org.employable.Model.RecruiterModel;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    // lists of strings for company options
   public static String[] companyOptions = {"Google", "Amazon", "JP Morgan"
   ,"Wendy's"};
    public static void main(String[] args) {

        // System.out.println("----------------- Recruiters -----------------");

        // RecruiterModel model = new RecruiterModel("Google");
        // model.setName("Julian Carter");
        // model.setPassword("Password");
        // model.setContactInfo("email.email@email.com");

        // model.createRecruiter();

        // System.out.println("----------------- Listings -----------------");

        // List<JobListingModel> listings = new ArrayList<JobListingModel>();
        // JobListingModel model2 = new JobListingModel("position", "link", "title", "bleh");
        // listings = model2.getAllListings();

        // for (JobListingModel x : listings) {
        //     System.out.println("Company Name: " + x.companyName);
        //     System.out.println("Link: " + x.hyperLink);
        //     System.out.println("Location: " + x.location);
        //     System.out.println("Position: " + x.positionName);

        //     System.out.println(" ");
        // }

        // List<JobListingModel> listingsByCompany = new ArrayList<JobListingModel>();
        // listingsByCompany = model2.getListingsByCompany("Google");
        // System.out.println("Listings from Google");
        // for (JobListingModel x : listingsByCompany) {
        //     System.out.println("Company Name: " + x.companyName);
        //     System.out.println("Link: " + x.hyperLink);
        //     System.out.println("Location: " + x.location);
        //     System.out.println("Position: " + x.positionName);

        //     System.out.println(" ");
        // }

        // List<JobListingModel> listingsByLocation = new ArrayList<JobListingModel>();
        // listingsByLocation = model2.getListingsByLocation("Los Angeles");
        // System.out.println("Listings in Los Angeles");
        // for (JobListingModel x : listingsByLocation) {
        //     System.out.println("Company Name: " + x.companyName);
        //     System.out.println("Link: " + x.hyperLink);
        //     System.out.println("Location: " + x.location);
        //     System.out.println("Position: " + x.positionName);

        //     System.out.println(" ");
        // }

        // List<JobListingModel> listingsByTitle = new ArrayList<JobListingModel>();
        // listingsByTitle = model2.getListingsByPosition("Staff Software Engineer");
        // System.out.println("Listings from Google");
        // for (JobListingModel x : listingsByTitle) {
        //     System.out.println("Company Name: " + x.companyName);
        //     System.out.println("Link: " + x.hyperLink);
        //     System.out.println("Location: " + x.location);
        //     System.out.println("Position: " + x.positionName);

        //     System.out.println(" ");
        // }


        // create a new jframe object for the home page
        JFrame openPage = new JFrame("First Open Page View");
        // make sure the page exits when the red x is pressed
        openPage.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set the dimmensions of the home page
        openPage.setSize(800, 800);

        // create panel for sign on
        final JPanel selectionPanel = new JPanel();
        // create a label for the open positions column
        JLabel selectionLabel = new JLabel("Which kind of user are you?");
        selectionPanel.add(selectionLabel);

        //create an invisible panel  for recruiter company info
        JPanel rPanel = new JPanel();
        // initialize companies combo box
        JComboBox<String> companies = new JComboBox<>(companyOptions);
        rPanel.add(companies);
        //create an enter button
        JButton enterRecruiter = new JButton("Enter");
        enterRecruiter.addActionListener(new ActionListener() {

          @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    String chosenCompany = companies.getSelectedItem().toString();
                    RecruiterView recruiter = new RecruiterView(chosenCompany);
                }
        });
        rPanel.add(enterRecruiter);
        rPanel.setVisible(false);
    

        // create a recruiter button to open recruiter view
        JButton rButton = new JButton("Recruiter");
        rButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent event) {
            //make recruiter selection panel visible
            rPanel.setVisible(true);
        }});


        // create a recruiter button to open recruiter view
        JButton jButton = new JButton("Job Seeker");
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                try {
                    JobSeekerProfileView jobseeker = new JobSeekerProfileView();
                } catch (Exception e) {
                    e.printStackTrace();
                }
        }
    });   
    
    selectionPanel.add(rButton);
    selectionPanel.add(jButton);
    
    openPage.add(selectionPanel, BorderLayout.NORTH);
    openPage.add(rPanel, BorderLayout.CENTER);
    openPage.setVisible(true);
    
    }
}
