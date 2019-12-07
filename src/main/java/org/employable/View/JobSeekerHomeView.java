package org.employable.View;

import org.employable.Controller.JobSeekerController;
import org.employable.Model.JobListingModel;
//import org.employable.Controller.RecruiterController;

import javax.swing.*;
import javax.swing.event.HyperlinkEvent;
import java.awt.*;
import java.awt.event.*;
import java.lang.*;
import java.net.URI;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;


public class JobSeekerHomeView extends javax.swing.JFrame{

    private static final long serialVersionUID = 1L;
    public static String[] searchParamaters = {"Company", "Location", "Role", "Industry"};

    // JobSeekerController controller = new JobSeekerController();

    public JobSeekerHomeView(){
        //create the frame
        JFrame frame = new JFrame("Home Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500,500);

        //Create search panel
        JPanel panel = new JPanel();
        //Profile button
        JButton profile = new JButton("Profile");
        JTextField universalSearchBox = new JTextField("Search Company", 10);
        //Combo box for search parameters
        JComboBox<String> searchList = new JComboBox<>(searchParamaters);
       

        //Search button
        JButton search = new JButton("Search");
        profile.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                //connect to job seeker profile via the controller
                //JobSeekerController.loadProfileView();
                // display/center the jdialog when the button is pressed
                JOptionPane.showMessageDialog(frame,"You have chosen to go to your profile.");
            }
        });
        
        search.addActionListener(new ActionListener()
        {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // display/center the jdialog when the button is pressed
                String company = universalSearchBox.getText();
                //display job listings based on the user's search
                JOptionPane.showMessageDialog(frame,"You searched for "+ company);
            }
        });
        panel.add(profile);
        panel.add(universalSearchBox);
        panel.add(searchList);
        panel.add(search);
        


        //create panel for job listings
        JPanel jobRecPanel = new JPanel();
        jobRecPanel.setLayout(new GridLayout(2,3));
        

        //section header with left justification
        JLabel jobListings = new JLabel("Recommended Jobs for You");
        JLabel blank = new JLabel("");
        JLabel anotherBlank = new JLabel("");
        jobRecPanel.add(jobListings);
        jobRecPanel.add(blank);
        jobRecPanel.add(anotherBlank);

        //add listing with links
        //first job listing
        JPanel recComp1 = new JPanel ();
        JButton comcastCompPage = new JButton("Comcast");
        comcastCompPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(frame, "Comcast's company page is not available at this time. \nPlease try again later.");
                } catch(Exception e0) {
                    //TODO Auto-generated catch block
                    e0.printStackTrace();
                }
            }
        });
        JLabel comcastRole = new JLabel("\nSoftware Engineer - Xfi Team");
        JLabel comcastLocation = new JLabel("\nPhiladelphia, PA\n");
        JButton comcastLink = new JButton("Apply");
        // recComp1.setEditable(false);//make text box uneditable
        //recComp1.setPreferredSize(new Dimension(200,100));
        //get the listings from the model/controller
        recComp1.add(comcastCompPage);
        recComp1.add(comcastRole);
        recComp1.add(comcastLocation);
        comcastLink.addActionListener(new ActionListener() {
            @Override
            //this button directs users to the external application
            public void actionPerformed(ActionEvent event) {
                // controller.updateEngagements();
                try {
                    openWebpage(new URL("https://jobs.comcast.com").toURI());
                } catch(MalformedURLException | URISyntaxException e) {
                    //TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        recComp1.add(comcastLink);
        

        
        //format the text pane
        recComp1.setPreferredSize(new Dimension(300,100));
        recComp1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        //add the pane to the panel
        jobRecPanel.add(recComp1);
        

        //add listing with links
        //second job listing
        JPanel recComp2 = new JPanel ();
        JButton googleCompPage = new JButton("Google");
        googleCompPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    GoogleCompanyView Google = new GoogleCompanyView();
                } catch (Exception e1){
                    //TODO Auto-generated catch block
                    e1.printStackTrace();
                }
            }
        });
        JLabel googleRole = new JLabel("\nEngineering Residency Program");
        JLabel googleLocation = new JLabel("\nNew York City, NY\n");
        JButton googleLink = new JButton("Apply");
        // recComp1.setEditable(false);//make text box uneditable
        //recComp2.setPreferredSize(new Dimension(200,100));
        //get the listings from the model/controller
        recComp2.add(googleCompPage);
        recComp2.add(googleRole);
        recComp2.add(googleLocation);
        googleLink.addActionListener(new ActionListener() {
            @Override
            //this button directs users to the external application
            public void actionPerformed(ActionEvent event) {
                try {
                    openWebpage(new URL("https://careers.google.com/jobs/results/82353156161184454-engineering-resident-university-graduate-fixed-term-employee/").toURI());
                } catch(MalformedURLException | URISyntaxException e) {
                    //TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        recComp2.add(googleLink);

        //format the text pane
        recComp2.setPreferredSize(new Dimension(300,100));
        recComp2.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        //add the pane to the panel
        jobRecPanel.add(recComp2);


        //add listing with links
        //third job listing
        JPanel recComp3 = new JPanel ();
        JButton adobeCompPage = new JButton("Adobe");
        adobeCompPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(frame, "Adobe's company page is not available at this time. \nPlease try again later.");
                } catch(Exception e2) {
                    //TODO Auto-generated catch block
                    e2.printStackTrace();
                }
            }
        });
        JLabel adobeRole = new JLabel("\nDevops Architect & Principal Scientist");
        JLabel adobeLocation = new JLabel("\nSanJose, CA\n");
        JButton adobeLink = new JButton("Apply");
        // recComp1.setEditable(false);//make text box uneditable
        //recComp3.setPreferredSize(new Dimension(200,100));
        //get the listings from the model/controller
        recComp3.add(adobeCompPage);
        recComp3.add(adobeRole);
        recComp3.add(adobeLocation);
        adobeLink.addActionListener(new ActionListener() {
            @Override
            //this button directs users to the external application
            public void actionPerformed(ActionEvent event) {
                try {
                    openWebpage(new URL("https://adobe.wd5.myworkdayjobs.com/en-US/external_experienced/job/San-Jose/Principal-Scientist_76059").toURI());
                } catch(MalformedURLException | URISyntaxException e) {
                    //TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
        recComp3.add(adobeLink);
         
        //format the text pane
        recComp3.setPreferredSize(new Dimension(300,100));
        recComp3.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        //add the pane to the panel
        jobRecPanel.add(recComp3);
    

        //top rated companies panel with heading left justified
        JPanel topCompPanel = new JPanel();
        topCompPanel.setLayout(new GridLayout(2,3));
        JLabel topCompanies = new JLabel("Top Companies");
        JLabel thisBlank = new JLabel("");
        JLabel thatBlank = new JLabel("");
        JPanel topCompany1 = new JPanel();
        //topCompany1.setEditable(false);//noneditable
        //format area
        adobeCompPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(frame, "Adobe's company page is not available at this time. \nPlease try again later.");
                } catch(Exception e2) {
                    //TODO Auto-generated catch block
                    e2.printStackTrace();
                }
            }
        });
        JLabel adobeLocation2 = new JLabel("\nSeattle, WA");
        topCompany1.setPreferredSize(new Dimension(300,100));
        topCompany1.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        //StringBuffer company1 = new StringBuffer();
        topCompany1.add(adobeCompPage);
        topCompany1.add(adobeLocation2);

        //add text to the area
        //topCompany1.setText(company1.toString());

        //second company
        JPanel topCompany2 = new JPanel();
        //topCompany2.setEditable(false);//noneditable
        //format area
        JButton pivotalCompPage = new JButton("Pivotal");
        pivotalCompPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(frame, "Pivotal's company page is not available at this time. \nPlease try again later.");
                } catch(Exception e3) {
                    //TODO Auto-generated catch block
                    e3.printStackTrace();
                }
            }
        });
        JLabel pivotalLocation = new JLabel ("\nNew York, NY");
        topCompany2.setPreferredSize(new Dimension(300,100));
        topCompany2.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        //StringBuffer company2 = new StringBuffer();
        topCompany2.add(pivotalCompPage);
        topCompany2.add(pivotalLocation);

        //add text to the area
        //topCompany2.setText(company2.toString());

        //thrid company
        JPanel topCompany3 = new JPanel();
        //topCompany3.setEditable(false); //noneditable
        //format area
        JButton cokeCompPage = new JButton("Coca-Cola");
        cokeCompPage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    JOptionPane.showMessageDialog(frame, "Coca-Cola's company page is not available at this time. \nPlease try again later.");
                } catch(Exception e4) {
                    //TODO Auto-generated catch block
                    e4.printStackTrace();
                }
            }
        });
        JLabel cokeLocation = new JLabel("\nAtlanta, GA");
        topCompany3.setPreferredSize(new Dimension(300,100));
        topCompany3.setBorder(BorderFactory.createLineBorder(Color.CYAN, 5));
        //StringBuffer company3 = new StringBuffer();
        topCompany3.add(cokeCompPage);
        topCompany3.add(cokeLocation);

        //add taxt to the area
        //topCompany3.setText(company3.toString());
        //add the heading and the companies to the panel
        topCompPanel.add(topCompanies);
        topCompPanel.add(thisBlank);
        topCompPanel.add(thatBlank);
        topCompPanel.add(topCompany1);
        topCompPanel.add(topCompany2);
        topCompPanel.add(topCompany3);

        //add all of the panels to the frame and with layout specifications
        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.WEST, jobRecPanel);
        frame.getContentPane().add(BorderLayout.SOUTH, topCompPanel);
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

    // method to open an external web page
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


