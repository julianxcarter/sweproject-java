package org.employable.View;


import org.employable.Controller.JobSeekerController;
import org.employable.Model.JobListingModel;


import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.net.URI;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;
import java.util.ArrayList;


public class JobSeekerHomeView extends javax.swing.JFrame{

    private static final long serialVersionUID = 1L;
    //List of search parameters for job listings
    public static String[] searchParamaters = {"Company", "Location", "Role", "Industry"};
    
    //create an instance of the job seeker controller
    final JobSeekerController jsController = new JobSeekerController();
    //create an instance of the array list
    List<String> bleh = new ArrayList<String>();
    //create an instance of the job listing model
    JobListingModel model = new JobListingModel("bleh", "bleh", "bleh", "bleh", bleh);

    // JobSeekerController controller = new JobSeekerController();

    public JobSeekerHomeView(){
        //retrieve the array of matched objects
        List<JobListingModel> match = jsController.newMatch();
        for(int i = 0; i< match.size(); i++){
            System.out.println(match.get(i));
        }
        //create the frame
        JFrame frame = new JFrame("Home Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//exit when window closes
        frame.setSize(500,500); //set frame for 500 by 500

        //Create search panel
        JPanel panel = new JPanel();
        //Profile button
        JButton profile = new JButton("Profile");
        //job listing search box
        JTextField universalSearchBox = new JTextField("Search Company", 10);
        //Combo box for search parameters
        JComboBox<String> searchList = new JComboBox<>(searchParamaters);
       

        //Search button
        JButton search = new JButton("Search");
        profile.addActionListener(new ActionListener()
        {
            @Override
            //this button takes the user to his/her profile
            public void actionPerformed(ActionEvent e)
            {
                //connect to job seeker profile via the controller
                //JobSeekerProfileView userProfile = new JobSeekerProfileView();
                // display/center the jdialog when the button is pressed
                JOptionPane.showMessageDialog(frame,"You have chosen to go to your profile.");
            }
        });
        
        search.addActionListener(new ActionListener()
        {
            @Override
            //this button allows the user to search for job listings
            public void actionPerformed(ActionEvent e)
            {
                // display/center the jdialog when the button is pressed
                String company = universalSearchBox.getText();
                //display job listings based on the user's search
                JOptionPane.showMessageDialog(frame,"You searched for "+ company);
            }
        });
        //add the profile button, search box, combo box and search button to the panel
        panel.add(profile);
        panel.add(universalSearchBox);
        panel.add(searchList);
        panel.add(search);
        


        //create panel for job listings
        JPanel jobRecPanel = new JPanel();
        //makes the layout 2 rows and 3 columns
        jobRecPanel.setLayout(new GridLayout(2,3));
        

        //section header with left justification
        JLabel jobListings = new JLabel("Recommended Jobs for You");
        JLabel blank = new JLabel("");
        JLabel anotherBlank = new JLabel("");
        jobRecPanel.add(jobListings);
        jobRecPanel.add(blank);
        jobRecPanel.add(anotherBlank);
        
        //get the listings from the model/controller
        //first job listing
        JPanel recComp1 = new JPanel ();
        //get first company name
        JButton firstCompPage = new JButton(match.get(0).companyName);
        firstCompPage.addActionListener(new ActionListener() {
            @Override
            //this button takes the user to the indicated company page
            public void actionPerformed(ActionEvent e) {
                try {
                    new GoogleCompanyView().setVisible(true);
                } catch(Exception e0) {
                    //TODO Auto-generated catch block
                    e0.printStackTrace();
                }
            }
        });
        //get first position title
        JLabel firstRole = new JLabel("\n" + match.get(0).positionName);
        //get first position location
        JLabel firstLocation = new JLabel("\n"+ match.get(0).location+"\n");
        //adds an apply button for the external application link
        JButton firstLink = new JButton("Apply");

        //add each componenets to the panel
        recComp1.add(firstCompPage);
        recComp1.add(firstRole);
        recComp1.add(firstLocation);
        firstLink.addActionListener(new ActionListener() {
            @Override
            //this button directs users to the external application
            public void actionPerformed(ActionEvent event) {
                // controller.updateEngagements();
                try {
                    openWebpage(new URL(match.get(0).hyperLink).toURI());
                } catch(MalformedURLException | URISyntaxException e) {
                    //TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        recComp1.add(firstLink);
        

        //format the text pane
        recComp1.setPreferredSize(new Dimension(300,100));//size
        recComp1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));//outline color
        //add the pane to the panel
        jobRecPanel.add(recComp1);
        

        //get the listings from the model/controller
        //second job listing
        JPanel recComp2 = new JPanel ();
        //get the second company name
        JButton secondCompPage = new JButton(match.get(1).companyName);
        secondCompPage.addActionListener(new ActionListener() {
            @Override
            //this button takes the user to the indicated company page
            public void actionPerformed(ActionEvent e) {
                try {
                    GoogleCompanyView Google = new GoogleCompanyView();
                } catch (Exception e1){
                    //TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        //get the second position title
        JLabel secondRole = new JLabel("\n" + match.get(1).positionName);
        //get the second location
        JLabel secondLocation = new JLabel("\n"+match.get(1).location+"\n");
        //add an apply button for the external application
        JButton secondLink = new JButton("Apply");
        
        //add each component to the panel
        recComp2.add(secondCompPage);
        recComp2.add(secondRole);
        recComp2.add(secondLocation);
        secondLink.addActionListener(new ActionListener() {
            @Override
            //this button directs users to the external application
            public void actionPerformed(ActionEvent event) {
                try {
                    openWebpage(new URL(match.get(1).hyperLink).toURI());
                } catch(MalformedURLException | URISyntaxException e) {
                    //TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        //add link to the panel
        recComp2.add(secondLink);

        //format the text pane
        recComp2.setPreferredSize(new Dimension(300,100));//size
        recComp2.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));//outline color
        //add the pane to the panel
        jobRecPanel.add(recComp2);


        //get the listings from the model/controller
        //third job listing
        JPanel recComp3 = new JPanel ();
        //get the third company name
        JButton thirdCompPage = new JButton(match.get(2).companyName);
        thirdCompPage.addActionListener(new ActionListener() {
            @Override
            //this button opens the indicated compnay page
            public void actionPerformed(ActionEvent e) {
                try {
                    new GoogleCompanyView().setVisible(true);
                } catch(Exception e2) {
                    //TODO Auto-generated catch block
                    e2.printStackTrace();
                }
            }
        });
        //get the third position title
        JLabel thirdRole = new JLabel("\n"+ match.get(2).positionName);
        //get the third location
        JLabel thirdLocation = new JLabel("\n"+match.get(2).location+"\n");
        //add the apply button for the external link
        JButton thirdLink = new JButton("Apply");
       
        //get the listings from the model/controller
        recComp3.add(thirdCompPage);
        recComp3.add(thirdRole);
        recComp3.add(thirdLocation);
        thirdLink.addActionListener(new ActionListener() {
            @Override
            //this button directs users to the external application
            public void actionPerformed(ActionEvent event) {
                try {
                    openWebpage(new URL(match.get(2).hyperLink).toURI());
                } catch(MalformedURLException | URISyntaxException e) {
                    //TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        //add the link to the panel
        recComp3.add(thirdLink);
         
        //format the text pane
        recComp3.setPreferredSize(new Dimension(300,100));//size
        recComp3.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));//outline color
        //add the pane to the panel
        jobRecPanel.add(recComp3);
    

        //top rated companies panel with heading left justified
        JPanel topCompPanel = new JPanel();
        //set layout to 2 rows and 3 columns
        topCompPanel.setLayout(new GridLayout(2,3));
        JLabel topCompanies = new JLabel("Top Companies");
        JLabel thisBlank = new JLabel("");
        JLabel thatBlank = new JLabel("");
        JPanel topCompany1 = new JPanel();
        
        //format area
        thirdCompPage.addActionListener(new ActionListener() {
            @Override
            //this button takes the user to the company page
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(frame, "Adobe's company page is not available at this time. \nPlease try again later.");
                } catch(Exception e2) {
                    //TODO Auto-generated catch block
                    e2.printStackTrace();
                }
            }
        });
        //show the company location
        JLabel adobeLocation2 = new JLabel("\nSeattle, WA");
        topCompany1.setPreferredSize(new Dimension(300,100));//format size
        topCompany1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));//format outline color
        
        //add components to the panel
        topCompany1.add(thirdCompPage);
        topCompany1.add(adobeLocation2);


        //second company
        JPanel topCompany2 = new JPanel();
        JButton pivotalCompPage = new JButton("Pivotal");
        pivotalCompPage.addActionListener(new ActionListener() {
            @Override
            //this button takes the user to the company page
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(frame, "Pivotal's company page is not available at this time. \nPlease try again later.");
                } catch(Exception e3) {
                    //TODO Auto-generated catch block
                    e3.printStackTrace();
                }
            }
        });
        //show the company location
        JLabel pivotalLocation = new JLabel ("\nNew York, NY");
        topCompany2.setPreferredSize(new Dimension(300,100));//format size
        topCompany2.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));//format outline color
        
        //add component to the panel
        topCompany2.add(pivotalCompPage);
        topCompany2.add(pivotalLocation);


        //thrid company
        JPanel topCompany3 = new JPanel();
        JButton cokeCompPage = new JButton("Coca-Cola");
        cokeCompPage.addActionListener(new ActionListener() {
            @Override
            //this button takes the user to the company page
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(frame, "Coca-Cola's company page is not available at this time. \nPlease try again later.");
                } catch(Exception e4) {
                    //TODO Auto-generated catch block
                    e4.printStackTrace();
                }
            }
        });
        //show the company location
        JLabel cokeLocation = new JLabel("\nAtlanta, GA");
        topCompany3.setPreferredSize(new Dimension(300,100));//format size
        topCompany3.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));//format outline color
        
        //add components to panel
        topCompany3.add(cokeCompPage);
        topCompany3.add(cokeLocation);

        
        //add the heading and the companies to the panel
        topCompPanel.add(topCompanies);
        topCompPanel.add(thisBlank);
        topCompPanel.add(thatBlank);
        topCompPanel.add(topCompany1);
        topCompPanel.add(topCompany2);
        topCompPanel.add(topCompany3);

        //add all of the panels to the frame and with layout specifications
        frame.getContentPane().add(BorderLayout.NORTH, panel);//top of the panel
        frame.getContentPane().add(BorderLayout.WEST, jobRecPanel);//middle of the panel
        frame.getContentPane().add(BorderLayout.SOUTH, topCompPanel);//bottom of the panels

        //make everything visible and pack frame
        frame.setVisible(true);
        frame.pack();
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

    // method to open an external webpage
    public static boolean openWebpage(URL url) {
        try {
            return openWebpage(url.toURI());
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String args[]){
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JobSeekerHomeView().setVisible(true);
            }
        });
    }
}


